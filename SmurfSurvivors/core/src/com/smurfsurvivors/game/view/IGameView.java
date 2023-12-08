package com.smurfsurvivors.game.view;

import com.smurfsurvivors.game.Observer;
import com.smurfsurvivors.game.view.audiomanager.IAudioManager;

public interface IGameView extends Observer {
    public IAudioManager getAudioManager();
}
