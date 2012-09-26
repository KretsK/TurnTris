package com.Turntris;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Orientation
{
	public int X;
	public int Y;
	public Rotation Rotation;
	private Sprite sprite;

	// private Rectangle position = new Rectangle();

	public Orientation(SpriteType spritetype, Rotation rotation, int x, int y)
	{
		X = x;
		Y = y;
		Rotation = rotation;
		sprite = spritetype.getSprite();
		// sprite.rotate(Rotation.Degrees);
	}

	public void draw(SpriteBatch batch)
	{
		sprite.setPosition(X * 100, Y * 100);

		sprite.draw(batch);
	}
}
