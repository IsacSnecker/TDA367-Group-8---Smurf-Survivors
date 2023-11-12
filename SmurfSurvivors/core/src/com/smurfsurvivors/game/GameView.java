package com.smurfsurvivors.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
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


public class GameView implements Observer {

    private GameModel model;

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;

    private SpriteBatch batch;

    public GameView(GameModel model) {
        this.model = model;
        gameViewInit();

    }

    public void gameViewInit() {
        observerInit();
        batchInit();
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
        map = new TmxMapLoader().load("Map/TestMap/TestMap.tmx");
    }

    private void batchInit() { batch = new SpriteBatch(); }

    private void renderFrame() {

        // Clears screen
        Gdx.gl.glClearColor( 1, 0, 0, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

        // Render process
        batch.begin();

        renderer.render();
        model.getPlayer().render(this.batch);
        renderEnemies();

        // Move camera
        camera.position.x = model.getPlayer().getX();
        camera.position.y = model.getPlayer().getY();
        camera.update();
        renderer.setView(camera);

        batch.end();
    }

    public void renderEnemies() {
        for (Enemy e: model.getEnemies()) {
            e.render(this.batch);
        }
    }

    // Disposes variables from memory. (Used during shutdown)
    public void dispose() {
        map.dispose();
        renderer.dispose();
        batch.dispose();
    }
}

