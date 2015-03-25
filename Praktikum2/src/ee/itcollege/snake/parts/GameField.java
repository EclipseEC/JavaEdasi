package ee.itcollege.snake.parts;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JApplet;

import ee.itcollege.snake.level.Level1Field;
import ee.itcollege.snake.lib.CollisionDetector;

/**
 * Applet for drawing gamefield
 */
@SuppressWarnings("serial")
public class GameField extends JApplet {

	private Snake snake = new Snake();
	private Image buffer;
	private ArrayList<Apple> apples = new ArrayList<Apple>();
	private Level1Field field = new Level1Field(this);

	private Image getBuffer() {
		if (null == buffer
				|| buffer.getWidth(null) != getWidth()
				|| buffer.getHeight(null) != getHeight()) {
			// if there is no buffer object, create a new Image
			buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
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
		field.drawItself(g2);

		snake.drawItself(g2);
		for (Apple apple : apples) {
        	apple.drawItself(g2);
        }
        
        g.drawImage(buffer, 0, 0, null);
	}

	public Snake getSnake() {
		return snake;
	}

	public void checkCollisions() {
		if (CollisionDetector.collide(snake.getHead(), field)) {
			System.exit(0);
		}
		
		if (snake.collideWithItself()) {
			System.exit(0);
		}
		
		for (int i = 0; i < apples.size(); i++) {
			if (CollisionDetector.collide(
					snake.getHead(), apples.get(i))) {
				snake.eat(apples.remove(i));
			}
		}
		
		if (apples.size() < 5) {
        	apples.add(new Apple(this));
        }
	}
}
