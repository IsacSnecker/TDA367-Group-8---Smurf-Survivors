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
        this.width = 400;
        this.height = 50;
        font.getData().setScale(2);

    }


    public void render(int xp, int levelCap, int playerLevel) {
        hudBatch.draw(barEmptyTexture, 0, 40, width, height);
        hudBatch.draw(xpBarFullTexture,0, 40, (int)((float)xp * ((float)width/(float)levelCap)), height);
        font.draw(hudBatch, "Level: " + playerLevel, width-160, height+30);
    }
}
