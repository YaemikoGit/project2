package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Scene {
	private String sceneName;
	private String bgImage;
	
	private BitmapFont font;
    private GlyphLayout layout;
    
    private Texture backgroundTexture;
	
	public Scene() {
		font = new BitmapFont();
        layout = new GlyphLayout();
	}
	
	
	public BitmapFont getFont() {
		return font;
	}
	
	public GlyphLayout getlayout() {
		return layout;
	}
	
	
	public String getSceneName() {
		return sceneName;
	}
	
	public void setSceneName(String s) {
		sceneName = s;
	}
	
	public String getBgImage() {
		return bgImage;
	}
	
	public void setBgImage(String b) {
		bgImage = b;
	}
	
	
	public void draw(Batch batch) {
		batch.begin();
        batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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
	
	
//	public void draw(Batch batch) {
//		
//	}
}
