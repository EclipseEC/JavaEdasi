package ee.itcollege.snake.level;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import ee.itcollege.snake.lib.IDrawable;
import ee.itcollege.snake.parts.GameField;

public class Level1Field implements IDrawable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GameField field;
	
	public Level1Field(GameField field) {
		this.field = field;
	}
	
	@Override
	public Area getCollisionArea() {
		Area area = new Area();
		// vasak
		area.add(new Area(
				new Rectangle(-490, 0, 500, field.getHeight())));
		
		// parem
		area.add(new Area(
				new Rectangle(field.getWidth() - 10, 0, 500, field.getHeight())));
		
		// üleval
		area.add(new Area(
				new Rectangle(0, -490, field.getWidth(), 500)));
		
		// all
		area.add(new Area(
				new Rectangle(0, field.getHeight() - 10, field.getWidth(), 500)));
		
		area.add(new Area(
				new Ellipse2D.Double(
						field.getWidth() / 2 - 100, 
						field.getHeight() / 2 - 100,
						200, 200)));
		return area;
	}

	@Override
	public void drawItself(Graphics2D g) {
	
		g.setColor(Color.green);
		g.fill(getCollisionArea());
	}
	
}
