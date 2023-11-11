package com.smurfsurvivors.game.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Collection;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

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
        ArrayList<AbstractWeapon> knivesToRemove = new ArrayList<AbstractWeapon>();
        for(AbstractWeapon knife : knifeList){
            if(calculateDistance(new Vector2(knife.positionRectangle.x, knife.positionRectangle.y), knife.originalPosition) > knife.attackRange){
                knivesToRemove.add(knife);
            }
            knife.update();
        }
        knifeList.removeAll(knivesToRemove);
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

    public double calculateDistance(Vector2 fromPosition, Vector2 toPosition){
        return sqrt(pow(fromPosition.x - toPosition.x,2) + pow(fromPosition.y - toPosition.y,2));
    }
}
