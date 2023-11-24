package com.smurfsurvivors.game.view.hud;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class XPBar {

    private int level;
    private int xp;
    private Batch hudBatch;
    private Texture barEmptyTexture;
    private Texture xpBarFullTexture;

    public XPBar(int level, int xp, Batch hudBatch) {
        this.level = level;
        this.xp = xp;
        this.hudBatch = hudBatch;
        this.barEmptyTexture = new Texture("UI/barEmpty.png");
        this.xpBarFullTexture = new Texture("UI/xpBarFull.png");
    }

    public void render(int _xp, int levelCap) {
        xp = _xp;
        hudBatch.draw(barEmptyTexture, 0, 40, 200, 40);
        hudBatch.draw(xpBarFullTexture,0, 40, (int)((float)this.xp * (float)(200/levelCap)), 40);
    }
}
