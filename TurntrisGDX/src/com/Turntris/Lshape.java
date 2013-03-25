package com.Turntris;

import java.util.ArrayList;
import java.util.Arrays;

public class Lshape extends Shape
{
	public Lshape()
	{
		orient0 = new Orientation(SpriteType.Corner, Rotation.Ninety, 0, 0, 2);
		orient1 = new Orientation(SpriteType.End, Rotation.TwoSeventy, 1, 0, 3);
		orient2 = new Orientation(SpriteType.Middle, Rotation.Zero, 0, 1, 1);
		orient3 = new Orientation(SpriteType.End, Rotation.Zero, 0, 2, 0);
		Orients = new ArrayList<Orientation>(Arrays.asList(orient0, orient1, orient2, orient3));
	}
}
