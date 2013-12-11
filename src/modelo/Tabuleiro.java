package modelo;

public class Tabuleiro {

	protected Posicao posicoes[][] = new Posicao[5][5];

	protected Jogador jogadorLocal;
	protected Jogador jogadorRemoto;

	protected int linhaSelecionada;
	protected int colunaSelecionada;

	protected boolean partidaEmAndamento;

	public Tabuleiro() {
		linhaSelecionada = -1;
		colunaSelecionada = -1;
	}

	public boolean informarPartidaEmAndamento() {
		return partidaEmAndamento;
	}

	public void setPartidaEmAndamento(boolean iniciar) {
		this.partidaEmAndamento = iniciar;
	}

	public void esvaziar() {
		/*
		for (int linha = 0; linha < 5; linha++) {
			for (int coluna = 0; coluna < 5; coluna++) {
				posicoes[linha][coluna].esvaziar();
			}
		}*/
	}

	public void criarJogador(String nome, int cor) {
		if ((jogadorLocal != null) && (jogadorRemoto != null)) {
			jogadorRemoto = null;
			jogadorLocal = new Jogador();
			jogadorLocal.iniciar(nome, cor);
		} else {
			if (jogadorLocal == null) {
				jogadorLocal = new Jogador();
				jogadorLocal.iniciar(nome, cor);
			} else {
				jogadorRemoto = new Jogador();
				jogadorRemoto.iniciar(nome, cor);
			}
		}
	}

	public boolean informarExistenciaPosSelecionada(){
		boolean retorno = true;

		if(linhaSelecionada == -1 && colunaSelecionada == -1) {
			retorno = false;
		}
		return retorno;
	}

	public void definirOPrimeiro(int primeiro) {
		this.esvaziar();
		partidaEmAndamento = true;
		jogadorLocal.reiniciar();
		jogadorRemoto.reiniciar();
		if (primeiro == 1) {
			jogadorLocal.habilitar();
		} else {
			jogadorRemoto.habilitar();
		}
	}

	public void setPeao(int linha, int coluna, Posicao p){
		this.posicoes[linha][coluna] = p;
	}

	public void iniciar() {
		linhaSelecionada = -1;
		colunaSelecionada = -1;
		for (int linha = 0; linha < 5; linha++) {
			for (int coluna = 0; coluna < 5; coluna++) {
				posicoes[linha][coluna] = new Posicao();
				posicoes[linha][coluna].esvaziar();
				if (linha == 0) {
					if (jogadorLocal.informarCor() == 1)
						posicoes[linha][coluna].definirOcupante(jogadorRemoto);
					else
						posicoes[linha][coluna].definirOcupante(jogadorLocal);
				} else if (linha == 4) {
					if (jogadorLocal.informarCor() == 2){
						posicoes[linha][coluna].definirOcupante(jogadorRemoto);
					} else {
						posicoes[linha][coluna].definirOcupante(jogadorLocal);
					}
				} else {
					posicoes[linha][coluna] = null;
				}
			}
		}
	}

	public ImagemDeTabuleiro informarEstado() {
		ImagemDeTabuleiro estado;
		int valor = 0;
		Jogador vencedor = null;
		estado = new ImagemDeTabuleiro();

		if (this.informarPartidaEmAndamento()) {
			if (jogadorLocal.informarDaVez()) {
				estado.assumirMensagem("É sua vez! E seus peões são os " + jogadorLocal.getCor());
			} else {
				estado.assumirMensagem("Aguarde! " + jogadorRemoto.informarNome() + " irá jogar!");
			}
		} else {
			vencedor = this.informarVencedor();
			estado.assumirMensagem("O vencedor foi: " + vencedor.informarNome() + " (jogou com os peões " + vencedor.getCor() + ")");
		}

		for (int linha = 0; linha < 5; linha++) {
			for (int coluna = 0; coluna < 5; coluna++) {
				if (this.recuperarPosicao(linha, coluna) != null) {
					if ((this.recuperarPosicao(linha, coluna)).ocupada()) {
						valor = ((this.recuperarPosicao(linha, coluna)).informarOcupante()).informarCor();
						if (linha == linhaSelecionada && coluna == colunaSelecionada) {
							estado.assumirValor(linha, coluna, valor + 2);
						} else {
							estado.assumirValor(linha, coluna, valor);
						}
					} else {
						valor = 0;
						estado.assumirValor(linha, coluna, valor);
					}
				} else {
					estado.assumirValor(linha, coluna, -1);
				}
			}
		}
		return (estado);
	}

	public Posicao recuperarPosicao(int linha, int coluna) {
		if(linha <= 4 && coluna <= 4){
			return (posicoes[linha][coluna]);
		}else{
			return null;
		}
	}

