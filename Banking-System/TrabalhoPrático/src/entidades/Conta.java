package entidades;

public class Conta { // Classe Conta
	// Atributos
	private int numConta;
	private Pessoa pessoa;
	private float saldo;
	
	private static int ContadorDeContas = 1; // Contador de contas para ir gerando um numero de contas automaticamente 
											 // assim que uma conta cadastrada.
	
	// Construtores
	// Metodo construtor padrao
	public Conta() {
		
	}
	
	// Mwtodo construtor da classe com parametros de atributos da classe
	public Conta(int numConta, Pessoa pessoa, float saldo) {
		this.numConta = ContadorDeContas;
		this.pessoa = pessoa;
		this.saldo = saldo;
		ContadorDeContas += 1;
	}
	
	// Metodo construtor da classe com parametro um objeto instanciado da classe Pessoa
	public Conta(Pessoa pessoa) {
		this.pessoa = pessoa;
		this.numConta = ContadorDeContas;
		ContadorDeContas += 1;
	}

	// Getters e Setters
	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public String toString() { // Metodo toString para auxiliar quando for mostrar dados
		return "\nNumero da conta: " + this.getNumConta() +
				"\nNome: " + this.getPessoa().getNome() +
				"\nCPF: " + this.getPessoa().getCpf() +
				"\nEndereco" + "\nRua: " + this.getPessoa().getEndereco().getRua() +
				"\nNumero: " + this.getPessoa().getEndereco().getNumero() +
				"\nBairro: " + this.getPessoa().getEndereco().getBairro() +
				"\nSaldo: " + this.getSaldo() +
				"\n";
	}
	
	public void transferir(Conta ContaDeposito, float valor) { // Metodo transferir que recebe por parametro
															   // o objeto ContaDeposito da classe conta e o valor do tipo float
		if((valor > 0) && (this.getSaldo() >= valor)) { // Se o valor for maior que zero e o saldo da
														// conta remetente for maior ou igual ao valor a ser transferido
			setSaldo(getSaldo() - valor); // Valor e retirado da conta remetente
			
			ContaDeposito.setSaldo(ContaDeposito.getSaldo() + valor); // Valor e depositado na conta destinataria
			System.out.println("Transferencia de R$" + valor + " da conta " + this.getNumConta() + " para a conta " + ContaDeposito.getNumConta() + " realizada com sucesso!");
		} else if(valor < 0) { // Se o valor a ser transferido for menor que zero, nao sera possivel transferir
			System.out.println("Erro! Valor da transferencia nao pode ser negativo.");
		} else if(this.getSaldo() < valor) { // Se o valor a ser transferido for maior que o saldo da conta remetente, nao sera possivel transferir
			System.out.println("Erro! Conta nao possui dinheiro suficiente para realizar transferencia.");
		}
	}
	
	public void depositar(float deposito) { // Metodo depositar que recebe por parametro o valor do deposito
		if(deposito > 0) { // Se o deposito for maior que o zero
			this.setSaldo(this.getSaldo() + deposito); // E adicionado ao saldo da conta o deposito realizado
			System.out.println("Deposito de R$" + deposito + " na conta " + this.getNumConta() + " realizado com sucesso!");
		} else if(deposito < 0) { // Se o deposito for menor que zero, nao sera possivel depositar
			System.out.println("Erro! Nao e possivel valor de deposito negativo.");
		} else if(deposito == 0) { // Se o deposito for igual a zero, nao sera possivel depositar
			System.out.println("Erro! Nao e possivel valor de deposito nulo.");
		}
	}
	
	public void sacar(float saque) { // Metodo sacar que recebe por parametro o valor do saque
	if(saque > 0) { // Se o saque for maior que zero...
		if(this.getSaldo() > saque) { // Se o saldo for maior que o saque...
			this.setSaldo(this.getSaldo() - saque); // Faz o debito da conta
			System.out.println("Saque de R$" + saque + " na conta " + this.getNumConta() + " realizado com sucesso!");
		} else if(this.getSaldo() < saque){ // Se o saldo for menor que o saque, nao sera possivel sacar
			System.out.println("Erro! O saque e maior que o saldo disponivel.");
		} else if (saque < 0) { // Se o saque for negativo, nao sera possivel sacar
			System.out.println("Erro! O valor de saque nao pode ser negativo.");
		} else if(saque == 0) { // Se o saque for igual a zero, nao sera possivel sacar
			System.out.println("Erro! Nao e possivel valor de saque nulo.");
		}
	}
	}
	
	// Metodo pagarMensalidade
	public void pagarMensalidade() {
		
	}
	
	// Metodo pagarMensalidade
	public void renderSaldo() {
		
	}
}
