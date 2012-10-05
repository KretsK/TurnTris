package com.Turntris;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Block
{

	private static Texture SpriteSheet;
	private static Sprite sprite;
	private Rectangle position = new Rectangle();
	private Color purple = new Color(.8f, .5f, 1f, 1);
	private Color blue = new Color(.2f, .5f, 1f, 1);
	private Color green = new Color(.3f, 1f, .3f, 1);
	private Color yellow = new Color(1f, 1f, .1f, 1);
	private Color color;

	public Block()
	{
		if (SpriteSheet == null)
		{
			SpriteSheet = new Texture(Gdx.files.internal("assets/TurntrisSprites.png"));
			sprite = new Sprite(SpriteSheet, 0, 1, 99, 99);
		}

		position.width = 99;
		position.height = 99;
		color = randomSetColor();
	}

	public void draw(SpriteBatch batch)
	{
		sprite.setPosition(position.x, position.y);
		sprite.setColor(color);
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
	public void setPosition(float x, float y)
	{
		position.x=x;
		position.y=y;
	}

	public Rectangle getRectangle()
	{
		return position;
	}

	public Color randomSetColor()
	{
		int rand = MathUtils.random(1, 4);

		if (rand == 1)
			return purple;
		if (rand == 2)
			return blue;
		if (rand == 3)
			return green;
		if (rand == 4)
			return yellow;

		return purple;

	}

	public Color getColor()
	{
		return color;
	}
}
