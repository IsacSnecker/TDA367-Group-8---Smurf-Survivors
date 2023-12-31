package com.smurfsurvivors.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.smurfsurvivors.game.model.GameModel;
import com.smurfsurvivors.game.model.entity.*;
import com.smurfsurvivors.game.view.audiomanager.AudioManager;
import com.smurfsurvivors.game.view.audiomanager.IAudioManager;
import com.smurfsurvivors.game.view.hud.HUD;
import com.smurfsurvivors.game.view.hud.IHUD;
import com.smurfsurvivors.game.model.weapons.IHandler;
import com.smurfsurvivors.game.view.spritemanager.ISpriteManager;
import com.smurfsurvivors.game.view.spritemanager.SpriteManager;

import java.util.ArrayList;
import java.util.Map;


public class GameView implements IGameView{

    private GameModel model;

    private ISpriteManager spriteManager;

    private IAudioManager audioManager;

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private SpriteBatch hudBatch;
    private BitmapFont font = new BitmapFont();
    private IHUD hud;

    public GameView(GameModel model) {
        this.spriteManager = new SpriteManager();
        this.audioManager = new AudioManager(model.getCollisionHandler());
        this.model = model;
        gameViewInit();
        audioManager.playSong("soundtrack");

    }

    public void gameViewInit() {
        observerInit();
        batchInit();
        HUDInit();
        mapInit();
        rendererInit();
        cameraInit();
    }

    public void observerUpdate() {
        renderFrame();
    }

    public void observerInit() {
        model.addObserver(this);
    }

    private void cameraInit() {
        this.camera = new OrthographicCamera();

        camera.viewportWidth = 1920;
        camera.viewportHeight = 1080;
        camera.position.set(new Vector3(camera.viewportWidth / 2, camera.viewportHeight /2, 0));

        camera.update();
        renderer.setView(camera);
    }

    private void rendererInit() {
        renderer = new OrthogonalTiledMapRenderer(this.map);
    }

    private void mapInit() {
        map = new TmxMapLoader().load("Map/TestMap/smurfsurvivors500x500-map.tmx");
    }

    private void batchInit() {
        batch = new SpriteBatch();
        hudBatch = new SpriteBatch();
    }

    private void HUDInit() {
        this.hud = new HUD(model.getPlayer(), hudBatch);
    }


    private void renderFrame() {

        // Clears screen
        Gdx.gl.glClearColor( 0.5f, 2, 0.1f, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

        // Render process
        batch.begin();
        renderer.render();
        renderEntities(model.getEntities());
        renderPlayerProjectiles(model.getPlayer());

        // Move camera
        camera.position.x = model.getPlayer().getX();
        camera.position.y = model.getPlayer().getY();
        camera.update();
        renderer.setView(camera);
        batch.end();

        // Render HUD
        hudBatch.begin();
        hud.renderHUD(model.getPlayer().getHealth(), model.getPlayer().getXP(), model.getPlayer().getLevelCap(), model.getPlayer().getLevel(), model.getClock());
        hudBatch.end();

        // Render Menus
        renderMenus(model.getStageOpenMap());
    }




    // Disposes variables from memory. (Used during shutdown)
    public void dispose() {
        map.dispose();
        renderer.dispose();
        batch.dispose();
    }

    public void renderPlayerProjectiles(PlayerCharacter player){
        for(IHandler weaponHandler : player.wHandler.getWeaponHandlers()){
            weaponHandler.renderProjectiles(this.batch);
        }
    }

    private void renderEntities(ArrayList<Entity> entities) {

            for (Entity entity: entities) {
                Sprite sprite = spriteManager.getSprite(entity);
                if(entity.getIsHit()){ sprite.setColor(1, 0, 0, 1); }
                sprite.flip(entity.isLookingRight(), false);
                sprite.setPosition(entity.getX(), entity.getY());
                sprite.draw(batch);
            }

    }

    private void renderMenus(Map<Stage, Boolean> stageOpenMap){
        for(Stage stage : stageOpenMap.keySet()){
            if(stageOpenMap.get(stage)){
                stage.draw();
            }
        }
    }

    public IAudioManager getAudioManager() {
        return audioManager;
    }

}

