package entidades;

public class Pessoa {//Classe Pessoa
	// Atributos
	private String nome;
	private Endereco endereco;
	private String cpf;
	private String rg;
	private String numero_celular;
	
	// Construtores
	// Construtor padrao
	public Pessoa() {
		
	}
	
	// Metodo Construtor que recebe os parametros nome, endereco, cpf, rg, e numero_celular 
	public Pessoa(String nome, Endereco endereco, String cpf, String rg, String numero_celular) {
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		this.rg = rg;
		this.numero_celular = numero_celular;
	}

	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNumero_celular() {
		return numero_celular;
	}

	public void setNumero_celular(String numero_celular) {
		this.numero_celular = numero_celular;
	}
	
}