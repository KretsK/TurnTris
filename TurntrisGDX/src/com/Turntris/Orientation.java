package com.Turntris;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

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

	public void draw(SpriteBatch batch, Vector2 shapeposition)
	{
		// sprite.setPosition(position.x + (shapeposition.x * 100), position.y
		// +(shapeposition.y * 100));// //add
		sprite.setPosition((X + shapeposition.x) * 100, (Y + shapeposition.y) * 100);// //add

		// shape
		// position
		// variable to these values
		sprite.draw(batch);
		// position.x = X + shapeposition.x;
		// position.y = Y + shapeposition.y;
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
