package com.jae.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.jae.Utils.Constants;

/**
 * Created by Alex Torrents (aka Turri) on 15-Nov-17.
 */

public class ParallaxBackground {

    private final Texture textureRegion;
    private Rectangle textureRegionBounds1;
    private Rectangle textureRegionBounds2;

    public ParallaxBackground(String path) {
        textureRegion = new Texture(path);
        textureRegionBounds1 = new Rectangle(0 - Gdx.graphics.getWidth()/ 2, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        textureRegionBounds2 = new Rectangle(Gdx.graphics.getWidth() / 2, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public void update(float delta) {
        if (leftBoundsReached(delta)) {
            resetBounds();
        } else {
            updateXBounds(-delta);
        }
    }

    public void draw(SpriteBatch batch) {
        batch.draw(textureRegion, textureRegionBounds1.x, textureRegionBounds1.y,
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight());
        batch.draw(textureRegion, textureRegionBounds2.x, textureRegionBounds2.y,
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight());
    }

    private boolean leftBoundsReached(float delta) {
        return (textureRegionBounds2.x - (delta * Constants.OTTER_GAME_SPEED)) <= 0.0f;
    }

    private void updateXBounds(float delta) {
        textureRegionBounds1.x += delta * Constants.OTTER_GAME_SPEED;
        textureRegionBounds2.x += delta * Constants.OTTER_GAME_SPEED;
    }

    private void resetBounds() {
        textureRegionBounds1 = textureRegionBounds2;
        textureRegionBounds2 = new Rectangle(Gdx.graphics.getWidth(),
                                            0,
                                            Gdx.graphics.getWidth(),
                                            Gdx.graphics.getHeight());
    }

}
