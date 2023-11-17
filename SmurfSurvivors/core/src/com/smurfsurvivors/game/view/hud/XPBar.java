package com.smurfsurvivors.game.view.hud;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class XPBar {

    private int level;
    private int xp;

    private Batch hudBatch;

    public XPBar(int level, int xp, Batch hudBatch) {
        this.level = level;
        this.xp = xp;
        this.hudBatch = hudBatch;
    }

    public void render() {
            hudBatch.draw(new Texture("UI/barEmpty.png"), 0, 40, 200, 40);
            hudBatch.draw(new Texture("UI/xpBarFull.png"),0, 40, this.xp, 40);
    }

}
