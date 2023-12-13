package com.smurfsurvivors.test.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.model.weapons.KnifeWeapon;
import com.smurfsurvivors.game.model.weapons.MacheteWeapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MacheteWeaponTest extends  LibGDXTest{
    @Test
    void update(){
        MacheteWeapon machete = new MacheteWeapon(new Vector2(0, 0), new TextureRegion(), 2, 100, 100, 0);
        machete.update();
        assertEquals(2, machete.getY());
        assertEquals(0, machete.getX());

        machete = new MacheteWeapon(new Vector2(0, 0), new TextureRegion(), 2, 100, 100, 1);
        machete.update();
        assertEquals(2, machete.getY());
        assertEquals(2, machete.getX());

        machete = new MacheteWeapon(new Vector2(0, 0), new TextureRegion(), 2, 100, 100, 2);
        machete.update();
        assertEquals(0, machete.getY());
        assertEquals(2, machete.getX());

        machete = new MacheteWeapon(new Vector2(0, 0), new TextureRegion(), 2, 100, 100, 3);
        machete.update();
        assertEquals(-2, machete.getY());
        assertEquals(2, machete.getX());

        machete = new MacheteWeapon(new Vector2(0, 0), new TextureRegion(), 2, 100, 100, 4);
        machete.update();
        assertEquals(-2, machete.getY());
        assertEquals(0, machete.getX());

        machete = new MacheteWeapon(new Vector2(0, 0), new TextureRegion(), 2, 100, 100, 5);
        machete.update();
        assertEquals(-2, machete.getY());
        assertEquals(-2, machete.getX());

        machete = new MacheteWeapon(new Vector2(0, 0), new TextureRegion(), 2, 100, 100, 6);
        machete.update();
        assertEquals(0, machete.getY());
        assertEquals(-2, machete.getX());

        machete = new MacheteWeapon(new Vector2(0, 0), new TextureRegion(), 2, 100, 100, 7);
        machete.update();
        assertEquals(2, machete.getY());
        assertEquals(-2, machete.getX());
    }
}
