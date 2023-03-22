package com.naver.excelsus;

public class TetrominoS extends Tetromino {
	private static final int[][][] shape = {
		{
			{0, 4, 4},
			{4, 4, 0},
			{0, 0, 0}
		},
		{
			{0, 4, 0},
			{0, 4, 4},
			{0, 0, 4}
		}
	};

	public TetrominoS(int x, int y) {
		super(x, y, shape);
	}
}
