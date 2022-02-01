package com.alexey.grizzly.sprite;

import com.alexey.grizzly.base.ScaledButton;
import com.alexey.grizzly.math.Rect;

import com.alexey.grizzly.screen.GameScreen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class NewGame extends ScaledButton {
    GameScreen gameScreen;


    private static final float HEIGHT = 0.1f;

    public NewGame(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        this.gameScreen = gameScreen;

    }

    @Override
    protected void action() {
        gameScreen.newGame();
    }
    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
        setTop(worldBounds.pos.y - 0.2f);
    }
}