	private Jogador informarVencedor() {
		if (jogadorLocal.informarVencedor()) {
			return jogadorLocal;
		} else {
			if (jogadorRemoto.informarVencedor()) {
				return jogadorRemoto;
			} else {
				return null;
			}
		}
	}

	public int selecionaPeao(int linha, int coluna, boolean remetenteServidor) {
		int retorno = 0;

		if (remetenteServidor || posicoes[linha][coluna].informarOcupante() == jogadorLocal) {
			assumirLinhaColunaSelecionada(linha,coluna);
		} else {
			retorno = 1;
			desselecionarPos();
		}
		return retorno;
	}

	private void assumirLinhaColunaSelecionada(int linha, int coluna){
		linhaSelecionada = linha;
		colunaSelecionada = coluna;
	}

	public int tratarLance(int linha, int coluna, boolean remetenteServidor) {
		int retorno;

		if (informarExistenciaPosSelecionada()) {
			mover(linha, coluna);
			alternarVez(verificarVencedor(remetenteServidor),remetenteServidor);
			retorno = 0;// jogada OK;
		} else {
			retorno = 2; // sem pe�o selecionado
		}
		return retorno;
	}

	private void mover(int linha, int coluna) {
		if(recuperarPosicao(linhaSelecionada,colunaSelecionada) == null){
			setPeao(linhaSelecionada, linhaSelecionada, null);
		}
		if(recuperarPosicao(linha,coluna) == null){
			setPeao(linha, coluna, new Posicao(jogadorLocal));
		}

		recuperarPosicao(linha,coluna).definirOcupante(recuperarPosicao(linhaSelecionada,colunaSelecionada).informarOcupante());
		recuperarPosicao(linhaSelecionada,colunaSelecionada).definirOcupante(null);
	}

	private void alternarVez(boolean haVencedor, boolean remetenteServidor) {
		if (haVencedor) {
			jogadorLocal.desabilitar();
			jogadorRemoto.desabilitar();
		} else if (remetenteServidor) {
			jogadorLocal.habilitar();
			jogadorRemoto.desabilitar();
		} else {
			jogadorLocal.desabilitar();
			jogadorRemoto.habilitar();
		}
	}

	@SuppressWarnings("unused")
	private int[] verificaExistenciaPecaIntervalo(int linha, int coluna) {
		int[] pos = null;

		if (linha == linhaSelecionada) {
			if (coluna > colunaSelecionada) {
				if (posicoes[linha][coluna - 1].ocupada()) {
					pos = new int[] { linha, coluna - 1 };
				}
			} else if (coluna < colunaSelecionada) {
				if (posicoes[linha][coluna + 1].ocupada()) {
					pos = new int[] { linha, coluna + 1 };
				}
			}
		} else if (coluna == colunaSelecionada) {
			if (linha > linhaSelecionada) {
				if (posicoes[linha - 1][coluna].ocupada()) {
					pos = new int[] { linha - 1, coluna };
				}
			} else if (linha < linhaSelecionada) {
				if (posicoes[linha + 1][coluna].ocupada()) {
					pos = new int[] { linha + 1, coluna };
				}
			}
		}
		return pos;
	}

	private int informarQuantidadeDePeao(int cor) {
		int quantidade = 0;
		for (int linha = 0; linha < 5; linha++) {
			for (int coluna = 0; coluna < 5; coluna++) {
				if(posicoes[linha][coluna] != null){
					if(posicoes[linha][coluna].ocupante != null){
						if(posicoes[linha][coluna].ocupante.cor == cor){
							quantidade = quantidade + 1;
						}
					}
				}
			}
			}
		return quantidade;
	}

	private boolean verificarVencedor(boolean remetenteServidor) {
		boolean retorno = false;

		if (informarQuantidadeDePeao(jogadorLocal.cor) == 0) {
			terminarPartidaEmAndamento();
			retorno = true;
			jogadorRemoto.assumirVencedor();
		} 
		if (informarQuantidadeDePeao(jogadorRemoto.cor) == 0) {
			terminarPartidaEmAndamento();
			retorno = true;
			jogadorLocal.assumirVencedor();
		} 

		return retorno;
	}

	public int informarLinhaSelecionada() {
		return linhaSelecionada;
	}

	public int informarColunaSelecionada() {
		return colunaSelecionada;
	}

	public void desselecionarPos() {
		linhaSelecionada = -1;
		colunaSelecionada = -1;
	}

	public Jogador informarJogadorLocal() {
		return jogadorLocal;
	}

	public Jogador informarJogadorRemoto() {
		return jogadorRemoto;
	}

	public void terminarPartidaEmAndamento() {
		partidaEmAndamento = false;
	}
}