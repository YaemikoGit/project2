package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Rectangle;

public class WinScreen extends Scene{
    private Rectangle retryBounds;

    public WinScreen() {
        
        super("win.jpg", "retry.png", "You win!\nCongratulations!");
        
    }

    public void draw(Batch batch) {
    	super.draw(batch);
    }
    
    public boolean isRetryClicked(float x, float y) {
        return retryBounds.contains(x, y);
    }

    
}
