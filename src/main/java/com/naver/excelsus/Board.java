package com.naver.excelsus;

public class Board {
	private final int width;
	private final int height;
	private final int[][] grid;

	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		this.grid = new int[height][width];
	}

	public boolean isValidMove(Tetromino tetromino, int newX, int newY) {
		int[][] shape = tetromino.getCurrentShape();

		for (int row = 0; row < shape.length; row++) {
			for (int col = 0; col < shape[0].length; col++) {
				if (shape[row][col] != 0) {
					int boardX = newX + col;
					int boardY = newY + row;

					if (boardX < 0 || boardX >= width || boardY < 0 || boardY >= height || grid[boardY][boardX] != 0) {
						return false;
					}
				}
			}
		}

		return true;
	}

	public void mergeTetromino(Tetromino tetromino) {
		int[][] shape = tetromino.getCurrentShape();

		for (int row = 0; row < shape.length; row++) {
			for (int col = 0; col < shape[0].length; col++) {
				if (shape[row][col] != 0) {
					int boardX = tetromino.getX() + col;
					int boardY = tetromino.getY() + row;

					grid[boardY][boardX] = shape[row][col];
				}
			}
		}
	}

	public int clearLines() {
		int linesCleared = 0;

		for (int row = 0; row < height; row++) {
			boolean fullLine = true;

			for (int col = 0; col < width; col++) {
				if (grid[row][col] == 0) {
					fullLine = false;
					break;
				}
			}

			if (fullLine) {
				linesCleared++;
				for (int newRow = row; newRow > 0; newRow--) {
					grid[newRow] = grid[newRow - 1];
				}

				grid[0] = new int[width];
			}
		}

		return linesCleared;
	}

	public int[][] getGrid() {
		return grid;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}