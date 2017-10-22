package com.jae.GameScreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.jae.JAEScreen;
import com.jae.Models.Entity;

/**
 * Created by Alex Torrents (AKA Turri) on 22-Oct-17.
 */

public class DragMe extends JAEScreen {

    Entity background;

    Camera camera;
    SpriteBatch batch;
    boolean done;

    public DragMe() {
        init();
    }


    @Override
    public void update(float delta) {
        camera.update();

        if (Gdx.input.isTouched()) {
            done = true;
        }

    }

    @Override
    public void draw(float delta) {

        Gdx.gl.glClearColor(0, 0.25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        batch.end();
    }

    @Override
    public boolean isDone() {
        return done;
    }

    private void init() {
        done = false;
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0.0f);

        background = new Entity("airadventurelevel1.png");
        background.setPosition(new Vector2(0,0));
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

    }
}
