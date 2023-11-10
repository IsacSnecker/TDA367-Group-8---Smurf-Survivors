package com.smurfsurvivors.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.smurfsurvivors.game.weapons.PassiveWeapon;
import com.smurfsurvivors.game.weapons.ActiveWeapon;
import com.smurfsurvivors.game.weapons.WeaponHandler;


import java.util.List;

public class PlayerCharacter extends Creature{ //Should PlayerCharacter be used through delegation?
    private List<PassiveWeapon> passiveWeapons; //Should be List<PassiveWeapon>
    private List<ActiveWeapon> abilities; //Should be List<Ability>

    private WeaponHandler Whandler = new WeaponHandler();

    public PlayerCharacter(int health, Texture sprite, int x, int y, int width, int height) {
        super(health, sprite, x, y, width, height);
    }
    //private

    public void addPassiveWeapon(PassiveWeapon passiveWeapon){
        passiveWeapons.add(passiveWeapon);
    }
    public void addAbility(ActiveWeapon ability){
        abilities.add(ability);
    }
    public void usePassiveWeapon(PassiveWeapon passiveWeapon){
        passiveWeapon.performAttack();
    }
    public void useAbility(ActiveWeapon ability){
        ability.performAttack();
    }
    public void useAllAbilities(){
        for(ActiveWeapon ability : abilities){
            useAbility(ability);
        }
    }
}
