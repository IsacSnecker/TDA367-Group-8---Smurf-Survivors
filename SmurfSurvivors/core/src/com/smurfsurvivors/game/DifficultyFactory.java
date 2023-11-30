package com.smurfsurvivors.game;

public class DifficultyFactory {
    public static Difficulty createEasyDifficulty(){
        return new Difficulty(1,1,1);
    }
    public static Difficulty createNormalDifficulty(){
        return new Difficulty(2,2,2);
    }
    public static Difficulty createHardDifficulty(){
        return new Difficulty(3,3,3);
    }
}
