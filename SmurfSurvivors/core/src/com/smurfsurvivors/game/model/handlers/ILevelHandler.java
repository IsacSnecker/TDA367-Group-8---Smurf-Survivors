package com.smurfsurvivors.game.model.handlers;

import com.smurfsurvivors.game.model.entity.Enemy;
import com.smurfsurvivors.game.model.entity.PlayerCharacter;

public interface ILevelHandler {
    void playerLevelUp(PlayerCharacter player, Enemy enemy);
}
