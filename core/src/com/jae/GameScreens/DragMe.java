package com.jae.GameScreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.jae.JAEScreen;
import com.jae.Models.Entity;
import com.jae.Models.JAEAnimation;

/**
 * Created by Alex Torrents (AKA Turri) on 22-Oct-17.
 */

public class DragMe extends JAEScreen {

    Entity background;
    Entity playButton;

    Camera camera;
    SpriteBatch batch;

    JAEAnimation flame;

    public DragMe(Game game) {
        super(game);
        init();
    }


    @Override
    public void update(float delta) {
        camera.update();
        flame.update();

        if (Gdx.input.isTouched()) {
            Vector3 touchpos = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0.0f));
            if (playButton.contains(touchpos.x, touchpos.y)) {
                done = true;
            }
            Vector2 flSize = flame.getSize();
            flame.setPosition(new Vector2(touchpos.x - flSize.x/2, touchpos.y - flSize.y/2));
        }

    }

    @Override
    public void draw(float delta) {
        Gdx.gl.glClearColor(0, 0.25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        background.draw(batch);
        playButton.draw(batch);
        flame.draw(batch);
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

        playButton = new Entity("b_round_g.png");
        playButton.setPosition(new Vector2(0, 0));
        playButton.setSize(new Vector2( Gdx.graphics.getHeight()/5, Gdx.graphics.getHeight()/5));

        flame = new JAEAnimation("walk2.png", 8, 1, 1/15.0f);
        flame.setSize(new Vector2(Gdx.graphics.getHeight()/4, Gdx.graphics.getHeight()/4));
        flame.setPosition(new Vector2(Gdx.graphics.getWidth()/2- flame.getSize().x/2,
                Gdx.graphics.getHeight()/2 - flame.getSize().y/2));

        Gdx.app.debug("DontBuyMe","init Drag Me Game");

    }
}
