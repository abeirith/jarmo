package interfaceGrafica;

import javax.swing.JFrame;

public class Jarmo {
	public static void main(String args[]){
		AtorJogador janela;
		janela = new AtorJogador();
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
}