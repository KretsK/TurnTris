package com.Turntris;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Shape
{

	protected Orientation orient0;
	protected Orientation orient1;
	protected Orientation orient2;
	protected Orientation orient3;
	protected ArrayList<Orientation> Orients;

	public Shape()
	{
		// shape should be sorted based on orientation index, not the variable
		// name.
		// Orients = new ArrayList<Orientation>(Arrays.asList(orient0, orient1,
		// orient2, orient3));
	}

	public void draw(SpriteBatch batch)
	{
		orient0.draw(batch);
		orient1.draw(batch);
		orient2.draw(batch);
		orient3.draw(batch);

	}

	public void moveIfinBounds(float velocityX, float velocityY)
	{
		boolean inBounds = true;
		for (Orientation orient : Orients)
		{
			if (orient.getPositionX() + velocityX < 1000 && orient.getPositionX() + velocityX >= 0 && orient.getPositionY() + velocityY < 1000 && orient.getPositionY() + velocityY >= 0)
			{
				inBounds = true;
			}
			else
			{
				return;
			}

		}

		if (inBounds == true)
		{
			for (Orientation orient : Orients)
			{
				orient.increment(velocityX, velocityY);
			}
		}

	}

	public Orientation getOrient(int x)
	{
		for (Orientation orient : Orients)
		{
			if (orient.Index == x)
				return orient;
		}

		return null;
	}

	public Orientation insideShape(Block block)
	{

		for (Orientation orient : Orients)
		{
			if (orient.getRectangle().overlaps(block.getRectangle()))
			{
				// System.out.println(orient.Index);
				return orient;
			}
		}

		return null;
	}
}
