package com.alexey.grizzly.sprite;

import com.alexey.grizzly.base.ScaledButton;
import com.alexey.grizzly.math.Rect;
import com.alexey.grizzly.screen.GameScreen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;


public class NewGameButton extends ScaledButton {
    private static final float HEIGHT = 0.08f;
    private static final float ANIMATE_INTERVAL = 0.1f;
    private float animateTimer;
    private boolean scaledUp = false;
    private GameScreen gameScreen;


    public NewGameButton(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        this.gameScreen = gameScreen;
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(HEIGHT);
        setTop(worldBounds.pos.y);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if (pressed){
            return;
        }
        animateTimer += delta;
        if (animateTimer > ANIMATE_INTERVAL) {
            animateTimer = 0;
            if (scaledUp){
                scale +=delta;
            }else {
                scale -=delta;
            }
            if (scale<=0.9f){
                scaledUp =true;
            }
            if (scale >=1){
                scaledUp =false;
            }
        }
    }

    @Override
    protected void action() {
        gameScreen.startNewGame();
    }
}
