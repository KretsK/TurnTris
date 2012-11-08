package com.Turntris;

import sps.graphics.Renderer;
import sps.states.StateManager;

import com.badlogic.gdx.ApplicationListener;

public class Turntris implements ApplicationListener
{

	@Override
	public void create()
	{
		StateManager.loadState(new GamePlayState());
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
		Renderer.get().end();

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
