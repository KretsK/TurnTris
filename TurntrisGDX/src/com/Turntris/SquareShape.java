package com.Turntris;

public class SquareShape extends Shape
{

	public int[][] shapeArray =
	{
	{ 0, 0, 0, 0 },
	{ 0, 0, 0, 0 },
	{ 1, 1, 0, 0 },
	{ 1, 1, 0, 0 } };

	public SquareShape()
	{
		setup(shapeArray);

		// orient0 = new Orientation(SpriteType.Corner, Rotation.Ninety, 0, 0,
		// 0);
		// orient1 = new Orientation(SpriteType.Corner, Rotation.OneEighty, 1,
		// 0, 1);
		// orient3 = new Orientation(SpriteType.Corner, Rotation.Zero, 0, 1, 3);
		// orient2 = new Orientation(SpriteType.Corner, Rotation.TwoSeventy, 1,
		// 1, 2);
		// Orients = new ArrayList<Orientation>(Arrays.asList(orient0, orient1,
		// orient2, orient3));
	}
}
