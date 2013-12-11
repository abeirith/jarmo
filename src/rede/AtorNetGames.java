package rede;

import java.awt.Rectangle;

import interfaceGrafica.AtorJogador;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import modelo.Lance;
import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;

public class AtorNetGames implements OuvidorProxy {
	
	private static final long serialVersionUID = 1L;

	private boolean ehMinhaVez = false;
	
	protected AtorJogador atorJogador;
	private Proxy proxy;
	
	private JMenu menuRede = null;
	
	private JMenuItem jMenuItemConectar = null;
	private JMenuItem jMenuItemIniciarPartidaRede = null;
	private JMenuItem jMenuItemDesconectar = null;

	@SuppressWarnings("static-access")
	public AtorNetGames(AtorJogador atorJogador) {
		this.atorJogador = atorJogador;
		proxy = proxy.getInstance();
	}
	
	
	@Override
	public void iniciarNovaPartida(Integer posicao) {
		if (posicao == 1) {
			JOptionPane.showMessageDialog(atorJogador, "Partida iniciada, você começa jogando!");
			ehMinhaVez = true;
			atorJogador.iniciarPartidaRede(ehMinhaVez);
		} else {
			JOptionPane.showMessageDialog(atorJogador, "Partida iniciada, aguarde seu oponente.");
			ehMinhaVez = false;
			atorJogador.iniciarPartidaRede(ehMinhaVez);
		}
	}

	@Override
	public void finalizarPartidaComErro(String message) {
		JOptionPane.showMessageDialog(atorJogador, message);
	}

	@Override
	public void receberMensagem(String msg) {
		JOptionPane.showMessageDialog(atorJogador, msg);
	}

	@Override
	public void receberJogada(Jogada jogada) {
		modelo.Lance jg = (modelo.Lance) jogada;
		atorJogador.efetuarJogadaRede(jg.informarLinhaOrigem(),	jg.informarColunaOrigem(), jg.informarLinhaDestino(), jg.informarColunaDestino());
		ehMinhaVez = true;
	}

	@Override
	public void tratarConexaoPerdida() {
		JOptionPane.showMessageDialog(atorJogador, "A conexão com o servidor foi perdida, por favor tente novamente mais tarde.");
	}

	@Override
	public void tratarPartidaNaoIniciada(String message) {
		JOptionPane.showMessageDialog(atorJogador, "A partida não pode ser iniciada devido ao seguinte erro: " + message);
	}
	
	public JMenu getMenuRede() {
		if (menuRede == null) {
			menuRede = new JMenu();
			menuRede.setText("Jogar");
			menuRede.setBounds(new Rectangle(1, 0, 57, 21));
			menuRede.add(getJMenuItemConectar());
			menuRede.add(getJMenuItemIniciarPartidaRede());
			menuRede.add(getJMenuItemDesconectar());
		}
		return menuRede;
	}

	private JMenuItem getJMenuItemConectar() {
		if (jMenuItemConectar == null) {
			jMenuItemConectar = new JMenuItem();
			jMenuItemConectar.setText("Conectar");
			jMenuItemConectar.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							conectar();
						}
					});
		}
		return jMenuItemConectar;
	}

	protected void conectar() {
		GuiRede ic = new GuiRede(this);
		ic.createFront();
	}
	
	protected void iniciarPartidaRede() {
		try {
			proxy.iniciarPartida(2);
		} catch (NaoConectadoException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(atorJogador, e.getMessage());
		}
	}

	private JMenuItem getJMenuItemIniciarPartidaRede() {
		if (jMenuItemIniciarPartidaRede == null) {
			jMenuItemIniciarPartidaRede = new JMenuItem();
			jMenuItemIniciarPartidaRede.setText("Iniciar partida");
			jMenuItemIniciarPartidaRede.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {	
							if(!atorJogador.informarPartidaEmAndamento())
								iniciarPartidaRede();
						}
					});
		}
		return jMenuItemIniciarPartidaRede;
	}
	
	private JMenuItem getJMenuItemDesconectar() {
		if (jMenuItemDesconectar == null) {
			jMenuItemDesconectar = new JMenuItem();
			jMenuItemDesconectar.setText("Desconectar");
			jMenuItemDesconectar.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							desconectar();
						}
					});
		}
		return jMenuItemDesconectar;
	}

	protected void desconectar() {
		try {
			atorJogador.terminarPartidaEmAndamento();
			proxy.desconectar();
		} catch (NaoConectadoException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(atorJogador, "Erro: "	+ e.getMessage());
		}
	}

	public boolean ehMinhaVez() {
		return ehMinhaVez;
	}
	
	public void enviarJogadaRede(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
		Lance jg = new Lance(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino);
		try {
			proxy.enviaJogada(jg);
			ehMinhaVez = false;
		} catch (NaoJogandoException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(atorJogador, e.getMessage());	
		}
	}

	public String obtemNomeAdversario() {
		return proxy.obterNomeAdversarios().get(0);
	}

	protected void conectarRede(String nome, String ipServidor) {
		try {
			proxy.conectar(ipServidor, nome);
			proxy.addOuvinte(this);
		} catch (JahConectadoException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(atorJogador, e.getMessage());
		} catch (NaoPossivelConectarException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(atorJogador, "Erro: "	+ e.getMessage());
		} catch (ArquivoMultiplayerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(atorJogador, "Erro: "	+ e.getMessage());
		}
	}
}
