package com.Turntris;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Cursor
{

	private static Texture SpriteSheet;
	// private static Sprite sprite;
	private Rectangle position1 = new Rectangle();
	private Rectangle position2 = new Rectangle();
	private Rectangle position3 = new Rectangle();
	private Rectangle position4 = new Rectangle();
	private int randSprite = 0;
	private Orientation orient1;
	private Orientation orient2;
	private Orientation orient3;
	private Orientation orient4;

	// private Color color;

	public Cursor()
	{

		// randSprite = MathUtils.random(1, 5);
		//
		if (SpriteSheet == null)
		{
			SpriteSheet = new Texture(Gdx.files.internal("assets/TurntrisSprites.png"));
			// sprite = new Sprite(SpriteSheet, 300, 1, 98, 98); this is for the
			// white outlined square as first attempt

		}
		//
		// if (randSprite == 1) // for a Square
		// {
		orient1 = new Orientation(SpriteType.Corner, Rotation.Zero, 0, 1);
		orient2 = new Orientation(SpriteType.Corner, Rotation.Ninety, 1, 1);
		orient3 = new Orientation(SpriteType.Corner, Rotation.OneEighty, 1, 0);
		orient4 = new Orientation(SpriteType.Corner, Rotation.TwoSeventy, 0, 0);

		// sprite = new Sprite(SpriteSheet, 400, 0, 200, 200);
		// position1.x = position3.x = 500;
		// position1.y = position2.y = 500;
		// position2.x = position4.x = position1.x + 100;
		// position3.y = position4.y = position1.y + 100;
		//
		// }
		//
		// if (randSprite == 2)
		// {
		// sprite = new Sprite(SpriteSheet, 0, 100, 197, 300);
		// position1.x = 500;
		// position2.x = position3.x = position1.x;
		// position1.y = 500;
		// position2.y = position4.y = position1.y + 100;
		// position3.y = position2.y + 100;
		// position4.x = position1.x + 100;
		//
		// }
		//
		// if (randSprite == 3)
		// {
		// sprite = new Sprite(SpriteSheet, 200, 100, 200, 300);
		// position1.x = 500;
		// position2.x = position3.x = position1.x;
		// position1.y = 400;
		// position4.y = position1.y;
		// position2.y = position1.y + 100;
		// position3.y = position2.y + 100;
		// position4.x = position1.x + 100;
		//
		// }
		//
		// if (randSprite == 4)
		// {
		// sprite = new Sprite(SpriteSheet, 600, 0, 300, 200);
		// position1.x = 500;
		// position2.x = position3.x = position1.x + 100;
		// position1.y = 500;
		// position2.y = position1.y;
		// position3.y = position4.y = position1.y - 100;
		// position4.x = position1.x + 200;
		//
		// }
		//
		// if (randSprite == 5)
		// {
		// sprite = new Sprite(SpriteSheet, 900, 0, 100, 400);
		// position1.x = 500;
		// position4.x = position2.x = position3.x = position1.x;
		// position1.y = 300;
		// position2.y = position1.y + 100;
		// position3.y = position2.y + 100;
		// position4.y = position3.y + 100;
		//
		// }
		//
		// position1.width = position2.width = position3.width = position4.width
		// = 99;
		// position1.height = position2.height = position3.height =
		// position4.height = 99;

	}

	public void draw(SpriteBatch batch)
	{
		orient1.draw(batch);
		orient2.draw(batch);
		orient3.draw(batch);
		orient4.draw(batch);
	}

	public float getPositionX()
	{
		return position1.x;
	}

	public float getPositionY()
	{
		return position1.y;
	}

	public void setPositionX(float x)
	{
		position1.x = x;
	}

	public void setPositionY(float y)
	{
		position1.y = y;
	}

	public boolean update(float time)
	{
		float speed = 100;
		float velocityX = ((Gdx.input.isKeyPressed(Keys.RIGHT)) ? 1 : 0) * speed - ((Gdx.input.isKeyPressed(Keys.LEFT)) ? 1 : 0) * speed;
		float velocityY = ((Gdx.input.isKeyPressed(Keys.UP)) ? 1 : 0) * speed - ((Gdx.input.isKeyPressed(Keys.DOWN)) ? 1 : 0) * speed;

		if (time > .15)
		{
			position1.x += velocityX;
			position1.y += velocityY;

			// Sets the limits of what the position can be by using the boundary
			// conditions.
			position1.x = Math.max(Math.min(position1.x, 800), 0);
			position1.y = Math.max(Math.min(position1.y, 800), 0);

			if (randSprite == 1)
			{

				position3.x = position1.x;
				position2.y = position1.y;
				position2.x = position4.x = position1.x + 100;
				position3.y = position4.y = position1.y + 100;

			}

			if (randSprite == 2)
			{
				position2.x = position3.x = position1.x;
				position2.y = position4.y = position1.y + 100;
				position3.y = position2.y + 100;
				position4.x = position1.x + 100;
			}

			if (randSprite == 3)
			{
				position2.x = position3.x = position1.x;
				position4.y = position1.y;
				position2.y = position1.y + 100;
				position3.y = position2.y + 100;
				position4.x = position1.x + 100;

			}

			if (randSprite == 4)
			{
				position2.x = position3.x = position1.x + 100;
				position2.y = position1.y;
				position3.y = position4.y = position1.y - 100;
				position4.x = position1.x + 200;

			}

			if (randSprite == 5)
			{
				position4.x = position2.x = position3.x = position1.x;
				position2.y = position1.y + 100;
				position3.y = position2.y + 100;
				position4.y = position3.y + 100;

			}

			if (velocityX != 0 || velocityY != 0)
				return true;
		}
		return false;
	}

	public boolean insideCursor(Block block)
	{
		if (position1.overlaps(block.getRectangle()) || position2.overlaps(block.getRectangle()) || position3.overlaps(block.getRectangle()) || position4.overlaps(block.getRectangle()))
		{
			// dropSound.play();
			return false;
		}
		return true;
	}
}
