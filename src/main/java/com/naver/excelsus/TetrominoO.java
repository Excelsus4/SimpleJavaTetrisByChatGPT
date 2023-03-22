package com.naver.excelsus;

public class TetrominoO extends Tetromino {
	private static final int[][][] shape = {
		{
			{2, 2},
			{2, 2}
		}
	};

	public TetrominoO(int x, int y) {
		super(x, y, shape);
	}
}
