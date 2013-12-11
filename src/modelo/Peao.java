package modelo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Peao extends JLabel {
	private int cor; //1- branco, 2-preto
	private int linha;
	private int coluna;
	
	public Peao(int cor) {
		this.cor = cor;
	}	
	
	/** Retorna a imagem do peao */
	public ImageIcon getImagem(){
		if(this.cor == 1){
			return new ImageIcon(getClass().getResource("../interfaceGrafica/img/peao_branco.png"));
		}else{
			return new ImageIcon(getClass().getResource("../interfaceGrafica/img/peao_preto.png"));
		}
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	
}
