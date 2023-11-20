package com.smurfsurvivors.game.view.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Toolbar {

    private Batch hudBatch;

    public Toolbar(Batch hudBatch) {
        this.hudBatch = hudBatch;
    }

    public void render() {
        hudBatch.draw(new Texture("UI/Toolbar/toolbarLeft.png"), Gdx.graphics.getWidth() / 2 + 40 - 80 * 4, 0, 80,80);

        for (int i = 1; i <= 5; i++) {
            hudBatch.draw(new Texture("UI/Toolbar/toolbarMid.png"), Gdx.graphics.getWidth() / 2 + 40 - 80 * 4 + 80 * i, 0, 80,80);
        }

        hudBatch.draw(new Texture("UI/Toolbar/toolbarRight.png"), Gdx.graphics.getWidth() / 2 + 40 + 80 * 2, 0, 80,80);

    }

}
