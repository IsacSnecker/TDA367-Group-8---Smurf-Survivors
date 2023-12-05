package com.smurfsurvivors.game.model.handlers;

import com.smurfsurvivors.game.model.Difficulty;
import com.smurfsurvivors.game.model.clock.Clock;
import com.smurfsurvivors.game.model.entity.PlayerCharacter;

public interface ICompositeHandler {

    void updateHandlers(Clock clock, PlayerCharacter player, Difficulty difficulty);

    IEnemyHandler getEnemyHandler();

    IFoodHandler getFoodHandler();

    ICollisionHandler getCollisionHandler();

}
