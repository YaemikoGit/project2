package com.mygdx.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;


public class SceneManager implements Screen {
	
	 private GameMaster game;
	 
	
	//call for spirit batch
	private SpriteBatch batch;
	
	//screens list
	private ArrayList<Scene> sceneList;
	private Scene currentScene;
	
	//scenes 
	private PauseScreen pauseScreen;
    private WinScreen winScreen;
    private LoseScreen loseScreen;
    private MainMenu mainMenu;
    private Map map;
    
    
    //atm not in use
    private boolean isPaused = false;
    private boolean isWin = false;
    private boolean isLose = false;
	 private boolean isPKeyPressed = false;
	    
    
    public SceneManager(GameMaster game) {
    	
    	//init game
    	this.game = game;
    	
    	//screens
    	pauseScreen = new PauseScreen(this);
        winScreen = new WinScreen(this);
        loseScreen = new LoseScreen(this);
        mainMenu = new MainMenu(this);
        map = new Map(this);
        
        sceneList = new ArrayList<>();
        
        //added to list (might remove if is really redundant)
        sceneList.add(pauseScreen);
        sceneList.add(winScreen);
        sceneList.add(loseScreen);
        sceneList.add(mainMenu);
        sceneList.add(map);
        
        batch = new SpriteBatch();
        
        //draw main menu
        menu();
        
    }
	
    
	//get current scene
	public Scene getCurrentScene() {
		return currentScene;
	}
	
	public void resizeCurrentScene(){
		
	}
	
	//init Main menu
	public void menu() {	
		currentScene = mainMenu;
		mainMenu.drawMain(batch);
	}
	
	//set currrent scene to map
	public void playGame() {	
        currentScene = map;
	}
	
	
	
    //set currrent scene to win screen
	public void winGame() {
		currentScene = winScreen;
	}
	
	//set currrent scene to lose screen
	public void loseGame() {
		currentScene = loseScreen;
	}
	
	public void pauseGame() {
	    currentScene = pauseScreen;
	}

	
    public void resumeGame() {
        isPaused = false;
        currentScene = map;
    }
	
    //flag for pause
	public boolean isPaused() {
	    return isPaused;
	}
	
	@Override 
	public void render(float delta) {
		
		handleInput();
		update(delta);
	}
	
	
	public void handleInput() {
		
		//mouse click input
		if (Gdx.input.justTouched()) {
	          float touchX = Gdx.input.getX();
	          float touchY = Gdx.graphics.getHeight() - Gdx.input.getY();

	          // If start button is touched
	          if (currentScene == mainMenu && mainMenu.isStartClicked(touchX, touchY)) {	        	 
	        	  playGame();
	        	  
	          }  
	          
		       
	          //to retry game from win screen
	          if(currentScene == winScreen && winScreen.isRetryClicked(touchX, touchY)) {
	        	  map = new Map(this);
	        	  currentScene = map;
	        	  
	        	  
	          }
	          
	        //to retry game from lose screen
	          if(currentScene == loseScreen && loseScreen.isRetryClicked(touchX, touchY)) {
	        	  map = new Map(this);
	        	  currentScene = map;	        	  
	          }
		}
		
		
		
		///got issues with pausing
		//to pause
		if (currentScene == map && Gdx.input.isKeyJustPressed(Input.Keys.P)) {
			isPaused = true;
			pauseGame();
	    }

		//to pause
		if (currentScene == pauseScreen && Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
			isPaused = false;
			map.setPause(isPaused);
			
	    }
		
		
		//check win/lose status
		if (currentScene == map && map.getWinStatus() == true) {
			winGame();
		}
		
		if (currentScene == map && map.getLoseStatus() == true) {
			loseGame();
		}
		
		
	}
	
	public void update(float dt) {
		//current scenes will be check and draw accordingly after input
		if (currentScene == mainMenu) {
			mainMenu.drawMain(batch);			
		
		} 
		else if (currentScene == map) {
	        map.draw(batch);

      	}
		else if (currentScene == pauseScreen) {
			pauseScreen.drawPause(batch);
		}
		 
		else if (currentScene == winScreen) {
	        winScreen.drawWin(batch);
	    }
		else if (currentScene == loseScreen) {
	        loseScreen.drawLose(batch);
	    }
		
	}
	
	
	@Override
	public void pause() {
		
	}
	
    @Override
    public void show() {
    	
    }

    @Override
    public void resume() {

    }
	
    @Override
    public void dispose() {
		map.dispose();
		mainMenu.dispose();
	}
	

    @Override
    public void hide() {

    }

    @Override
    public void resize(int width, int height) {

    }
    
	

	
}
