package com.smurfsurvivors.game;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;


// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {

		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("SmurfSurvivors");

		// Set resolution
		Graphics.DisplayMode dm = Lwjgl3ApplicationConfiguration.getDisplayMode();
		config.setWindowedMode(dm.width, dm.height);

		// MVC initialization
		IGameModel gameModel = GameModelFactory.createDefaultModel();
		IGameController gameController = new GameController(gameModel);
		GameView gameView = new GameView(gameModel, gameController);

		new Lwjgl3Application(gameView, config);
	}
}
