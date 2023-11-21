package com.smurfsurvivors.game.view.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FPS {

    private GlyphLayout glyphLayout;
    private Batch batch;
    public FPS(Batch _batch){
        batch = _batch;
    }

    public void render(){
        BitmapFont font = new BitmapFont();
        font.draw(batch, "FPS=" + Gdx.graphics.getFramesPerSecond(), 0, Gdx.graphics.getHeight());
    }
}
