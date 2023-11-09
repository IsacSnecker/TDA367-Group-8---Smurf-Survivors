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

    public KnifeHandler(SpriteBatch _batch){
        cooldown = 500f;
        Useable = true;
        batch = _batch;
        oldTime = 0;
    }

    public void update(Vector2 position, long currentTime){
        for(KnifeWeapon knife : knifeList){
            if(!knife.isUseable){
                //knifeList.remove(knife);
            } else {
                knife.render(batch);
                knife.update();
            }
        }
        if(Useable){
            spawnKnife(position);
            Useable = false;
            oldTime = currentTime;
        } else if ((currentTime - oldTime) > cooldown) {
            Useable = true;
        }
    }

    public void spawnKnife(Vector2 position) {
        knifeList.add(new KnifeWeapon(position));
    }
}
