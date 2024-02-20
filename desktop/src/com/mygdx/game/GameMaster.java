package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.backends.lwjgl3.audio.Ogg.Sound;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Random;

public class GameMaster implements ApplicationListener {
	
    private SceneManager sm;

    @Override
    public void create() {

    	sm = new SceneManager(this);
    	//setScreen(sm);
    	
    }
    
    @Override
    public void render() {
    	System.out.println("running");
    	//super.render();
    	//sm.render(Gdx.graphics.getDeltaTime());
    	//screen.dispose();
    }


    
    @Override
    public void dispose() {
        sm.dispose();
    }
    
    @Override
	public void resize (int width, int height) {
		if (sm.getCurrentScene() != null) sm.resizeCurrentScene(width, height);
	}
    
}
