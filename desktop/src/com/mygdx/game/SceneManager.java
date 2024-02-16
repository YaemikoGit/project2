package com.mygdx.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.badlogic.gdx.graphics.g2d.Batch;


public class SceneManager {
	
	private ArrayList<Scene> sceneList;
	private Scene currentScene;
	
	//screens using
	private Scene pauseScreen;
    private Scene winScreen;
    private Scene loseScreen;
    
    private boolean isPaused = false;
    private boolean isWin = false;
    private boolean isLose = false;
	    
    
    public SceneManager() {
    	
    	pauseScreen = new PauseScreen();
        winScreen = new WinScreen();
        loseScreen = new LoseScreen();
        
        sceneList = new ArrayList<>();
        
        sceneList.add(pauseScreen);
        sceneList.add(winScreen);
        sceneList.add(loseScreen);
        
        
           
    }
	
	//get current scene
	public Scene getCurrentScene() {
		return currentScene;
	}
	
	//load screen	
	public void loadScene(Batch batch, int current) {
        switch (current) {
            case 1:
                winScreen.draw(batch);
                break;
            case 2:
                loseScreen.draw(batch);
                break;
            case 3:
                pauseScreen.draw(batch);
                break;
        }
    }
	
	
	
	
}
