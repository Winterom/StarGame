package com.alexey.grizzly.sprite;

import com.alexey.grizzly.base.Sprite;
import com.alexey.grizzly.math.Rect;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Logo extends Sprite {
    private final Vector2 temp;
    private final Vector2 v;
    private Vector2 touch;

    public Logo(Texture texture) {
        super(new TextureRegion(texture));
        touch = new Vector2();
        temp = new Vector2();
        v = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.1f);
        setBottom(worldBounds.getBottom() + 0.02f);
    }

    @Override
    public void draw(SpriteBatch batch) {
        if(v.x==0 & v.y==0){
            super.draw(batch);
            return;
        }

        if(temp.sub(pos).len()<=v.len()){
            pos.set(touch);
            v.setZero();
        }else {
            pos.add(v);
        }
        super.draw(batch);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch = touch;
        temp.set(touch);
        v.set(touch.cpy().sub(pos)).setLength(0.01f);
        return false;
    }
}
