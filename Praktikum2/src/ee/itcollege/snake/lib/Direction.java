package ee.itcollege.snake.lib;

public enum Direction {
    LEFT, RIGHT, UP, DOWN;
    
    public boolean isOpposite(Direction direction) {
    	switch (this) {
    	case DOWN:
    		return UP.equals(direction);
    	case LEFT:
    		return RIGHT.equals(direction);
    	case RIGHT:
    		return LEFT.equals(direction);
    	case UP:
    		return DOWN.equals(direction);
    	}
    	
    	throw new IllegalStateException("Sellist suunda pole! " + this + " " + direction);
    }
}
