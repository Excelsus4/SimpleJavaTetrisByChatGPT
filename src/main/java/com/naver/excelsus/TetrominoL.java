package com.naver.excelsus;

public class TetrominoL extends Tetromino {
	private static final int[][][] shape = {
		{
			{0, 7, 0},
			{0, 7, 0},
			{0, 7, 7}
		},
		{
			{0, 0, 0},
			{7, 7, 7},
			{7, 0, 0}
		},
		{
			{7, 7, 0},
			{0, 7, 0},
			{0, 7, 0}
		},
		{
			{0, 0, 7},
			{7, 7, 7},
			{0, 0, 0}
		}
	};

	public TetrominoL(int x, int y) {
		super(x, y, shape);
	}
}
