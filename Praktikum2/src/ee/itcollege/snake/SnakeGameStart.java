package ee.itcollege.snake;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import ee.itcollege.snake.lib.Direction;
import ee.itcollege.snake.parts.GameField;
import ee.itcollege.snake.parts.Snake;

public class SnakeGameStart implements Runnable {

	GameField game = new GameField();
	JFrame window = new JFrame("Uss!!");

	@Override
	public void run() {
		window.setSize(500, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new BorderLayout());
		window.add(game);
		window.setVisible(true);
		
		Timer timer = new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Snake snake = game.getSnake();
				snake.move();
				game.checkCollisions();
				game.repaint();
			}
		}); 
		timer.start();

		window.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Snake snake = game.getSnake();
				Direction direction = null;
				switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					direction = Direction.RIGHT;
					break;
				case KeyEvent.VK_LEFT:
					direction = Direction.LEFT;
					break;
				case KeyEvent.VK_DOWN:
					direction = Direction.DOWN;
					break;
				case KeyEvent.VK_UP:
					direction = Direction.UP;
					break;
				case KeyEvent.VK_ESCAPE:
					System.exit(0);
					break;
				case KeyEvent.VK_S:/*
					ObjectOutputStream saver = new ObjectOutputStream(
							new FileOutputStream(new File("gamedata.dat")));
						saver.writeObject(obj);*/
				}
				if (null != direction) {
					snake.setDirection(direction);
				}
			}
		});

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new SnakeGameStart());
	}
}
