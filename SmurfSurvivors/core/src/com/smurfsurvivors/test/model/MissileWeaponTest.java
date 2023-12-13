package com.smurfsurvivors.test.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.model.entity.Demon;
import com.smurfsurvivors.game.model.entity.Enemy;
import com.smurfsurvivors.game.model.weapons.MissileWeapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissileWeaponTest extends LibGDXTest{
    @Test
    void update(){
        Enemy enemy = new Demon(100, 100);
        MissileWeapon missile = new MissileWeapon(new Vector2(0, 0), new TextureRegion(), 1, 100, 100, enemy);
        missile.update();
        assertEquals(Math.sqrt(2)/2, missile.getX(), 0.01);
        assertEquals(Math.sqrt(2)/2, missile.getY(), 0.01);
    }
}
