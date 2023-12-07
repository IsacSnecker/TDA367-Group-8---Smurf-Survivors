package com.smurfsurvivors.game.model;

import com.smurfsurvivors.game.model.entity.PlayerCharacter;
import com.smurfsurvivors.game.model.factories.DifficultyFactory;
import com.smurfsurvivors.game.model.handlers.*;

public abstract class GameModelFactory {


    public static GameModel createEasyModel() {

        PlayerCharacter player = new PlayerCharacter(100, 16000, 16000, 90, 90, 5, 0);
        GameModel model = new GameModel(DifficultyFactory.createEasyDifficulty(), player);

        return DependencyInject(model);
    }

    public static GameModel createNormalModel() {

        PlayerCharacter player = new PlayerCharacter(100, 16000, 16000, 90, 90, 5, 0);
        GameModel model = new GameModel(DifficultyFactory.createNormalDifficulty(), player);


        return DependencyInject(model);
    }

    public static GameModel createHardModel() {

        PlayerCharacter player = new PlayerCharacter(100, 16000, 16000, 90, 90, 5, 0);
        GameModel model = new GameModel(DifficultyFactory.createHardDifficulty(), player);

        return DependencyInject(model);
    }



    private static GameModel DependencyInject(GameModel model) {

        // Dependency injection by setter method
        IFoodHandler foodHandler = new FoodHandler(500);
        IEnemyHandler enemyHandler = new EnemyHandler(model);
        ICollisionHandler collisionHandler = new CollisionHandler(enemyHandler,foodHandler, model.getPlayer());
        ICompositeHandler compositeHandler = new CompositeHandler(foodHandler, enemyHandler, collisionHandler);
        model.setCompositeHandler(compositeHandler);

        return model;
    }

}
