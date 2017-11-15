package com.jae.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Alex Torrents (aka Turri) on 10-Nov-17.
 */

public class Text extends Actor {
    private final String text;
    private Vector2 position;
    private Rectangle rectangle;

    BitmapFont font;

    public Text(String text, Vector2 position) {
        this.text = text;
        this.position = position;
        rectangle = new Rectangle();
        font = new BitmapFont();
    }

    public void setSize(float x, float y) {rectangle.setSize(x, y);}

    public void setColor(Color color) {
        font.setColor(color.r, color.g, color.b, 1.0f);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        font.draw(batch, text, position.x-getWidth()/2.0f, position.y - getHeight()/2.0f);
        font.draw(batch,
                text,
                position.x-getWidth()/2.0f,
                position.y - getHeight()/2.0f,
                Gdx.graphics.getWidth()*3/4,
                5,
                false);

    }
}
