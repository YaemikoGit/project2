package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Rectangle;

public class WinScreen {
    private BitmapFont font;
    private GlyphLayout layout;
    private Texture backgroundTexture;
    private Texture retryButton;
    private Rectangle retryBounds;

    public WinScreen() {
        font = new BitmapFont();
        layout = new GlyphLayout();
        
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
        layout.setText(font, text);
        float x = (Gdx.graphics.getWidth() - layout.width) / 2;
        float y = (Gdx.graphics.getHeight() + layout.height) / 2;
        font.draw(batch, text, x, y);
        
        batch.draw(retryButton, retryBounds.x, retryBounds.y, retryBounds.width, retryBounds.height);
        batch.end();
    }
    
    public boolean isRetryClicked(float x, float y) {
        return retryBounds.contains(x, y);
    }

    public void dispose() {
        font.dispose();
        backgroundTexture.dispose();
        retryButton.dispose();
    }
}
