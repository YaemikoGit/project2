package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Scene{
	//general layout of scene
	private BitmapFont font;
    private GlyphLayout layout;
    private Texture backgroundTexture;	
    
    //buttons
    private Texture guiPack;
    private Texture retryButton;
    private Rectangle retryBounds;
    private Rectangle startButtonBounds;
    private Rectangle creditButtonBounds;
    
    
    //display message on scene
  	private String message;

  	protected SceneManager sm;
  	
  	
  	
	////////CONSTRUCTORS/////////
  	
	//Main Screen
	public Scene(SceneManager sm, String fontImg, String bgTxt, String TxtPack, String msg) {
		this.sm = sm;
		font = new BitmapFont(Gdx.files.internal(fontImg));
        layout = new GlyphLayout();
        
        backgroundTexture = new Texture(Gdx.files.internal(bgTxt));
        guiPack = new Texture(Gdx.files.internal(TxtPack));
        
        message = msg;
	}
	
	
	//Constructor for win and lose screen
	public Scene(SceneManager sm, String bgTxt, String rBtn, String msg) {
		this.sm = sm;
		font = new BitmapFont();
	    layout = new GlyphLayout();
	        
	    backgroundTexture = new Texture(Gdx.files.internal(bgTxt));
	    retryButton = new Texture(Gdx.files.internal(rBtn));
	    message = msg;
	        
	    float buttonWidth = retryButton.getWidth() * 0.5f;
        float buttonHeight = retryButton.getHeight() * 0.5f;
        
        this.retryBounds = new Rectangle(
	    		Gdx.graphics.getWidth() / 2f - buttonWidth / 2f,
	            Gdx.graphics.getHeight() / 4f - buttonHeight / 2f,
	            buttonWidth,
	            buttonHeight
	     );
	            
	}
		
	//default constructor or pause screen	
	public Scene(SceneManager sm) {
		this.sm = sm;
	}	
	
	public Scene(SceneManager sm, String msg) {
		this.sm = sm;
		this.font = new BitmapFont();	        			
		this.layout = new GlyphLayout();
	}
	
	
	
	////////DRAWING SCENES//////////
			
	//Draw main, win and lose screens
	public void draw(Batch batch) {
		batch.begin();
        batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());       
        
	}	
	
	
	//draw pause
	public void drawPause(Batch batch) {
		String text = "Paused\nPress 'P' to continue!";
        
        layout.setText(font, text);
        float x = (Gdx.graphics.getWidth() - layout.width) / 2;
        float y = (Gdx.graphics.getHeight() + layout.height) / 2;
        batch.begin();
        font.draw(batch, text, x, y);
        batch.end();
	}
	
	

	//getter methods
	public BitmapFont getFont() {
		return font;
	}
	
	public GlyphLayout getlayout() {
		return layout;
	}
	
	public Texture getGUI() {
		return guiPack;
	}
	
	public Texture getBackgroundTexture() {
		return backgroundTexture;
	}
	
	public Texture getRetryBtn() {
		return retryButton;
	}
	
	public Rectangle getRectB() {
		return retryBounds;
	}

	public String getMessage() {
		return message;
	}
	
	
	//dispose
	public void dispose() {
		font.dispose();
		//backgroundTexture.dispose();
		retryButton.dispose();
	}
}
