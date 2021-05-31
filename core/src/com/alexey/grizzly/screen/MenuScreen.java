package com.alexey.grizzly.screen;

import com.alexey.grizzly.base.BaseScreen;
import com.alexey.grizzly.math.Rect;
import com.alexey.grizzly.sprite.Background;
import com.alexey.grizzly.sprite.Logo;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;



public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Logo logo;
    private Background background;

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        background = new Background(bg);
        Texture logoTexture = new Texture("badlogic.jpg");
        logo = new Logo(logoTexture);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        logo.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        ScreenUtils.clear(0.33f, 0.45f, 0.68f, 1);
        batch.begin();
        background.draw(batch);
        logo.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        logo.touchDown(touch,pointer,button);
        return false;
    }
}
