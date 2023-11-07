package com.smurfsurvivors.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/*public class smurfSurvivors extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("Map/grass.png");

	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}*/

public class smurfSurvivors extends ApplicationAdapter {
	public static void main(String args[])
	{

		IGameModel gameModel = new GameModel();
		IGameController gameController = new GameController(gameModel);
		IGameView gameView = new GameView(gameModel, gameController);

		// TODO
		// Start game model to run program.

	}
}

