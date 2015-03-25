package ee.itcollege.snake.parts;

import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.util.ArrayList;

import ee.itcollege.snake.lib.CollisionDetector;
import ee.itcollege.snake.lib.Direction;
import ee.itcollege.snake.lib.IDrawable;
import ee.itcollege.snake.lib.IEdible;

public class Snake implements IDrawable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArrayList<SnakePart> parts = new ArrayList<SnakePart>();

	private Direction direction = Direction.RIGHT;
	private Direction directionOrder = null;

	public Snake() {
		for (int i = 0; i < 10; i++) {
			SnakePart part = new SnakePart(100, 100 + i * 10);
			parts.add(part);
		}
	}
	
	@Override
	public Area getCollisionArea() {
		Area area = new Area();
		for (SnakePart part : parts) {
			area.add(part.getCollisionArea());
		}
		return area;
	}

	public void drawItself(Graphics2D g) {
		for (SnakePart part : parts) {
			part.drawItself(g);
		}
	}

	public void move() {
		if (directionOrder != null) {
			if (!direction.isOpposite(directionOrder)) {
				direction = directionOrder;
			}
			this.directionOrder = null;
		}
		// move all the parts but the head
		for (int i = parts.size() - 1; i >= 1; i--) {
			SnakePart part = parts.get(i);
			part.x = parts.get(i - 1).x;
			part.y = parts.get(i - 1).y;
		}

		// move the head
		SnakePart head = getHead();
		switch (direction) {
		case RIGHT:
			head.x += 10;
			break;
		case LEFT:
			head.x -= 10;
			break;
		case UP:
			head.y -= 10;
			break;
		case DOWN:
			head.y += 10;
			break;
		}
	}

	public SnakePart getHead() {
		return parts.get(0);
	}

	public Direction getDirection() {
		return direction;
	}

	public void eat(IEdible food) {
		for (int i = 0; i < food.getCalories(); i++) {
			parts.add(new SnakePart(-100, -100));
		}
	}

	public void setDirection(Direction direction) {
		if (this.directionOrder == null) {
			this.directionOrder = direction;
		}
	}

	public boolean collideWithItself() {
		SnakePart head = getHead();
		for (int i = 4; i < parts.size(); i++) {
			if (CollisionDetector.collide(head, parts.get(i))) {
				return true;
			}
		}
		return false;
	}

}
