package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Rectangle;

public class WinScreen extends Scene{
    private Texture backgroundTexture;
    private Texture retryButton;
    private Rectangle retryBounds;

    public WinScreen() {
        super();
        
        backgroundTexture = new Texture(Gdx.files.internal("win.jpg"));
        retryButton = new Texture(Gdx.files.internal("retry.png"));
        
        float buttonWidth = retryButton.getWidth() * 0.5f;
        float buttonHeight = retryButton.getHeight() * 0.5f;
        
        retryBounds = new Rectangle(
            Gdx.graphics.getWidth() / 2f - buttonWidth / 2f,
            Gdx.graphics.getHeight() / 4f - buttonHeight / 2f,
            buttonWidth,
            buttonHeight
        );
    }

    public void draw(Batch batch) {
        
        batch.begin();
        batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        
        String text = "You win!\nCongratulations!";
        super.getlayout().setText(getFont(), text);
        float x = (Gdx.graphics.getWidth() - super.getlayout().width) / 2;
        float y = (Gdx.graphics.getHeight() + super.getlayout().height) / 2;
        super.getFont().draw(batch, text, x, y);
        
        batch.draw(retryButton, retryBounds.x, retryBounds.y, retryBounds.width, retryBounds.height);
        batch.end();
    }
    
    public boolean isRetryClicked(float x, float y) {
        return retryBounds.contains(x, y);
    }

    public void dispose() {
        super.getFont().dispose();
        backgroundTexture.dispose();
        retryButton.dispose();
    }
}
