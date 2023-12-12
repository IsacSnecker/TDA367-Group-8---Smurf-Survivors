package com.smurfsurvivors.game.model.handlers;

import com.smurfsurvivors.game.model.entity.Enemy;
import com.smurfsurvivors.game.model.entity.PlayerCharacter;

public class LevelHandler implements ILevelHandler {

    public LevelHandler(){

    }

    public void playerLevelUp(PlayerCharacter player, Enemy enemy){
        boolean levelUp = player.addXP(enemy.getXpGive());

        if (levelUp) {
            switch (player.getLevel()) {
                case 2:
                case 6:
                case 10:
                case 11:
                    player.wHandler.levelUpBullet();
                    break;
                case 3:
                    player.wHandler.addKnifeHandler();
                    break;
                case 4:
                case 8:
                case 5:
                case 9:
                    player.wHandler.levelUpKnife();
                    break;
                case 7:
                    player.wHandler.addMissileHandler();
                    break;
                case 12:
                    player.wHandler.addMagicHandler();
                    break;
                case 13:
                case 16:
                case 14:
                case 15:
                    player.wHandler.levelUpMissile();
                    break;
                case 17:
                case 18:
                case 19:
                case 20:
                    player.wHandler.levelUpMagic();
                    break;
                case 21:
                    player.wHandler.addMacheteHandler();
                    break;
                case 22:
                case 23:
                case 24:
                case 25:
                    player.wHandler.levelUpMachete();
                    break;
                default:
                    break;
            }
        }

    }

}
