package com.smurfsurvivors.game;

public interface Observable {
    void initializeObservers();
    void notifyObservers();
    void addObserver(Observer o);
    void removeObserver(Observer o);
}
