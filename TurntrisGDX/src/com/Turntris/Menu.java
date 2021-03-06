package com.Turntris;

import sps.graphics.Renderer;
import sps.states.State;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Menu implements State
{
	private BitmapFont font;

	public Menu()
	{
		font = new BitmapFont();
	}

	@Override
	public void draw()
	{
		Gdx.gl.glClearColor(0.5f, 0.1f, 0.6f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		renderString("Press Enter to Play Game", 300, 600, Color.CYAN, 2);
		renderString("TURNTRIS", 250, 800, Color.CYAN, 5);
		renderString("Press the 'I' Key for Instructions", 300, 300, Color.CYAN, 2);
		// TextPool.get().write("TURNTRIS", new Point2(500, 200));
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
		// TODO Auto-generated method stub

	}

	private void renderString(String content, float xCoord, float yCoord, Color filter, float scale)
	{
		font.setScale(scale);
		font.setColor(filter);
		font.draw(Renderer.get().batch, content, xCoord, yCoord);
	}

}
