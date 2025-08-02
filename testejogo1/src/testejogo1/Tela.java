package testejogo1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Tela extends JPanel{

	public Tela() {
		setBackground(Color.BLACK);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//desenha um quadrado vermelho
		g.setColor(getBackground());
		g.fillRect(100,100,50,50);
	}
}
