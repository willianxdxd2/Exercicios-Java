package criandoTelas2;

import java.awt.Color;

import javax.swing.JPanel;

import java.awt.Graphics;

public class Tela extends JPanel {

	public Tela(){
		
		setBackground(Color.ORANGE);
	}
	@Override	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillRect(100,100,50,50);
	}
	
	
}
	