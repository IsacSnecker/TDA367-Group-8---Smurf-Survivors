package com.smurfsurvivors.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.smurfsurvivors.game.weapons.AbstractWeapon;

import java.util.List;

public class PlayerCharacter extends Creature{ //Should PlayerCharacter be used through delegation?
    private List<AbstractWeapon> passiveWeapons; //Should be List<PassiveWeapon>
    private List<AbstractWeapon> abilities; //Should be List<Ability>

    public PlayerCharacter(Texture sprite, int x, int y, int width, int height) {
        super(sprite, x, y, width, height);
    }
    //private

    public void addPassiveWeapon(AbstractWeapon passiveWeapon){
        passiveWeapons.add(passiveWeapon);
    }
    public void addAbility(AbstractWeapon ability){
        abilities.add(ability);
    }
    public void usePassiveWeapon(AbstractWeapon passiveWeapon){
        passiveWeapon.performAttack();
    }
    public void useAbility(AbstractWeapon ability){
        ability.performAttack();
    }
    public void useAllAbilities(){
        for(AbstractWeapon ability : abilities){
            useAbility(ability);
        }
    }
}
