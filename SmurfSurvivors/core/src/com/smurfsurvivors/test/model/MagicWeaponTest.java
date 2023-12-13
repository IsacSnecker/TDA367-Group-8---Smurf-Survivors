package com.smurfsurvivors.test.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.model.entity.Demon;
import com.smurfsurvivors.game.model.entity.Enemy;
import com.smurfsurvivors.game.model.weapons.MagicWeapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MagicWeaponTest extends LibGDXTest{
    @Test
    void update(){
        Enemy enemy = new Demon(100, 100);
        MagicWeapon magic = new MagicWeapon(new Vector2(0, 0), new TextureRegion(), 1, 100, 100, new Vector2(enemy.getX(), enemy.getY()));
        magic.update();
        assertEquals(Math.sqrt(2)/2, magic.getX(), 0.01);
        assertEquals(Math.sqrt(2)/2, magic.getY(), 0.01);
    }
}
