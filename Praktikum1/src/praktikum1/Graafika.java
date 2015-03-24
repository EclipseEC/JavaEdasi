package praktikum1;
import java.applet.Applet;
import java.awt.Graphics;

public class Graafika extends Applet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		g.draw3DRect(0, 0, 10, 10, false);
	}
}
