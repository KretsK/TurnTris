package com.Turntris;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Cursor
{

	private int randSprite = 1;

	private Shape shape;

	public Cursor()
	{

		randSprite = MathUtils.random(1, 5);

		if (randSprite == 1) // for a Square
		{
			shape = new SquareShape();
		}

		if (randSprite == 2) // for a L
		{
			shape = new Lshape();
		}

		if (randSprite == 3) // for a t
		{
			shape = new Tshape();
		}

		if (randSprite == 4) // for a |
		{
			shape = new LineShape();
		}

		if (randSprite == 5) // for a z
		{
			shape = new Zshape();
		}

		// shape should be sorted based on orientation index, not the variable
		// name.
		// shape = new ArrayList<Orientation>(Arrays.asList(orient0, orient1,
		// orient2, orient3));
	}

	public void draw(SpriteBatch batch)
	{
		shape.draw(batch);
	}

	public boolean update(float time)
	{
		float speed = 100; // how far is next square away
		float velocityX = ((Gdx.input.isKeyPressed(Keys.RIGHT)) ? 1 : 0) * speed - ((Gdx.input.isKeyPressed(Keys.LEFT)) ? 1 : 0) * speed;
		float velocityY = ((Gdx.input.isKeyPressed(Keys.UP)) ? 1 : 0) * speed - ((Gdx.input.isKeyPressed(Keys.DOWN)) ? 1 : 0) * speed;

		if (time > .15)
		{
			shape.moveIfinBounds(velocityX, velocityY);

			if (velocityX != 0 || velocityY != 0)
				return true;
		}
		return false;
	}

	public Orientation insideCursor(Block block)
	{

		for (Orientation orient : shape)
		{
			if (orient.getRectangle().overlaps(block.getRectangle()))
			{
				// System.out.println(orient.Index);
				return orient;
			}
		}

		return null;
	}

	public Orientation getOrient(int x)
	{
		for (Orientation orient : shape)
		{
			if (orient.Index == x)
				return orient;
		}

		return null;
	}

	public Orientation getNextMove(Block block)
	{
		if (insideCursor(block) != null)
		{
			return getOrient((insideCursor(block).Index + 1) % 4);
		}
		return null;
	}

	public void rotateCursor()
	{

	}
}
