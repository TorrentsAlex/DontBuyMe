package com.jae.Models.Otter;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.jae.Utils.Constants;


/**
 * Created by Alex Torrents (aka Turri) on 16-Nov-17.
 */

public class OtterTrap {

    private TextureRegion trapOpen;
    private TextureRegion trapClosed;
    private Rectangle rectangle;

    private boolean closeTrap;

    public OtterTrap(Vector2 position, Vector2 size) {
        TextureAtlas textureAtlas = new TextureAtlas(Constants.OTTER_TRAP_ATLAS);
        trapOpen = textureAtlas.findRegion(Constants.OTTER_TRAP_OPEN);
        trapClosed = textureAtlas.findRegion(Constants.OTTER_TRAP_CLOSE);

        closeTrap = false;
        rectangle = new Rectangle();
        rectangle.setSize(size.x, size.y);
        rectangle.setPosition(position);
    }

    public void update(float delta) {
        rectangle.x += Constants.OTTER_SPEED * -delta;
    }

    public void draw(SpriteBatch batch) {
        if (closeTrap) {
            batch.draw(trapClosed, rectangle.x, rectangle.y,
                    rectangle.width,
                    rectangle.height);
        } else {
            batch.draw(trapOpen, rectangle.x, rectangle.y,
                    rectangle.width,
                    rectangle.height);
        }
    }

    public void closeTrap() {
        closeTrap = true;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

}
