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
			sprite = new Sprite(SpriteSheet, 300, 1, 98, 98);
		}
		position.x = 500;
		position.y = 500;
		position.width = 100;
		position.height = 100;
		// color = new
		// Color(MathUtils.random(5,10)/10f,MathUtils.random(5,10)/10f,MathUtils.random(5,10)/10f,1);

	}

	public void draw(SpriteBatch batch)
	{
		sprite.setPosition(position.x, position.y);
		// sprite.setColor(color);
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
			position.x = Math.max(Math.min(position.x, 900), 0);
			position.y = Math.max(Math.min(position.y, 900), 0);

			if (velocityX != 0 || velocityY != 0)
				return true;
		}
		return false;
	}
}
