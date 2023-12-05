package com.smurfsurvivors.test.view;

import com.smurfsurvivors.game.view.audiomanager.AudioManager;
import com.smurfsurvivors.game.AudioObservable;
import com.smurfsurvivors.test.model.LibGDXTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AudioManagerTest extends LibGDXTest {

    private AudioManager audioManager;
    private AudioObservable audioObservableMock;

    @BeforeEach
    public void setUp() {
        audioObservableMock = mock(AudioObservable.class);
        audioManager = new AudioManager(audioObservableMock);
    }

    @Test
    public void testPlaySoundEffect() {
        try {
            audioManager.playSoundEffect("HealthPickUp");
        } catch (Exception e) {
            fail("testPlaySoundEffect() failed");
        }
    }

    @Test
    public void testPlaySong() {
        try {
            audioManager.playSong("soundtrack");
        } catch (Exception e) {
            fail("testPlaySong() failed");
        }
    }

    @Test
    public void testSetMusicVolume() {
            audioManager.setMusicVolume(0.5f);
            assertEquals(0.5f, audioManager.getMusicVolume(), 0.001);
    }

    @Test
    public void testSetSoundVolume() {
            audioManager.setSoundVolume(0.5f);
            assertEquals(0.5f, audioManager.getSoundVolume(), 0.001);
    }

    @Test
    public void testAudioObserverInit() {
            audioManager.audioObserverInit(audioObservableMock);
    }

}