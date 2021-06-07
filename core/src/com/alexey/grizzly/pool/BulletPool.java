package com.alexey.grizzly.pool;

import com.alexey.grizzly.base.SpritesPool;
import com.alexey.grizzly.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {

    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
