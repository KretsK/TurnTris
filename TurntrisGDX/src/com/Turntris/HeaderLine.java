package com.Turntris;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class HeaderLine
{
	private static Texture SpriteSheet;
	private static Sprite sprite;
	private Rectangle position = new Rectangle();
	private Color color;

	public HeaderLine()
	{
		if (SpriteSheet == null)
		{
			SpriteSheet = new Texture(Gdx.files.internal("assets/TurntrisSprites.png"));
			sprite = new Sprite(SpriteSheet, 1, 5, 1, 1);
		}
		position.x = 0;
		position.y = 1000;
		position.width = 1;
		position.height = 1;
		color = Color.WHITE;
	}

	public void draw(SpriteBatch batch)
	{
		sprite.setPosition(position.x, position.y);
		sprite.setScale(5000, 2);
		sprite.setColor(color);
		sprite.draw(batch);
	}
}
