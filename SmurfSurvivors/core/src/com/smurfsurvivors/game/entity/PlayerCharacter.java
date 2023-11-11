package com.smurfsurvivors.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.weapons.PassiveWeapon;
import com.smurfsurvivors.game.weapons.ActiveWeapon;
import com.smurfsurvivors.game.weapons.WeaponHandler;


import java.util.List;

public class PlayerCharacter extends Creature{ //Should PlayerCharacter be used through delegation?
    private List<PassiveWeapon> passiveWeapons; //Should be List<PassiveWeapon>
    private List<ActiveWeapon> abilities; //Should be List<Ability>

    public WeaponHandler WHandler = new WeaponHandler();

    public PlayerCharacter(int health, Texture sprite, int x, int y, int width, int height) {
        super(health, sprite, x, y, width, height);
        WHandler.giveKnife();
    }
    //private

    public void addPassiveWeapon(PassiveWeapon passiveWeapon){
        passiveWeapons.add(passiveWeapon);
    }
    public void addAbility(ActiveWeapon ability){
        abilities.add(ability);
    }
    public void usePassiveWeapon(){
        WHandler.passiveWeaponUpdate(new Vector2(getX(),getY()));
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
