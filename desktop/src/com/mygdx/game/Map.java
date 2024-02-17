package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Map extends Scene {
	
	private Entity bucket;
	private final int NUM_DROPS = 10;
	private Entity[] drops = new Entity[NUM_DROPS];
	private EntityManager em;

	private float timeElapsed = 0;
	private int dropletsCollected = 0;
	private Texture backgroundTexture;
	
	private boolean isPaused = false;
    private boolean isWin = false;
    private boolean isLose = false;
	
	//call for spirit batch
	private SpriteBatch batch;
	
	public Map() {
		
		batch = new SpriteBatch();

		//initialize collision handler and entity manager
        CollisionHandler collisionHandler = new CollisionHandler();
        em = new EntityManager(collisionHandler);
         
        backgroundTexture = new Texture(Gdx.files.internal("background.jpg"));
        
        //bucket
        bucket = new TextureObject("bucket.png", 200, 0, 200, false);
        em.addEntity(bucket);
       
        //droplets
        Random random = new Random();
        
        for (int i = 0; i < NUM_DROPS; i++) {
            int xPos = random.nextInt(600);
            int speed = random.nextInt(9) + 2;
            drops[i] = new TextureObject("droplet.png", xPos, 400, speed, true);
            em.addEntity(drops[i]);
        }
		
	}
	
	public void playMap() {
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
	
	
	public EntityManager getEM() {
		return em;
	}
	
	
	
	
	
	
}
