package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public class LoseScreen extends Scene {
    private Rectangle retryBounds;

    public LoseScreen(SceneManager sm) {
    	super(sm,"lose.png", "retry.png","You lose!\nTry again!");
    	
    	
    }

    public void drawLose(Batch batch) {
        
        super.draw(batch);
        
        super.getlayout().setText(super.getFont(), super.getMessage());
        float x = (Gdx.graphics.getWidth() - super.getlayout().width) / 2;
        float y = (Gdx.graphics.getHeight() + super.getlayout().height) / 2;
        super.getFont().draw(batch, super.getlayout(), x, y);    
        
        batch.draw(super.getRetryBtn(), super.getRectB().x, super.getRectB().y, super.getRectB().width, super.getRectB().height);
        batch.end();
    	
    }
    
    public boolean isRetryClicked(float x, float y) {
        return super.getRectB().contains(x, y);
    }


}