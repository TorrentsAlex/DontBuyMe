package com.jae.GameScreens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.jae.Models.JAEScreen;
import com.jae.Models.Entity;
import com.jae.Utils.ImagePaths;

import java.util.Timer;

/**
 * Created by Alex Torrents (AKA Turri) on 22-Oct-17.
 */

public class TouchFast extends JAEScreen {

    private Entity backgroundGame;

    private ParticleEffect startExplosion;

    public TouchFast(Game game) {
        super(game);
        init();
    }

    @Override
    public void update(float delta) {

        if (Gdx.input.isTouched()) {
            Vector3 touchpos = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0.0f));
        }
    }

    @Override
    public void draw(float delta) {
        backgroundGame.draw(batch);
    }

    @Override
    public boolean isDone() {
        return done;
    }

    private void init() {
        done = false;
        com.badlogic.gdx.utils.Timer.schedule(new com.badlogic.gdx.utils.Timer.Task(){
            @Override
            public void run() {
                // Do your work
                done = true;
            }
        }, 3.0f);

        backgroundGame = new Entity(ImagePaths.TOUCHFAST_BACKGROUND);
        backgroundGame.setPosition(new Vector2(0,0));
        backgroundGame.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        Gdx.app.debug("DontBuyMe","init Touch fast game");
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
