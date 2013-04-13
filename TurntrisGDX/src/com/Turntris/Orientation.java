package com.Turntris;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Orientation
{
	public int X;
	public int Y;
	public Rotation rotation;
	private Sprite sprite;
	public int Index;

	private Rectangle position = new Rectangle();

	public Orientation(SpriteType spritetype, Rotation angle, int x, int y, int index)
	{
		X = x;
		Y = y;
		rotation = angle;
		sprite = spritetype.getSprite();
		sprite.setRotation(rotation.Degrees);

		position.x = X * 100;
		position.y = Y * 100;

		position.width = 99;
		position.height = 99;
		Index = index;

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

	// public void setPositionX(float x)
	// {
	// position.x = x;
	// }
	//
	// public void setPositionY(float y)
	// {
	// position.y = y;
	// }

	public Rectangle getRectangle()
	{
		return position;
	}

	// public void setPosition(float x, float y)
	// {
	// position.x = x;
	// position.y = y;
	// }

	public void increment(float x, float y)
	{
		position.x += x;
		position.y += y;
	}

	public void setSprite(SpriteType spritetype)
	{
		sprite = spritetype.getSprite();
	}

	public void setRotation(Rotation angle)
	{
		rotation = angle;
		sprite.setRotation(rotation.Degrees);

	}

}
