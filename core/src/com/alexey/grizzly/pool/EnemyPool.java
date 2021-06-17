package com.alexey.grizzly.pool;

import com.alexey.grizzly.base.SpritesPool;
import com.alexey.grizzly.math.Rect;
import com.alexey.grizzly.sprite.EnemyShip;
import com.badlogic.gdx.audio.Sound;

public class EnemyPool extends SpritesPool<EnemyShip> {

    private final Rect worldBounds;
    private final BulletPool bulletPool;
    private final Sound bulletSound;

    public EnemyPool(Rect worldBounds, BulletPool bulletPool, Sound bulletSound) {
        this.worldBounds = worldBounds;
        this.bulletPool = bulletPool;
        this.bulletSound = bulletSound;
    }

    @Override
    protected EnemyShip newObject() {
        return new EnemyShip(worldBounds, bulletPool, bulletSound);
    }
}
