package com.smurfsurvivors.test.model;

import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.model.weapons.MacheteHandler;
import com.smurfsurvivors.game.model.weapons.WeaponInformationHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MacheteHandlerTest extends LibGDXTest{
    @Test
    public void testSpawnProjectile() {
        WeaponInformationHandler weaponInformationHandler = new WeaponInformationHandler();
        MacheteHandler macheteHandler = new MacheteHandler(weaponInformationHandler);

        macheteHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(8, macheteHandler.getProjectiles().size());
        assertEquals(5000, macheteHandler.getCooldown(), 0.001);

        macheteHandler.levelUp(); // Level up to 2
        macheteHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(16, macheteHandler.getProjectiles().size());
        assertEquals(4000, macheteHandler.getCooldown(), 0.001);

        macheteHandler.levelUp(); // Level up to 3
        macheteHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(24, macheteHandler.getProjectiles().size());
        assertEquals(3000, macheteHandler.getCooldown(), 0.001);

        macheteHandler.levelUp(); // Level up to 4
        macheteHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(32, macheteHandler.getProjectiles().size());
        assertEquals(3000, macheteHandler.getCooldown(), 0.001);

        macheteHandler.levelUp(); // Level up to 5
        macheteHandler.spawnProjectile(new Vector2(0, 0));
        assertEquals(40, macheteHandler.getProjectiles().size());
        assertEquals(500, macheteHandler.getCooldown(), 0.001);
    }

    @Test
    public void testAddWeapon() {
        WeaponInformationHandler weaponInformationHandler = new WeaponInformationHandler();
        MacheteHandler macheteHandler = new MacheteHandler(weaponInformationHandler);

        Vector2 position = new Vector2(0, 0);
        macheteHandler.addWeapon(position, 20, 100, 0);

        assertEquals(8, macheteHandler.getProjectiles().size());
        assertEquals(100, macheteHandler.getProjectiles().get(0).getAttackDamage());
    }
}
