package com.smurfsurvivors.game.model.clock;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class Clock {
    private BitmapFont bitmapFont;
    private GlyphLayout glyphLayout;
    private long timeMillis;
    private long startTime;
    private long pauseTime = 0;
    private Boolean paused = false;

    public Clock(){
        bitmapFont = new BitmapFont();
        bitmapFont.getData().setScale(5);
        glyphLayout = new GlyphLayout(bitmapFont, "00:00"); //???
    }

    public void startClock(){
        startTime = System.currentTimeMillis();
    }

    public long getTimeSeconds(){
        currentTime();
        return (timeMillis+pauseTime)/ 1000;
    }

    public long getTimeMinutes(){
        return getTimeSeconds() / 60;
    }

    private void currentTime(){
        timeMillis = 0;
        if(!paused) {
            timeMillis = (System.currentTimeMillis() - startTime);
        }
    }

    public String getTimeString(){
        return String.format("%02d", getTimeMinutes())+ ":" + String.format("%02d",getTimeSeconds()%60);
    }

    public void pauseClock(){
        paused = true;
        pauseTime += timeMillis;
        currentTime();

    }

    public void resumeClock(){
        paused = false;
        currentTime();
        startClock();
    }

    public void resetClock(){
        pauseTime = 0;
        startClock();
    }

    public void render(Batch batch){
        glyphLayout.setText(bitmapFont,getTimeString());
        bitmapFont.draw(batch, getTimeString(), (Gdx.graphics.getWidth() - glyphLayout.width)/2 , Gdx.graphics.getHeight() - 10);
    }
}

