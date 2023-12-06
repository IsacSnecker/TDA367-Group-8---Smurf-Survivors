package com.smurfsurvivors.test.model;

import com.smurfsurvivors.game.model.entity.*;
import com.smurfsurvivors.game.model.factories.EnemyFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyFactoryTest extends LibGDXTest{
    @Test
    void makeDemons(){
        ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
        enemyList.addAll(EnemyFactory.makeDemons(7, 16000, 16000));
        assertEquals(7, enemyList.size());
        for(Enemy enemy : enemyList){
            assertTrue(12500 <= enemy.getX() && enemy.getX() <= 19500);
            assertTrue(12500 <= enemy.getY() && enemy.getY() <= 19500);
            assertEquals(enemy.getClass(), Demon.class);
        }
    }

    @Test
    void makeGargamels(){
        ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
        enemyList.addAll(EnemyFactory.makeGargamels(7, 16000, 16000));
        assertEquals(7, enemyList.size());
        for(Enemy enemy : enemyList){
            assertTrue(12500 <= enemy.getX() && enemy.getX() <= 19500);
            assertTrue(12500 <= enemy.getY() && enemy.getY() <= 19500);
            assertEquals(enemy.getClass(), Gargamel.class);
        }
    }

    @Test
    void makePurpleSmurfs(){
        ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
        enemyList.addAll(EnemyFactory.makePurpleSmurfs(7, 16000, 16000));
        assertEquals(7, enemyList.size());
        for(Enemy enemy : enemyList){
            assertTrue(12500 <= enemy.getX() && enemy.getX() <= 19500);
            assertTrue(12500 <= enemy.getY() && enemy.getY() <= 19500);
            assertEquals(enemy.getClass(), PurpleSmurf.class);
        }
    }

    @Test
    void makeNemesises(){
        ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
        enemyList.addAll(EnemyFactory.makeNemesises(7, 16000, 16000));
        assertEquals(7, enemyList.size());
        for(Enemy enemy : enemyList){
            assertTrue(12500 <= enemy.getX() && enemy.getX() <= 19500);
            assertTrue(12500 <= enemy.getY() && enemy.getY() <= 19500);
            assertEquals(enemy.getClass(), Nemesis.class);
        }
    }
}
