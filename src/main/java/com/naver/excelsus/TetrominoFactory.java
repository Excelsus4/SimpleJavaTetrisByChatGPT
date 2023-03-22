package com.naver.excelsus;

import java.util.Random;

public class TetrominoFactory {
	private static final Random random = new Random();

	public static Tetromino createRandomTetromino(int x, int y) {
		int randomType = random.nextInt(7);

		switch (randomType) {
			case 0:
				return new TetrominoI(x, y);
			case 1:
				return new TetrominoO(x, y);
			case 2:
				return new TetrominoT(x, y);
			case 3:
				return new TetrominoS(x, y);
			case 4:
				return new TetrominoZ(x, y);
			case 5:
				return new TetrominoJ(x, y);
			case 6:
				return new TetrominoL(x, y);
			default:
				throw new IllegalStateException("Unexpected random value: " + randomType);
		}
	}
}
