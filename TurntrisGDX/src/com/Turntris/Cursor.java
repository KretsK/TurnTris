package com.Turntris;

import java.util.ArrayList;
import java.util.Arrays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Cursor
{

	private int randSprite = 1;
	private Orientation orient1;
	private Orientation orient2;
	private Orientation orient3;
	private Orientation orient4;
	private ArrayList<Orientation> Shape;

	public Cursor()
	{

		randSprite = MathUtils.random(1, 5);

		if (randSprite == 1) // for a Square
		{
			orient1 = new Orientation(SpriteType.Corner, Rotation.Zero, 0, 1);
			orient2 = new Orientation(SpriteType.Corner, Rotation.TwoSeventy, 1, 1);
			orient3 = new Orientation(SpriteType.Corner, Rotation.OneEighty, 1, 0);
			orient4 = new Orientation(SpriteType.Corner, Rotation.Ninety, 0, 0);
		}

		if (randSprite == 2) // for a L
		{
			orient1 = new Orientation(SpriteType.End, Rotation.Zero, 0, 2);
			orient2 = new Orientation(SpriteType.Middle, Rotation.Zero, 0, 1);
			orient3 = new Orientation(SpriteType.Corner, Rotation.Ninety, 0, 0);
			orient4 = new Orientation(SpriteType.End, Rotation.TwoSeventy, 1, 0);
		}

		if (randSprite == 3) // for a t
		{
			orient1 = new Orientation(SpriteType.End, Rotation.Zero, 0, 2);
			orient2 = new Orientation(SpriteType.Edge, Rotation.Zero, 0, 1);
			orient3 = new Orientation(SpriteType.End, Rotation.OneEighty, 0, 0);
			orient4 = new Orientation(SpriteType.End, Rotation.TwoSeventy, 1, 1);
		}

		if (randSprite == 4) // for a |
		{
			orient1 = new Orientation(SpriteType.End, Rotation.Zero, 0, 3);
			orient2 = new Orientation(SpriteType.Middle, Rotation.Zero, 0, 2);
			orient3 = new Orientation(SpriteType.Middle, Rotation.Zero, 0, 1);
			orient4 = new Orientation(SpriteType.End, Rotation.OneEighty, 0, 0);
		}

		if (randSprite == 5) // for a z
		{
			orient1 = new Orientation(SpriteType.End, Rotation.Ninety, 0, 1);
			orient2 = new Orientation(SpriteType.Corner, Rotation.TwoSeventy, 1, 1);
			orient3 = new Orientation(SpriteType.Corner, Rotation.Ninety, 1, 0);
			orient4 = new Orientation(SpriteType.End, Rotation.TwoSeventy, 2, 0);
		}

		Shape = new ArrayList<Orientation>(Arrays.asList(orient1, orient2, orient3, orient4));
	}

	public void draw(SpriteBatch batch)
	{
		orient1.draw(batch);
		orient2.draw(batch);
		orient3.draw(batch);
		orient4.draw(batch);
	}

	public boolean update(float time)
	{
		float speed = 100; // how far is next square away
		float velocityX = ((Gdx.input.isKeyPressed(Keys.RIGHT)) ? 1 : 0) * speed - ((Gdx.input.isKeyPressed(Keys.LEFT)) ? 1 : 0) * speed;
		float velocityY = ((Gdx.input.isKeyPressed(Keys.UP)) ? 1 : 0) * speed - ((Gdx.input.isKeyPressed(Keys.DOWN)) ? 1 : 0) * speed;

		if (time > .15)
		{
			boolean inBounds = true;
			for (Orientation orient : Shape)
			{
				if (orient.getPositionX() + velocityX < 1000 && orient.getPositionX() + velocityX >= 0 && orient.getPositionY() + velocityY < 1000 && orient.getPositionY() + velocityY >= 0)
				{
					inBounds = true;
				}
				else
				{
					inBounds = false;
					break;
				}

			}

			if (inBounds == true)
			{
				for (Orientation orient : Shape)
				{
					orient.increment(velocityX, velocityY);
				}
			}

			// Sets the limits of what the position can be by using the boundary
			// conditions.
			// position1.x = Math.max(Math.min(position1.x, 800), 0);
			// position1.y = Math.max(Math.min(position1.y, 800), 0);

			if (velocityX != 0 || velocityY != 0)
				return true;
		}
		return false;
	}

	public boolean insideCursor(Block block)
	{
		if (orient1.getRectangle().overlaps(block.getRectangle()) || orient2.getRectangle().overlaps(block.getRectangle()) || orient3.getRectangle().overlaps(block.getRectangle()) || orient4.getRectangle().overlaps(block.getRectangle()))
		{
			// dropSound.play();
			return false;
		}
		return true;
	}
}
