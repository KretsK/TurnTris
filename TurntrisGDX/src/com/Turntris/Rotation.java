package com.Turntris;

public enum Rotation
{
	Zero(0), Ninety(90), OneEighty(180), TwoSeventy(270);
	public final float Degrees;

	private Rotation(float degrees)
	{
		Degrees = degrees;
	}
}
