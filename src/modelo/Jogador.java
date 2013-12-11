package modelo;

public class Jogador {
	protected int cor; //1 - preto e 2 - branco
	protected boolean daVez;
	protected boolean vencedor;
	protected String nome;
	
	public Jogador(){
		
	}
	
	public void habilitar() {
		daVez = true;
	}
	
	public void iniciar(String nome, int cor) {
		this.cor = cor;
		daVez = false;
		vencedor = false;
		this.nome = nome;
	}
	
	public void reiniciar() {
		daVez = false;
		vencedor = false;
	}
	
	public void desabilitar() {
		daVez = false;
	}
	
	public boolean informarDaVez() {
		return daVez;
	}

	public String informarNome() {
		return nome;
	}
	
	public int informarCor(){
		return cor;
	}
	
	public String getCor(){
		if(cor == 1){
			return "pretos";
		}
		if(cor == 2){
			return "brancos";
		}
		return "";
	}
	
	public void assumirVencedor(){
		vencedor = true;
	}
	
	public boolean informarVencedor(){
		return vencedor;
	}

}