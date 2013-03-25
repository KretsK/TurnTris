package com.Turntris;

import java.util.ArrayList;
import java.util.Arrays;

public class Zshape extends Shape
{
	public Zshape()
	{
		orient0 = new Orientation(SpriteType.Corner, Rotation.Ninety, 1, 0, 0);
		orient1 = new Orientation(SpriteType.End, Rotation.TwoSeventy, 2, 0, 1);
		orient2 = new Orientation(SpriteType.End, Rotation.Ninety, 0, 1, 2);
		orient3 = new Orientation(SpriteType.Corner, Rotation.TwoSeventy, 1, 1, 3);
		Orients = new ArrayList<Orientation>(Arrays.asList(orient0, orient1, orient2, orient3));
	}
}
