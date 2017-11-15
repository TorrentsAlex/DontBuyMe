package com.jae.GameScreens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Timer;
import com.jae.Models.Entity;
import com.jae.Models.JAEScreen;
import com.jae.Models.OtterRunner;
import com.jae.Utils.Data;
import com.jae.Utils.GameCallback;

/**
 * Created by Alex Torrents (AKA Turri) on 22-Oct-17.
 */

public class TouchFast extends JAEScreen implements GestureDetector.GestureListener, GameCallback {

    private Entity backgroundGame;

    private OtterRunner otterRunner;

    public TouchFast(Game game) {
        super(game);
        init();
    }

    @Override
    public void update(float delta) {
        otterRunner.update();

        if (Gdx.input.isTouched()) {
            Vector3 touchpos = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0.0f));

        }
    }

    @Override
    public void draw(float delta) {

        backgroundGame.draw(batch);
        otterRunner.draw(batch);
    }

    @Override
    public boolean isDone() {
        return done;
    }

    private void init() {
        done = false;

        backgroundGame = new Entity(Data.TOUCHFAST_BACKGROUND);
        backgroundGame.setPosition(new Vector2(0,0));
        backgroundGame.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        Gdx.app.debug("DontBuyMe","init Touch fast game");
//String path, int frame_cols, int frame_rows, float frameDuration
        otterRunner = new OtterRunner();
        Gdx.input.setInputProcessor(new GestureDetector(this));
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void show() {

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
        otterRunner.jump();
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                otterRunner.fall();
            }
        }, 2.0f);
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
