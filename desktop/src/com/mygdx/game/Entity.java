package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Entity implements iMovable{
    private float x,y;
    private float speed;
    private Color color;
    private Rectangle bounds;
    private boolean collected = false;

    public Entity()
    {

    }

    public Entity(float x, float y, Color color, float speed)
    {
        this.x = x;
        this.y = y;
        this.color = color;
        this.speed = speed;
    }


    public void setX(float x)
    {
        this.x = x;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public void setSpeed(float speed)
    {
        this.speed = speed;
    }

    public float getSpeed()
    {
        return speed;
    }

    public Color getColor()
    {
        return color;
    }

    public Rectangle getBounds()
    {
        return bounds;
    }

    public void setBounds(Rectangle bounds)
    {
        this.bounds = bounds;
    }
    
    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    public void draw(SpriteBatch batch)
    {

    }

    public abstract void update();

    public void movement()
    {

    }
}
