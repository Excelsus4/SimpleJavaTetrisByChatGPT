package com.naver.excelsus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
	private static final int BOARD_WIDTH = 10;
	private static final int BOARD_HEIGHT = 20;
	private static final int BLOCK_SIZE = 30;
	private static final int TIMER_DELAY = 500;

	private Board board;
	private Tetromino currentTetromino;
	private Timer timer;

	public GameWindow() {
		setTitle("Tetris");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);

		board = new Board(BOARD_WIDTH, BOARD_HEIGHT);
		currentTetromino = TetrominoFactory.createRandomTetromino(BOARD_WIDTH / 2 - 1, 0);

		JPanel gamePanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				drawBoard(g);
				drawTetromino(g, currentTetromino);
			}
		};
		gamePanel.setPreferredSize(new Dimension(BOARD_WIDTH * BLOCK_SIZE, BOARD_HEIGHT * BLOCK_SIZE));
		add(gamePanel);

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				handleKeyPress(e);
			}
		});

		timer = new Timer(TIMER_DELAY, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleTimerEvent();
			}
		});
		timer.start();

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void drawBoard(Graphics g) {
		int[][] grid = board.getGrid();

		for (int row = 0; row < BOARD_HEIGHT; row++) {
			for (int col = 0; col < BOARD_WIDTH; col++) {
				if (grid[row][col] != 0) {
					g.setColor(getColorForTetrominoType(grid[row][col]));
					g.fillRect(col * BLOCK_SIZE, row * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
				}
			}
		}
	}

	private void drawTetromino(Graphics g, Tetromino tetromino) {
		int[][] shape = tetromino.getCurrentShape();

		for (int row = 0; row < shape.length; row++) {
			for (int col = 0; col < shape[0].length; col++) {
				if (shape[row][col] != 0) {
					g.setColor(getColorForTetrominoType(shape[row][col]));
					g.fillRect((tetromino.getX() + col) * BLOCK_SIZE, (tetromino.getY() + row) * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
				}
			}
		}
	}

	private Color getColorForTetrominoType(int type) {
		// Use different colors for different tetromino types
		switch (type) {
			case 1:
				return Color.CYAN;
			case 2:
				return Color.YELLOW;
			case 3:
				return Color.MAGENTA;
			case 4:
				return Color.GREEN;
			case 5:
				return Color.RED;
			case 6:
				return Color.BLUE;
			case 7:
				return Color.ORANGE;
			default:
				return Color.GRAY;
		}
	}
	private void handleKeyPress(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT) {
			int newX = currentTetromino.getX() + (keyCode == KeyEvent.VK_LEFT ? -1 : 1);
			if (board.isValidMove(currentTetromino, newX, currentTetromino.getY())) {
				currentTetromino.setX(newX);
			}
		} else if (keyCode == KeyEvent.VK_DOWN) {
			int newY = currentTetromino.getY() + 1;
			if (board.isValidMove(currentTetromino, currentTetromino.getX(), newY)) {
				currentTetromino.setY(newY);
			} else {
				handleTetrominoLanding();
			}
		} else if (keyCode == KeyEvent.VK_UP) {
			currentTetromino.rotateClockwise();
			if (!board.isValidMove(currentTetromino, currentTetromino.getX(), currentTetromino.getY())) {
				currentTetromino.rotateCounterClockwise();
			}
		} else if (keyCode == KeyEvent.VK_SPACE) {
			while (board.isValidMove(currentTetromino, currentTetromino.getX(), currentTetromino.getY() + 1)) {
				currentTetromino.setY(currentTetromino.getY() + 1);
			}
			handleTetrominoLanding();
		}

		repaint();
	}

	private void handleTimerEvent() {
		int newY = currentTetromino.getY() + 1;
		if (board.isValidMove(currentTetromino, currentTetromino.getX(), newY)) {
			currentTetromino.setY(newY);
		} else {
			handleTetrominoLanding();
		}

		repaint();
	}

	private void handleTetrominoLanding() {
		board.mergeTetromino(currentTetromino);
		int linesCleared = board.clearLines();
		// You can update the score based on the linesCleared value here.
		currentTetromino = TetrominoFactory.createRandomTetromino(BOARD_WIDTH / 2 - 1, 0);

		// Check if the new Tetromino can be placed on the board. If not, the game is over.
		if (!board.isValidMove(currentTetromino, currentTetromino.getX(), currentTetromino.getY())) {
			timer.stop();
			// Handle game over logic here.
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GameWindow();
			}
		});
	}
}