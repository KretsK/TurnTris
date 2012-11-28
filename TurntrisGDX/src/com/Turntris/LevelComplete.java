package com.Turntris;

import sps.graphics.Renderer;
import sps.states.State;
import sps.states.StateManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class LevelComplete implements State
{

	private BitmapFont font;

	public LevelComplete()
	{
		font = new BitmapFont();
	}

	@Override
	public void draw()
	{
		Gdx.gl.glClearColor(0.5f, 0.1f, 0.6f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		renderString("Level Complete!", 300, 600, Color.CYAN, 2);
		renderString("TURNTRIS", 300, 800, Color.CYAN, 5);
		renderString("Press ENTER to Continue", 250, 400, Color.GREEN, 2);
	}

	@Override
	public void load()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void unload()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void update()
	{
		if (Gdx.input.isKeyPressed(Keys.ENTER))
		{
			StateManager.loadState(Turntris.gamePlayState);
		}

	}

	private void renderString(String content, float xCoord, float yCoord, Color filter, float scale)
	{
		font.setScale(scale);
		font.setColor(filter);
		font.draw(Renderer.get().batch, content, xCoord, yCoord);
	}
}
