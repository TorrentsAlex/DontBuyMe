package com.jae.GameScreens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.jae.Models.GameScreen;
import com.jae.Models.JAEScreen;
import com.jae.Models.Entity;

/**
 * Created by Alex Torrents (AKA Turri) on 22-Oct-17.
 */

public class TouchFast extends GameScreen {

    private Entity playButton;

    private ParticleEffect startExplosion;

    public TouchFast(Game game) {
        super(game);
        init();
    }

    @Override
    public void update(float delta) {
        super.update(delta);


        if (Gdx.input.isTouched()) {
            Vector3 touchpos = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0.0f));
            if (playButton.contains(touchpos.x, touchpos.y)) {
                done = true;
            }
        }
    }

    @Override
    public void draw(float delta) {
        super.draw(delta);
        playButton.draw(batch);
    }

    @Override
    public boolean isDone() {
        return done;
    }

    private void init() {
        done = false;

        backgroundGame = new Entity("airadventurelevel2.png");
        backgroundGame.setPosition(new Vector2(0,0));
        backgroundGame.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        Gdx.app.debug("DontBuyMe","init Touch fast game");
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void drawGame(float delta) {

    }

    @Override
    public void drawWin(float delta) {

    }

    @Override
    public void drawFail(float delta) {

    }
}
