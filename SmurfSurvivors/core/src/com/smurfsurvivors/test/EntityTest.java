package com.smurfsurvivors.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.smurfsurvivors.game.SmurfSurvivors;
import com.smurfsurvivors.game.entity.Demon;
import com.smurfsurvivors.game.entity.PlayerCharacter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.lwjgl.Sys;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


class EntityTest {

    @BeforeAll
    static void testSetup() {

        String currentDirectory = System.getProperty("user.dir");
        System.out.println("Current Working Directory: " + currentDirectory);

        Gdx.gl = mock(GL20.class); // Use a mock GL20 object

        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        new HeadlessApplication(new SmurfSurvivors(), config);

    }

    @Test
    void getX() {
        Demon demon = new Demon(100,100);
        demon.move(20,0);
        assertEquals(demon.getX(), 120);
    }

    @Test
    void getY() {
        Demon demon = new Demon(100,100);
        demon.move(0,20);
        assertEquals(demon.getY(), 120);
    }

    @Test
    void setY() {
        Demon demon = new Demon(100,100);
        demon.setY(120);
        assertEquals(demon.getY(), 120);
    }

    @Test
    void setX() {
        Demon demon = new Demon(100,100);
        demon.setX(120);
        assertEquals(demon.getX(), 120);
    }

}