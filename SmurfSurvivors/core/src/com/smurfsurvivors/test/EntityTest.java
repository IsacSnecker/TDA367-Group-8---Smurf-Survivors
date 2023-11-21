package com.smurfsurvivors.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.smurfsurvivors.game.SmurfSurvivors;
import com.smurfsurvivors.game.entity.PlayerCharacter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.lwjgl.Sys;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class EntityTest {

    @BeforeAll
    static void testSetup() {

        String currentDirectory = System.getProperty("user.dir");
        System.out.println("Current Working Directory: " + currentDirectory);

        Gdx.gl = mock(GL20.class); // Use a mock GL20 object
        // Other necessary mock setups

        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        new HeadlessApplication(new SmurfSurvivors(), config);

    }

    @Test
    void getX() {

    }

    @Test
    void getY() {
    }
}