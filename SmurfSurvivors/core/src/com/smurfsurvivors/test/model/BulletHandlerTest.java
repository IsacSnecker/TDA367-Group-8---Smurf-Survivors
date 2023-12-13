package com.smurfsurvivors.test.model;

import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.model.weapons.BulletHandler;
import com.smurfsurvivors.game.model.weapons.WeaponInformationHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BulletHandlerTest extends LibGDXTest{
    @Test
    public void testSpawnProjectile() {
        WeaponInformationHandler weaponInformationHandler = new WeaponInformationHandler();
        BulletHandler bulletHandler = new BulletHandler(weaponInformationHandler);

        bulletHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(1, bulletHandler.getProjectiles().size());
        assertEquals(200, bulletHandler.getCooldown(), 0.001);

        bulletHandler.levelUp(); // Level up to 2
        bulletHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(2, bulletHandler.getProjectiles().size());
        assertEquals(150, bulletHandler.getCooldown(), 0.001);

        bulletHandler.levelUp(); // Level up to 3
        bulletHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(3, bulletHandler.getProjectiles().size());
        assertEquals(100, bulletHandler.getCooldown(), 0.001);

        bulletHandler.levelUp(); // Level up to 4
        bulletHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(4, bulletHandler.getProjectiles().size());
        assertEquals(50, bulletHandler.getCooldown(), 0.001);

        bulletHandler.levelUp(); // Level up to 5
        bulletHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(6, bulletHandler.getProjectiles().size());
        assertEquals(50, bulletHandler.getCooldown(), 0.001);
    }

    @Test
    public void testAddWeapon() {
        WeaponInformationHandler weaponInformationHandler = new WeaponInformationHandler();
        BulletHandler bulletHandler = new BulletHandler(weaponInformationHandler);

        Vector2 position = new Vector2(0, 0);
        bulletHandler.addWeapon(position, 20, 100, 0);

        assertEquals(1, bulletHandler.getProjectiles().size());
        assertEquals(100, bulletHandler.getProjectiles().get(0).getAttackDamage());
    }
}
