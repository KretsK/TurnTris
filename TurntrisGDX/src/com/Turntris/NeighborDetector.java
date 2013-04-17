package com.Turntris;

//Using this class requires 6 different sprites in this horizontal order:
//Direction is the side on which a neighbor exists
//None, Left, Up, LeftUp, LeftRight, and LeftUpRight, and All
public enum NeighborDetector
{
	None(0, SpriteType.Full, Rotation.Zero),
	Left(1, SpriteType.End, Rotation.TwoSeventy),
	Up(2, SpriteType.End, Rotation.OneEighty),
	LeftUp(3, SpriteType.Corner, Rotation.OneEighty),
	Right(4, SpriteType.End, Rotation.Ninety),
	LeftRight(5, SpriteType.Middle, Rotation.Ninety),
	UpRight(6, SpriteType.Corner, Rotation.Ninety),
	LeftUpRight(7, SpriteType.Edge, Rotation.Ninety),
	Down(8, SpriteType.End, Rotation.Zero),
	DownLeft(9, SpriteType.Corner, Rotation.TwoSeventy),
	DownUp(10, SpriteType.Middle, Rotation.Zero),
	DownLeftUp(11, SpriteType.Edge, Rotation.OneEighty),
	DownRight(12, SpriteType.Corner, Rotation.Zero),
	DownLeftRight(13, SpriteType.Edge, Rotation.TwoSeventy),
	DownUpRight(14, SpriteType.Edge, Rotation.Zero),
	DownLeftUpRight(15, SpriteType.None, Rotation.Zero);

	private int bitwiseIndex;
	public final SpriteType Frame;
	public final Rotation RotationAngle;

	private NeighborDetector(int bitwiseIndex, SpriteType frame, Rotation rotation)
	{
		this.bitwiseIndex = bitwiseIndex;
		Frame = frame;
		RotationAngle = rotation;
	}

	private static NeighborDetector[] edges = new NeighborDetector[16];

	public static NeighborDetector determine(int bIndex)
	{
		if (edges[0] == null)
		{
			for (NeighborDetector edge : values())
			{
				edges[edge.bitwiseIndex] = edge;
			}
		}

		return edges[bIndex];
	}
}
