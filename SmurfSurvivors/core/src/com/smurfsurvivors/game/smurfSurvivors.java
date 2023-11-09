package com.smurfsurvivors.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.smurfsurvivors.game.weapons.KnifeWeapon;
import com.smurfsurvivors.game.weapons.WeaponHandler;

public class smurfSurvivors extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture background;
	WeaponHandler WHandler;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("smurf.png");
		background = new Texture("Map/grass.png");
		WHandler = new WeaponHandler(batch);

	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(background, 0, 0);
		batch.draw(img, 0, 0);
		WHandler.passiveWeaponUpdate(new Vector2(100,100));
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
