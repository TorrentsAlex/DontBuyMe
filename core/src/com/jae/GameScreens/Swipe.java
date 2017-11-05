package com.jae.GameScreens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.jae.Models.JAEScreen;
import com.jae.Models.Entity;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Alex Torrents (aka Turri) on 31-Oct-17.
 */

public class Swipe extends JAEScreen implements GestureDetector.GestureListener {

    enum SWIPE {
        UP, DOWN, LEFT, RIGHT, NULL
    }

    Entity background;

    Entity imgUp;
    Entity imgDown;
    Entity imgLeft;
    Entity imgRight;

    // Variables of the game
    ArrayList<SWIPE> swipesList;
    int currentCountSwipeList;
    SWIPE currentSWIPEDetected;

    public Swipe(Game game) {
        super(game);
        init();
    }

    @Override
    public void update(float delta) {
        // Check if we swiped
        if (currentSWIPEDetected != SWIPE.NULL &&
                 swipesList.get(currentCountSwipeList).equals(currentSWIPEDetected)) {
            currentCountSwipeList++;
            if (currentCountSwipeList >= swipesList.size()) {
                done = true;
            }
        }
        currentSWIPEDetected = SWIPE.NULL;

    }

    @Override
    public void draw(float delta) {
        background.draw(batch);

        // Render the swipes images
        SWIPE drawSWIPE = done ? SWIPE.NULL : swipesList.get(currentCountSwipeList);
        switch(drawSWIPE) {
            case UP:
                imgUp.draw(batch);
                break;
            case DOWN:
                imgDown.draw(batch);
                break;
            case LEFT:
                imgLeft.draw(batch);
                break;
            case RIGHT:
                imgRight.draw(batch);
                break;
            case NULL:
                break;
        }
    }

    @Override
    public boolean isDone() {
        return done;
    }

    @Override
    public void dispose() {
        super.dispose();
        background.dispose();
    }

    private void shuffleSwipes() {
        currentSWIPEDetected = SWIPE.NULL;
        currentCountSwipeList = 0;
        swipesList = new ArrayList<SWIPE>();

        swipesList.add(SWIPE.UP);
        swipesList.add(SWIPE.UP);
        swipesList.add(SWIPE.DOWN);
        swipesList.add(SWIPE.DOWN);
        swipesList.add(SWIPE.LEFT);
        swipesList.add(SWIPE.LEFT);
        swipesList.add(SWIPE.RIGHT);
        swipesList.add(SWIPE.RIGHT);

        Collections.shuffle(swipesList);
    }

    private void init() {
        done = false;

        shuffleSwipes();

        background = new Entity("airadventurelevel4.png");
        background.setPosition(new Vector2(0,0));
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // Swipe images
        imgUp = new Entity("swipe_up.png");
        imgUp.setSize(Gdx.graphics.getWidth()/2,Gdx.graphics.getWidth()/2);
        imgUp.setPositionCenter();

        imgDown = new Entity("swipe_down.png");
        imgDown.setSize(Gdx.graphics.getWidth()/2,Gdx.graphics.getWidth()/2);
        imgDown.setPositionCenter();

        imgLeft = new Entity("swipe_left.png");
        imgLeft.setSize(Gdx.graphics.getWidth()/2,Gdx.graphics.getWidth()/2);
        imgLeft.setPositionCenter();

        imgRight = new Entity("swipe_right.png");
        imgRight.setSize(Gdx.graphics.getWidth()/2,Gdx.graphics.getWidth()/2);
        imgRight.setPositionCenter();

        Gdx.input.setInputProcessor(new GestureDetector(this));
        Gdx.app.debug("DontBuyMe", "init Swipe Class");
    }

    private void onUp() {currentSWIPEDetected  = SWIPE.UP;}
    private void onDown() {currentSWIPEDetected  = SWIPE.DOWN;}
    private void onRight() {currentSWIPEDetected  = SWIPE.RIGHT;}
    private void onLeft() {currentSWIPEDetected  = SWIPE.LEFT;}

    // Gesture Listener overrides
    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        if(Math.abs(velocityX) > Math.abs(velocityY)){
            if(velocityX>0){
                onRight();
            } else{
                onLeft();
            }
        }else{
            if(velocityY>0){
                onDown();
            } else{
                onUp();
            }
        }
        return false;
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {return false;}

    @Override
    public boolean tap(float x, float y, int count, int button) {return false;}

    @Override
    public boolean longPress(float x, float y) {return false;}

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {return false;}

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {return false;}

    @Override
    public boolean zoom(float initialDistance, float distance) {return false;}

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {return false;}

    @Override
    public void pinchStop() {}
}