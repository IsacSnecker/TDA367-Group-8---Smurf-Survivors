package com.smurfsurvivors.game.model.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FPS {

    private GlyphLayout glyphLayout;
    private Batch batch;
    BitmapFont font = new BitmapFont();

    public FPS(Batch _batch){
        batch = _batch;
    }

    public void render(){
        font.draw(batch, "FPS=" + Gdx.graphics.getFramesPerSecond(), 0, Gdx.graphics.getHeight());
    }
}
