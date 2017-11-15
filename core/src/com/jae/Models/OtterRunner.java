package com.jae.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Alex Torrents (aka Turri) on 14-Nov-17.
 */

public class OtterRunner  {

    private boolean isJumping;
    private Animation animationRunning;
    private TextureRegion animationJump;
    private float stateTime;

    public OtterRunner() {
        TextureAtlas textureAtlas = new TextureAtlas("otter_anim.txt");

        TextureRegion[] runningFrames = new TextureRegion[runnPath.length];
        for (int i = 0; i < runnPath.length; i++) {
            runningFrames[i] = textureAtlas.findRegion(runnPath[i]);
        }
        animationRunning = new Animation<TextureRegion>(0.2f, runningFrames);

        animationJump = textureAtlas.findRegion("jump_up");
        stateTime = 0.0f;
    }

    public void update() {
        stateTime += Gdx.graphics.getDeltaTime();
    }

    public void draw(SpriteBatch batch) {
        if (isJumping) {
            batch.draw(animationJump,100.0f,100.0f, 150.f, 150.f);
        } else {
            batch.draw((TextureRegion) animationRunning.getKeyFrame(stateTime, true),100.0f,100.0f, 150.f, 150.f);
        }
    }

    public void jump() {
        isJumping = true;
        stateTime = 0.0f;
    }

    public void fall() {
        isJumping = false;
        stateTime = 0.0f;
    }
    private String[] runnPath = {"frame-1", "frame-2", "frame-3", "frame-4", "frame-5", "frame-6"};
    private String[] jumpPath = {"jump_fall", "jump_up"};
}
