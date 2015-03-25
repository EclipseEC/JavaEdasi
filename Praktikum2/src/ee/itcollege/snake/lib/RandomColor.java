package ee.itcollege.snake.lib;

import java.awt.Color;

public class RandomColor extends Color {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RandomColor() {
		super(randomTone(), randomTone(), randomTone());
	}
	
	private static int randomTone() {
		return (int)(Math.random() * 256);
	}
}
