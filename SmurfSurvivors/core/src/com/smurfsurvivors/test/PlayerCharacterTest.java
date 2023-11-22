package com.smurfsurvivors.test;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.smurfsurvivors.game.entity.PlayerCharacter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PlayerCharacterTest extends LibGDXTest {

    @Test
    void updatePosition() {
    }

    @Test
    void addXP() {
        PlayerCharacter player = new PlayerCharacter(100, new Texture("Player/smurf-100x100.png"),0,0,32,32,40);
        player.addXP(100);
        assertEquals(100, player.getXP());
    }

    @Test
    void getXP() {
        PlayerCharacter player = new PlayerCharacter(100, new Texture("Player/smurf-100x100.png"),0,0,32,32,40);
        player.addXP(120);
        assertEquals(120, player.getXP());
    }

    @Test
    void getLevel() {
    }

    @Test
    void getMaxHealth() {
        PlayerCharacter player = new PlayerCharacter(132, new Texture("Player/smurf-100x100.png"),0,0,32,32,40);
        player.decreaseHealth(120);
        assertEquals(132, player.getMaxHealth());
    }

    @Test
    void getHealth() {
        PlayerCharacter player = new PlayerCharacter(132, new Texture("Player/smurf-100x100.png"),0,0,32,32,40);
        player.decreaseHealth(32);
        assertEquals(100,player.getHealth());
    }
}