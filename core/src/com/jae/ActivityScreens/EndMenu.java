package com.jae.ActivityScreens;

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

public class EndMenu extends JAEScreen { Camera camera;

    Entity background;

    Entity playButton;
    Entity endButton;

    public EndMenu(Game game) {
        super(game);
        init();
    }

    @Override
    public void update(float delta) {

        if (Gdx.input.isTouched()) {
            Vector3 touchpos = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0.0f));
            if (playButton.contains(touchpos.x, touchpos.y)) {
                game.setScreen(new MainMenu(game));
            }
            if (endButton.contains(touchpos.x, touchpos.y)) {
                done = true;
            }
        }
    }

    @Override
    public void draw(float delta) {
        background.draw(batch);

        playButton.draw(batch);
        endButton.draw(batch);
    }

    @Override
    public boolean isDone() {
        return done;
    }

    @Override
    public void dispose() {
        super.dispose();
        background.dispose();
    }

    private void init() {
        done = false;

        background = new Entity("parallax-forest.png");
        background.setPosition(new Vector2(0,0));
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        playButton = new Entity("returngame.png");
        playButton.setSize(new Vector2( Gdx.graphics.getHeight()/5, Gdx.graphics.getHeight()/5));
        playButton.setPosition(new Vector2(Gdx.graphics.getWidth()/2 - playButton.getSize().x /2, Gdx.graphics.getHeight()/2));

        endButton = new Entity("cross.png");
        endButton.setSize(new Vector2( Gdx.graphics.getHeight()/5, Gdx.graphics.getHeight()/5));
        endButton.setPosition(new Vector2(Gdx.graphics.getWidth()/2 + playButton.getSize().x /2, Gdx.graphics.getHeight()/2));
        Gdx.app.debug("DontBuyMe","init End menu");

    }
}
