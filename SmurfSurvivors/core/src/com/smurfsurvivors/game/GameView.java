package com.smurfsurvivors.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;
import com.smurfsurvivors.game.entity.Enemy;


public class GameView extends ApplicationAdapter implements IGameView{

    private IGameModel model;
    private IGameController controller;

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;

    public GameView(IGameModel model, IGameController controller) {
        this.model = model;
        this.controller = controller;

    }

    SpriteBatch batch;
    Texture img;

    private void viewInit() {

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
        img = new Texture("Map/grass.png");
    }

    @Override
    public void create () {

        viewInit();

    }

    @Override
    public void render () {

        renderer.setView(camera);
        renderer.render();

        batch.begin();
        batch.draw(img,10,10);
        batch.end();


    }

    @Override
    public void dispose () {
        batch.dispose();
        img.dispose();
    }

    public void renderEnemies() {

        for (Enemy e: model.getEnemies()) {

        }

    }


/*    public void renderEnemies() {

        for (Enemy e: model.getEnemies()) {
            e.render(this.batch);
        }

    }
*/

}

