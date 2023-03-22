package com.naver.excelsus;

public class TetrominoJ extends Tetromino {
	private static final int[][][] shape = {
		{
			{0, 6, 0},
			{0, 6, 0},
			{6, 6, 0}
		},
		{
			{6, 0, 0},
			{6, 6, 6},
			{0, 0, 0}
		},
		{
			{0, 6, 6},
			{0, 6, 0},
			{0, 6, 0}
		},
		{
			{0, 0, 0},
			{6, 6, 6},
			{0, 0, 6}
		}
	};

	public TetrominoJ(int x, int y) {
		super(x, y, shape);
	}
}
