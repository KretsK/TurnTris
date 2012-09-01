package com.Turntris;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Block {
	
	private static Texture SpriteSheet; 
    private static Sprite sprite;
    private Rectangle position = new Rectangle();
	private Color color;
	
	
	public Block()
	{
		if(SpriteSheet==null)
		{
			SpriteSheet = new Texture(Gdx.files.internal("assets/TurntrisSprites.png"));
	    	sprite = new Sprite(SpriteSheet, 0, 1,98,98);
		}
		
		position.width = 100;
		position.height = 100;
		color = new Color(MathUtils.random(5,10)/10f,MathUtils.random(5,10)/10f,MathUtils.random(7,10)/10f,1);
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
		position.x=x;
	}
	
	public void setPositionY(float y)
	{
		position.y=y;
	}
}
