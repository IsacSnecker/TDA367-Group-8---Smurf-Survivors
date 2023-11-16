package com.smurfsurvivors.game.entity;

import com.badlogic.gdx.graphics.Texture;

public class Gargamel extends Enemy{
    public Gargamel(int x, int y) {
        super(100, 100, new Texture("Enemies/gargamel-150x150.png"), x, y, 150, 150, 2);
    }

    public void performAttack(){

    }
}
