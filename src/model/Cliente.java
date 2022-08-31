package model;

public class Cliente {
	
	private int id_cliente;
	private String nome_cliente;
	private String nomesocial_cliente;
	private int idade_cliente;
	private String identidade_cliente;
	private String cpf_cliente;
	private String endereco_cliente;
	private String telefone_cliente;
	private String email_cliente;
	
	
	public Cliente() {
		
	}

	public Cliente(int id_cliente, String nome_cliente, String nomesocial_cliente, int idade_cliente,
			String identidade_cliente, String cpf_cliente, String endereco_cliente, String telefone_cliente,
			String email_cliente) {
		super();
		this.id_cliente = id_cliente;
		this.nome_cliente = nome_cliente;
		this.nomesocial_cliente = nomesocial_cliente;
		this.idade_cliente = idade_cliente;
		this.identidade_cliente = identidade_cliente;
		this.cpf_cliente = cpf_cliente;
		this.endereco_cliente = endereco_cliente;
		this.telefone_cliente = telefone_cliente;
		this.email_cliente = email_cliente;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getNomesocial_cliente() {
		return nomesocial_cliente;
	}

	public void setNomesocial_cliente(String nomesocial_cliente) {
		this.nomesocial_cliente = nomesocial_cliente;
	}

	public int getIdade_cliente() {
		return idade_cliente;
	}

	public void setIdade_cliente(int idade_cliente) {
		this.idade_cliente = idade_cliente;
	}

	public String getIdentidade_cliente() {
		return identidade_cliente;
	}

	public void setIdentidade_cliente(String identidade_cliente) {
		this.identidade_cliente = identidade_cliente;
	}

	public String getCpf_cliente() {
		return cpf_cliente;
	}

	public void setCpf_cliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}

	public String getEndereco_cliente() {
		return endereco_cliente;
	}

	public void setEndereco_cliente(String endereco_cliente) {
		this.endereco_cliente = endereco_cliente;
	}

	public String getTelefone_cliente() {
		return telefone_cliente;
	}

	public void setTelefone_cliente(String telefone_cliente) {
		this.telefone_cliente = telefone_cliente;
	}

	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}
	
	

}
