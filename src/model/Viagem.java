package model;



public class Viagem {
	
	private int id_viagem;
	private String data_ida;
	private String data_volta;
	private double preco;
	
	 private Origem origem;
	 private Destino destino;
	 
	public Viagem() {
		
	}

	public Viagem(int id_viagem, String data_ida, String data_volta, double preco, Origem origem, Destino destino) {
		super();
		this.id_viagem = id_viagem;
		this.data_ida = data_ida;
		this.data_volta = data_volta;
		this.preco = preco;
		this.origem = origem;
		this.destino = destino;
	}

	public int getId_viagem() {
		return id_viagem;
	}

	public void setId_viagem(int id_viagem) {
		this.id_viagem = id_viagem;
	}

	public String getData_ida() {
		return data_ida;
	}

	public void setData_ida(String data_ida) {
		this.data_ida = data_ida;
	}

	public String getData_volta() {
		return data_volta;
	}

	public void setData_volta(String data_volta) {
		this.data_volta = data_volta;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	
}
