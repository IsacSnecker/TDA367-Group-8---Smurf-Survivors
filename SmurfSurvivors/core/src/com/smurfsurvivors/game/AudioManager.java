package com.smurfsurvivors.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import java.util.HashMap;
import java.util.Map;

public class AudioManager  {

    private float musicVolume = 0.7f;
    private float soundVolume = 0.7f;




    private Map<String, Music> songs;
    private Map<String, Sound> soundEffects;

    public AudioManager() {

        this.songs = new HashMap<>();
        this.soundEffects = new HashMap<>();

        loadSongs();
        loadSoundEffects();
    }

    private void loadSoundEffects() {
        String path = "Sounds/SoundFX/";
        loadSoundEffect("HealthPickUp", path + "HealthPickUp.wav");
        loadSoundEffect("DemonDeath", path + "DemonDeath.wav");
    }

    private void loadSongs() {
        loadSong("soundtrack", "Sounds/Hallonsaft.mp3");
    }

    public void playSoundEffect(String soundEffectKey) {
        System.out.println("Played:" + soundEffectKey);
        Sound sound = soundEffects.get(soundEffectKey);
        if (sound != null) {
            sound.play(soundVolume);
        }
    }
    public void playSong(String songName) {
        Music song = songs.get(songName);
        if (songName != null) {
            song.setLooping(true);
            song.setVolume(musicVolume);
            song.play();
        }
    }

    public void stopMusic(String song) {
        Music music = songs.get(song);
        music.stop();
    }

    public void setMusicVolume(float volume) {
        musicVolume = volume;
        for(Music music : songs.values()){
            music.setVolume(volume);
        }
    }

    public void setSoundVolume(float volume) {
        soundVolume = volume;
        for(Sound sound : soundEffects.values()){
            sound.setVolume(0, volume);
        }
    }

    private void loadSoundEffect(String name, String filePath) {
        Sound sound = Gdx.audio.newSound(Gdx.files.internal(filePath));
        soundEffects.put(name, sound);
    }

    private void loadSong(String name, String filePath) {
        Music song = Gdx.audio.newMusic(Gdx.files.internal(filePath));
        songs.put(name, song);
    }


}
