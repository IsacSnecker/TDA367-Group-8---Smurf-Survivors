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

    private ArrayList<AudioObserver> soundObservers;

    private GameModel model;

    public CollisionHandler(IEnemyHandler enemyHandler, IFoodHandler foodHandler, GameModel model){
        this.player = model.getPlayer();
        this.enemyHandler = enemyHandler;
        this.foodHandler = foodHandler;
        this.model = model;
        this.soundObservers = new ArrayList<>();
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
                        enemy.setIsHit(true);
                        //model.getAudioManager().playSoundEffect("DemonDeath");
                        if (enemy.getHealth() <= 0){
                            notifyAudioObservers("DemonDeath");
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
                                player.WHandler.addMagicHandler();
                            }
                            if(levelUp && player.getLevel() == 13){
                                player.WHandler.levelUpMissile();
                            }
                            if(levelUp && player.getLevel() == 14){
                                player.WHandler.levelUpMissile();
                            }
                            if(levelUp && player.getLevel() == 15){
                                player.WHandler.levelUpMissile();
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
                            if(levelUp && player.getLevel() == 21){
                                player.WHandler.addMacheteHandler();
                            }
                            if(levelUp && player.getLevel() == 22){
                                player.WHandler.levelUpMachete();
                            }
                            if(levelUp && player.getLevel() == 23){
                                player.WHandler.levelUpMachete();
                            }
                            if(levelUp && player.getLevel() == 24){
                                player.WHandler.levelUpMachete();
                            }
                            if(levelUp && player.getLevel() == 25){
                                player.WHandler.levelUpMachete();
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
                //model.getAudioManager().playSoundEffect("HealthPickUp");

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
