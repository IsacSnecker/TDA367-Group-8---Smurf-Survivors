package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Collection;

public class KnifeHandler implements IHandler{

    public interface List<E> extends Collection<E> {};
    ArrayList<AbstractWeapon> knifeList = new ArrayList<AbstractWeapon> ();
    float cooldown;
    boolean Useable;
    long oldTime;

    public KnifeHandler(){
        cooldown = 500f;
        Useable = true;
        oldTime = 0;
    }

    public void updateProjectiles(Vector2 position, long currentTime){
        for(AbstractWeapon knife : knifeList){
            if(!knife.isUseable){
                knifeList.remove(knife);
            } else {
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

    public void renderProjectiles(SpriteBatch batch){
        for(AbstractWeapon knife : knifeList){
            knife.render(batch);
        }
    }

    public ArrayList<AbstractWeapon> getProjectiles(){
        return knifeList;
    }

    public void spawnKnife(Vector2 position) {
        knifeList.add(new KnifeWeapon(position));
    }
}
