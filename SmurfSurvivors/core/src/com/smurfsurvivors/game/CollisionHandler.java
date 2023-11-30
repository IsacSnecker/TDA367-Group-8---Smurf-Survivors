package com.smurfsurvivors.game;

import com.badlogic.gdx.Gdx;
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

    public CollisionHandler(PlayerCharacter player, EnemyHandler enemyHandler, FoodHandler foodHandler){
        this.player = player;
        this.enemyHandler = enemyHandler;
        this.foodHandler = foodHandler;
    }


    public void handleIfCollision(ArrayList<AbstractWeapon> projectiles, ArrayList<Enemy> enemies){
        for(AbstractWeapon projectile : projectiles){
            for(Enemy enemy : enemies){
                if(projectile.getPositionRectangle().overlaps(enemy.getRectangle())){
                    if(!projectile.getHitEntities().contains(enemy)){
                        projectile.getHitEntities().add(enemy);
                        enemy.decreaseHealth(projectile.attackDamage);
                        if (enemy.getHealth() <= 0){
                            boolean levelUp = player.addXP(enemy.getXpGive());
                            if(levelUp && player.getLevel() == 2){
                                player.WHandler.levelUpBullet();
                            }
                            if(levelUp && player.getLevel() == 3){
                                player.WHandler.addKnifeHandler();
                            }
                            if(levelUp && player.getLevel() == 4){
                                player.WHandler.levelUpKnife();
                            }
                            if(levelUp && player.getLevel() == 5){
                                player.WHandler.levelUpKnife();
                            }
                            if(levelUp && player.getLevel() == 6){
                                player.WHandler.levelUpBullet();
                            }
                            if(levelUp && player.getLevel() == 7){
                                player.WHandler.addMissileHandler();
                            }
                            if(levelUp && player.getLevel() == 8){
                                player.WHandler.levelUpKnife();
                            }
                            if(levelUp && player.getLevel() == 9){
                                player.WHandler.levelUpKnife();
                            }
                            if(levelUp && player.getLevel() == 10){
                                player.WHandler.levelUpBullet();
                            }
                            if(levelUp && player.getLevel() == 11){
                                player.WHandler.levelUpBullet();
                            }
                            if(levelUp && player.getLevel() == 12){
                                player.WHandler.levelUpBullet();
                            }
                            if(levelUp && player.getLevel() == 13){
                                player.WHandler.levelUpMissile();
                            }
                            if(levelUp && player.getLevel() == 14){
                                player.WHandler.levelUpMissile();
                            }
                            if(levelUp && player.getLevel() == 15){
                                player.WHandler.levelUpMissile();
                                player.WHandler.addMagicHandler();
                            }
                            if(levelUp && player.getLevel() == 16){
                                player.WHandler.levelUpMissile();
                            }
                            if(levelUp && player.getLevel() == 17){
                                player.WHandler.levelUpMagic();
                            }
                            if(levelUp && player.getLevel() == 18){
                                player.WHandler.levelUpMagic();
                            }
                            if(levelUp && player.getLevel() == 19){
                                player.WHandler.levelUpMagic();
                            }
                            if(levelUp && player.getLevel() == 20){
                                player.WHandler.levelUpMagic();
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
                System.out.println("FOOD");
                player.addHealth(10);
                food.getSoundEffect().play();
                foodsToRemove.add(food);
            }
        }
        for(Food food : foodsToRemove) {
            foodHandler.removeFood(food);
        }
    }
}
