package com.smurfsurvivors.test.model;

import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.model.weapons.MagicHandler;
import com.smurfsurvivors.game.model.weapons.WeaponInformationHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MagicHandlerTest extends LibGDXTest{
    @Test
    public void testSpawnProjectile() {
        WeaponInformationHandler weaponInformationHandler = new WeaponInformationHandler();
        MagicHandler magicHandler = new MagicHandler(weaponInformationHandler);

        magicHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(1, magicHandler.getProjectiles().size());
        assertEquals(700, magicHandler.getCooldown(), 0.001);

        magicHandler.levelUp(); // Level up to 2
        magicHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(2, magicHandler.getProjectiles().size());
        assertEquals(500, magicHandler.getCooldown(), 0.001);

        magicHandler.levelUp(); // Level up to 3
        magicHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(3, magicHandler.getProjectiles().size());
        assertEquals(400, magicHandler.getCooldown(), 0.001);

        magicHandler.levelUp(); // Level up to 4
        magicHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(4, magicHandler.getProjectiles().size());
        assertEquals(400, magicHandler.getCooldown(), 0.001);

        magicHandler.levelUp(); // Level up to 5
        magicHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(6, magicHandler.getProjectiles().size());
        assertEquals(100, magicHandler.getCooldown(), 0.001);
    }

    @Test
    public void testAddWeapon() {
        WeaponInformationHandler weaponInformationHandler = new WeaponInformationHandler();
        MagicHandler magicHandler = new MagicHandler(weaponInformationHandler);

        Vector2 position = new Vector2(0, 0);
        magicHandler.addWeapon(position, 20, 100, 0);

        assertEquals(1, magicHandler.getProjectiles().size());
        assertEquals(100, magicHandler.getProjectiles().get(0).getAttackDamage());
    }
}
