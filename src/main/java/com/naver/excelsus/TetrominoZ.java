package com.naver.excelsus;

public class TetrominoZ extends Tetromino {
	private static final int[][][] shape = {
		{
			{5, 5, 0},
			{0, 5, 5},
			{0, 0, 0}
		},
		{
			{0, 0, 5},
			{0, 5, 5},
			{0, 5, 0}
		}
	};

	public TetrominoZ(int x, int y) {
		super(x, y, shape);
	}
}
