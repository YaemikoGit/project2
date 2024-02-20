package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.GL20;

public class MainMenu extends Scene {
	
	private TextureRegion startButtonRegion;
    private TextureRegion creditButtonRegion;
    private Rectangle startButtonBounds;
    private Rectangle creditButtonBounds;
    private SpriteBatch batch;
    
    private float touchX;
    private float touchY;
    
    
    public MainMenu(SceneManager sm) {
    	
    	super(sm,"GoldPeaberry.fnt", "RLGMLA.png", "GUI.png", "Raindrop Rally Version 1");
    	this.sm = sm;
    	batch = new SpriteBatch();
    	startButtonRegion = new TextureRegion(super.getGUI(), 71, 145, 19, 10);
        creditButtonRegion = new TextureRegion(super.getGUI(), 35, 145, 25, 10);
    	
    	float startButtonWidth = this.startButtonRegion.getRegionWidth() * 5; // Scale the button width
        float startButtonHeight = this.startButtonRegion.getRegionHeight() * 5; // Scale the button height

        float creditButtonWidth = this.creditButtonRegion.getRegionWidth() * 5; // Scale the button width
        float creditButtonHeight = this.creditButtonRegion.getRegionHeight() * 5; // Scale the button height

        this.startButtonBounds = new Rectangle(
                Gdx.graphics.getWidth() / 2f - startButtonWidth / 2f,
                Gdx.graphics.getHeight() / 3f - startButtonHeight / 2f, // Lower the start button
                startButtonWidth,
                startButtonHeight
        );

        this.creditButtonBounds = new Rectangle(
                Gdx.graphics.getWidth() / 2f - creditButtonWidth / 2f,
                Gdx.graphics.getHeight() / 3f - 3 * creditButtonHeight / 2f, // Lower the credit button
                creditButtonWidth,
                creditButtonHeight
        );
    }
    

    
    
    public float getTouchX() {
    	return touchX;
    }
    
    public float getTouchY() {
    	return touchY;
    }
    
    
    public void drawMain(Batch batch) {
    	Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
    	super.draw(batch);
    	
    	super.getFont().getData().setScale(1); // Change this value to scale the font
        super.getlayout().setText(super.getFont(), super.getMessage());
        
        float x = (Gdx.graphics.getWidth() - super.getlayout().width) / 2; // Horizontal center
        float y = Gdx.graphics.getHeight() - super.getlayout().height - 50;

        super.getFont().draw(batch, super.getMessage(), x, y);
    	
    	batch.draw(this.startButtonRegion, this.startButtonBounds.x, this.startButtonBounds.y, this.startButtonBounds.width, this.startButtonBounds.height); // No need to scale here, as the playBounds is already scaled
        batch.draw(this.creditButtonRegion, this.creditButtonBounds.x, this.creditButtonBounds.y, this.creditButtonBounds.width, this.creditButtonBounds.height); // No need to scale here, as the playBounds is already scaled

        batch.end();
    }
    
    
	public boolean isStartClicked(float x, float y) {
        return startButtonBounds.contains(x, y);
    }

    public boolean isCreditClicked(float x, float y) {
        return creditButtonBounds.contains(x, y);
    }
    
    
    

}
