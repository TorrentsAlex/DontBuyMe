package com.jae.Models.Otter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.jae.Utils.Constants;

/**
 * Created by Alex Torrents (aka Turri) on 14-Nov-17.
 */

public class OtterRunner {

    // Animation Variables
    private Animation animationRunning;
    private Animation animationJump;
    private float stateTime;

    private String[] runnPath = {"run0", "run1", "run2", "run3", "run4"};
    private String[] jumpPath = {"jump0", "jump1", "jump2", "jump3", "jump4"};

    // Positions, sizes
    private Rectangle rectangle;
    private Vector2 initPosition;

    // Jump variables
    private float velocityJump;
    private boolean isJumping;

    public OtterRunner(Vector2 position, Vector2 size) {
        TextureAtlas textureAtlas = new TextureAtlas(Constants.OTTER_ANIMATION);

        TextureRegion[] runningFrames = new TextureRegion[runnPath.length];
        for (int i = 0; i < runnPath.length; i++) {
            runningFrames[i] = textureAtlas.findRegion(runnPath[i]);
        }
        animationRunning = new Animation<TextureRegion>(0.16f, runningFrames);

        TextureRegion[] jumpFrames = new TextureRegion[jumpPath.length];
        for (int i = 0; i < jumpPath.length; i++) {
            jumpFrames[i] = textureAtlas.findRegion(jumpPath[i]);
        }
        animationJump = new Animation<TextureRegion>(0.2f, jumpFrames);
        stateTime = 0.0f;

        rectangle = new Rectangle();
        rectangle.setSize(size.x, size.y);
        rectangle.setPosition(position);
        initPosition = position;
        isJumping = false;
        velocityJump = Constants.OTTER_FORCE_JUMP;
    }

    public Vector2 getPosition() {
        return new Vector2(rectangle.x, rectangle.y);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void update() {
        stateTime += Gdx.graphics.getDeltaTime();

        if (isJumping) {
            jump();
        }
    }

    public void draw(SpriteBatch batch) {
        if (isJumping) {
            batch.draw((TextureRegion) animationJump.getKeyFrame(stateTime, false),
                    rectangle.x,
                    rectangle.y,
                    rectangle.width,
                    rectangle.height);
        } else {
            batch.draw((TextureRegion) animationRunning.getKeyFrame(stateTime, true),
                    rectangle.x,
                    rectangle.y,
                    rectangle.width,
                    rectangle.height);
        }
    }

    public void jump() {
        velocityJump += Constants.OTTER_GRAVITY;
        rectangle.y += velocityJump;

        if (rectangle.y < Constants.OTTER_GROUND_Y) {
            land();
        }
    }

    private void land() {
        isJumping = false;
        rectangle.y = initPosition.y;
        stateTime = 0.0f;
        velocityJump = Constants.OTTER_FORCE_JUMP;
    }

    public void startJump() {
        isJumping = true;
    }
}