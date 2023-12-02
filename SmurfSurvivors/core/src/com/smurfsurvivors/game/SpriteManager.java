package com.smurfsurvivors.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.smurfsurvivors.game.model.entity.Entity;
import com.smurfsurvivors.game.model.entity.ISpriteManager;

import java.util.HashMap;
import java.util.Map;

public class SpriteManager implements ISpriteManager {

    Map<String, Texture> textures;

    public SpriteManager() {
        this.textures = new HashMap<>();
        loadSprites();
    }

    private void loadSprites() {
        loadTexture("Player", "Player/smurf-90x90.png");
        loadTexture("Demon", "Enemies/demon-96x96.png");
        loadTexture("Gargamel", "Enemies/gargamel-150x150.png");
        loadTexture("Food", "Items/health.png");
        loadTexture("PurpleSmurf", "Enemies/purplemsmurf-pixel-60x83.png");
        loadTexture("Nemesis", "Enemies/Nemesis.png");
    }

    private void loadTexture(String name, String filepath) {
        Texture texture = new Texture(filepath);
        textures.put(name,texture);
    }

    public Sprite getSprite(Entity entity) {
        return new Sprite(textures.get(entity.getName()),0,0, entity.getWidth(), entity.getHeight());
    }



}
