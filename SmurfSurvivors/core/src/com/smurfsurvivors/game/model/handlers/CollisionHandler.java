package com.smurfsurvivors.game.model.handlers;

import com.smurfsurvivors.game.AudioObservable;
import com.smurfsurvivors.game.AudioObserver;
import com.smurfsurvivors.game.model.GameModel;
import com.smurfsurvivors.game.model.entity.*;
import com.smurfsurvivors.game.model.weapons.AbstractWeapon;

import java.util.ArrayList;

public class CollisionHandler implements ICollisionHandler {
    private PlayerCharacter player;
    private IEnemyHandler enemyHandler;
    private IFoodHandler foodHandler;
    private LevelHandler levelHandler;
    private ArrayList<AudioObserver> soundObservers;
    private GameModel model;

    public CollisionHandler(IEnemyHandler enemyHandler, IFoodHandler foodHandler, PlayerCharacter player, LevelHandler levelHandler){
        this.player = player;
        this.enemyHandler = enemyHandler;
        this.foodHandler = foodHandler;
        this.soundObservers = new ArrayList<>();
        this.levelHandler = levelHandler;
    }

    public void update() {
        handleIfCollision(player.WHandler.getProjectiles(), enemyHandler.getEnemies(), levelHandler);
        handleIfCollision(enemyHandler.getEnemies());
        handleFoodCollision();
    }


    public void handleIfCollision(ArrayList<AbstractWeapon> projectiles, ArrayList<Enemy> enemies, LevelHandler levelHandler){
        for(AbstractWeapon projectile : projectiles){
            for(Enemy enemy : enemies){
                if(projectile.getPositionRectangle().overlaps(enemy.getRectangle())){
                    if(!projectile.getHitEntities().contains(enemy)){
                        projectile.getHitEntities().add(enemy);
                        enemy.decreaseHealth(projectile.attackDamage);
                        enemy.setIsHit(true);
                        if (enemy.getHealth() <= 0){
                            notifyAudioObservers("DemonDeath");
                            levelHandler.playerLevelUp(enemy);

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
                notifyAudioObservers("HealthPickUp");
                player.addHealth(10);

                foodsToRemove.add(food);
            }
        }
        for(Food food : foodsToRemove) {
            foodHandler.removeFood(food);
        }
    }

    @Override
    public void addSoundObserver(AudioObserver o) {
        soundObservers.add(o);
    }

    @Override
    public void removeSoundObserver(AudioObserver o) {
        soundObservers.remove(o);
    }

    @Override
    public void notifyAudioObservers(String soundName) {
        for (AudioObserver o: soundObservers) {
            o.playSound(soundName);
        }
    }
}
