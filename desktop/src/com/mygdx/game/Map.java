package com.mygdx.game;

import java.util.Random;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Map extends Scene {

	private Entity bucket;
	private final int NUM_DROPS = 10;
	private Entity[] drops = new Entity[NUM_DROPS];
	private EntityManager em;

	private int dropletsCollected = 0;
	private Texture backgroundTexture;
	
	private boolean isPaused = false;
    private boolean isWin = false;
    private boolean isLose = false;
    
    private float elapsedTime = 0;
    private static final float MAX_TIME = 10; // player loses if they haven't collected 10 droplets in 10 seconds
	
    private IOManager audioManager;
    private SpriteBatch batch;
    
	public Map(SceneManager sm) {
		super(sm);
		
		this.batch = new SpriteBatch();

        // Move the game initialization code from the GameMaster.create() method here
        this.audioManager = new IOManager();
        this.audioManager.setDropSound("drop.wav");
        this.audioManager.setBackgroundSound("Mbackground.wav");
        this.audioManager.playBackgroundMusic(true);
		
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
	
	public void draw(SpriteBatch batch) {

		float dt = Gdx.graphics.getDeltaTime();
		elapsedTime += dt;
		
		batch.begin();
    	batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    	batch.end();
        
    	 
        for (Entity drop : drops) {
            if (drop.getBounds().overlaps(bucket.getBounds()) && !drop.isCollected()) {
                drop.setCollected(true);
                dropletsCollected++;
                if (dropletsCollected == 10) {
                    System.out.println("WINNER!");
                    isWin = true;
                }
            }
        }

        if (!isWin && elapsedTime >= MAX_TIME) {
            System.out.println("GAME OVER!");
            isLose = true;
        }
      
   	 
//        em.movement();
//        em.update();
//        em.draw(batch);
        
        if (isPaused) {
        	sm.pauseGame();
        } 
        else {
        	em.movement();
            em.update();
        	em.draw(batch);
        }
        
        
	}
	
	public void update(float dt) {
		
		
		
	}
	
	public EntityManager getEM() {
		return em;
	}
	
	
	public Entity getBucket() {
		return bucket;
	}
	
	public Entity[] getDroplets() {
		return drops;
	}
	
	public boolean getWinStatus() {
		return isWin;
	}
	
	public boolean getLoseStatus() {
		return isLose;
	}

	public boolean getPause() {
		return isPaused;
	}
	
	public void setPause(boolean P) {
		isPaused = P;
	}
	
}
