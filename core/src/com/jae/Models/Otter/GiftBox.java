package com.jae.Models.Otter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.jae.Utils.Constants;

/**
 * Created by Alex Torrents (aka Turri) on 28-Nov-17.
 */

public class GiftBox {

    private TextureAtlas textureAtlas;
    private TextureRegion texture;
    private Rectangle rect;
    private int countCage = 1;

    private float velocity = 0.0f;

    private boolean leftSideReached = false;
    private boolean rightSideReached = false;

    public GiftBox(String path, Vector2 size, Vector2 pos) {
        textureAtlas = new TextureAtlas(path);
        texture = textureAtlas.findRegion(Constants.OTTER_CAGE_NAME + countCage);

        rect = new Rectangle();
        rect.setSize(size.x, size.y);
        rect.setPosition(pos);
    }

    public void addVelocity(float vel) {
        // Pass to false side reached if the player tilt the mobile
        // to the other side
        if (leftSideReached && vel > 0.0f) {
            leftSideReached = false;
        }
        if (rightSideReached && vel < 0.0f) {
            rightSideReached = false;
        }

        velocity += vel;
    }

    public Rectangle getRectangle() {return rect;}

    public void update() {
        if (rightSideReached && velocity > 0.0f) {
            velocity = 0.0f;
        }
        if (leftSideReached && velocity < 0.0f) {
            velocity = 0.0f;
        }

        rect.x += velocity * Gdx.graphics.getDeltaTime();
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture,
                rect.x,
                rect.y,
                rect.width,
                rect.height);
    }
    public void dispose() {
    }

    public void setVelocity(int random) {
        velocity = (float) random;
    }

    public void nextCageState() {
        if (countCage >= 4) return;
        countCage++;
        texture = textureAtlas.findRegion(Constants.OTTER_CAGE_NAME + countCage);
    }

    public void rightReached() {
        if (!rightSideReached) {
            nextCageState();
            leftSideReached = false;
            rightSideReached = true;
        }
    }

    public void leftReached() {
        if (!leftSideReached) {
            nextCageState();
            leftSideReached = true;
            rightSideReached = false;
        }
    }
}
