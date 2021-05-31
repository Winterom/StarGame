package com.alexey.grizzly;

import com.alexey.grizzly.screen.MenuScreen;
import com.badlogic.gdx.Game;



public class StarGameClazz extends Game {

	@Override
	public void create() {
		setScreen(new MenuScreen());
	}

}
