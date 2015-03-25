package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ee.itcollege.snake.lib.Direction;
import ee.itcollege.snake.parts.Snake;

public class SnakeTurningTest {
	private Snake snake;

	@Test(timeout = 1000)
	public void testOneTurn() {

		snake = new Snake();
		snake.setDirection(Direction.LEFT);
		assertEquals(Direction.RIGHT, snake.getDirection());

		snake = new Snake();
		snake.setDirection(null);
		snake.move();
		assertEquals(Direction.RIGHT, snake.getDirection());

		snake = new Snake();
		snake.setDirection(Direction.UP);
		assertEquals(Direction.RIGHT, snake.getDirection());

		snake = new Snake();
		snake.setDirection(Direction.UP);
		snake.move();
		assertEquals(Direction.UP, snake.getDirection());
	}

	@Test(timeout = 1000)
	public void testMultipleTurns() {

		snake = new Snake();
		snake.setDirection(Direction.UP);
		snake.setDirection(Direction.LEFT);
		assertEquals(Direction.RIGHT, snake.getDirection());

		snake = new Snake();
		snake.setDirection(Direction.UP);
		snake.move();
		snake.setDirection(Direction.LEFT);
		assertEquals(Direction.UP, snake.getDirection());

		snake = new Snake();
		snake.setDirection(Direction.UP);
		snake.move();
		snake.setDirection(Direction.LEFT);
		snake.move();
		assertEquals(Direction.LEFT, snake.getDirection());

		snake = new Snake();
		snake.setDirection(Direction.DOWN);
		snake.move();
		snake.setDirection(Direction.UP);
		snake.move();
		assertEquals(Direction.DOWN, snake.getDirection());

		snake = new Snake();
		snake.setDirection(Direction.DOWN);
		snake.move();
		snake.setDirection(Direction.LEFT);
		snake.move();
		assertEquals(Direction.LEFT, snake.getDirection());
	}

}
