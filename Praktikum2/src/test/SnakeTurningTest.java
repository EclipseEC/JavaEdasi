package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ee.itcollege.snake.lib.Direction;
import ee.itcollege.snake.parts.Snake;

public class SnakeTurningTest {
	private Snake snake;

	@Test(timeout = 1000)
	public void testOppositeTurn() {
		snake = new Snake();
		snake.setDirection(Direction.LEFT);
		assertEquals(Direction.RIGHT, snake.getDirection());
		
		snake = new Snake();
		snake.setDirection(Direction.UP);
		assertEquals(Direction.UP, snake.getDirection());
		
		snake = new Snake();
		snake.setDirection(Direction.UP);
		snake.setDirection(Direction.LEFT);
		assertEquals(Direction.LEFT, snake.getDirection());
		
		snake = new Snake();
		snake.setDirection(Direction.DOWN);
		snake.setDirection(Direction.UP);
		assertEquals(Direction.DOWN, snake.getDirection());
	}

}
