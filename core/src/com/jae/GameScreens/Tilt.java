package com.jae.GameScreens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.jae.Models.JAEScreen;
import com.jae.Models.Entity;
import com.jae.Models.JAEAnimation;
import com.jae.Models.Otter.GiftBox;
import com.jae.Utils.Constants;

/**
 * Created by Alex Torrents (AKA Turri) on 22-Oct-17.
 */

public class Tilt extends JAEScreen {

    Entity background;

    Entity[] column;
    GiftBox player;

    int velocity = 40;

    boolean collisionRight = false;
    boolean collisionLeft = false;

    public Tilt(Game game) {
        super(game);
        init();
    }

    @Override
    public void update(float delta) {
        player.update();

        float accelY = Gdx.input.getAccelerometerY();

        player.addVelocity(accelY / 10 * velocity);

        // Collisions
        for (int i = 0; i < column.length; i++) {
            if (Intersector.overlaps(player.getRectangle(), column[i].getRectangle())) {
                if (i == 0) {
                    player.leftReached();
                } else {
                    player.rightReached();
                }
            }
        }

    }

    @Override
    public void draw(float delta) {
        background.draw(batch);

        for (int i = 0; i< column.length; i++) {
            column[i].draw(batch);
        }

        player.draw(batch);
    }

    @Override
    public boolean isDone() {
        return done;
    }

    @Override
    public void show() {

    }

    private void init() {
        done = false;

        background = new Entity(Constants.TILT_BACKGROUND);
        background.setPosition(new Vector2(0,0));
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        column = new Entity[2];
        for (int i=0; i<2; i++) {
            column[i] = new Entity(Constants.TILT_ENEMY_SPIKE);
            column[i].setSize(Gdx.graphics.getHeight()/4, Gdx.graphics.getHeight());
        }
        column[0].setPosition(new Vector2(0, 0));
        column[1].setPosition(new Vector2(Gdx.graphics.getWidth()- Gdx.graphics.getHeight()/4, 0));

        player = new GiftBox(Constants.OTTER_CAGE_BOX,
                new Vector2(Gdx.graphics.getHeight()/4,
                            Gdx.graphics.getHeight()/4),
                new Vector2(Gdx.graphics.getWidth()/2 - Gdx.graphics.getHeight()/4/2,
                            Gdx.graphics.getHeight()/2 - Gdx.graphics.getHeight()/4/2));

        player.setVelocity(MathUtils.random(5));
        Gdx.app.debug("DontBuyMe","init Tilt Game");

    }

    @Override
    public void dispose() {
        super.dispose();
        player.dispose();
        background.dispose();
    }
}
