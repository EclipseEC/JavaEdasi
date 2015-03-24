package praktikum1;
import java.applet.Applet;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Jänese joonistamise näide
 * @author Mikk Mangus
 */
@SuppressWarnings("serial")
public class Janes extends Applet {
    
    private Graphics2D g;
	
    public void paint(Graphics g) {
        this.g = (Graphics2D) g;
        // Antialias teeb servad vähem karvaseks
        this.g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        this.g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        
        joonistaTaust();
        joonistaJanes();
    }
    
    /**
     * Katab tausta valgega
     */
    public void joonistaTaust() {
        int w = getWidth();
        int h = getHeight();
        g.setColor(Color.black);
        GradientPaint blackToWhite = new GradientPaint(0, h, Color.black, w, h, Color.white);
        g.setPaint(blackToWhite);
        g.fillRect(0, 0, w, h);
    }
    
    /**
     * Joonistab jänese
     */
    public void joonistaJanes() {
        // pea
        g.setColor(Color.blue);
        g.fillOval(60, 50, 50, 50);
        
        // keha
        g.fillOval(50, 95, 75, 75);
            
        // k6rvad
        g.fillOval(60, 5, 23, 70);
        g.fillOval(88, 5, 23, 70);
        g.setColor(Color.white);
        g.fillOval(64, 10, 15, 45);
        g.fillOval(92, 10, 15, 45);
        
        // silmad
        g.setColor(Color.black);
        g.fillRect(70, 69, 5, 7);
        g.fillRect(95, 69, 5, 7);

        // tekst
        g.drawString("Hipsadi hopsadi!", 70, 190);
    }
	
}