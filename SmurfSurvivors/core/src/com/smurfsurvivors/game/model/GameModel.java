package com.smurfsurvivors.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.*;
import com.smurfsurvivors.game.model.entity.Enemy;
import com.smurfsurvivors.game.model.entity.PlayerCharacter;
import com.smurfsurvivors.game.model.weapons.AbstractWeapon;

import java.util.ArrayList;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class GameModel implements Observable {

    private ArrayList<Observer> observerList;
    private PlayerCharacter player;
    public EnemyHandler enemyHandler;
    private CollisionHandler collisionHandler;
    private Difficulty difficulty;
    private Clock clock;

    private Music soundTrack;

    private Boolean isPaused = false;

    public GameModel(Difficulty difficulty){

        this.difficulty = difficulty;
        this.collisionHandler = new CollisionHandler();
        this.observerList = new ArrayList<Observer>();
        this.enemyHandler = new EnemyHandler();

        soundTrack = Gdx.audio.newMusic(Gdx.files.internal("Sounds/Hallonsaft.mp3")); //
        soundTrack.setLooping(true);
        soundTrack.play(); //Should probably not be here

        this.clock = new Clock();
        clock.startClock();
        initializeObservers();

    }
    @Override
    public void initializeObservers() {
        for (Observer o : observerList){
            o.observerInit();
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer o: observerList){
            o.observerUpdate();
        }
    }

    @Override
    public void addObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) { observerList.remove(o);}

    public PlayerCharacter getPlayer(){
        return this.player;
    }

    public Clock getClock(){
        return this.clock;
    }

    public Boolean getIsPaused(){
        return isPaused;
    }


    public void setPlayer(PlayerCharacter player) { this.player = player; }

    public void togglePaused(){
        isPaused = !isPaused;
        if(isPaused){
            clock.pauseClock();
        }
        else {
            clock.resumeClock();
        }
    }


    public void updatePlayerPosition(ArrayList<Integer> inputList){
        if(!isPaused){
            player.updatePosition(inputList);
        }
    }

    public void updateEnemyPositions(){
        for (Enemy enemy : getEnemies()) {
            enemy.moveTowardsEntity(player);
        }
    }

    public void updatePlayerHealth(){
     /*   for (Enemy enemy : enemyList){
            if (collisionHandler.isCollision(player, enemy)){
                player.decreaseHealth();
            }
        }
        for (Food food : foodList){
            if (collisionHandler.isCollision(player, food)){
                player.increaseHealth();
                pop food from list
            }
        }
        */
    }

    public void update() {
        if(!isPaused){
            updateEnemyPositions();
            updatePlayerHealth();
            if(!getEnemies().isEmpty()){
                player.weaponInformationHandler.updateWeaponInformation(player.getDirection(), getNearestEnemyPosition(), getNearestEnemy());
                player.usePassiveWeapon();
                player.WHandler.updateWeaponCooldowns();
                enemyPlayerCollision();
                enemyProjectileCollision();
            }
            enemyHandler.spawnNewEnemies(clock.getTimeSeconds(), player.getX(), player.getY(), difficulty.getSpawnRateMultiplier());
            enemyHandler.updateEnemies(player); //gör till koordinater istället för entity
        }

        notifyObservers();
    }

    public ArrayList<Enemy> getEnemies() {
        return enemyHandler.getEnemies();
    }

    public Vector2 getNearestEnemyPosition(){
        return getNearestEnemy().getPosition();
    }

    public Enemy getNearestEnemy(){
        ArrayList<Enemy> enemyList = getEnemies();
        Enemy nearestEnemy = enemyList.get(0);
        for(Enemy enemy: enemyList){
            if(calculateDistance(enemy.getPosition(), player.getPosition()) < calculateDistance(nearestEnemy.getPosition(), player.getPosition())){
                nearestEnemy = enemy;
            }
        }
        return nearestEnemy;
    }

    public void enemyProjectileCollision(){
        for(AbstractWeapon projectile : player.WHandler.getProjectiles()){
            for(Enemy enemy : getEnemies()){
                if(projectile.getPositionRectangle().overlaps(enemy.getRectangle())){
                    enemy.decreaseHealth(projectile.attackDamage);
                    player.WHandler.removeProjectile(projectile);
                }
            }
        }
    }

    public void enemyPlayerCollision(){
        ArrayList<Enemy> enemiesToRemove = new ArrayList<Enemy>();
        for(Enemy enemy : getEnemies()){
            if(enemy.getRectangle().overlaps(player.getRectangle())){
                player.decreaseHealth(10);
                int distanceMultiplier = 4;
                if(player.getPosition().x < enemy.getPosition().x && player.getPosition().y < enemy.getPosition().y){
                    player.move(-player.getSpeed() * distanceMultiplier, -player.getSpeed() * distanceMultiplier);
                }
                else if(player.getPosition().x < enemy.getPosition().x && player.getPosition().y > enemy.getPosition().y){
                    player.move(-player.getSpeed() * distanceMultiplier, player.getSpeed() * distanceMultiplier);
                }
                else if(player.getPosition().x > enemy.getPosition().x && player.getPosition().y < enemy.getPosition().y){
                    player.move(player.getSpeed() * distanceMultiplier, -player.getSpeed() * distanceMultiplier);
                }
                else if(player.getPosition().x > enemy.getPosition().x && player.getPosition().y > enemy.getPosition().y){
                    player.move(player.getSpeed() * distanceMultiplier, player.getSpeed() * distanceMultiplier);
                }
                else if(player.getPosition().x > enemy.getPosition().x){
                    player.move(player.getSpeed() * distanceMultiplier, 0);
                }
                else if(player.getPosition().y > enemy.getPosition().y){
                    player.move(0, player.getSpeed() * distanceMultiplier);
                }
                else if(player.getPosition().x < enemy.getPosition().x){
                    player.move(-player.getSpeed() * distanceMultiplier, 0);
                }
                else if(player.getPosition().y < enemy.getPosition().y){
                    player.move(0, -player.getSpeed() * distanceMultiplier);
                }
                enemiesToRemove.add(enemy);
            }
        }
        for(Enemy enemy : enemiesToRemove){
            enemyHandler.removeEnemy(enemy);
        }
    }

    public double calculateDistance(Vector2 fromPosition, Vector2 toPosition){
        return sqrt(pow(fromPosition.x - toPosition.x,2) + pow(fromPosition.y - toPosition.y,2));
    }
}
