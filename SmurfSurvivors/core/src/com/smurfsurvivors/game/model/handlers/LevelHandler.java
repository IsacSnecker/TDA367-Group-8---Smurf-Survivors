package com.smurfsurvivors.game.model.handlers;

import com.smurfsurvivors.game.model.entity.Enemy;
import com.smurfsurvivors.game.model.entity.PlayerCharacter;

public class LevelHandler implements ILevelHandler {

    public LevelHandler(){

    }

    public void playerLevelUp(PlayerCharacter player, Enemy enemy){
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

}
