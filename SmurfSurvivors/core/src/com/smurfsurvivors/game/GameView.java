package com.smurfsurvivors.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;
import com.smurfsurvivors.game.entity.Enemy;
import com.smurfsurvivors.game.entity.PlayerCharacter;
import com.smurfsurvivors.game.weapons.IHandler;


public class GameView implements Observer{

    private GameModel model;
    private GameController controller;

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;

    public GameView(GameModel model, GameController controller) {
        this.model = model;
        this.controller = controller;

        model.addObserver(this);
    }

    SpriteBatch batch;
    Texture img;

    public void init() {
        mapInit();
        rendererInit();
        cameraInit();
        batchInit();
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
        map = new TmxMapLoader().load("Map/TestMap/TestMap.tmx");
    }

    private void batchInit() {
        batch = new SpriteBatch();
    }

    //@Override
    public void update () {
        renderer.setView(camera);
        renderer.render();
        batch.begin();
        PlayerCharacter player = model.getPlayer();
        player.render(this.batch);
        renderPlayerProjectiles(player);
        //Sprite sprite = new Sprite(player.getTexture(), player.getX(), player.getX(),
        //        player.getWidth(), player.getHeight());
        //sprite.setPosition(sprite.getX()/2, sprite.getY()/2);
        //sprite
        renderEnemies();
        batch.end();
    }

    //@Override
    public void dispose () {
        batch.dispose();
        img.dispose();
    }

    public void renderEnemies() {
        for (Enemy e: model.getEnemies()) {
            e.render(this.batch);
        }

    }
    public void renderPlayerProjectiles(PlayerCharacter player){
        for(IHandler weaponHandler : player.WHandler.getWeaponHandlers()){
            weaponHandler.renderProjectiles(this.batch);
        }
    }
}

