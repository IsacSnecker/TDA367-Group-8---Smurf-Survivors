package com.smurfsurvivors.test.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.model.weapons.KnifeHandler;
import com.smurfsurvivors.game.model.weapons.KnifeWeapon;
import com.smurfsurvivors.game.model.weapons.WeaponHandler;
import com.smurfsurvivors.game.model.weapons.WeaponInformationHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractWeaponHandlerTest extends LibGDXTest{

    @Test
    void testUpdateProjectilesRemoval(){
        WeaponInformationHandler weaponInformationHandler = new WeaponInformationHandler();
        KnifeHandler knifeHandler = new KnifeHandler(weaponInformationHandler);
        KnifeWeapon knifeWeapon = new KnifeWeapon(new Vector2(100, 100), new TextureRegion(), 2, 20, 30, 2, 100);
        knifeHandler.getProjectiles().add(knifeWeapon);
        knifeWeapon.setX(5200);
        knifeWeapon.setY(5200);
        knifeHandler.updateProjectiles(new Vector2(5, 5), 0);
        assertEquals(1, knifeHandler.getProjectiles().size());
    }

    @Test
    void testUpdateProjectilesCreation(){
        WeaponInformationHandler weaponInformationHandler = new WeaponInformationHandler();
        KnifeHandler knifeHandler = new KnifeHandler(weaponInformationHandler);
        knifeHandler.updateProjectiles(new Vector2(5, 5), 0);
        assertEquals(1, knifeHandler.getProjectiles().size());
    }

    @Test
    void testUpdateProjectilesCooldown(){
        WeaponInformationHandler weaponInformationHandler = new WeaponInformationHandler();
        KnifeHandler knifeHandler = new KnifeHandler(weaponInformationHandler);

        knifeHandler.updateProjectiles(new Vector2(5, 5), 0);
        assertEquals(1, knifeHandler.getProjectiles().size());

        knifeHandler.updateProjectiles(new Vector2(5, 5), 200);
        assertEquals(1, knifeHandler.getProjectiles().size());

        knifeHandler.updateProjectiles(new Vector2(5, 5), 502);
        knifeHandler.updateProjectiles(new Vector2(5, 5), 503);

        assertEquals(2, knifeHandler.getProjectiles().size());
    }

    @Test
    public void testLevelUp() {
        WeaponInformationHandler weaponInformationHandler = new WeaponInformationHandler();
        KnifeHandler knifeHandler = new KnifeHandler(weaponInformationHandler);

        int initialLevel = knifeHandler.getLevel();
        knifeHandler.levelUp();
        assertEquals(initialLevel + 1, knifeHandler.getLevel());
    }

    @Test
    public void testRemoveProjectile() {
        WeaponInformationHandler weaponInformationHandler = new WeaponInformationHandler();
        KnifeHandler knifeHandler = new KnifeHandler(weaponInformationHandler);
        KnifeWeapon knifeWeapon = new KnifeWeapon(new Vector2(100, 100), new TextureRegion(), 2, 20, 30, 2, 100);
        knifeHandler.getProjectiles().add(knifeWeapon);

        knifeHandler.removeProjectile(knifeWeapon);

        assertFalse(knifeHandler.getProjectiles().contains(knifeWeapon));
    }

    @Test
    public void testGetProjectiles() {
        WeaponInformationHandler weaponInformationHandler = new WeaponInformationHandler();
        KnifeHandler knifeHandler = new KnifeHandler(weaponInformationHandler);
        KnifeWeapon knifeWeapon = new KnifeWeapon(new Vector2(100, 100), new TextureRegion(), 2, 20, 30, 2, 100);
        knifeHandler.getProjectiles().add(knifeWeapon);
        assertEquals(1, knifeHandler.getProjectiles().size());
        assertTrue(knifeHandler.getProjectiles().contains(knifeWeapon));
    }
}
