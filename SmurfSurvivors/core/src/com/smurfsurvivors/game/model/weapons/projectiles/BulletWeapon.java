package com.smurfsurvivors.game.model.weapons.projectiles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class BulletWeapon extends AbstractWeapon {
    private final int playerDirection;
    private Random rnd = new Random();
    private final float randomDirection;
    public BulletWeapon(Vector2 _position, TextureRegion weaponTexture, int velocity, int attackDamage, int passThrough, int playerDirection) {
        super(_position, weaponTexture, 35f, 35f, 5000f, "Bullet");
        this.playerDirection = playerDirection;
        this.randomDirection = generateRandomDirection();
        this.velocity = velocity;
        this.attackDamage = attackDamage;
        this.passThrough = passThrough;

    }

    public void update() {
        if (playerDirection == 0) {
            move(randomDirection, velocity);
        } else if (playerDirection == 1) {
            move(velocity + randomDirection/2, velocity + randomDirection/2);
        } else if (playerDirection == 2) {
            move(velocity, randomDirection);
        } else if (playerDirection == 3) {
            move(velocity + randomDirection/2, -velocity + randomDirection/2);
        } else if (playerDirection == 4) {
            move(randomDirection, -velocity);
        } else if (playerDirection == 5) {
            move(-velocity + randomDirection/2, -velocity + randomDirection/2);
        } else if (playerDirection == 6) {
            move(-velocity, randomDirection);
        } else if (playerDirection == 7) {
            move(-velocity + randomDirection/2, velocity + randomDirection/2);
        }
    }

    private float generateRandomDirection(){
        return rnd.nextFloat(-5,5);
    }

    @Override
    public void render(SpriteBatch batch){
        if (playerDirection == 0) {
            draw(batch, 0);
        } else if (playerDirection == 1) {
            draw(batch, -45);
        } else if (playerDirection == 2) {
            draw(batch, -90);
        } else if (playerDirection == 3) {
            draw(batch, -135);
        } else if (playerDirection == 4) {
            draw(batch, -180);
        } else if (playerDirection == 5) {
            draw(batch, -225);
        } else if (playerDirection == 6) {
            draw(batch, -270);
        } else if (playerDirection == 7) {
            draw(batch, -315);
        }
    }

    private void draw(SpriteBatch batch, int rotation){
        batch.draw(weaponTexture, position.x + 50, position.y + 50, 0, 0, width, height, 1,1,rotation + 90);

    }
}
