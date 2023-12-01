package com.smurfsurvivors.game;

public interface IAudioManager {

    void playSong(String songname);
    void playSoundEffect(String soundEffectKey);
    void setMusicVolume(float volume);
    void setSoundVolume(float volume);

}
