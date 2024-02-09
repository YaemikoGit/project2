package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Random;


public class GameMaster extends ApplicationAdapter {

    private boolean isPaused = false;
    private SpriteBatch batch;
    private Entity bucket;
    private final int NUM_DROPS = 10;
    private Entity[] drops = new Entity[NUM_DROPS];
    EntityManager em;
    private PauseScreen pauseScreen;

    @Override
    public void create()
    {
        pauseScreen = new PauseScreen();

        batch = new SpriteBatch();

        CollisionHandler collisionHandler = new CollisionHandler();
        em = new EntityManager(collisionHandler);

        Random random = new Random();

        for(int i = 0; i < NUM_DROPS; i++)
        {
            int xPos = random.nextInt(600);
            int speed = random.nextInt(9) + 2;
            drops[i] = new TextureObject("droplet.png",xPos,400,speed, true);
            em.addEntity(drops[i]);
        }

        bucket = new TextureObject("bucket.png", 200, 0, 200, false);

        em.addEntity(bucket);
    }

    @Override
    public void render() {
        if (Gdx.input.isKeyJustPressed(Keys.P)) {
            isPaused = !isPaused;
        }

        ScreenUtils.clear(0, 0, 0.2f, 1);

        if (!isPaused) {
            em.movement();
            em.update();
        }
        if (isPaused) {
            pauseScreen.draw(batch);
        }
        em.draw(batch);
    }

    @Override
    public void dispose() {
        batch.dispose();
        pauseScreen.dispose();
    }
}


