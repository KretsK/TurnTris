package com.Turntris;

import java.util.ArrayList;

import sps.core.Logger;

import com.Utils.RotateArray;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Shape
{

	protected ArrayList<Orientation> Orients;
	private int[][] shapeArrayCache;

	public Shape()
	{

		// shape should be sorted based on orientation index, not the variable
		// name.
		// Orients = new ArrayList<Orientation>(Arrays.asList(orient0, orient1,
		// orient2, orient3));
	}

	protected void setup(int[][] shapeArray)
	{
		Orients = new ArrayList<Orientation>();

		for (int ii = 0; ii < shapeArray.length; ii++)
		{
			for (int jj = 0; jj < shapeArray[ii].length; jj++)
			{
				if (shapeArray[shapeArray.length - 1 - ii][jj] == 1)
				{
					Orients.add(new Orientation(SpriteType.Corner, Rotation.Ninety, jj, ii, 0));
					Logger.info(jj + "," + ii);
				}
			}
		}

		shapeArrayCache = shapeArray;

		for (Orientation orient : Orients)
		{
			int row = orient.X;
			int col = orient.Y;

			int bIndex = 0;
			if (col - 1 >= 0 && shapeArrayCache[shapeArrayCache.length - 1 - row][col - 1] == 1)
			{
				bIndex += 1;
			}
			if (shapeArrayCache.length - 1 - row - 1 >= 0 && shapeArrayCache[shapeArrayCache.length - 1 - row - 1][col] == 1)
			{
				bIndex += 2;
			}
			// System.out.println("col# " + col);
			// System.out.println("col+1Value  " + shapeArrayCache[row][col +
			// 1]);
			if (col + 1 < shapeArrayCache.length && shapeArrayCache[shapeArrayCache.length - 1 - row][col + 1] == 1)
			{
				bIndex += 4;
				// System.out.println(shapeArrayCache[row][col]);
			}
			if (shapeArrayCache.length - 1 - row + 1 < shapeArrayCache.length && shapeArrayCache[shapeArrayCache.length - 1 - row + 1][col] == 1)
			{
				bIndex += 8;
			}
			NeighborDetector neigh = NeighborDetector.determine(bIndex);

			orient.setSprite(neigh.Frame);
			orient.setRotation(neigh.RotationAngle);
			System.out.println("bindex " + bIndex);
		}

	}

	public void draw(SpriteBatch batch)
	{
		for (Orientation orient : Orients)
		{
			orient.draw(batch);
		}

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

	public void rotateShape()
	{
		if (shapeArrayCache != null)
		{
			RotateArray.clockwiseSquareInPlace(shapeArrayCache);
			setup(shapeArrayCache);
		}
	}

}
