package com.smurfsurvivors.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.smurfsurvivors.game.entity.PlayerCharacter;

public class HUD {
    private PlayerCharacter player;

    private int xp;
    private int level;

    private Batch hudBatch;

    private Clock clock;

    public HUD(Clock clock, PlayerCharacter playerCharacter, Batch hudBatch) {
        this.player = playerCharacter;
        this.xp = playerCharacter.getXP();
        this.level = playerCharacter.getLevel();
        this.hudBatch = hudBatch;
        this.clock = clock;
    }

    public void renderHUD() {
        renderHealth();
        renderXP();
        renderClock();
        renderToolbar();
    }

    private void renderHealth() {
        hudBatch.draw(new Texture("UI/barEmpty.png"), 0, 0, 200, 40);
        hudBatch.draw(new Texture("UI/healthBarFull.png"), 0, 0, player.getHealth() * 2, 40);
    }

    private void renderXP() {
        hudBatch.draw(new Texture("UI/barEmpty.png"), 0, 40, 200, 40);
        hudBatch.draw(new Texture("UI/xpBarFull.png"),0, 40, player.getXP(), 40);
    }

    private void renderClock() {
        this.clock.render(hudBatch);
    }

    private void renderToolbar() {
        hudBatch.draw(new Texture("UI/Toolbar/toolbarLeft.png"), Gdx.graphics.getWidth() / 2 - 80 * 4, 0, 104,80);

        for (int i = 1; i <= 5; i++) {
            hudBatch.draw(new Texture("UI/Toolbar/toolbarMid.png"), Gdx.graphics.getWidth() / 2 + 24 - 80 * 4 + 80 * i, 0, 80,80);
        }

        hudBatch.draw(new Texture("UI/Toolbar/toolbarRight.png"), Gdx.graphics.getWidth() / 2 + 24 + 80 * 2, 0, 104,80);

    }

}
