package ee.itcollege.snake.lib;

import java.awt.geom.Area;

public class CollisionDetector {

	public static boolean collide(IDrawable a1, IDrawable a2) {
		
		if (a1 == null || a2 == null) {
			return false;
		}
		
		Area thisArea = a1.getArea();
		Area substracted = new Area(thisArea);
		
		substracted.subtract(a2.getArea());
		if (!thisArea.equals(substracted)) {
			return true;
		}
		
		return false;
	}
	
}
