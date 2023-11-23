package com.smurfsurvivors.game.weapons;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class KnifeWeapon extends PassiveWeapon{

    public KnifeWeapon(Vector2 _position, Texture weaponTexture){
        super(_position, weaponTexture, 50f,50f, 500f, 20, 50, "Knife");

    }

    public void update(Vector2 enemyPosition, int playerDirection) {
        if (playerDirection == 0) {
            move(0, velocity);
        } else if (playerDirection == 1) {
            move(velocity, velocity);
        } else if (playerDirection == 2) {
            move(velocity, 0);
        } else if (playerDirection == 3) {
            move(velocity, -velocity);
        } else if (playerDirection == 4) {
            move(0, -velocity);
        } else if (playerDirection == 5) {
            move(-velocity, -velocity);
        } else if (playerDirection == 6) {
            move(-velocity, 0);
        } else if (playerDirection == 7) {
            move(-velocity, velocity);
        }
        }
    }
