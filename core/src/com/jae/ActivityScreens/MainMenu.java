package com.jae.ActivityScreens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.jae.JAEScreen;
import com.jae.Models.Entity;

/**
 * Created by Alex Torrents (AKA Turri) on 22-Oct-17.
 */

public class MainMenu extends JAEScreen {

    Camera camera;
    SpriteBatch batch;

    Entity background;
    Entity playButton;
    Entity title;


    public MainMenu(Game game) {
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
        Gdx.gl.glClearColor(0, 0.25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        background.draw(batch);
        playButton.draw(batch);
        title.draw(batch);

        batch.end();
    }

    @Override
    public boolean isDone() {
        return done;
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        background.dispose();

    }

    private void init() {
        done = false;
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0.0f);

        background = new Entity("parallax-forest.png");
        background.setPosition(new Vector2(0,0));
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        playButton = new Entity("b_round_g.png");
        playButton.setPosition(new Vector2(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/4));
        playButton.setSize(new Vector2( Gdx.graphics.getHeight()/5, Gdx.graphics.getHeight()/5));


        Texture titleTexture = new Texture("titles.png");
        TextureRegion titleRegion = new TextureRegion(titleTexture, 0, 0, titleTexture.getWidth(), titleTexture.getHeight()/ 6);

        title = new Entity(titleRegion.getTexture());
        title.setSize(Gdx.graphics.getWidth()*3/4, Gdx.graphics.getHeight() /4);
        title.setPosition(new Vector2(Gdx.graphics.getWidth()/2 + title.getSize().x/2, 50));

        Gdx.app.debug("DontBuyMe","init Main menu");
    }
}
