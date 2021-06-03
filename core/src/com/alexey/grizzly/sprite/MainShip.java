package com.alexey.grizzly.sprite;

import com.alexey.grizzly.base.Sprite;
import com.alexey.grizzly.math.Rect;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class MainShip extends Sprite {
    Rect worldBounds;
    Vector2 v;
    Vector2 touch;

    private  final static float PADDING= 0.03f;

    public MainShip(TextureAtlas atlas) {
        super(new TextureRegion(atlas.findRegion("main_ship")),0,0,390/2,287);
        v = new Vector2();
        touch= new Vector2();
    }


    @Override
    public void update(float delta) {
        super.update(delta);
        pos.mulAdd(v,delta);
        if (touch.x>0 & pos.x>=touch.x){
            v.setZero();
        }
        if (touch.x<0 & pos.x<=touch.x){
            v.setZero();
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(0.2f);
        setBottom(worldBounds.getBottom()+PADDING);
        this.worldBounds = worldBounds;
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch.set(touch);
        //если ткнули слишком близко к краю экрана
        //текстура корабля частично уходит за край
        if (touch.x>0 & touch.x>worldBounds.getRight()*0.9){
            touch.x=worldBounds.getRight()*0.9f;
        }
        if (touch.x<0 & touch.x<worldBounds.getLeft()*0.9){
            touch.x =worldBounds.getLeft()*0.9f;
        }
        v.set((touch.sub(pos).setLength(0.2f)).x,0);
        return false;
    }

}
