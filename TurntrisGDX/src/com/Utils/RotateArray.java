package com.Utils;

//Taken from: http://stackoverflow.com/questions/42519/how-do-you-rotate-a-two-dimensional-array
public class RotateArray
{
	public static void clockwiseSquareInPlace(final int[][] arr)
	{
		int z = arr.length;
		for (int i = 0; i < z / 2; i++)
		{
			for (int j = 0; j < (z / 2 + z % 2); j++)
			{
				int x = i, y = j;
				int temp = arr[x][y];
				for (int k = 0; k < 4; k++)
				{
					int temptemp = arr[y][z - x - 1];
					arr[y][z - x - 1] = temp;
					temp = temptemp;

					int tempX = y;
					y = z - x - 1;
					x = tempX;
				}
			}
		}
	}

	public static int[][] clockwise(final int[][] arr)
	{
		int width = arr[0].length;
		int depth = arr.length;
		int[][] result = new int[width][depth];
		for (int i = 0; i < depth; i++)
		{
			for (int j = 0; j < width; j++)
			{
				result[j][depth - i - 1] = arr[i][j];
			}
		}
		return result;
	}
}
