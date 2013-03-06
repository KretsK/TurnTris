package com.Turntris.test;

import sps.core.Logger;

import com.Utils.RotateArray;

public class TurntrisTests
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		TurntrisTests tests = new TurntrisTests();
		tests.runAll();
	}

	private TurntrisTests()
	{

	}

	public void runAll()
	{
		Logger.info("Starting to run tests.");
		testArrayRotate();
		testArrayRotateInPlace();
		Logger.info("Tests have passed");
	}

	public void testArrayRotate()
	{
		int[][] input =
		{
		{ 1, 2 },
		{ 3, 4 } };

		int[][] expectedOutput =
		{
		{ 3, 1 },
		{ 2, 4 } };

		int[][] output = RotateArray.clockwise(input);

		assert (areEqual(output, expectedOutput));
	}

	public void testArrayRotateInPlace()
	{
		int[][] input =
		{
		{ 1, 2 },
		{ 3, 4 } };

		int[][] expectedOutput =
		{
		{ 3, 1 },
		{ 2, 4 } };

		RotateArray.clockwiseSquareInPlace(input);

		assert (areEqual(input, expectedOutput));
	}

	private boolean areEqual(int[][] a, int[][] b)
	{
		for (int ii = 0; ii < a.length; ii++)
		{
			for (int jj = 0; jj < a[0].length; jj++)
			{
				if (a[ii][jj] != b[ii][jj])
				{
					return false;
				}
			}
		}
		return true;
	}
}
