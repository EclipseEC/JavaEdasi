package ee.itcollege.snake.parts;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JApplet;

/**
 * Applet for drawing gamefield
 */
@SuppressWarnings("serial")
public class GameField extends JApplet {

	private Snake snake = new Snake();
	private Apple apple = new Apple();
	private Image buffer;

	private Image getBuffer() {
		if (null == buffer) {
			// if there is no buffer object, create a new Image
			buffer = new BufferedImage(getWidth(), getHeight(),
					BufferedImage.TYPE_INT_ARGB);
		}
		// fill the image with white
		Graphics g = buffer.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());

		return buffer;
	}

	@Override
	public void init() {
		System.err.println("Please run the SnakeGameStart");
		System.exit(0);
	}

	@Override
	public void paint(Graphics g) {
		Image buffer = getBuffer();
		Graphics2D g2 = (Graphics2D) buffer.getGraphics();

		snake.drawItself(g2);
		apple.drawItself(g2);

		g.drawImage(buffer, 0, 0, null);
	}

	public Snake getSnake() {
		return snake;
	}
}
