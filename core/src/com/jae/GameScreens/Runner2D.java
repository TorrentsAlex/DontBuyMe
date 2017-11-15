package com.jae.GameScreens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.jae.Models.JAEScreen;
import com.jae.Models.ParallaxBackground;
import com.jae.Models.Otter.OtterRunner;
import com.jae.Utils.Constants;
import com.jae.Utils.GameCallback;

/**
 * Created by Alex Torrents (AKA Turri) on 22-Oct-17.
 */

public class Runner2D extends JAEScreen implements GestureDetector.GestureListener, GameCallback {

    private ParallaxBackground backgroundGame;
    private OtterRunner otterRunner;


    public Runner2D(Game game) {
        super(game);
        init();
    }

    @Override
    public void update(float delta) {
        backgroundGame.update(delta);
        otterRunner.update();
    }

    @Override
    public void draw(float delta) {
        backgroundGame.draw(batch);
        otterRunner.draw(batch);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void show() {

    }

    @Override
    public boolean isDone() {
        return done;
    }

    private void init() {
        done = false;

        backgroundGame = new ParallaxBackground(Constants.OTTER_BACKGROUND);

        Gdx.app.debug("DontBuyMe","init Touch fast game");

        // Add listener this class to touch
        Gdx.input.setInputProcessor(new GestureDetector(this));
        otterRunner = new OtterRunner( new Vector2(Gdx.graphics.getWidth()*1/4,
                                                    Gdx.graphics.getHeight()*1/6),
                                        new Vector2(Gdx.graphics.getHeight()/4,
                                                    Gdx.graphics.getHeight()/4));

    }

    //  GameCallbacks callbacks

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


    // Gesture Listener callbacks

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        otterRunner.startJump();
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }
}
