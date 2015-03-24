package praktikum1;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Lained extends Applet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		int w = getWidth();
		int h = getHeight();
		Polygon polygon = new Polygon();
		for (int x = 0; x < w; x++) {
			double phase = Math.sin(x / 20.);
			int y = (int) (h / 2
					+ phase * 30);
			polygon.addPoint((int)(x + phase * 15), y);
		}
		
		polygon.addPoint(w, h);
		polygon.addPoint(0, h);
		
		g.setColor(Color.blue);
		g.fillPolygon(polygon);
	}
}
