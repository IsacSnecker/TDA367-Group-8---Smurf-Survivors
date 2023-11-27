package com.smurfsurvivors.game.model.weapons;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class KnifeWeapon extends PassiveWeapon {

    int playerDirection;

    public KnifeWeapon(Vector2 _position, TextureRegion weaponTexture, int playerDirection) {
        super(_position, weaponTexture, 50f, 50f, 500f, 20, 50, "Knife");
        this.playerDirection = playerDirection;

    }

    public void update() {
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

    @Override
    public void render(SpriteBatch batch){
        batch.draw(weaponTexture, position.x, position.y, width, height, 100, 100, 1,1,180);
    }

    }

