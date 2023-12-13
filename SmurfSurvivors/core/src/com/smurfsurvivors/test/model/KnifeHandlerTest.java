package com.smurfsurvivors.test.model;

import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.model.weapons.KnifeHandler;
import com.smurfsurvivors.game.model.weapons.WeaponInformationHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnifeHandlerTest extends LibGDXTest{
    @Test
    public void testSpawnProjectile() {
        WeaponInformationHandler weaponInformationHandler = new WeaponInformationHandler();
        KnifeHandler knifeHandler = new KnifeHandler(weaponInformationHandler);

        knifeHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(1, knifeHandler.getProjectiles().size());
        assertEquals(500, knifeHandler.getCooldown(), 0.001);

        knifeHandler.levelUp(); // Level up to 2
        knifeHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(2, knifeHandler.getProjectiles().size());
        assertEquals(400, knifeHandler.getCooldown(), 0.001);

        knifeHandler.levelUp(); // Level up to 3
        knifeHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(3, knifeHandler.getProjectiles().size());
        assertEquals(300, knifeHandler.getCooldown(), 0.001);

        knifeHandler.levelUp(); // Level up to 4
        knifeHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(4, knifeHandler.getProjectiles().size());
        assertEquals(100, knifeHandler.getCooldown(), 0.001);

        knifeHandler.levelUp(); // Level up to 5
        knifeHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(5, knifeHandler.getProjectiles().size());
        assertEquals(100, knifeHandler.getCooldown(), 0.001);
    }

    @Test
    public void testAddWeapon() {
        WeaponInformationHandler weaponInformationHandler = new WeaponInformationHandler();
        KnifeHandler knifeHandler = new KnifeHandler(weaponInformationHandler);

        Vector2 position = new Vector2(0, 0);
        knifeHandler.addWeapon(position, 20, 100, 0);

        assertEquals(1, knifeHandler.getProjectiles().size());
        assertEquals(100, knifeHandler.getProjectiles().get(0).getAttackDamage());
    }
}
