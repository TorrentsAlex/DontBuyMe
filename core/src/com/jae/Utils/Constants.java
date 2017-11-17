package com.jae.Utils;

import com.badlogic.gdx.Gdx;

/**
 * Created by Alex Torrents (aka Turri) on 07-Nov-17.
 */

public class Constants {

    // APPDATA
    public static String TAG = "DontBuyMe";
    // GAMEDATA

    public static float GAMEDATA_TIME_START = 2.0f;

    public static float GAMEDATA_TIME_INGAME = 10.0f;
    public static float GAMEDATA_TIME_WINFAIL = 5.0f;
    // MAINMENU
    public static String MAINMENU_BACKGROUND = "parallax-forest.png";

    public static String MAINMENU_BUTTON_PLAY = "b_round_g.png";
    public static String MAINMENU_TITLE = "titles.png";
    // END
    public static String END_BACKGROUND = "parallax-forest.png";

    public static String END_BUTTON_RETURN = "returngame.png";
    public static String END_BUTTON_END = "cross.png";
    // GAMES
    public static String DRAGME_BACKGROUND = "airadventurelevel1.png";


    public static String DRAGME_BUTTON_NEXT = "b_round_g.png";
    public static String SWIPE_BACKGROUND_GAME = "airadventurelevel2.png";


    public static String SWIPE_BACKGROUND_WIN = "win_bk.png";
    public static String SWIPE_BACKGROUND_FAIL = "fail_bk.png";
    public static String SWIPE_SWIPE_UP = "swipe_up.png";
    public static String SWIPE_SWIPE_DOWN = "swipe_down.png";
    public static String SWIPE_SWIPE_LEFT = "swipe_left.png";
    public static String SWIPE_SWIPE_RIGHT = "swipe_right.png";
    public static String SWIPE_PARTICLE_EFFECT = "star_explosion.p";
    public static String TILT_BACKGROUND = "airadventurelevel3.png";

    public static String TILT_PLAYER = "jump-blue.png";
    public static String TILT_ENEMY_SPIKE = "spike-ball.png";


    //  Otter Runner
    public static final String OTTER_BACKGROUND = "otter_runner/airadventurelevel4.png";
    public static final String OTTER_ANIMATION ="otter_runner/otter_anim.txt";
    public static final String OTTER_TEXT_TUTORIAL ="otter_runner/otter_tutorial.png";
    public static final String OTTER_TRAP_ATLAS = "otter_runner/otter_trap.txt";
    public static final String OTTER_TRAP_OPEN = "trap_open";
    public static final String OTTER_TRAP_CLOSE = "trap_close";
    
    public static final float OTTER_GRAVITY = -2.5f;
    public static final float OTTER_FORCE_JUMP = 50f;
    public static final float OTTER_GROUND_Y = Gdx.graphics.getHeight()*1/8;
    public static float OTTER_SPEED = 950.0f;
}
