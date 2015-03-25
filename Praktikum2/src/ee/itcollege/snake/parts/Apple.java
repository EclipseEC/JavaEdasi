package ee.itcollege.snake.parts;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import ee.itcollege.snake.lib.IDrawable;

public class Apple implements IDrawable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int APPLE_SIZE  = 20;
	int x;
	int y;
	
	public Apple(GameField field) {
		x = (int) ((field.getWidth() - APPLE_SIZE) * Math.random());
		y = (int) ((field.getHeight() - APPLE_SIZE) * Math.random());
	}

	@Override
	public Area getArea() {
		return new Area(new Ellipse2D.Double(x, y, APPLE_SIZE, APPLE_SIZE));
	}

	@Override
	public void drawItself(Graphics2D g) {
		g.setColor(Color.red);
		g.fill(getArea());
	}

}
