package com.jae.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Alex Torrents (aka Turri) on 09-Nov-17.
 */

public class WorldBuilder {
    public Entity backgroundGame;
    public Entity backgroundWin;
    public Entity backgroundFail;

    public WorldBuilder() {}

    public WorldBuilder addBackgroundGame(String path) {
        backgroundGame = new Entity(path);
        backgroundGame.setSize(Gdx.graphics.getWidth(),
                                Gdx.graphics.getHeight());
        backgroundGame.setPosition(new Vector2(0, 0));
        return this;
    }
    public WorldBuilder addBackgroundWin(String path) {
        backgroundWin = new Entity(path);
        backgroundWin.setSize(Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight());
        backgroundWin.setPosition(new Vector2(0, 0));
        return this;
    }
    public WorldBuilder addBackgroundFail(String path) {
        backgroundWin = new Entity(path);
        backgroundWin.setSize(Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight());
        backgroundWin.setPosition(new Vector2(0, 0));
        return this;
    }
}
