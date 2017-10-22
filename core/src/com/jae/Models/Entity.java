package com.jae.Models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Alex Torrents (AKA Turri) on 22-Oct-17.
 */

public class Entity {

    protected Texture texture;
    protected Rectangle rectangle;

    public Entity() {
        rectangle = new Rectangle();
    }

    public Entity(String path) {
        texture = new Texture(path);
        rectangle = new Rectangle();
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

    public void dispose() {
        if (texture != null) {
            texture.dispose();
        }
    }

    public void addPosition(float x, int y) {
        rectangle.x += x;
        rectangle.y += y;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public void update() {}

    /* GETTERS */

    public Vector2 getSize() {
        return new Vector2(rectangle.getWidth(), rectangle.getHeight());
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public boolean contains(float x, float y) {
        if (rectangle.contains(x, y)) {
            return true;
        }
        return false;
    }

    public boolean contains(Entity e1) {
        if (rectangle.contains(e1.getRectangle())) {
            return true;
        }
        return false;
    }
}
