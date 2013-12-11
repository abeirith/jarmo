package modelo;

import javax.swing.JLabel;

public class Posicao extends JLabel {
	protected Jogador ocupante;
	protected Posicao posPermitidas[];
	private int linha;
	private int coluna;
	
	public Posicao(){
		ocupante = null;
	}
	public Posicao(int linha, int coluna){
		ocupante = null;
		setLinha(linha);
		setColuna(coluna);
	}
	public Posicao(Jogador ocupante){
		this.ocupante = ocupante;
	}	

	public boolean ocupada() {
		return !(ocupante == null);
	}

	public Jogador informarOcupante() {
		return ocupante;
	}
	
	public void definirOcupante(Jogador ocupante){
		this.ocupante = ocupante;
	}
	
	public Posicao[] informarPosPermitidas() {
		return posPermitidas;
	}
	
	public void definirPosPermitidas(Posicao[] posPermitidas){
		this.posPermitidas = posPermitidas;
	}

	public boolean getPosPermitida(int linha, int coluna) {
		for (int i = 0; i < posPermitidas.length; i++) {
			if(posPermitidas[i].getLinha() == linha && posPermitidas[i].getColuna() == coluna){
				return true;
			}
		}
		return false;
	}
	
	public void esvaziar() {
		ocupante = null;
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