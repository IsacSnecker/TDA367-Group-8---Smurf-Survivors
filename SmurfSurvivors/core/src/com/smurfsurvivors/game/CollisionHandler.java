package com.smurfsurvivors.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.smurfsurvivors.game.model.GameModel;
import com.smurfsurvivors.game.model.entity.*;
import com.smurfsurvivors.game.model.weapons.AbstractWeapon;
import org.lwjgl.Sys;
import java.util.Iterator;
import java.util.List;

import java.util.ArrayList;

public class CollisionHandler {
    private PlayerCharacter player;
    private EnemyHandler enemyHandler;
    private FoodHandler foodHandler;

    private GameModel model;

    public CollisionHandler(PlayerCharacter player, EnemyHandler enemyHandler, FoodHandler foodHandler, GameModel model){
        this.player = player;
        this.enemyHandler = enemyHandler;
        this.foodHandler = foodHandler;
        this.model = model;
    }

    public void update() {
        handleIfCollision(player.WHandler.getProjectiles(), enemyHandler.getEnemies());
        handleIfCollision(enemyHandler.getEnemies());
        handleFoodCollision();
    }


    public void handleIfCollision(ArrayList<AbstractWeapon> projectiles, ArrayList<Enemy> enemies){
        for(AbstractWeapon projectile : projectiles){
            for(Enemy enemy : enemies){
                if(projectile.getPositionRectangle().overlaps(enemy.getRectangle())){
                    if(!projectile.getHitEntities().contains(enemy)){
                        projectile.getHitEntities().add(enemy);
                        enemy.decreaseHealth(projectile.attackDamage);
                        model.getAudioManager().playSoundEffect("DemonDeath");
                        if (enemy.getHealth() <= 0){
                            boolean levelUp = player.addXP(enemy.getXpGive());
                            model.getAudioManager().playSoundEffect("DemonDeath");

                            if(levelUp && player.getLevel() == 5){
                                player.WHandler.addMissileHandler();
                            }
                            if(levelUp && player.getLevel() == 10){
                                player.WHandler.addMagicHandler();
                            }
                        }
                        if(projectile.getPassThrough() == 0){
                            player.WHandler.removeProjectile(projectile);
                        }
                        else{
                            projectile.setPassThrough(projectile.getPassThrough() - 1);
                        }
                    }
                }
            }
        }

    }

    public void handleIfCollision(ArrayList<Enemy> enemies){
        ArrayList<Enemy> enemiesToRemove = new ArrayList<Enemy>();
        for(Enemy enemy : enemies){
            if(enemy.getRectangle().overlaps(player.getRectangle())){
                player.decreaseHealth(10);
                if(player.getHealth() <= 0){
                    //killPlayer();
                }
                enemiesToRemove.add(enemy);
            }
        }
        for(Enemy enemy : enemiesToRemove){
            enemyHandler.removeEnemy(enemy);
        }
    }

    public void handleFoodCollision(){
        ArrayList<Food> foodsToRemove = new ArrayList<Food>();

        for(Food food : foodHandler.getFoods()){
            if(food.getRectangle().overlaps(player.getRectangle())){

                player.addHealth(10);
                model.getAudioManager().playSoundEffect("HealthPickUp");

                foodsToRemove.add(food);
            }
        }
        for(Food food : foodsToRemove) {
            foodHandler.removeFood(food);
        }
    }
}
