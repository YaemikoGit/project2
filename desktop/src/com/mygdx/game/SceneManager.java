package com.mygdx.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class SceneManager extends ApplicationAdapter {
	
	//entities
	 private Entity bucket;
	 private final int NUM_DROPS = 10;
	 private Entity[] drops = new Entity[NUM_DROPS];
	 private EntityManager em;

	 private float timeElapsed = 0;
	 private int dropletsCollected = 0;
	 private Texture backgroundTexture;
	
	
	//call for spirit batch
	private SpriteBatch batch;
	
	//screens using
	private ArrayList<Scene> sceneList;
	private Scene currentScene;
	
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
        //mainScreen = new MainScreen();
        
        sceneList = new ArrayList<>();
        
        sceneList.add(pauseScreen);
        sceneList.add(winScreen);
        sceneList.add(loseScreen);
        
        
    }
	
	//get current scene
	public Scene getCurrentScene() {
		return currentScene;
	}
	
	
	
//	public void loadScene(Scene scene) {
//		currentScene = scene;
//	}
	
	public void main() {
		
	}
	
	@Override
	public void create() {
		
		batch = new SpriteBatch();

        CollisionHandler collisionHandler = new CollisionHandler();
        em = new EntityManager(collisionHandler);
        //sm = new SceneManager();

        Random random = new Random();
        
        backgroundTexture = new Texture(Gdx.files.internal("background.jpg"));

        for (int i = 0; i < NUM_DROPS; i++) {
            int xPos = random.nextInt(600);
            int speed = random.nextInt(9) + 2;
            drops[i] = new TextureObject("droplet.png", xPos, 400, speed, true);
            em.addEntity(drops[i]);
        }

        bucket = new TextureObject("bucket.png", 200, 0, 200, false);
        em.addEntity(bucket);
		
		
	}
	
	
	
	@Override
	public void render() {
		
        
        
        
        
        
		
	}
	
	public void play() {
		
		//maybe put render method under play?
		
		batch.begin();
        batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
		
		float deltaTime = Gdx.graphics.getDeltaTime();

        if (!isPaused && !isWin && !isLose) {
            timeElapsed += deltaTime;
            if (timeElapsed >= 10) {
                isLose = true;
            }
            em.movement();
            em.update();
            
            
            // Check for collisions with bucket
            for (Entity drop : drops) {
                if (drop.getBounds().overlaps(bucket.getBounds()) && !drop.isCollected()) {
                    drop.setCollected(true);
                    dropletsCollected++;
                    if (dropletsCollected == 10) {
                        isWin = true;
                    }
                }
            }
        }
	}
	
	
	@Override
	public void pause() {
		pauseScreen.draw(batch);
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
