package com.Turntris;

public class Tshape extends Shape
{
	public int[][] shapeArray =
	{

	{ 0, 0, 0, 0, },
	{ 1, 0, 0, 0, },
	{ 1, 1, 0, 0, },
	{ 1, 0, 0, 0, } };

	public Tshape()
	{
		setup(shapeArray);

		// orient0 = new Orientation(SpriteType.End, Rotation.OneEighty, 0, 0,
		// 0);
		// orient1 = new Orientation(SpriteType.Edge, Rotation.Zero, 0, 1, 1);
		// orient2 = new Orientation(SpriteType.End, Rotation.TwoSeventy, 1, 1,
		// 2);
		// orient3 = new Orientation(SpriteType.End, Rotation.Zero, 0, 2, 3);
		// Orients = new ArrayList<Orientation>(Arrays.asList(orient0, orient1,
		// orient2, orient3));
	}
}
