package praktikum1;


import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AkenNaidis {
    
    public static void main(String[] args) {
        
        final JFrame aken = new JFrame("Naidis");
        final JTextField vali = new JTextField();
        final JTextArea area = new JTextArea();
        final JButton nupp = new JButton("Kasva suureks!");
        aken.setSize(300, 200);
        aken.setLayout(new GridLayout(3, 1));
        aken.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      

        vali.setText("Tere!");
        aken.add(vali);
        aken.add(area);
        area.addKeyListener(new KeyListener() {
	    
	    @Override
	    public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == '›') {
		    e.setKeyChar('š');
		} else if (e.getKeyChar() == ' ') {
		    if (Math.random() < .3) {
			e.consume();
		    }
		}
	    }
	    
	    @Override
	    public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	    }
	    
	    @Override
	    public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	    }
	});
        vali.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		if (e.getKeyChar() == 'm') {
        			e.setKeyChar('n');
        		} else {
        			e.setKeyChar('m');
        		}
        		System.out.println(e.getKeyChar());
        	}
		});
        
        aken.add(nupp);
        aken.setVisible(true);
        
       nupp.addMouseListener(new MouseAdapter() {
	   @Override
	   public void mouseClicked(MouseEvent e) {
	      vali.setText(vali.getText().toUpperCase()); 
	   }
    });
    }
}