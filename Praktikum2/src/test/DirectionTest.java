package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ee.itcollege.snake.lib.Direction;

public class DirectionTest {

	@Test
	public void testOpposite() {
		assertTrue(Direction.RIGHT.isOpposite(Direction.LEFT));
		assertTrue(Direction.LEFT.isOpposite(Direction.RIGHT));
		assertTrue(Direction.DOWN.isOpposite(Direction.UP));
		assertTrue(Direction.UP.isOpposite(Direction.DOWN));
		
		assertFalse(Direction.RIGHT.isOpposite(Direction.RIGHT));
		assertFalse(Direction.RIGHT.isOpposite(Direction.DOWN));
		assertFalse(Direction.RIGHT.isOpposite(Direction.UP));
		
		assertFalse(Direction.LEFT.isOpposite(Direction.LEFT));
		assertFalse(Direction.LEFT.isOpposite(Direction.DOWN));
		assertFalse(Direction.LEFT.isOpposite(Direction.UP));
		
		assertFalse(Direction.UP.isOpposite(Direction.RIGHT));
		assertFalse(Direction.UP.isOpposite(Direction.LEFT));
		assertFalse(Direction.UP.isOpposite(Direction.UP));
		
		assertFalse(Direction.DOWN.isOpposite(Direction.RIGHT));
		assertFalse(Direction.DOWN.isOpposite(Direction.LEFT));
		assertFalse(Direction.DOWN.isOpposite(Direction.DOWN));
	}

}
