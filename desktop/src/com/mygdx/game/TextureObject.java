package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class TextureObject extends Entity {
    private Texture tex;
    public Boolean isAIControlled = true;

    public TextureObject() {

    }

    public TextureObject(String t, float x, float y, float speed, Boolean isAIControlled) {
        super(x, y, Color.RED, speed);
        this.isAIControlled = isAIControlled;
        tex = new Texture(Gdx.files.internal(t));
        this.setBounds(new Rectangle(x, y, tex.getWidth(), tex.getHeight()));
    }

    public Texture getTexture() {
        return tex;
    }

    public void setTexture(Texture t) {
        tex = t;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(this.getTexture(), this.getX(), this.getY(), this.getTexture().getWidth(), this.getTexture().getHeight());
    }

    public void update() {

    }

    public void movement() {
        if (isAIControlled) {
            AIMovement();
        } else {
            userMovement();
        }
    }

    public void userMovement() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            setX(getX() - getSpeed() * Gdx.graphics.getDeltaTime());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            setX(getX() + getSpeed() * Gdx.graphics.getDeltaTime());
        }
        this.getBounds().setPosition(getX(), getY());
    }

    public void AIMovement() {
        setY(getY() - getSpeed());

        if (getY() <= 0) {
            setY(400);
        }
        this.getBounds().setPosition(getX(), getY());
    }
}

