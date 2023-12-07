package com.smurfsurvivors.game.view.hud;

import com.smurfsurvivors.game.model.clock.Clock;

public interface IHUD {

     void renderHUD(int health, int xp, int levelCap, int playerLevel, Clock clock);

}
