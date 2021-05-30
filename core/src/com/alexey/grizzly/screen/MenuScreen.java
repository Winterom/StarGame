package com.alexey.grizzly.screen;

import com.alexey.grizzly.base.BaseScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;



public class MenuScreen extends BaseScreen {

    private Texture img;
    private Vector2 pos;
    private Vector2 v;
    private Vector2 touch;
    private Vector2 temp;
    private final static float V_LEN =1.5f;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        pos = new Vector2();
        v = new Vector2();
        touch = new Vector2();
        temp = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        pos.add(v);
        ScreenUtils.clear(0.33f, 0.45f, 0.68f, 1);
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
        if (touch.cpy().sub(pos).len()<=v.len()){
            pos.set(touch);
            v.setZero();
        }else {
            pos.add(v);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX,Gdx.graphics.getHeight()-screenY);
        temp.set(touch);
        v.set(touch.cpy().sub(pos)).setLength(V_LEN);
       return false;
    }
}
