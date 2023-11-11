package com.smurfsurvivors.game;

<<<<<<< Updated upstream:SmurfSurvivors/core/src/com/smurfsurvivors/game/IGameView.java
public interface IGameView {
=======
import com.badlogic.gdx.graphics.Texture;
import com.smurfsurvivors.game.entity.Demon;
import com.smurfsurvivors.game.entity.Enemy;

import java.util.ArrayList;

public class EnemyHandler {
    ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
    public void spawnDemon(){
        enemyList.add(new Enemy(100, 100, new Texture("Enemies/blueDemon.png"), 100, 100, 32, 32));
    }
>>>>>>> Stashed changes:SmurfSurvivors/core/src/com/smurfsurvivors/game/EnemyHandler.java
}
