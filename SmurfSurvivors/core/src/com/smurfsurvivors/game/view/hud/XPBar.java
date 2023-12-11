package com.smurfsurvivors.game.view.hud;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class XPBar {

    private Batch hudBatch;
    private Texture barEmptyTexture;
    private Texture xpBarFullTexture;
    private int width;
    private int height;
    BitmapFont font = new BitmapFont();

    public XPBar(Batch hudBatch) {
        this.hudBatch = hudBatch;
        this.barEmptyTexture = new Texture("UI/barEmpty.png");
        this.xpBarFullTexture = new Texture("UI/xpBarFull.png");
        this.width = 500;
        this.height = 60;
        font.getData().setScale(2);

    }


    public void render(int xp, int levelCap, int playerLevel) {
        hudBatch.draw(barEmptyTexture, 0, 60, width, height);
        hudBatch.draw(xpBarFullTexture,0, 60, (int)((float)xp * ((float)width/(float)levelCap)), height);
        font.draw(hudBatch, "Level: " + playerLevel, 40, height+42);
    }
}
