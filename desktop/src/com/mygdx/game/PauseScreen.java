package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class PauseScreen extends Scene {
	private BitmapFont font;
    private GlyphLayout layout;

    public PauseScreen(SceneManager sm) {
    	super(sm);
    	this.font = new BitmapFont();	        			
		this.layout = new GlyphLayout();
    }
    
    
    public void drawPause(Batch batch) {
    	String text = "Paused\nPress 'P' to continue!";
        
        this.layout.setText(font, text);
        float x = (Gdx.graphics.getWidth() - this.layout.width) / 2;
        float y = (Gdx.graphics.getHeight() + this.layout.height) / 2;
        batch.begin();
        this.font.draw(batch, text, x, y);
        batch.end();
    }

}