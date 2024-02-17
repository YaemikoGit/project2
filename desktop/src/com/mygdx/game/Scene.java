package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Scene {
	//general layout of scene
	private BitmapFont font;
    private GlyphLayout layout;
    private Texture backgroundTexture;	
    
    //buttons
    private Texture retryButton;
    private Rectangle retryBounds;
    
    
    //display message on scene
  	private String message;
	
  	
    //default constructor or pause screen
	public Scene() {
		font = new BitmapFont();
        layout = new GlyphLayout();
	}
	
	//Constructor for win and lose screen
	public Scene(String bgTxt, String rBtn, String msg) {
		font = new BitmapFont();
        layout = new GlyphLayout();
        
        backgroundTexture = new Texture(Gdx.files.internal(bgTxt));
        retryButton = new Texture(Gdx.files.internal(rBtn));
        message = msg;
        
        float buttonWidth = retryButton.getWidth() * 0.5f;
        float buttonHeight = retryButton.getHeight() * 0.5f;
        
        retryBounds = new Rectangle(
            Gdx.graphics.getWidth() / 2f - buttonWidth / 2f,
            Gdx.graphics.getHeight() / 4f - buttonHeight / 2f,
            buttonWidth,
            buttonHeight
        );
            
	}
	
	
	//Draw win and lose screens
	public void draw(Batch batch) {
		batch.begin();
        batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
       
        layout.setText(font, message);
        float x = (Gdx.graphics.getWidth() - layout.width) / 2;
        float y = (Gdx.graphics.getHeight() + layout.height) / 2;
        font.draw(batch, layout, x, y);
        
        batch.draw(retryButton, retryBounds.x, retryBounds.y, retryBounds.width, retryBounds.height);
        batch.end();
        
	}
	
	
	//Draw Pause screen 
	public void drawPause(Batch batch) {
		String text = "Paused\nPress 'P' to continue!";
        
        layout.setText(font, text);
        float x = (Gdx.graphics.getWidth() - layout.width) / 2;
        float y = (Gdx.graphics.getHeight() + layout.height) / 2;
        batch.begin();
        font.draw(batch, text, x, y);
        batch.end();
	}
	
	
	//Main map scene
	public void drawMain(Batch batch) {
		batch.begin();
        batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
       
	}
	
	
	public BitmapFont getFont() {
		return font;
	}
	
	public GlyphLayout getlayout() {
		return layout;
	}
	
	public Texture getBackgroundTexture() {
		return backgroundTexture;
	}
	
	public Texture getRetryBtn() {
		return retryButton;
	}
	
	public boolean isRetryClicked(float x, float y) {
        return retryBounds.contains(x, y);
    }
	
	
	//dispose
	public void dispose() {
		font.dispose();
		backgroundTexture.dispose();
		retryButton.dispose();
	}
}
