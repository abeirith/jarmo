package interfaceGrafica;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import rede.AtorNetGames;
import br.ufsc.inf.leobr.cliente.Proxy;
import modelo.ImagemDeTabuleiro;
import modelo.Jogador;
import modelo.Peao;
import modelo.Posicao;
import modelo.Tabuleiro;

public class AtorJogador extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	protected Tabuleiro tab; 

	private Posicao vPosicao01 = null;
	private Posicao vPosicao02 = null;
	private Posicao vPosicao03 = null;
	private Posicao vPosicao04 = null;
	private Posicao vPosicao05 = null;

	private Posicao vPosicao06 = null;
	private Posicao vPosicao07 = null;
	private Posicao vPosicao08 = null;
	private Posicao vPosicao09 = null;
	private Posicao vPosicao10 = null;

	private Posicao vPosicao11 = null;
	private Posicao vPosicao12 = null;
	private Posicao vPosicao13 = null;
	private Posicao vPosicao14 = null;
	private Posicao vPosicao15 = null;

	private Posicao vPosicao16 = null;
	private Posicao vPosicao17 = null;
	private Posicao vPosicao18 = null;
	private Posicao vPosicao19 = null;
	private Posicao vPosicao20 = null;

	private Posicao vPosicao21 = null;
	private Posicao vPosicao22 = null;
	private Posicao vPosicao23 = null;
	private Posicao vPosicao24 = null;
	private Posicao vPosicao25 = null;	

	private JLabel vMensagem = null;

	protected JLabel mapaVPosicao[][] = new JLabel[5][5];

	private JMenuBar jMenuBar = null;

	private AtorNetGames atorNetGames;

	public AtorJogador(){
		super();
		initialize();
	}

	private void initialize() {
		atorNetGames = new AtorNetGames(this);
		this.setSize(600, 690);
		this.setContentPane(getJContentPane());
		this.setTitle("Jarmo");
		this.setResizable(false);
		tab = new Tabuleiro();
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			Icon vazia = new ImageIcon(getClass().getResource("img/posicao.png"));
			Posicao[] posicoes;
//Precisa habilitar o deselecionar o peao e não deixar que a peça pegue a própria peça e avisar de movimentos inválidos
			vMensagem = new JLabel();
			vMensagem.setForeground(new Color(0,0,0));
			vMensagem.setBounds(new Rectangle(97, 600, 500, 20));
			vMensagem.setText("Bem vindo!");

			vPosicao01 = new Posicao(0,0);
			vPosicao02 = new Posicao(0,1);
			vPosicao03 = new Posicao(0,2);
			vPosicao04 = new Posicao(0,3);
			vPosicao05 = new Posicao(0,4);
			vPosicao06 = new Posicao(1,0);
			vPosicao07 = new Posicao(1,1);
			vPosicao08 = new Posicao(1,2);
			vPosicao09 = new Posicao(1,3);
			vPosicao10 = new Posicao(1,4);
			vPosicao11 = new Posicao(2,0);
			vPosicao12 = new Posicao(2,1);
			vPosicao13 = new Posicao(2,2);
			vPosicao14 = new Posicao(2,3);
			vPosicao15 = new Posicao(2,4);
			vPosicao16 = new Posicao(3,0);
			vPosicao17 = new Posicao(3,1);
			vPosicao18 = new Posicao(3,2);
			vPosicao19 = new Posicao(3,3);
			vPosicao20 = new Posicao(3,4);
			vPosicao21 = new Posicao(4,0);
			vPosicao22 = new Posicao(4,1);
			vPosicao23 = new Posicao(4,2);
			vPosicao24 = new Posicao(4,3);
			vPosicao25 = new Posicao(4,4);

			posicoes = new Posicao[2];
			posicoes[0] = vPosicao08;
			posicoes[1] = vPosicao12;
			vPosicao01.definirPosPermitidas(posicoes);
			vPosicao01.setBounds(new Rectangle(97, 93, 70, 70));
			vPosicao01.setIcon(vazia);
			vPosicao01.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});


			posicoes = new Posicao[2];
			posicoes[0] = vPosicao09;
			posicoes[1] = vPosicao11;
			vPosicao02.definirPosPermitidas(posicoes);
			vPosicao02.setBounds(new Rectangle(187, 93, 70, 70));
			vPosicao02.setIcon(vazia);
			vPosicao02.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});


			posicoes = new Posicao[3];
			posicoes[0] = vPosicao06;
			posicoes[1] = vPosicao12;
			posicoes[2] = vPosicao10;
			vPosicao03.definirPosPermitidas(posicoes);
			vPosicao03.setBounds(new Rectangle(277, 93, 70, 70));
			vPosicao03.setIcon(vazia);
			vPosicao03.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});


			posicoes = new Posicao[2];
			posicoes[0] = vPosicao07;
			posicoes[1] = vPosicao15;
			vPosicao04.definirPosPermitidas(posicoes);
			vPosicao04.setBounds(new Rectangle(367, 93, 70, 70));
			vPosicao04.setIcon(vazia);
			vPosicao04.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});

			posicoes = new Posicao[2];
			posicoes[0] = vPosicao08;
			posicoes[1] = vPosicao14;
			vPosicao05.definirPosPermitidas(posicoes);
			vPosicao05.setBounds(new Rectangle(457, 93, 70, 70));
			vPosicao05.setIcon(vazia);
			vPosicao05.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});

			posicoes = new Posicao[2];
			posicoes[0] = vPosicao03;
			posicoes[1] = vPosicao13;
			vPosicao06.definirPosPermitidas(posicoes);
			vPosicao06.setBounds(new Rectangle(97, 183, 70, 70));
			vPosicao06.setIcon(vazia);
			vPosicao06.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});

			posicoes = new Posicao[4];
			posicoes[0] = vPosicao04;
			posicoes[1] = vPosicao08;
			posicoes[2] = vPosicao12;
			posicoes[3] = vPosicao14;
			vPosicao07.definirPosPermitidas(posicoes);
			vPosicao07.setBounds(new Rectangle(187, 183, 70, 70));
			vPosicao07.setIcon(vazia);
			vPosicao07.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});

			posicoes = new Posicao[5];
			posicoes[0] = vPosicao01;
			posicoes[1] = vPosicao05;
			posicoes[2] = vPosicao07;
			posicoes[3] = vPosicao09;
			posicoes[4] = vPosicao17;
			vPosicao08.definirPosPermitidas(posicoes);
			vPosicao08.setBounds(new Rectangle(277, 183, 70, 70));
			vPosicao08.setIcon(vazia);
			vPosicao08.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});

			posicoes = new Posicao[4];
			posicoes[0] = vPosicao02;
			posicoes[1] = vPosicao08;
			posicoes[2] = vPosicao14;
			posicoes[3] = vPosicao20;
			vPosicao09.definirPosPermitidas(posicoes);
			vPosicao09.setBounds(new Rectangle(367, 183, 70, 70));
			vPosicao09.setIcon(vazia);
			vPosicao09.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});

			posicoes = new Posicao[2];
			posicoes[0] = vPosicao03;
			posicoes[1] = vPosicao13;
			vPosicao10.definirPosPermitidas(posicoes);
			vPosicao10.setBounds(new Rectangle(457, 183, 70, 70));
			vPosicao10.setIcon(vazia);
			vPosicao10.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});

			posicoes = new Posicao[2];
			posicoes[0] = vPosicao02;
			posicoes[1] = vPosicao22;
			vPosicao11.definirPosPermitidas(posicoes);
			vPosicao11.setBounds(new Rectangle(97, 270, 70, 70));
			vPosicao11.setIcon(vazia);
			vPosicao11.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});

			posicoes = new Posicao[6];
			posicoes[0] = vPosicao01;
			posicoes[1] = vPosicao03;
			posicoes[2] = vPosicao07;
			posicoes[3] = vPosicao17;
			posicoes[4] = vPosicao19;
			posicoes[5] = vPosicao21;
			vPosicao12.definirPosPermitidas(posicoes);
			vPosicao12.setBounds(new Rectangle(187, 270, 70, 70));
			vPosicao12.setIcon(vazia);
			vPosicao12.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});

			posicoes = new Posicao[4];
			posicoes[0] = vPosicao06;
			posicoes[1] = vPosicao10;
			posicoes[2] = vPosicao16;
			posicoes[3] = vPosicao24;
			vPosicao13.definirPosPermitidas(posicoes);
			vPosicao13.setBounds(new Rectangle(277, 270, 70, 70));
			vPosicao13.setIcon(vazia);
			vPosicao13.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});

			posicoes = new Posicao[6];
			posicoes[0] = vPosicao07;
			posicoes[1] = vPosicao05;
			posicoes[2] = vPosicao09;
			posicoes[3] = vPosicao19;
			posicoes[4] = vPosicao23;
			posicoes[5] = vPosicao25;
			vPosicao14.definirPosPermitidas(posicoes);
			vPosicao14.setBounds(new Rectangle(367, 270, 70, 70));
			vPosicao14.setIcon(vazia);
			vPosicao14.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});

			posicoes = new Posicao[2];
			posicoes[0] = vPosicao04;
			posicoes[1] = vPosicao18;
			vPosicao15.definirPosPermitidas(posicoes);
			vPosicao15.setBounds(new Rectangle(457, 270, 70, 70));
			vPosicao15.setIcon(vazia);
			vPosicao15.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});

			posicoes = new Posicao[2];
			posicoes[0] = vPosicao13;
			posicoes[1] = vPosicao23;
			vPosicao16.definirPosPermitidas(posicoes);
			vPosicao16.setBounds(new Rectangle(97, 355, 70, 70));
			vPosicao16.setIcon(vazia);
			vPosicao16.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});

			posicoes = new Posicao[3];
			posicoes[0] = vPosicao12;
			posicoes[1] = vPosicao18;
			posicoes[2] = vPosicao24;
			vPosicao17.definirPosPermitidas(posicoes);
			vPosicao17.setBounds(new Rectangle(187, 355, 70, 70));
			vPosicao17.setIcon(vazia);
			vPosicao17.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});

			posicoes = new Posicao[4];
			posicoes[0] = vPosicao15;
			posicoes[1] = vPosicao17;
			posicoes[2] = vPosicao19;
			posicoes[3] = vPosicao25;
			vPosicao18.definirPosPermitidas(posicoes);
			vPosicao18.setBounds(new Rectangle(277, 355, 70, 70));
			vPosicao18.setIcon(vazia);
			vPosicao18.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});

			posicoes = new Posicao[4];
			posicoes[0] = vPosicao12;
			posicoes[1] = vPosicao14;
			posicoes[2] = vPosicao18;
			posicoes[3] = vPosicao22;
			vPosicao19.definirPosPermitidas(posicoes);
			vPosicao19.setBounds(new Rectangle(367, 355, 70, 70));
			vPosicao19.setIcon(vazia);
			vPosicao19.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});

			posicoes = new Posicao[2];
			posicoes[0] = vPosicao09;
			posicoes[1] = vPosicao23;
			vPosicao20.definirPosPermitidas(posicoes);
			vPosicao20.setBounds(new Rectangle(457, 355, 70, 70));
			vPosicao20.setIcon(vazia);
			vPosicao20.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});

			posicoes = new Posicao[2];
			posicoes[0] = vPosicao12;
			posicoes[1] = vPosicao18;
			vPosicao21.definirPosPermitidas(posicoes);
			vPosicao21.setBounds(new Rectangle(97, 445, 70, 70));
			vPosicao21.setIcon(vazia);
			vPosicao21.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});

			posicoes = new Posicao[2];
			posicoes[0] = vPosicao11;
			posicoes[1] = vPosicao19;
			vPosicao22.definirPosPermitidas(posicoes);
			vPosicao22.setBounds(new Rectangle(187, 445, 70, 70));
			vPosicao22.setIcon(vazia);
			vPosicao22.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});

			posicoes = new Posicao[3];
			posicoes[0] = vPosicao14;
			posicoes[1] = vPosicao16;
			posicoes[2] = vPosicao20;
			vPosicao23.definirPosPermitidas(posicoes);
			vPosicao23.setBounds(new Rectangle(277, 445, 70, 70));
			vPosicao23.setIcon(vazia);
			vPosicao23.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});

			posicoes = new Posicao[2];
			posicoes[0] = vPosicao13;
			posicoes[1] = vPosicao17;
			vPosicao24.definirPosPermitidas(posicoes);
			vPosicao24.setBounds(new Rectangle(367, 445, 70, 70));
			vPosicao24.setIcon(vazia);
			vPosicao24.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});

			posicoes = new Posicao[2];
			posicoes[0] = vPosicao14;
			posicoes[1] = vPosicao18;
			vPosicao25.definirPosPermitidas(posicoes);
			vPosicao25.setBounds(new Rectangle(457, 445, 70, 70));
			vPosicao25.setIcon(vazia);
			vPosicao25.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Posicao p = (Posicao)e.getSource();
					getJogada(p);
				}
			});

			jMenuBar = new JMenuBar();
			jMenuBar.add(atorNetGames.getMenuRede());
			this.setJMenuBar(jMenuBar);

			jContentPane = new PainelPrincipal();
			jContentPane.setLayout(null);



			jContentPane.add(vMensagem, null);
		}
		return jContentPane;
	}

	public void setElementos(Jogador local, Jogador visitante) {
		jContentPane.add(vPosicao01, null);
		jContentPane.add(vPosicao02, null);
		jContentPane.add(vPosicao03, null);
		jContentPane.add(vPosicao04, null);
		jContentPane.add(vPosicao05, null);

		jContentPane.add(vPosicao06, null);
		jContentPane.add(vPosicao07, null);
		jContentPane.add(vPosicao08, null);
		jContentPane.add(vPosicao09, null);
		jContentPane.add(vPosicao10, null);

		jContentPane.add(vPosicao11, null);
		jContentPane.add(vPosicao12, null);
		jContentPane.add(vPosicao13, null);
		jContentPane.add(vPosicao14, null);
		jContentPane.add(vPosicao15, null);

		jContentPane.add(vPosicao16, null);
		jContentPane.add(vPosicao17, null);
		jContentPane.add(vPosicao18, null);
		jContentPane.add(vPosicao19, null);
		jContentPane.add(vPosicao20, null);

		jContentPane.add(vPosicao21, null);
		jContentPane.add(vPosicao22, null);
		jContentPane.add(vPosicao23, null);
		jContentPane.add(vPosicao24, null);
		jContentPane.add(vPosicao25, null);


		mapaVPosicao[0][0] = vPosicao01;
		mapaVPosicao[0][1] = vPosicao02;
		mapaVPosicao[0][2] = vPosicao03;
		mapaVPosicao[0][3] = vPosicao04;
		mapaVPosicao[0][4] = vPosicao05;

		mapaVPosicao[1][0] = vPosicao06;
		mapaVPosicao[1][1] = vPosicao07;
		mapaVPosicao[1][2] = vPosicao08;
		mapaVPosicao[1][3] = vPosicao09;
		mapaVPosicao[1][4] = vPosicao10;

		mapaVPosicao[2][0] = vPosicao11;
		mapaVPosicao[2][1] = vPosicao12;
		mapaVPosicao[2][2] = vPosicao13;
		mapaVPosicao[2][3] = vPosicao14;
		mapaVPosicao[2][4] = vPosicao15;

		mapaVPosicao[3][0] = vPosicao16;
		mapaVPosicao[3][1] = vPosicao17;
		mapaVPosicao[3][2] = vPosicao18;
		mapaVPosicao[3][3] = vPosicao19;
		mapaVPosicao[3][4] = vPosicao20;

		mapaVPosicao[4][0] = vPosicao21;
		mapaVPosicao[4][1] = vPosicao22;
		mapaVPosicao[4][2] = vPosicao23;
		mapaVPosicao[4][3] = vPosicao24;
		mapaVPosicao[4][4] = vPosicao25;

	}

	public void getJogada(Posicao p){
		if(tab.informarPartidaEmAndamento()){
			if(!(atorNetGames.ehMinhaVez())){
				JOptionPane.showMessageDialog(null, "Aguarde, não é sua vez.");
			} else {
				if(tab.informarExistenciaPosSelecionada()){
					if(p.getPosPermitida(tab.informarLinhaSelecionada(), tab.informarColunaSelecionada())){
						if(tab.recuperarPosicao(p.getLinha(),p.getColuna()) == null){
							tratarLance(p.getLinha(),p.getColuna(), false);
						}else{
							if(!tab.recuperarPosicao(p.getLinha(),p.getColuna()).ocupada()){
								tratarLance(p.getLinha(),p.getColuna(), false);
							} else {
								if(tab.informarExistenciaPosSelecionada()){
									tratarLance(p.getLinha(),p.getColuna(), false);
								}else{
									selecionaPeao(p.getLinha(),p.getColuna(), false);
								}
							}
						}
					}else{
						if(tab.informarLinhaSelecionada() != p.getLinha() && tab.informarColunaSelecionada() != p.getColuna()){
							atorNetGames.receberMensagem("Movimento inválido!");
						}
					}
				}else{
					if(tab.recuperarPosicao(p.getLinha(),p.getColuna()) == null){
						tratarLance(p.getLinha(),p.getColuna(), false);
					}else{
						if(!tab.recuperarPosicao(p.getLinha(),p.getColuna()).ocupada()){
							tratarLance(p.getLinha(),p.getColuna(), false);
						} else {
							if(tab.informarExistenciaPosSelecionada()){
								tratarLance(p.getLinha(),p.getColuna(), false);
							}else{
								selecionaPeao(p.getLinha(),p.getColuna(), false);
							}
						}
					}
				}


			}
		}
	}

	public void iniciarPartidaRede(boolean iniciarComoSolicitante) {
		if (tab == null) {
			tab = new Tabuleiro();
		}
		tab.setPartidaEmAndamento(true);

		String idJ1 = Proxy.getInstance().getNomeJogador();
		String idJ2 = atorNetGames.obtemNomeAdversario();

		if(iniciarComoSolicitante){
			tab.criarJogador(idJ1, 1);
			tab.criarJogador(idJ2, 2);
			tab.definirOPrimeiro(1);
		} else {
			tab.criarJogador(idJ1, 2);
			tab.criarJogador(idJ2, 1);
			tab.definirOPrimeiro(2);
		}

		setElementos(tab.informarJogadorLocal(),tab.informarJogadorRemoto());
		tab.iniciar();
		this.exibirEstado();
	}

	public void efetuarJogadaRede(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
		selecionaPeao(linhaOrigem, colunaOrigem, true);
		tratarLance(linhaDestino, colunaDestino, true);
		this.exibirEstado();
	}

	public void exibirEstado() {
		ImagemDeTabuleiro estado;
		int valor = 0;

		Icon vazia = new ImageIcon(getClass().getResource("img/posicao.png"));
		Icon preto = new ImageIcon(getClass().getResource("img/peao_preto.png"));
		Icon branco = new ImageIcon(getClass().getResource("img/peao_branco.png"));
		Icon pretoSelecionado = new ImageIcon(getClass().getResource("img/peao_preto_selecionado.png"));
		Icon brancoSelecionado = new ImageIcon(getClass().getResource("img/peao_branco_selecionado.png"));

		estado = tab.informarEstado();
		vMensagem.setText(estado.informarMensagem());

		for (int linha = 0; linha < 5; linha++) {
			for (int coluna = 0; coluna < 5; coluna++) {
				valor = estado.informarValor(linha, coluna);
				switch (valor) {
				case 0:
					mapaVPosicao[linha][coluna].setIcon(vazia);
					break;
				case 1:
					mapaVPosicao[linha][coluna].setIcon(preto);
					break;
				case 2:
					mapaVPosicao[linha][coluna].setIcon(branco);
					break;
				case 3:
					mapaVPosicao[linha][coluna].setIcon(pretoSelecionado);
					break;
				case 4:
					mapaVPosicao[linha][coluna].setIcon(brancoSelecionado);
				}
			}
		}
		this.pack();
		this.repaint();
	}

	public void notificarIrregularidade(int codigo) {
		switch(codigo){
		case 1:
			JOptionPane.showMessageDialog(this, "Peão inválido!");
			break;
		case 2:
			JOptionPane.showMessageDialog(this,	"Selecione um peão, por favor.");
			break;
		case 3:
			JOptionPane.showMessageDialog(this,	"Não é possível mover para essa posição!");
			break;
		}
	}

	public void selecionaPeao(int linha, int coluna, boolean remetenteServidor){

		int resultado = tab.selecionaPeao(linha, coluna, remetenteServidor); 
		/*
		 * resultado = 0 - Sucesso
		 *             1 - Nao é dono do peão
		 */
		if (resultado == 1) {
			this.notificarIrregularidade(resultado);
		}
		this.exibirEstado();
	}

	public void tratarLance(int linha, int coluna, boolean remetenteServidor){
		int resultado = tab.tratarLance(linha, coluna, remetenteServidor);
		/*
		 * resultado: 0 - Sucesso
		 *            2 - Sem peao selecionado
		 *            3 - Posicao impossivel
		 */
		if (resultado == 0 && !remetenteServidor) {
			atorNetGames.enviarJogadaRede(tab.informarLinhaSelecionada(), tab.informarColunaSelecionada(), linha, coluna);
		} else {
			this.notificarIrregularidade(resultado);
		}

		tab.desselecionarPos();
		this.exibirEstado();
	}

	public boolean informarPartidaEmAndamento(){
		return tab.informarPartidaEmAndamento();
	}

	public void terminarPartidaEmAndamento(){
		tab.terminarPartidaEmAndamento();
	}
}