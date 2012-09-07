package com.Turntris;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Cursor
{

	private static Texture SpriteSheet;
	private static Sprite sprite;
	private Rectangle position = new Rectangle();

	// private Color color;

	public Cursor()
	{
		if (SpriteSheet == null)
		{
			SpriteSheet = new Texture(Gdx.files.internal("assets/TurntrisSprites.png"));
			// sprite = new Sprite(SpriteSheet, 300, 1, 98, 98); this is for the
			// white outlined square as first attempt
			sprite = new Sprite(SpriteSheet, 400, 0, 200, 200);
		}
		position.x = 500;
		position.y = 500;
		position.width = 199; // set to 100 for 1 square cursor, but now I am
								// trying 4 square cursors.
		position.height = 199;
		// color = new
		// Color(MathUtils.random(5,10)/10f,MathUtils.random(5,10)/10f,MathUtils.random(5,10)/10f,1);
		// sprite.scale((float) 1);
	}

	public void draw(SpriteBatch batch)
	{
		sprite.setPosition(position.x, position.y);
		sprite.draw(batch);
	}

	public float getPositionX()
	{
		return position.x;
	}

	public float getPositionY()
	{
		return position.y;
	}

	public void setPositionX(float x)
	{
		position.x = x;
	}

	public void setPositionY(float y)
	{
		position.y = y;
	}

	public boolean update(float time)
	{
		float speed = 100;
		float velocityX = ((Gdx.input.isKeyPressed(Keys.RIGHT)) ? 1 : 0) * speed - ((Gdx.input.isKeyPressed(Keys.LEFT)) ? 1 : 0) * speed;
		float velocityY = ((Gdx.input.isKeyPressed(Keys.UP)) ? 1 : 0) * speed - ((Gdx.input.isKeyPressed(Keys.DOWN)) ? 1 : 0) * speed;

		if (time > .15)
		{
			position.x += velocityX;
			position.y += velocityY;

			// Sets the limits of what the position can be by using the boundary
			// conditions.
			position.x = Math.max(Math.min(position.x, 800), 0); // set to 900
																	// instead
																	// of 800
																	// for 2 by
																	// 2 cursor.
			position.y = Math.max(Math.min(position.y, 800), 0);

			if (velocityX != 0 || velocityY != 0)
				return true;
		}
		return false;
	}

	public boolean insideCursor(Block block)
	{
		if (position.overlaps(block.getRectangle()))
		{
			// dropSound.play();
			return false;
		}
		return true;
	}
}
