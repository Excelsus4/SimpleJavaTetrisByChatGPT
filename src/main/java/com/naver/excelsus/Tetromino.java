package com.naver.excelsus;

public abstract class Tetromino implements Cloneable {
	protected int x, y; // The current position of the tetromino
	protected int rotation; // The current rotation state of the tetromino
	protected int[][][] shape; // The shape of the tetromino in its different rotation states

	public Tetromino(int x, int y, int[][][] shape) {
		this.x = x;
		this.y = y;
		this.rotation = 0;
		this.shape = shape;
	}

	public void moveLeft() {
		x--;
	}

	public void moveRight() {
		x++;
	}

	public void moveDown() {
		y++;
	}

	public void rotateClockwise() {
		rotation = (rotation + 1) % shape.length;
	}

	public void rotateCounterClockwise() {
		rotation = (rotation - 1 + shape.length) % shape.length;
	}

	public int[][] getCurrentShape() {
		return shape[rotation];
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	@Override
	public Tetromino clone() {
		try {
			return (Tetromino) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError("Cloning not supported for Tetromino", e);
		}
	}
}