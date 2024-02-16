package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class PauseScreen extends Scene {
    

    public PauseScreen() {
    	super();
    }
    
    public void draw(Batch batch) {
        super.drawPause(batch);
    }

    public void dispose() {
        super.getFont().dispose();
    }
}