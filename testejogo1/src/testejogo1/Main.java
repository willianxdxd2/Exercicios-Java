package testejogo1;

import java.awt.Component;

import javax.swing.JFrame;
import testejogo1.Tela;
public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Meu jogo");
		Tela tela =new Tela();
		frame.add(tela);
		frame.setSize(800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
