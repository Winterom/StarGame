package com.alexey.grizzly.sprite;

import com.alexey.grizzly.base.Sprite;
import com.alexey.grizzly.math.Rect;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class GameOver extends Sprite {

    private static final float HEIGHT = 0.08f;

    public GameOver(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
        setTop(worldBounds.pos.y + 0.1f);
    }
}
