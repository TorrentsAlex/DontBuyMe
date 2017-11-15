package com.jae.GameScreens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.jae.Models.JAEScreen;
import com.jae.Models.Entity;
import com.jae.Utils.Constants;
import com.jae.Utils.GameCallback;
import com.jae.Utils.GameLogic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Alex Torrents (aka Turri) on 31-Oct-17.
 */

public class Swipe extends JAEScreen implements GestureDetector.GestureListener, GameCallback {

    enum SWIPE {
        UP, DOWN, LEFT, RIGHT, NULL
    }

    private Entity backgroundGame;
    private Entity backgroundWin;
    private Entity backgroundFail;

    private Entity imgUp;
    private Entity imgDown;
    private Entity imgLeft;
    private Entity imgRight;

    private ArrayList<ParticleEffect> particlesToDraw;
    // Variables of the game
    ArrayList<SWIPE> swipesList;
    int currentCountSwipeList;
    SWIPE currentSWIPEDetected;
    boolean allSwiped;

    public Swipe(Game game) {
        super(game);
        init();
    }

    @Override
    public void update(float delta) {
        if (gameLoop != GameLoop.inGame)
            return;

        // Check if we swiped
        if (currentSWIPEDetected != SWIPE.NULL){
            // Swiped the right direction
            if (swipesList.get(currentCountSwipeList).equals(currentSWIPEDetected)) {
                currentCountSwipeList++;

                particlesToDraw.add(createParticle(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2 ));
                if (currentCountSwipeList >= swipesList.size()) {
                    allSwiped = true;
                }
            } else { // swiped the wrong direction
                Gdx.input.vibrate(500);
            }
        }
        currentSWIPEDetected = SWIPE.NULL;
        for (int i = 0; i< particlesToDraw.size(); i++) {
            particlesToDraw.get(i).update(delta);
        }
    }

    @Override
    public void draw(float delta) {
        switch (gameLoop) {
            case inGame:
            case tutorial:
                drawGame();
                break;
            case win:
                drawWin();
                break;
            case fail:
                drawFail();
                break;
        }
    }

    @Override
    public void show() {
        Gdx.app.debug("DontBuyMe","Start Swipe");
        GameLogic.startGameTimer(this, Constants.GAMEDATA_TIME_START, Constants.GAMEDATA_TIME_INGAME);
    }

    private void drawWin() {
        backgroundWin.draw(batch);
    }

    private void drawGame() {
        backgroundGame.draw(batch);

        // Render the swipes images
        SWIPE drawSWIPE = allSwiped ? SWIPE.NULL : swipesList.get(currentCountSwipeList);
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

        for (ParticleEffect pe : particlesToDraw) {
            pe.draw(batch);
        }
    }

    private void drawFail() {
        backgroundFail.draw(batch);
    }

    @Override
    public void startGame() {
        gameLoop = GameLoop.inGame;
    }

    @Override
    public void finishGame() {
        Gdx.app.debug("DontBuyMe", "SWIPE, finish game");

        // Check if the user finished the game
        gameLoop = allSwiped ? GameLoop.win : GameLoop.fail;

        GameLogic.nextGameTimer(this, Constants.GAMEDATA_TIME_WINFAIL);
    }

    @Override
    public void nextGame() {
        Gdx.app.debug("DontBuyMe", "SWIPE next game, next Game");

        done = true;
    }

    @Override
    public boolean isDone() {
        return done;
    }

    @Override
    public void dispose() {
        super.dispose();
        backgroundGame.dispose();
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
        allSwiped = false;

        shuffleSwipes();

        // Initialize all textures

        backgroundGame = new Entity(Constants.SWIPE_BACKGROUND_GAME);
        backgroundGame.setPosition(new Vector2(0,0));
        backgroundGame.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        backgroundWin = new Entity(Constants.SWIPE_BACKGROUND_WIN);
        backgroundWin.setPosition(new Vector2(0,0));
        backgroundWin.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        backgroundFail = new Entity(Constants.SWIPE_BACKGROUND_FAIL);
        backgroundFail.setPosition(new Vector2(0,0));
        backgroundFail.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // Swipe images
        imgUp = new Entity(Constants.SWIPE_SWIPE_UP);
        imgUp.setSize(Gdx.graphics.getWidth()/2,Gdx.graphics.getWidth()/2);
        imgUp.setPositionCenter();

        imgDown = new Entity(Constants.SWIPE_SWIPE_DOWN);
        imgDown.setSize(Gdx.graphics.getWidth()/2,Gdx.graphics.getWidth()/2);
        imgDown.setPositionCenter();

        imgLeft = new Entity(Constants.SWIPE_SWIPE_LEFT);
        imgLeft.setSize(Gdx.graphics.getWidth()/2,Gdx.graphics.getWidth()/2);
        imgLeft.setPositionCenter();

        imgRight = new Entity(Constants.SWIPE_SWIPE_RIGHT);
        imgRight.setSize(Gdx.graphics.getWidth()/2,Gdx.graphics.getWidth()/2);
        imgRight.setPositionCenter();

        particlesToDraw = new ArrayList<ParticleEffect>();

        // Initialize GameLoop
        gameLoop = GameLoop.tutorial;

        Gdx.input.setInputProcessor(new GestureDetector(this));
        Gdx.app.debug("DontBuyMe", "init Swipe Class");
    }

    /** */
    private ParticleEffect createParticle(float x, float y) {

        ParticleEffect pe = new ParticleEffect();
        pe.load(Gdx.files.internal(Constants.SWIPE_PARTICLE_EFFECT), Gdx.files.internal(""));
        pe.start();
        pe.setPosition(x, y);
        return pe;
    }

    // Gesture Listener overrides
    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        if(Math.abs(velocityX) > Math.abs(velocityY)){
            if(velocityX>0){
                currentSWIPEDetected  = SWIPE.RIGHT;
            } else{
                currentSWIPEDetected  = SWIPE.LEFT;
            }
        } else {
            if(velocityY>0){
                currentSWIPEDetected  = SWIPE.DOWN;
            } else{
                currentSWIPEDetected  = SWIPE.UP;
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