package com.smurfsurvivors.game.view.hud;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.smurfsurvivors.game.Clock;
import com.smurfsurvivors.game.model.entity.PlayerCharacter;

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

    public void renderHUD(int currentHealth, int currentXp, int levelCap, int playerLevel) {
        healthBar.render(currentHealth);
        xpBar.render(currentXp, levelCap, playerLevel);
        toolbar.render();
        clock.render(hudBatch);
        FPS.render();
    }

}
