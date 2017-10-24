package com.jae.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

/**
 * Created by Alex Torrents (AKA Turri) on 22-Oct-17.
 */

public class Entity {

    protected Texture texture;
    protected Rectangle rectangle;
    protected Vector2 velocity;

    public Entity() {
        rectangle = new Rectangle();
        init();
    }

    public Entity(String path) {
        texture = new Texture(path);
        init();
    }

    private void init() {
        rectangle = new Rectangle();
        velocity = new Vector2(0, 0);
    }

    public void setPosition(Vector2 pos) {
        rectangle.setPosition(pos.x, pos.y);
    }

    public void setSize(Vector2 size) {
        rectangle.setSize(size.x, size.y);
    }

    public void setSize(int x, int y) {
        rectangle.setSize(x, y);
    }

    public void setVelocity(int x, int y) { velocity.set(x, y);}
    public void setVelocity(Vector2 vel) { velocity.set(vel.x, vel.y);}

    public void addVelocity(int x, int y) { velocity.add(x, y);}
    public void addVelocity(Vector2 vel) { velocity.add(vel.x, vel.y);}

    /**
     *  Plus the current position.
     * */
    public void addPosition(float x, int y) {
        rectangle.x += x;
        rectangle.y += y;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public void update() {
        if (velocity != new Vector2(0, 0)) {
            rectangle.x += velocity.x * Gdx.graphics.getDeltaTime();
            rectangle.y += velocity.y * Gdx.graphics.getDeltaTime();
        }
    }

    /**
     * @return the width and height
     * */
    public Vector2 getSize() {
        return new Vector2(rectangle.getWidth(), rectangle.getHeight());
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    /**
     * @return if a point is inside the object,
     *          not use for collision between 2 objects
     * */
    public boolean contains(float x, float y) {
        if (rectangle.contains(x, y)) {
            return true;
        }
        return false;
    }

    public void dispose() {
        if (texture != null) {
            texture.dispose();
        }
    }
}
