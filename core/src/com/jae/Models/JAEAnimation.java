package com.jae.Models;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Alex Torrents (AKA Turri) on 22-Oct-17.
 */

public class JAEAnimation extends Entity {

    private TextureRegion[] walkFrames;
    private TextureRegion currentFrame;
    private Animation walkAnimation;
    private float stateTime;

    public JAEAnimation(String path, int frame_cols, int frame_rows, float frameDuration) {
        super();
        // Animation
        Texture texture = new Texture(path);
        TextureRegion[][] tmp = TextureRegion.split(texture,
                                                    texture.getWidth()/frame_cols,
                                                    texture.getHeight()/frame_rows);
        walkFrames = new TextureRegion[frame_cols * frame_rows];
        int index = 0;
        for (int i = 0; i < frame_rows; i++) {
            for (int j = 0; j < frame_cols; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }

        walkAnimation = new Animation<TextureRegion>(frameDuration, walkFrames);
        stateTime = 0.0f;
    }


    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(currentFrame,
                rectangle.x,
                rectangle.y,
                rectangle.getWidth(),
                rectangle.getHeight());
    }

    @Override
    public void update() {
        super.update();
        stateTime += Gdx.graphics.getDeltaTime();
        currentFrame = (TextureRegion) walkAnimation.getKeyFrame(stateTime, true);
    }

    @Override
    public void dispose() {
        super.dispose();

    }
}
