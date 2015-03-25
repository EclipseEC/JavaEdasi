package ee.itcollege.snake.lib;

public enum Direction {
    LEFT, RIGHT, UP, DOWN;
    
    public static Direction isOpposite(Direction direction) {
    	if (direction == DOWN) {
    		return UP;
    	} else if (direction == UP) {
    		return DOWN;
    	} else if (direction == LEFT) {
    		return RIGHT;
    	} else {
    		return LEFT;
    	}
    }
}
