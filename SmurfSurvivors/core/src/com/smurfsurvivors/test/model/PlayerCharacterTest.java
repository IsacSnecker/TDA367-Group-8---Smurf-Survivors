package com.smurfsurvivors.test.model;

import com.smurfsurvivors.game.model.entity.PlayerCharacter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PlayerCharacterTest extends LibGDXTest {

    @Test
    void addXP() {
        PlayerCharacter player = new PlayerCharacter(100,0,0,32,32,40, 0);
        player.addXP(110);
        assertEquals(10, player.getXP());
    }

    @Test
    void getXP() {
        PlayerCharacter player = new PlayerCharacter(100,0,0,32,32,40, 0);
        player.addXP(50);
        assertEquals(50, player.getXP());
    }

    @Test
    void getLevel() {
        PlayerCharacter player = new PlayerCharacter(132,0,0,32,32,40, 0);
        player.addXP(120);
        assertEquals(2, player.getLevel());
    }

    @Test
    void getLevelCap() {
        PlayerCharacter player = new PlayerCharacter(132,0,0,32,32,40, 0);
        player.addXP(120);
        assertEquals(110, player.getLevelCap());
    }

    @Test
    void updatePosition() {
        PlayerCharacter player = new PlayerCharacter(100, 0, 0, 50, 50, 1, 0);

        // Test moving right
        player.updatePosition(new ArrayList<Integer>(Arrays.asList(1, 0, 0, 0)));
        assertEquals(0, player.getDirection());
        assertEquals(0, player.getX()); // Assuming initial X position is 0
        assertEquals(1, player.getY());

        // Test moving left
        player.updatePosition(new ArrayList<Integer>(Arrays.asList(0, 0, 1, 0)));
        assertEquals(4, player.getDirection());
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());

        // Test moving up
        player.updatePosition(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0)));
        assertEquals(2, player.getDirection());
        assertEquals(1, player.getX());
        assertEquals(0, player.getY()); // Assuming initial Y position is 0

        // Test moving down
        player.updatePosition(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 1)));
        assertEquals(6, player.getDirection());
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());

        // Test moving up right
        player.updatePosition(new ArrayList<Integer>(Arrays.asList(1, 1, 0, 0)));
        assertEquals(1, player.getDirection());
        assertEquals((double)Math.round(Math.sqrt(2)/2), (double)Math.round(player.getX()));
        assertEquals((double)Math.round(Math.sqrt(2)/2), (double)Math.round(player.getY()));

        // Test moving down left
        player.updatePosition(new ArrayList<Integer>(Arrays.asList(0, 0, 1, 1)));
        assertEquals(5, player.getDirection());
        assertEquals(0, player.getX());
        assertEquals(0,player.getY());

        // Test moving down right
        player.updatePosition(new ArrayList<Integer>(Arrays.asList(0, 1, 1, 0)));
        assertEquals(3, player.getDirection());
        assertEquals((double)Math.round(Math.sqrt(2)/2), (double)Math.round(player.getX()));
        assertEquals(-(double)Math.round(Math.sqrt(2)/2), (double)Math.round(player.getY()));

        // Test moving up left
        player.updatePosition(new ArrayList<Integer>(Arrays.asList(1, 0, 0, 1)));
        assertEquals(7, player.getDirection());
        assertEquals(0, player.getX());
        assertEquals(0,player.getY());
    }
}