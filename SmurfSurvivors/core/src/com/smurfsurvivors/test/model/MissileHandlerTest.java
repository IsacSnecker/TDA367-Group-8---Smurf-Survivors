package com.smurfsurvivors.test.model;

import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.model.weapons.MissileHandler;
import com.smurfsurvivors.game.model.weapons.MissileWeapon;
import com.smurfsurvivors.game.model.weapons.WeaponInformationHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissileHandlerTest extends LibGDXTest{
    @Test
    public void testSpawnProjectile() {
        WeaponInformationHandler weaponInformationHandler = new WeaponInformationHandler();
        MissileHandler missileHandler = new MissileHandler(weaponInformationHandler);

        missileHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(1, missileHandler.getProjectiles().size());
        assertEquals(1000f, missileHandler.getCooldown(), 0.001);

        missileHandler.levelUp(); // Level up to 2
        missileHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(2, missileHandler.getProjectiles().size());
        assertEquals(800, missileHandler.getCooldown(), 0.001);

        missileHandler.levelUp(); // Level up to 3
        missileHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(3, missileHandler.getProjectiles().size());
        assertEquals(700, missileHandler.getCooldown(), 0.001);

        missileHandler.levelUp(); // Level up to 4
        missileHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(4, missileHandler.getProjectiles().size());
        assertEquals(500, missileHandler.getCooldown(), 0.001);

        missileHandler.levelUp(); // Level up to 5
        missileHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(6, missileHandler.getProjectiles().size());
        assertEquals(200, missileHandler.getCooldown(), 0.001);
    }

    @Test
    public void testAddWeapon() {
        WeaponInformationHandler weaponInformationHandler = new WeaponInformationHandler();
        MissileHandler missileHandler = new MissileHandler(weaponInformationHandler);

        Vector2 position = new Vector2(0, 0);
        missileHandler.addWeapon(position, 20, 100, 0);

        assertEquals(1, missileHandler.getProjectiles().size());
        assertEquals(100, missileHandler.getProjectiles().get(0).getAttackDamage());
    }
}
