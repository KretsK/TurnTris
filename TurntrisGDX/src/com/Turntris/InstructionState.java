package com.Turntris;

import sps.graphics.Renderer;
import sps.states.State;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class InstructionState implements State
{

	private BitmapFont font;
	public boolean inInstructionMenu = false;

	public InstructionState()
	{
		font = new BitmapFont();
	}

	@Override
	public void draw()
	{
		Gdx.gl.glClearColor(0.5f, 0.1f, 0.6f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		renderString("Instructions", 450, 1000, Color.CYAN, 3);
		renderString("Use the Arrow Keys to move the Cursor", 50, 800, Color.CYAN, 2);
		renderString("Press the 'R' key to rotate the blocks that are inside the cursor", 50, 600, Color.CYAN, 2);
		renderString("4 blocks of the same color will clear when rotated inside the cursor", 50, 400, Color.CYAN, 2);
		renderString("Clear 30% of the blocks to continue. Press 'Q' to return to game.", 50, 200, Color.CYAN, 2);

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
		inInstructionMenu = true;

	}

	private void renderString(String content, float xCoord, float yCoord, Color filter, float scale)
	{
		font.setScale(scale);
		font.setColor(filter);
		font.draw(Renderer.get().batch, content, xCoord, yCoord);
	}

}
