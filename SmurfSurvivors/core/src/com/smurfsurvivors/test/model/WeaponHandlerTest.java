package com.smurfsurvivors.test.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.model.weapons.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class WeaponHandlerTest extends LibGDXTest{
    @Test
    void addBulletHandler(){
        WeaponHandler weaponHandler = new WeaponHandler();
        weaponHandler.addBulletHandler();
        assertEquals(1, weaponHandler.getHandlerList().size());
        assertEquals(weaponHandler.getHandlerList().get(0).getClass(), BulletHandler.class);
    }

    @Test
    void addKnifeHandler(){
        WeaponHandler weaponHandler = new WeaponHandler();
        weaponHandler.addKnifeHandler();
        assertEquals(1, weaponHandler.getHandlerList().size());
        assertEquals(weaponHandler.getHandlerList().get(0).getClass(), KnifeHandler.class);
    }

    @Test
    void addMagicHandler(){
        WeaponHandler weaponHandler = new WeaponHandler();
        weaponHandler.addMagicHandler();
        assertEquals(1, weaponHandler.getHandlerList().size());
        assertEquals(weaponHandler.getHandlerList().get(0).getClass(), MagicHandler.class);
    }

    @Test
    void addMissileHandler(){
        WeaponHandler weaponHandler = new WeaponHandler();
        weaponHandler.addMissileHandler();
        assertEquals(1, weaponHandler.getHandlerList().size());
        assertEquals(weaponHandler.getHandlerList().get(0).getClass(), MissileHandler.class);
    }

    @Test
    void addMacheteHandler(){
        WeaponHandler weaponHandler = new WeaponHandler();
        weaponHandler.addMacheteHandler();
        assertEquals(1, weaponHandler.getHandlerList().size());
        assertEquals(weaponHandler.getHandlerList().get(0).getClass(), MacheteHandler.class);
    }

    @Test
    public void testGetProjectilesandGetWeaponHandlers() {
        WeaponHandler weaponHandler = new WeaponHandler();
        weaponHandler.addKnifeHandler();
        weaponHandler.passiveWeaponUpdate(new Vector2(5, 5));

        assertEquals(1, weaponHandler.getProjectiles().size());
        assertEquals(1, weaponHandler.getHandlerList().size());
    }

    @Test
    public void removeProjectile() {
        WeaponHandler weaponHandler = new WeaponHandler();
        weaponHandler.addKnifeHandler();
        weaponHandler.passiveWeaponUpdate(new Vector2(5, 5));
        weaponHandler.removeProjectile(weaponHandler.getProjectiles().get(0));

        assertEquals(0, weaponHandler.getProjectiles().size());
        assertEquals(1, weaponHandler.getHandlerList().size());
    }

    @Test
    public void testLevelUpHandler() {
        WeaponHandler weaponHandler = new WeaponHandler();
        weaponHandler.addKnifeHandler();
        weaponHandler.addMacheteHandler();
        weaponHandler.addBulletHandler();
        weaponHandler.addMissileHandler();
        weaponHandler.addMagicHandler();

        weaponHandler.levelUpBullet();
        weaponHandler.levelUpMachete();
        weaponHandler.levelUpKnife();
        weaponHandler.levelUpMagic();
        weaponHandler.levelUpMissile();

        for(IHandler handler : weaponHandler.getWeaponHandlers()){
            assertEquals(2, handler.getLevel());
        }
    }
}