package com.smurfsurvivors.test.model;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.smurfsurvivors.game.model.GameModel;
import org.junit.jupiter.api.BeforeAll;

import static org.mockito.Mockito.mock;

public class LibGDXTest extends ApplicationAdapter {

    @BeforeAll
    static void testSetup() {
        // Mock the GL20 class
        Gdx.gl = mock(GL20.class);

        // Set up a headless application
        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        new HeadlessApplication(new LibGDXTest(), config);

    }

    @Override
    public void create() {
        // Initialization code if needed
    }

    @Override
    public void render() {
        // Render code if needed
    }

    @Override
    public void dispose() {
        // Cleanup code if needed
    }

}
