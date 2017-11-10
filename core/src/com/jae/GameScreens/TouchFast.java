package com.jae.GameScreens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Timer;
import com.jae.Models.Entity;
import com.jae.Models.JAEScreen;
import com.jae.Utils.Data;
import com.jae.Utils.GameCallback;

/**
 * Created by Alex Torrents (AKA Turri) on 22-Oct-17.
 */

public class TouchFast extends JAEScreen implements GameCallback {

    private Entity backgroundGame;

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
        Timer.schedule(new com.badlogic.gdx.utils.Timer.Task(){
            @Override
            public void run() {
                // Do your work
                done = true;
            }
        }, 3.0f);

        backgroundGame = new Entity(Data.TOUCHFAST_BACKGROUND);
        backgroundGame.setPosition(new Vector2(0,0));
        backgroundGame.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        Gdx.app.debug("DontBuyMe","init Touch fast game");
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void show() {

    }

    @Override
    public void startGame() {

    }

    @Override
    public void finishGame() {

    }

    @Override
    public void nextGame() {
        done = true;
    }
}
