package com.jae;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

/**
 * Created by Alex Torrents AKA Turri on 22-Oct-17.
 */

public abstract class JAEScreen implements Screen {

    protected Game game;
    protected boolean done;

    /** Called when the screen should update itself, e.g. continue a simulation etc. */
    public abstract void update (float delta);

    /** Called when a screen should render itself */
    public abstract void draw (float delta);

    public abstract boolean isDone();

    public JAEScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(delta);
        draw(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        done = false;
    }
}
