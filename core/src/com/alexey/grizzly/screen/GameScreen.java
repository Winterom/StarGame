package com.alexey.grizzly.screen;

import com.alexey.grizzly.base.BaseScreen;
import com.alexey.grizzly.math.Rect;
import com.alexey.grizzly.sprite.Background;
import com.alexey.grizzly.sprite.MainShip;
import com.alexey.grizzly.sprite.Star;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen extends BaseScreen {
    private static final int STAR_COUNT = 64;

    private Texture bg;
    private TextureAtlas atlas;

    private Background background;
    private Star[] stars;
    private MainShip ship;

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        background = new Background(bg);
        atlas = new TextureAtlas("textures/mainAtlas.tpack");
        stars = new Star[STAR_COUNT];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(atlas);
        }
        ship = new MainShip(atlas);
    }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }



    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (Star star : stars) {
            star.resize(worldBounds);
        }
        ship.resize(worldBounds);
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        atlas.dispose();
    }

    private void update(float delta) {
        for (Star star : stars) {
            star.update(delta);
        }
        ship.update(delta);
    }

    private void draw() {
        ScreenUtils.clear(0.33f, 0.45f, 0.68f, 1);
        batch.begin();
        background.draw(batch);
        for (Star star : stars) {
            star.draw(batch);
        }
        ship.draw(batch);
        batch.end();
    }
    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
       return ship.touchDown(touch, pointer, button);
    }
}

