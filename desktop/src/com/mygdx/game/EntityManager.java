package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EntityManager {
    private List<Entity> entityList;
    private CollisionHandler collisionHandler;

    public EntityManager(CollisionHandler collisionHandler) {
        entityList = new ArrayList<Entity>();
        this.collisionHandler = collisionHandler;
    }

    public void addEntity(Entity e) {
        entityList.add(e);
    }
    
    public void removeEntity(Entity e) {
    	entityList.remove(e);
    }

    public void draw(SpriteBatch batch) {
        for (Entity entity : entityList) {
            batch.begin();
            entity.draw(batch);
            batch.end();
        }
    }

    public void movement() {
        for (Entity entity : entityList) {
            entity.movement();
        }
    }

    public void update() {
        Iterator<Entity> iterator = entityList.iterator();

        while (iterator.hasNext()) {
            Entity entity1 = iterator.next();

            if (entity1 instanceof TextureObject && ((TextureObject) entity1).isAIControlled) {
                for (Entity entity2 : entityList) {
                    if (entity2 instanceof TextureObject && !((TextureObject) entity2).isAIControlled && entity1.getBounds().overlaps(entity2.getBounds())) {
                        // A collision has occurred between a non-playable and a playable entity
                        collisionHandler.handleCollision(entity1, entity2);
                        iterator.remove();
                        break;
                    }
                }
            }
        }

        for (Entity entity : entityList) {
            entity.update();
        }
    }
}