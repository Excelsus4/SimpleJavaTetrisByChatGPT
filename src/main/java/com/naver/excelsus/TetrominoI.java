package com.naver.excelsus;

public class TetrominoI extends Tetromino {
	private static final int[][][] shape = {
		{
			{0, 0, 0, 0},
			{1, 1, 1, 1},
			{0, 0, 0, 0},
			{0, 0, 0, 0}
		},
		{
			{0, 0, 1, 0},
			{0, 0, 1, 0},
			{0, 0, 1, 0},
			{0, 0, 1, 0}
		}
	};

	public TetrominoI(int x, int y) {
		super(x, y, shape);
	}
}