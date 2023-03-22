package com.naver.excelsus;

public class TetrominoT extends Tetromino {
	private static final int[][][] shape = {
		{
			{0, 3, 0},
			{3, 3, 3},
			{0, 0, 0}
		},
		{
			{0, 3, 0},
			{0, 3, 3},
			{0, 3, 0}
		},
		{
			{0, 0, 0},
			{3, 3, 3},
			{0, 3, 0}
		},
		{
			{0, 3, 0},
			{3, 3, 0},
			{0, 3, 0}
		}
	};

	public TetrominoT(int x, int y) {
		super(x, y, shape);
	}
}
