package com.Turntris;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Raindrop
{

	private static Texture SpriteSheet;
	private static Sprite sprite;
	private static Sound dropSound;
	private Rectangle position = new Rectangle();
	private Color color;

	public Raindrop()
	{

		if (dropSound == null)
		{
			dropSound = Gdx.audio.newSound(Gdx.files.internal("assets/rainmusic 2.mp3"));
			SpriteSheet = new Texture(Gdx.files.internal("assets/TurntrisSprites.png"));
			sprite = new Sprite(SpriteSheet, 101, 1, 98, 98);
		}

		color = new Color(MathUtils.random(5, 10) / 10f, MathUtils.random(5, 10) / 10f, MathUtils.random(7, 10) / 10f, 1);
		position.x = MathUtils.random(0, 1000 - 48);
		position.y = 1000;
		position.width = 100;
		position.height = 100;

	}

	public void draw(SpriteBatch batch)
	{

		sprite.setPosition(position.x, position.y);
		sprite.setColor(color);
		sprite.draw(batch);

	}

	public boolean update(Rectangle bucket)
	{
		position.y -= 200 * Gdx.graphics.getDeltaTime();
		if (position.y + 48 < 0)
			return false;
		if (position.overlaps(bucket))
		{
			dropSound.play();
			return false;
		}
		return true;
	}

}
