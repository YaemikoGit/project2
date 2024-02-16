package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.backends.lwjgl3.audio.Ogg.Sound;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Random;

public class GameMaster extends ApplicationAdapter {
	
    private SpriteBatch batch;
    private Entity bucket;
    private final int NUM_DROPS = 10;
    private Entity[] drops = new Entity[NUM_DROPS];
    private EntityManager em;

    private float timeElapsed = 0;
    private int dropletsCollected = 0;
    private Texture backgroundTexture;
    
    //sceneManager
//  private PauseScreen pauseScreen;
//  private WinScreen winScreen;
//  private LoseScreen loseScreen;
    private boolean isPaused = false;
    private boolean isWin = false;
    private boolean isLose = false;	
    private SceneManager sm;
    private int current;

    @Override
    public void create() {
//        pauseScreen = new PauseScreen();
//        winScreen = new WinScreen();
//        loseScreen = new LoseScreen();

    	sm = new SceneManager();
    	
        batch = new SpriteBatch();

        CollisionHandler collisionHandler = new CollisionHandler();
        em = new EntityManager(collisionHandler);
       

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
    	
    	//sm.play();
    	
    	
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


        if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
            isPaused = !isPaused;
        }

        if (isWin) {
        	current = 1;
            sm.loadScene(batch, current);
            
        } 
        else if (isLose) {
        	current = 2;
            sm.loadScene(batch, current);
            
        } 
        else if (isPaused) {
        	current = 3;
            sm.loadScene(batch, current);
            
            //sm.paused();
        } 
        else {
            em.draw(batch);
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
//        pauseScreen.dispose();
//        winScreen.dispose();
//        loseScreen.dispose();
        backgroundTexture.dispose();
        
        //sm.stop();
    }
}
