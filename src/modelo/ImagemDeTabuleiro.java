package modelo;

public class ImagemDeTabuleiro {
	
	protected int mapa[][] = new int [5][5];

	protected String mensagem;
	
	public ImagemDeTabuleiro(){
		for(int linha = 0; linha < 5; linha++){
			for(int coluna = 0; coluna < 5; coluna++){
				mapa[linha][coluna] = 0;
				if(linha == 0){
					mapa[linha][coluna] = 1;
				} 
				if(linha == 4){
					mapa[linha][coluna] = 2;
				} 
			}
		}
	}
	
	public String informarMensagem() {
		return mensagem;
	}

	public int informarValor(int linha, int coluna) {
		return mapa [linha][coluna]; 
	}

	public void assumirMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public void assumirValor(int linha, int coluna, int valor) {
		mapa [linha][coluna] = valor;
	}
}