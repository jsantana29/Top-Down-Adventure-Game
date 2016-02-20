package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Metaphor;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Metaphor.WIDTH;
		config.height = Metaphor.HEIGHT;
		config.title = "Prototype game";
		new LwjglApplication(new Metaphor(), config);
	}
}
