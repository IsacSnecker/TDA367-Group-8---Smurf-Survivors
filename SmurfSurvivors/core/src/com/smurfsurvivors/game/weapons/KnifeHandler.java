package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Collection;

public class KnifeHandler {

    public interface List<E> extends Collection<E> {};
    ArrayList<KnifeWeapon> knifeList = new ArrayList<KnifeWeapon> ();
    float cooldown;
    boolean Useable;
    SpriteBatch batch;
    long oldTime;

    public void KnifeHandler(SpriteBatch _batch){
        cooldown = 2f;
        Useable = true;
        batch = _batch;
        oldTime = 0;
    }

    public void update(Vector2 position, long currentTime){
        if(Useable){
            spawnKnife(position);
            Useable = false;
            oldTime = currentTime;
        } else if (currentTime - oldTime > cooldown) {
            Useable = true;
        }
        for(KnifeWeapon knife : knifeList){
            knife.update();
            knife.render(batch);
            if(!knife.isUseable){
                knife = null;
            }
        }
    }

    public void spawnKnife(Vector2 position) {
        knifeList.add(new KnifeWeapon(position));
    }
}
