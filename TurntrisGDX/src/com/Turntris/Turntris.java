package com.Turntris;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class Turntris implements ApplicationListener
{

	Texture dropImage;
	Texture bucketImage;
	Sound dropSound;
	Music rainMusic;
	OrthographicCamera camera;
	SpriteBatch batch;
	Rectangle bucket;
	Array<Raindrop> raindrops;
	long lastDropTime;
	Texture SquareImage;
	Rectangle Square;

	Texture SpriteSheet;

	Sprite pail;
	Array<Block> blocks;
	Cursor cursor;
	float cursorTime;
	boolean cursorMoved;
	int orientNum = 1;
	float rotateTime;

	@Override
	public void create()
	{

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1000, 1020);
		batch = new SpriteBatch();

		// load the drop sound effect and the rain background "music"
		// dropSound =
		// Gdx.audio.newSound(Gdx.files.internal("assets/rainmusic 2.mp3"));
		// rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));

		// start the playback of the background music immediately
		// rainMusic.setLooping(true);
		// rainMusic.play();

		// ***************************Turntris Code****************

		init();
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
		cursorMoved = false;
	}

	@Override
	public void resize(int width, int height)
	{

	}

	@Override
	public void render()
	{
		// clear the screen with a dark blue color. The
		// arguments to glClearColor are the red, green
		// blue and alpha component in the range [0,1]
		// of the color to be used to clear the screen.
		Gdx.gl.glClearColor(0.5f, 0.1f, 0.6f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		camera.update();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		for (Block block : blocks)
		{
			block.draw(batch);
		}

		cursor.draw(batch);

		batch.end();

		cursorMoved = false;

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
			cursorMoved = true;
		}

		// *********TurnTris Code************

		if (Gdx.input.isKeyPressed(Keys.N))
		{
			init();
		}

		if (Gdx.input.isKeyPressed(Keys.R) && rotateTime > .15)
		{
			rotate();
			rotateTime = 0;
		}

		cursorTime += Gdx.graphics.getDeltaTime();
		rotateTime += Gdx.graphics.getDeltaTime();
		// System.out.println(rotateTime);

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
		batch.dispose();

	}

	private void rotate()
	{

		ArrayList<Block> inCursor = new ArrayList<Block>();
		inCursor.clear();

		if (cursorMoved)
		{
			orientNum = 1;
		}

		for (Block block : blocks)
		{
			if (block != null)
			{
				if (cursor.insideCursor(block) == false)
				{
					block.setPosition(cursor.getOrient(orientNum).getPositionX(), cursor.getOrient(orientNum).getPositionY());

					orientNum = (orientNum + 1) % 4;
					inCursor.add(block);
				}

			}
		}
		orientNum = (orientNum + 1) % 4;

		if (inCursor.size() == 4)
		{
			if (inCursor.get(0).getColor().equals(inCursor.get(1).getColor()) && inCursor.get(0).getColor().equals(inCursor.get(2).getColor()) && inCursor.get(0).getColor().equals(inCursor.get(3).getColor()))
			{
				for (Block block : inCursor)
				{
					blocks.removeValue(block, true);

				}
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
}
