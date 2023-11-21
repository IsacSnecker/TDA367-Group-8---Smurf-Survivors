package com.smurfsurvivors.game.view.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.smurfsurvivors.game.Clock;
import com.smurfsurvivors.game.entity.PlayerCharacter;

import java.awt.*;

public class HUD implements IHUD {

    private FPS FPS;
    private HealthBar healthBar;
    private XPBar xpBar;
    private Toolbar toolbar;

    private Batch hudBatch;

    private Clock clock;

    public HUD(Clock clock, PlayerCharacter playerCharacter, Batch hudBatch) {
        this.hudBatch = hudBatch;
        this.clock = clock;
        this.healthBar = new HealthBar(playerCharacter.getMaxHealth(), playerCharacter.getHealth(), hudBatch);
        this.xpBar = new XPBar(0,0, hudBatch);
        this.toolbar = new Toolbar(hudBatch);
        this.FPS = new FPS(hudBatch);
    }

    public void renderHUD() {
        healthBar.render();
        xpBar.render();
        toolbar.render();
        clock.render(hudBatch);
        FPS.render();
    }

}
