package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ee.itcollege.snake.lib.Direction;

public class DirectionTest {

	@Test
	public void testOpposite() {
		assertTrue(Direction.RIGHT == Direction.isOpposite(Direction.LEFT));
		assertTrue(Direction.LEFT == Direction.isOpposite(Direction.RIGHT));
		assertTrue(Direction.DOWN == Direction.isOpposite(Direction.UP));
		assertTrue(Direction.UP == Direction.isOpposite(Direction.DOWN));
	}

}
