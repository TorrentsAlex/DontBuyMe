package com.jae.Models;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Alex Torrents AKA Turri on 22-Oct-17.
 */

public abstract class JAEScreen implements Screen {

    protected Game game;
    protected boolean done;

    protected Camera camera;
    protected SpriteBatch batch;

    /** Called when the screen should update itself, e.g. continue a simulation etc. */
    public abstract void update (float delta);

    /** Called when a screen should render itself */
    public abstract void draw (float delta);

    public abstract boolean isDone();

    public JAEScreen(Game game) {
        this.game = game;
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0.0f);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        camera.update();

        update(delta);

        Gdx.gl.glClearColor(0, 0.25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        draw(delta);
        batch.end();
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
        batch.dispose();
        done = false;
    }
}
