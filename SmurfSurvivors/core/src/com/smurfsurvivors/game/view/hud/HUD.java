package com.smurfsurvivors.game.view.hud;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.smurfsurvivors.game.model.clock.Clock;
import com.smurfsurvivors.game.model.entity.PlayerCharacter;

public class HUD implements IHUD {

    private FPS FPS;
    private HealthBar healthBar;
    private XPBar xpBar;
    private Toolbar toolbar;
    private Batch hudBatch;

    public HUD(PlayerCharacter playerCharacter, Batch hudBatch) {
        this.hudBatch = hudBatch;
        this.healthBar = new HealthBar(playerCharacter.getMaxHealth(), playerCharacter.getHealth(), hudBatch);
        this.xpBar = new XPBar(hudBatch);
        this.toolbar = new Toolbar(hudBatch);
        this.FPS = new FPS(hudBatch);
    }

    public void renderHUD(int currentHealth, int currentXp, int levelCap, int playerLevel, Clock clock) {
        healthBar.render(currentHealth);
        xpBar.render(currentXp, levelCap, playerLevel);
        toolbar.render();
        clock.render(hudBatch);
        FPS.render();
    }

}
