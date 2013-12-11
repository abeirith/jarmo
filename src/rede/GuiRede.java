package rede;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GuiRede implements ActionListener {

	private JFrame viewFrame;

	private JPanel conectarViewPanel = new JPanel();
	private JPanel camposViewPanel = new JPanel(); 
	private JPanel botoesViewPanel = new JPanel();

	private JButton contectarButton = new JButton("Conectar");
	private JButton cancelarButton = new JButton("Cancelar");

	private JTextField nickField = new JTextField(15);
	private JTextField ipServidorField = new JTextField(15);

	private JLabel nickLabel = new JLabel("Usu·rio");
	private JLabel ipServidorLabel = new JLabel("IP do servidor:");

	// private ProxyImpl clienteJogador;

	private AtorNetGames jogo;

	public GuiRede(AtorNetGames jogo) {
		this.jogo = jogo;
		this.ipServidorField.setText("venus.inf.ufsc.br");
	}

	/**
	 * Cria a janela gr√°fica de conex√µes
	 */
	public void createFront() {
		JFrame.setDefaultLookAndFeelDecorated(true);

		viewFrame = new JFrame("Conectar");
		viewFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		this.createPanel();

		viewFrame.add(conectarViewPanel);

		viewFrame.pack();
		viewFrame.setSize(400, 130);
		viewFrame.setVisible(true);
	}

	public void createPanel() {
		// Insere os elementos de campos e labels no painel de campos
		camposViewPanel.setLayout(new GridLayout(2, 2, 2, 2));

		camposViewPanel.add(nickLabel);
		camposViewPanel.add(nickField);

		camposViewPanel.add(ipServidorLabel);
		camposViewPanel.add(ipServidorField);

		// Define os listeners dos bot√µes
		contectarButton.addActionListener(this);
		cancelarButton.addActionListener(this);

		// Insere os elementos de bot√µes no painel de bot√µes
		botoesViewPanel.add(contectarButton);
		botoesViewPanel.add(cancelarButton);

		conectarViewPanel.add(camposViewPanel);
		conectarViewPanel.add(botoesViewPanel);
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o != null && o instanceof JButton) {
			JButton item = (JButton) o;

			if (item == this.contectarButton) {
				this.conectar();
			}
			if (item == this.cancelarButton) {
				this.cancelar();
			}
		}
	}

	/**
	 * Retorna para a tela principal
	 */
	private void cancelar() {
		viewFrame.setVisible(false);
		viewFrame.dispose();
	}

	/**
	 * Tenta se conectar com o servidor Caso consigua emite uma mensagem de
	 * afirma√ß√£o e retorna para a tela principal Do contrario emite uma mensagem
	 * de erro e continua na mesma tela
	 */

	private void conectar() {
		String nome = nickField.getText();
		String ipServidor = ipServidorField.getText();

		// validaÁıes
		if (nome.equals("")) {
			JOptionPane.showMessageDialog(this.viewFrame, "VocÍ deve escolher um nome de usu·rio", "Erro", JOptionPane.ERROR_MESSAGE, null);
			return;
		}

		jogo.conectarRede(nome, ipServidor);

		// fecha a janela
		this.cancelar();
	}
}