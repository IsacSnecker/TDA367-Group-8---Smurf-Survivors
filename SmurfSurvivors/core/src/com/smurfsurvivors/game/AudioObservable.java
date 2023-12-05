package com.smurfsurvivors.game;

public interface AudioObservable {

    void addSoundObserver(AudioObserver o);
    void removeSoundObserver(AudioObserver o);
    void notifyAudioObservers( x);

}
