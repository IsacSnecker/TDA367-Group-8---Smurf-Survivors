package com.smurfsurvivors.game.model.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class MacheteWeapon extends PassiveWeapon{

    private final int direction;

    public MacheteWeapon(Vector2 _position, TextureRegion weaponTexture, int velocity, int attackDamage, int passThrough, int direction) {
        super(_position, weaponTexture, 35f, 35f, 5000f, "Axe");
        this.velocity = velocity;
        this.attackDamage = attackDamage;
        this.passThrough = passThrough;
        this.direction = direction;

    }

    public void update(){
        if (direction == 0) {
            move(0, velocity);
        } else if (direction == 1) {
            move(velocity, velocity);
        } else if (direction == 2) {
            move(velocity, 0);
        } else if (direction == 3) {
            move(velocity, -velocity);
        } else if (direction == 4) {
            move(0, -velocity);
        } else if (direction == 5) {
            move(-velocity, -velocity);
        } else if (direction == 6) {
            move(-velocity, 0);
        } else if (direction == 7) {
            move(-velocity, velocity);
        }
    }

    @Override
    public void render(SpriteBatch batch){
        if (direction == 0) {
            draw(batch, 20);
        } else if (direction == 1) {
            draw(batch, -25);
        } else if (direction == 2) {
            draw(batch, -70);
        } else if (direction == 3) {
            draw(batch, -115);
        } else if (direction == 4) {
            draw(batch, -160);
        } else if (direction == 5) {
            draw(batch, -205);
        } else if (direction == 6) {
            draw(batch, -250);
        } else if (direction == 7) {
            draw(batch, -295);
        }
    }

    private void draw(SpriteBatch batch, int rotation){
        batch.draw(weaponTexture, position.x, position.y, width, height, width, height, 1,1,rotation);

    }

}
