package praktikum1;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class Ring extends Applet {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void paint(Graphics g) {
	Graphics2D g2 = ((Graphics2D) g);
	
	BufferedImage image = new BufferedImage(20, 7,
		BufferedImage.TYPE_INT_ARGB);
	Graphics2D g1 = image.createGraphics();

	g1.setColor(Color.BLACK);
	Rectangle rect = new Rectangle(0, 0, 8, 10);
	g1.fill(rect);
	g2.rotate(Math.toRadians(-10));

	g2.setPaint(new TexturePaint(image, new Rectangle(0, 0, image
		.getWidth(), image.getHeight())));
	Ellipse2D e = new Ellipse2D.Double(20, 20, 100, 100);
	g2.fill(e);
    }
}
