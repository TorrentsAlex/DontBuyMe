package com.jae.GameScreens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.jae.JAEScreen;
import com.jae.Models.Entity;

/**
 * Created by Alex Torrents (AKA Turri) on 22-Oct-17.
 */

public class TouchFast extends JAEScreen {
    Entity background;

    Entity playButton;

    public TouchFast(Game game) {
        super(game);
        init();
    }


    @Override
    public void update(float delta) {
        camera.update();

        if (Gdx.input.isTouched()) {
            Vector3 touchpos = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0.0f));
            if (playButton.contains(touchpos.x, touchpos.y)) {
                done = true;
            }
        }
    }

    @Override
    public void draw(float delta) {
        background.draw(batch);
        playButton.draw(batch);
    }

    @Override
    public boolean isDone() {
        return done;
    }

    private void init() {
        done = false;

        background = new Entity("airadventurelevel2.png");
        background.setPosition(new Vector2(0,0));
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        playButton = new Entity("b_round_g.png");
        playButton.setPosition(new Vector2(Gdx.graphics.getWidth()/2.5f, Gdx.graphics.getHeight()/2.5f));
        playButton.setSize(new Vector2( Gdx.graphics.getHeight()/5, Gdx.graphics.getHeight()/5));

        Gdx.app.debug("DontBuyMe","init Touch fast game");
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
