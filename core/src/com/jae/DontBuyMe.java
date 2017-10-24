package com.jae;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.jae.ActivityScreens.EndMenu;
import com.jae.ActivityScreens.MainMenu;
import com.jae.GameScreens.DragMe;
import com.jae.GameScreens.Tilt;
import com.jae.GameScreens.TouchFast;

import java.util.ArrayList;

enum GameState {
    MENU,
    GAME,
    END
};

public class DontBuyMe extends Game {

    ArrayList<JAEScreen> games;
    int countCurrentScreen;
    GameState gameState;

	@Override
	public void create () {
        setScreen(new MainMenu(this));

        games = new ArrayList<JAEScreen>();
        games.add(new Tilt(this));
        games.add(new DragMe(this));
        games.add(new TouchFast(this));
        countCurrentScreen = 0;

        gameState = GameState.MENU;
    }

	@Override
	public void render () {
        JAEScreen currentScreen = (JAEScreen) super.getScreen();

        currentScreen.render(Gdx.graphics.getDeltaTime());

	    if (currentScreen.isDone()) {
            currentScreen.dispose();
            switch (gameState) {
                case MENU:
                    gameState = GameState.GAME;
                    setScreen(games.get(countCurrentScreen));

                    break;
                case GAME:
                    countCurrentScreen++;
                    if (countCurrentScreen >= games.size()) {
                        gameState = GameState.END;
                        setScreen(new EndMenu(this));

                    } else {
                        setScreen(games.get(countCurrentScreen));
                    }
                    break;
                case END:
                    setScreen(new MainMenu(this));
                    countCurrentScreen = 0;
                    gameState = GameState.MENU;
                    break;
            }
        }
	}
	
	@Override
	public void dispose () {

	}
}
