package com.smurfsurvivors.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.smurfsurvivors.game.model.entity.Entity;

import java.util.HashMap;
import java.util.Map;

public class SpriteManager {

    Map<String, Texture> textures;

    public SpriteManager() {
        this.textures = new HashMap<>();
        loadSprites();
    }

    private void loadSprites() {
        loadTexture("Player", "Player/smurf-100x100.png");
        loadTexture("Demon", "Enemies/demon.png");
        loadTexture("Gargamel", "Enemies/gargamel-150x150.png");
        loadTexture("Food", "Items/health.png");
        loadTexture("PurpleSmurf", "Enemies/demon.png");
        loadTexture("Nemesis", "Enemies/demon.png");
    }

    private void loadTexture(String name, String filepath) {
        Texture texture = new Texture(filepath);
        textures.put(name,texture);
    }

    public Sprite getSprite(Entity entity) {
        return new Sprite(textures.get(entity.getName()),0,0, entity.getWidth(), entity.getHeight());
    }



}
