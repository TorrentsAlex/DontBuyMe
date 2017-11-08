package com.jae.Models;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by Alex Torrents (aka Turri) on 03-Nov-17.
 */

public class GameScreen extends JAEScreen {
    protected Entity backgroundGame;
    protected Entity backgroundWin;
    protected Entity backgroundFail;

    enum GAMESTATE{GAME, WIN, FAIL}
    private GAMESTATE gamestate;

    // value that determine if the player has won or not
    protected boolean isWin;

    public GameScreen(Game game) {
        super(game);
        gamestate = GAMESTATE.GAME;

    }

    @Override
    public void update(float delta) {
        camera.update();

    }

    void finishGame() {}

    @Override
    public void draw(float delta) {
        switch (gamestate){
            case WIN:
                backgroundGame.draw(batch);
                drawWin(delta);
                break;
            case FAIL:
                backgroundFail.draw(batch);
                drawFail(delta);
                break;
            case GAME:
                backgroundWin.draw(batch);
                drawGame(delta);
                break;
        }
        drawFail(delta);
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public void dispose() {
        backgroundGame.dispose();
        super.dispose();
    }

    public void startGame(float seconds) {
//
//        Timer.schedule(new Timer.Task() {
//            @Override
//            public void run() {
//                gamestate = isWin ? GAMESTATE.WIN : GAMESTATE.FAIL;
//            }
//        }, seconds);


        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                gamestate = GAMESTATE.WIN;
            }
        }, 2.0f);
    }

    public void drawGame(float delta) {}
    public void drawWin(float delta) {}
    public void drawFail(float delta) {}
}