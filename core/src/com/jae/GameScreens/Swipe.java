package com.jae.GameScreens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.jae.JAEScreen;
import com.jae.Models.Entity;

import sun.rmi.runtime.Log;

/**
 * Created by Alex Torrents (aka Turri) on 31-Oct-17.
 */

public class Swipe extends JAEScreen implements GestureDetector.GestureListener {

    Entity background;
    Entity playButton;

    Camera camera;

    SpriteBatch batch;


    public Swipe(Game game) {
        super(game);
        init();
    }

    @Override
    public void update(float delta) {
        camera.update();

        if (Gdx.input.isTouched()) {
            Vector3 touchpos = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0.0f));
            if (playButton.contains(touchpos.x, touchpos.y)) {
                done = true;
            }
        }
    }

    @Override
    public void draw(float delta) {
        Gdx.gl.glClearColor(0, 0.25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        background.draw(batch);
        playButton.draw(batch);

        batch.end();
    }

    @Override
    public boolean isDone() {
        return done;
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        background.dispose();

    }

    private void init() {
        done = false;
        batch = new SpriteBatch();

        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0.0f);

        background = new Entity("airadventurelevel4.png");
        background.setPosition(new Vector2(0,0));
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        playButton = new Entity("b_round_g.png");
        playButton.setSize(new Vector2( Gdx.graphics.getHeight()/5, Gdx.graphics.getHeight()/5));
        playButton.setPosition(new Vector2(Gdx.graphics.getWidth()/2 - playButton.getSize().x /2, Gdx.graphics.getHeight()/2));

        Gdx.input.setInputProcessor(new GestureDetector(this));
        Gdx.app.debug("DontBuyMe", "init Swipe Class");
    }

    private void onUp() {Gdx.app.debug("DontBuyMe", "OnUp");}
    private void onDown() {Gdx.app.debug("DontBuyMe", "OnDown");}
    private void onRight() {Gdx.app.debug("DontBuyMe", "OnRight");}
    private void onLeft() {Gdx.app.debug("DontBuyMe", "OnLeft");}

    // Gesture Listener overrides

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        if(Math.abs(velocityX)>Math.abs(velocityY)){
            if(velocityX>0){
               onRight();
            }else{
                onLeft();
            }
        }else{
            if(velocityY>0){
                onDown();
            }else{
                onUp();
            }
        }
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