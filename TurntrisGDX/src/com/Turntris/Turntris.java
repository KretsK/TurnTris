package com.Turntris;

import sps.graphics.Renderer;
import sps.states.StateManager;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Turntris implements ApplicationListener
{
	private int initial = 0;
	public static GamePlayState gamePlayState;
	public static InstructionState instructionState;

	@Override
	public void create()
	{

		Renderer.setVirtualResolution(1000, 1125);
		StateManager.loadState(new Menu());
		// Spx.setup();
		gamePlayState = new GamePlayState();
		instructionState = new InstructionState();
	}

	@Override
	public void resize(int width, int height)
	{

	}

	@Override
	public void render()
	{
		StateManager.update();

		Renderer.get().begin();
		StateManager.draw();
		// TextPool.get().draw();
		Renderer.get().end();

		if (initial == 0 && Gdx.input.isKeyPressed(Keys.ENTER))
		{
			initial++;
			StateManager.loadState(gamePlayState);
		}

		if (Gdx.input.isKeyPressed(Keys.I))
		{
			StateManager.loadState(instructionState);
		}

		if (instructionState.inInstructionMenu == true && Gdx.input.isKeyPressed(Keys.Q))
		{
			StateManager.loadState(gamePlayState);
		}

	}

	@Override
	public void pause()
	{

	}

	@Override
	public void resume()
	{

	}

	@Override
	public void dispose()
	{

		// dropImage.dispose();
		// bucketImage.dispose();
		// dropSound.dispose();
		// rainMusic.dispose();
		// batch.dispose();

	}

}
