package com.Turntris;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import sps.graphics.Renderer;
import sps.states.State;
import sps.states.StateManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Array;

public class GamePlayState implements State
{
	Sound fallBrick;
	Music TurntrisMusic2;

	Texture SpriteSheet;

	Array<Block> blocks;
	Cursor cursor;
	float cursorTime;
	int orientNum = 1;
	float rotateTime;
	float rotateShapeTime;
	private BitmapFont font;
	HeaderLine line;
	private float oneSec;
	private int seconds = 0;
	private int minutes = 0;
	private String timer;
	private int score = 0;

	public GamePlayState()
	{

		font = new BitmapFont();

		// load the drop sound effect and the rain background "music"
		fallBrick = Gdx.audio.newSound(Gdx.files.internal("assets/BricksFalling.mp3"));
		// TurntrisMusic2 =
		// Gdx.audio.newMusic(Gdx.files.internal("assets/TurntrisMusic3.wav"));

		// start the playback of the background music immediately
		// TurntrisMusic2.setLooping(true);
		// TurntrisMusic2.play();

		init();
	}

	@Override
	public void draw()
	{
		Gdx.gl.glClearColor(0.5f, 0.1f, 0.6f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		for (Block block : blocks)
		{
			block.draw(Renderer.get().batch);
		}

		cursor.draw(Renderer.get().batch);
		line.draw(Renderer.get().batch);

		renderString("SCORE", 50, 1075, Color.MAGENTA, 2);
		renderString(String.valueOf(score), 50, 1035, Color.MAGENTA, 2);
		renderString("TIME", 500, 1075, Color.MAGENTA, 2);
		renderString(timer, 500, 1035, Color.MAGENTA, 2);
		renderString("NEXT", 900, 1075, Color.MAGENTA, 2);

	}

	@Override
	public void update()
	{
		// clear the screen with a dark blue color. The
		// arguments to glClearColor are the red, green
		// blue and alpha component in the range [0,1]
		// of the color to be used to clear the screen.

		timer = minutes + "." + seconds;
		if (seconds < 10)
		{
			timer = minutes + ".0" + seconds;
		}

		// if (Gdx.input.isTouched())
		// {
		// Vector3 touchPos = new Vector3();
		// touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		// camera.unproject(touchPos);
		// Square.x = touchPos.x - 100 / 2;
		// }

		if (cursor.update(cursorTime))
		{
			cursorTime = 0;
		}

		if (oneSec > 1)
		{
			seconds += 1;
			if (seconds == 60)
			{
				minutes++;
				seconds = 0;
			}
			oneSec = 0;
		}

		if (Gdx.input.isKeyPressed(Keys.N))
		{
			init();
		}
		if (Gdx.input.isKeyPressed(Keys.S) && rotateShapeTime > .15)
		{
			cursor.rotateCursor();
			rotateShapeTime = 0;
		}

		if (Gdx.input.isKeyPressed(Keys.R) && rotateTime > .15)
		{
			rotate();
			rotateTime = 0;

		}

		cursorTime += Gdx.graphics.getDeltaTime();
		rotateTime += Gdx.graphics.getDeltaTime();
		rotateShapeTime += Gdx.graphics.getDeltaTime();
		oneSec += Gdx.graphics.getDeltaTime();
		// System.out.println();

		for (int i = 0; i < blocks.size; i++)
		{
			Block block = blocks.get(i);
			if (block != null)
			{

				if (findPositionBelow(block.getPositionX(), block.getPositionY()) == null && block.getPositionY() > 0)
				{
					block.gravity();
				}

			}
		}

		if (blocks.size <= 85) // change back to 32 when done testing
		{
			init();
			StateManager.loadState(new LevelComplete());

		}

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

	private void rotate()
	{

		ArrayList<Block> inCursor = new ArrayList<Block>();
		inCursor.clear();

		Map<Block, Orientation> nextMoves = new HashMap<Block, Orientation>();

		for (Block block : blocks)
		{
			// System.out.println(cursor.getNextMove(block));
			if (block != null && cursor.getNextMove(block) != null)
			{
				inCursor.add(block);
				nextMoves.put(block, cursor.getNextMove(block));
				System.out.println("put block into InCursor");

			}
		}

		if (inCursor.size() == 4)
		{
			for (Block block : inCursor)
			{
				block.setPosition(nextMoves.get(block).getPositionX(), nextMoves.get(block).getPositionY());
				System.out.println("set the block to new position.");
			}

			if (inCursor.get(0).getColor().equals(inCursor.get(1).getColor()) && inCursor.get(0).getColor().equals(inCursor.get(2).getColor()) && inCursor.get(0).getColor().equals(inCursor.get(3).getColor()))
			{
				for (Block block : inCursor)
				{
					blocks.removeValue(block, true);

				}
				score = score + 40;
				fallBrick.play();
			}
		}

	}

	private Block findPositionBelow(float x, float y)
	{
		for (int i = 0; i < blocks.size; i++)
		{
			Block block = blocks.get(i);
			if (block != null)
			{
				if (block.getPositionX() == x && block.getPositionY() == (y - 100))
				{
					return block;
				}
			}
		}
		return null;
	}

	private void renderString(String content, float xCoord, float yCoord, Color filter, float scale)
	{
		font.setScale(scale);
		font.setColor(filter);
		font.draw(Renderer.get().batch, content, xCoord, yCoord);
	}

	public void init()
	{

		blocks = new Array<Block>();
		for (int j = 0; j < 10; j++)
		{
			for (int i = 0; i < 10; i++)
			{

				Block temp = new Block();
				temp.setPositionX(i * 100);
				temp.setPositionY(j * 100);
				blocks.add(temp);

			}
		}

		cursor = new Cursor();

		line = new HeaderLine();

	}

}
