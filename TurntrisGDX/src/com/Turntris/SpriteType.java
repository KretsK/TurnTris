package com.Turntris;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public enum SpriteType
{
	End(0), Middle(400), Corner(200), Edge(600);
	private int Xaxis;
	private static Texture SpriteSheet;

	private SpriteType(int xaxis)
	{
		Xaxis = xaxis;
	}

	public Sprite getSprite()
	{
		if (SpriteSheet == null)
		{
			SpriteSheet = new Texture(Gdx.files.internal("assets/TurntrisSprites.png"));
		}

		return new Sprite(SpriteSheet, Xaxis, 500, 100, 100);
	}
}
