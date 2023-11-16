package com.smurfsurvivors.game;

public class Difficulty {
    private double spawnRateMultiplier;
    private double enemyHealthMultiplier;
    private double enemySpeedMultiplier;
    public Difficulty(double spawnRateMultiplier, double enemyHealthMultiplier, double enemySpeedMultiplier){
        this.spawnRateMultiplier = spawnRateMultiplier;
        this.enemyHealthMultiplier = enemyHealthMultiplier;
        this.enemySpeedMultiplier = enemySpeedMultiplier;
    }

    public double getSpawnRateMultiplier() { return spawnRateMultiplier; }
    public double getEnemyHealthMultiplier() { return enemyHealthMultiplier; }
    public double getEnemySpeedMultiplier() { return enemySpeedMultiplier; }

}
