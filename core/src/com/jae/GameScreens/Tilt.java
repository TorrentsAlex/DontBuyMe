package com.jae.GameScreens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.jae.Models.JAEScreen;
import com.jae.Models.Entity;
import com.jae.Models.JAEAnimation;

/**
 * Created by Alex Torrents (AKA Turri) on 22-Oct-17.
 */

public class Tilt extends JAEScreen {

    Entity background;

    Entity[] spikes;
    JAEAnimation player;

    int velocity = 20;

    public Tilt(Game game) {
        super(game);
        init();
    }


    @Override
    public void update(float delta) {
        player.update();

        float accelY = Gdx.input.getAccelerometerY();
        player.addVelocity((int) (accelY / 10 * velocity), 0);

        // Collisions
        for (int i = 0; i < spikes.length; i++) {
            if (Intersector.overlaps(player.getRectangle(), spikes[i].getRectangle())) {
                done = true;
            }
        }
    }

    @Override
    public void draw(float delta) {
        background.draw(batch);

        for (int i = 0; i<spikes.length; i++) {
            spikes[i].draw(batch);
        }

        player.draw(batch);
    }

    @Override
    public boolean isDone() {
        return done;
    }

    private void init() {
        done = false;

        background = new Entity("airadventurelevel3.png");
        background.setPosition(new Vector2(0,0));
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        spikes = new Entity[4];
        for (int i=0; i<4;i++) {
            spikes[i] = new Entity("spike-ball.png");
            spikes[i].setSize(Gdx.graphics.getHeight()/4, Gdx.graphics.getHeight()/2);
        }
        spikes[0].setPosition(new Vector2(0, 0));
        spikes[1].setPosition(new Vector2(0, Gdx.graphics.getHeight()/2));
        spikes[2].setPosition(new Vector2(Gdx.graphics.getWidth() - Gdx.graphics.getHeight()/4, 0));
        spikes[3].setPosition(new Vector2(Gdx.graphics.getWidth() - Gdx.graphics.getHeight()/4, Gdx.graphics.getHeight()/2));

        player = new JAEAnimation("jump-blue.png", 4, 2, 1/15.0f);
        player.setSize(new Vector2(Gdx.graphics.getHeight()/4, Gdx.graphics.getHeight()/4));
        player.setPosition(new Vector2(Gdx.graphics.getWidth()/2- player.getSize().x/2,
                                        Gdx.graphics.getHeight()/2 - player.getSize().y/2));
        player.setVelocity(MathUtils.random(2), 0);
        Gdx.app.debug("DontBuyMe","init Tilt Game");

    }

    @Override
    public void dispose() {
        super.dispose();
        player.dispose();
        background.dispose();
    }
}
