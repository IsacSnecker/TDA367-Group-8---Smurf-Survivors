package com.smurfsurvivors.game;

public interface AudioObserver {

    void playSound(String soundName);

    void playSong(String songName);

    void audioObserverInit(AudioObservable a);


}
