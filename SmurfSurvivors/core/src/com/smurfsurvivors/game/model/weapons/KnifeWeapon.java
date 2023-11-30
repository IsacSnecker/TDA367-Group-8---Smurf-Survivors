package com.smurfsurvivors.game.model.weapons;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class KnifeWeapon extends PassiveWeapon {

    int playerDirection;

    public KnifeWeapon(Vector2 _position, TextureRegion weaponTexture, int velocity, int attackDamage, int passThrough, int playerDirection) {
        super(_position, weaponTexture, 35f, 35f, 5000f, "Magic");
        this.velocity = velocity;
        this.attackDamage = attackDamage;
        this.passThrough = passThrough;
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
        if (playerDirection == 0) {
            draw(batch, 20);
        } else if (playerDirection == 1) {
            draw(batch, -25);
        } else if (playerDirection == 2) {
            draw(batch, -70);
        } else if (playerDirection == 3) {
            draw(batch, -115);
        } else if (playerDirection == 4) {
            draw(batch, -160);
        } else if (playerDirection == 5) {
            draw(batch, -205);
        } else if (playerDirection == 6) {
            draw(batch, -250);
        } else if (playerDirection == 7) {
            draw(batch, -295);
        }
    }

    private void draw(SpriteBatch batch, int rotation){
        batch.draw(weaponTexture, position.x, position.y, width, height, width, height, 1,1,rotation);

    }

    }

