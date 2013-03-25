package com.Turntris;


public class LineShape extends Shape
{

	public int[][] shapeArray =
	{
	{ 1, 0, 0, 0 },
	{ 1, 0, 0, 0 },
	{ 1, 0, 0, 0 },
	{ 1, 0, 0, 0 } };

	public LineShape()
	{
		setup(shapeArray);

		// orient0 = new Orientation(SpriteType.End, Rotation.OneEighty, 0, 0,
		// 0);
		// orient1 = new Orientation(SpriteType.Middle, Rotation.Zero, 0, 1, 1);
		// orient2 = new Orientation(SpriteType.Middle, Rotation.Zero, 0, 2, 2);
		// orient3 = new Orientation(SpriteType.End, Rotation.Zero, 0, 3, 3);
		// Orients = new ArrayList<Orientation>(Arrays.asList(orient0, orient1,
		// orient2, orient3));
	}
}
