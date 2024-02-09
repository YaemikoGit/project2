package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class PauseScreen {
    private BitmapFont font;
    private GlyphLayout layout;

    public PauseScreen() {
        font = new BitmapFont();
        layout = new GlyphLayout();
    }

    public void draw(Batch batch) {
        String text = "Paused\nPress 'P' to continue!";
        layout.setText(font, text);
        float x = (Gdx.graphics.getWidth() - layout.width) / 2;
        float y = (Gdx.graphics.getHeight() + layout.height) / 2;
        batch.begin();
        font.draw(batch, text, x, y);
        batch.end();
    }

    public void dispose() {
        font.dispose();
    }
}