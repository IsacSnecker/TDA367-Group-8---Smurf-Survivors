package com.smurfsurvivors.game.entity;

import com.badlogic.gdx.graphics.Texture;

public class Gargamel extends Enemy{

    static Texture gargamelTexture = new Texture("Enemies/gargamel-150x150.png");
    public Gargamel(int x, int y) {
        super(100, 100, gargamelTexture, x, y, 150, 150, 2);
    }

    public void performAttack(){

    }
}
