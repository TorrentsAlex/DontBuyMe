package com.jae.ActivityScreens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Timer;
import com.jae.Models.JAEScreen;
import com.jae.Models.Entity;
import com.jae.Models.Text;
import com.jae.Utils.Data;

/**
 * Created by Alex Torrents (AKA Turri) on 22-Oct-17.
 */

public class MainMenu extends JAEScreen {

    Entity background;
    Entity playButton;
    Entity title;
    Text textDontBuyMe;


    public MainMenu(Game game) {
        super(game);
        init();
    }

    @Override
    public void update(float delta) {
        if (Gdx.input.isTouched()) {
            Vector3 touchpos = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0.0f));
            if (playButton.contains(touchpos.x, touchpos.y)) {
                done = true;
            }
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void draw(float delta) {
        background.draw(batch);
        playButton.draw(batch);
        textDontBuyMe.draw(batch, delta);

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

        background = new Entity(Data.MAINMENU_BACKGROUND);
        background.setPosition(new Vector2(0,0));
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        playButton = new Entity(Data.MAINMENU_BUTTON_PLAY);
        playButton.setPosition(new Vector2(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/4));
        playButton.setSize(new Vector2( Gdx.graphics.getHeight()/5, Gdx.graphics.getHeight()/5));

        Texture titleTexture = new Texture(Data.MAINMENU_TITLE);
        TextureRegion titleRegion = new TextureRegion(titleTexture, 0, 0, titleTexture.getWidth(), titleTexture.getHeight()/ 6);

        textDontBuyMe = new Text("Don't Buy Me", new Vector2(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2));
        textDontBuyMe.setColor(Color.GOLD);

        Gdx.app.debug("DontBuyMe","init Main menu");
    }
}

