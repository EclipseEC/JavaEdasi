package ee.itcollege.snake.level;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;

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
	public Area getArea() {
		Area area = new Area();
		area.add(new Area(new Rectangle(0, 0, 10, field.getHeight())));
		area.add(new Area(new Rectangle(0, 0, field.getWidth(), 10)));
		area.add(new Area(new Rectangle(0, field.getHeight() - 10, field.getWidth(), 10)));
		area.add(new Area(new Rectangle(field.getWidth() - 10, 0, 10, field.getHeight())));
		return area;
	}

	@Override
	public void drawItself(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
	
}
