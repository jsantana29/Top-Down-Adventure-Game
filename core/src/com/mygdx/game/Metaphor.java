package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Abstract.ObjectCollision;
import com.mygdx.game.Objects.Wall;
import com.mygdx.game.Screens.PlayScreen;

public class Metaphor extends Game {
	public static final int V_WIDTH = 600;
	public static final int V_HEIGHT = 600;
	public SpriteBatch batch;

	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;


	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen(this));

	}

	@Override
	public void render () {
		super.render();

	}
}
