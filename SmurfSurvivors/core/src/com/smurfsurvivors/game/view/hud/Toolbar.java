package com.smurfsurvivors.game.view.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Toolbar {

    private Batch hudBatch;
    private Texture toolbarLeft;
    private Texture toolbarMid;
    private Texture toolbarRight;

    public Toolbar(Batch hudBatch) {
        this.hudBatch = hudBatch;
        this.toolbarLeft = new Texture("UI/Toolbar/toolbarLeft.png");
        this.toolbarMid = new Texture("UI/Toolbar/toolbarMid.png");
        this.toolbarRight = new Texture("UI/Toolbar/toolbarRight.png");
    }

    public void render() {
        hudBatch.draw(toolbarLeft, Gdx.graphics.getWidth() / 2 + 40 - 80 * 4, 0, 80,80);

        for (int i = 1; i <= 5; i++) {
            hudBatch.draw(toolbarMid, Gdx.graphics.getWidth() / 2 + 40 - 80 * 4 + 80 * i, 0, 80,80);
        }

        hudBatch.draw(toolbarRight, Gdx.graphics.getWidth() / 2 + 40 + 80 * 2, 0, 80,80);

    }

}
