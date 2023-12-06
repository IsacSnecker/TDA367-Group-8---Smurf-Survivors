package com.smurfsurvivors.game.model.handlers;

import com.smurfsurvivors.game.model.Difficulty;
import com.smurfsurvivors.game.model.GameModel;
import com.smurfsurvivors.game.model.clock.Clock;
import com.smurfsurvivors.game.model.entity.PlayerCharacter;

public class CompositeHandler implements ICompositeHandler {

    private ICollisionHandler collisionHandler;
    private IEnemyHandler enemyHandler;
    private IFoodHandler foodHandler;

    public CompositeHandler(IFoodHandler foodHandler, IEnemyHandler enemyHandler, ICollisionHandler collisionHandler) {
        this.foodHandler = foodHandler;
        this.enemyHandler = enemyHandler;
        this.collisionHandler = collisionHandler;
    }


    @Override
    public void updateHandlers(Clock clock, PlayerCharacter player, Difficulty difficulty) {

         enemyHandler.updateEnemies();
         collisionHandler.update();
         foodHandler.update();
         enemyHandler.spawnNewEnemies(clock.getTimeSeconds(), player.getX(), player.getY(), difficulty.getSpawnRateAdd());

    }

    @Override
    public IEnemyHandler getEnemyHandler() {
        return enemyHandler;
    }

    @Override
    public IFoodHandler getFoodHandler() {
        return foodHandler;
    }

    @Override
    public ICollisionHandler getCollisionHandler() {
        return collisionHandler;
    }
}
