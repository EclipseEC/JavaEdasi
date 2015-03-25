package ee.itcollege.snake.parts;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;

import ee.itcollege.snake.lib.IDrawable;
import ee.itcollege.snake.lib.RandomColor;

@SuppressWarnings("serial")
public class SnakePart implements IDrawable {

    int x;
    int y;
    int size = 10;
    Color color = new RandomColor();
    
    public SnakePart(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    
    @Override
	public void drawItself(Graphics2D g) {
        g.setColor(color);
	    g.fill(getCollisionArea());
    }

	@Override
	public Area getCollisionArea() {
		return new Area(new Rectangle(x, y, size, size));
	}

}



