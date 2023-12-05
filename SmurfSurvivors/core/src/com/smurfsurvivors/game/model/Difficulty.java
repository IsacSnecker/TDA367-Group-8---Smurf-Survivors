package com.smurfsurvivors.game.model;

public class Difficulty {
    private double spawnRateAdd;
    private double enemyHealthMultiplier;
    private double enemySpeedMultiplier;
    public Difficulty(double spawnRateAdd, double enemyHealthMultiplier, double enemySpeedMultiplier){
        this.spawnRateAdd = spawnRateAdd;
        this.enemyHealthMultiplier = enemyHealthMultiplier;
        this.enemySpeedMultiplier = enemySpeedMultiplier;
    }

    public double getSpawnRateAdd() { return spawnRateAdd; }
    public double getEnemyHealthMultiplier() { return enemyHealthMultiplier; }
    public double getEnemySpeedMultiplier() { return enemySpeedMultiplier; }

}
