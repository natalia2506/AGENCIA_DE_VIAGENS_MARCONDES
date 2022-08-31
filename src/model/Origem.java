package model;

public class Origem {
	
	private int id_origem;
	private String nome_origem;
	private String pais_origem;
	
	public Origem() {
		
	}

	public Origem(int id_origem, String nome_origem, String pais_origem) {
		super();
		this.id_origem = id_origem;
		this.nome_origem = nome_origem;
		this.pais_origem = pais_origem;
	}

	public int getId_origem() {
		return id_origem;
	}

	public void setId_origem(int id_origem) {
		this.id_origem = id_origem;
	}

	public String getNome_origem() {
		return nome_origem;
	}

	public void setNome_origem(String nome_origem) {
		this.nome_origem = nome_origem;
	}

	public String getPais_origem() {
		return pais_origem;
	}

	public void setPais_origem(String pais_origem) {
		this.pais_origem = pais_origem;
	}
	

}
