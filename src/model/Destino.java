package model;

public class Destino {
	
	private int id_destino;
	private String nome_destino;
	private String pais_destino;
	
	
	
	public Destino() {
	}



	public Destino(int id_destino, String nome_destino, String pais_destino) {
		super();
		this.id_destino = id_destino;
		this.nome_destino = nome_destino;
		this.pais_destino = pais_destino;
	}



	public int getId_destino() {
		return id_destino;
	}



	public void setId_destino(int id_destino) {
		this.id_destino = id_destino;
	}



	public String getNome_destino() {
		return nome_destino;
	}



	public void setNome_destino(String nome_destino) {
		this.nome_destino = nome_destino;
	}



	public String getPais_destino() {
		return pais_destino;
	}



	public void setPais_destino(String pais_destino) {
		this.pais_destino = pais_destino;
	}
	
	

}
