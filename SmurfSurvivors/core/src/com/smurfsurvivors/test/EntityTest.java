package com.smurfsurvivors.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.SmurfSurvivors;
import com.smurfsurvivors.game.entity.Demon;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


class EntityTest extends LibGDXTest {


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

    @Test
    void getPositiion() {
        Demon demon = new Demon(100,100);
        assertEquals(new Vector2(100,100), demon.getPosition());
    }



}

