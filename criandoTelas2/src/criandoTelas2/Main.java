package criandoTelas2;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Tela tela = new Tela();
		frame.add(tela);
		frame.setVisible(true);
		frame.setSize(900,700);
	}

}
