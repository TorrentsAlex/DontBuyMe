package com.jae.Utils;

import com.badlogic.gdx.utils.Timer;

/**
 * Created by Alex Torrents (aka Turri) on 02-Nov-17.
 */

public class GameLogic {

    public static void startGameTimer(final GameCallback tc, float timeStart, float timeEnd) {
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                tc.startGame();
            }
        }, timeStart);

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                tc.finishGame();
            }
        }, timeEnd + timeStart);
    }

    public static void nextGameTimer(final GameCallback tc, float time) {
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                tc.nextGame();
            }
        }, time);
    }
}