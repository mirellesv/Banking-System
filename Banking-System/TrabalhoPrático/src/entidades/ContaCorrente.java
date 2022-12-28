package entidades;

public class ContaCorrente extends Conta{//Classe Conta Corrente e um tipo de Classe Conta
	// Atributos
	private float mensalidade;
	private float taxaRendimento;
	
	// Construtor
	public ContaCorrente(Pessoa pessoa) {
		super(pessoa);
		this.mensalidade = 12.0f;
		this.taxaRendimento = 0.12f;
	}
	
	// Metodo toString da classe ContaCorrente que herda do metodo toString
	// da classe Conta e adiciona o tipo de conta (polimorfismo)
	public String toString() {
		String informacoes = super.toString();
		
		informacoes += "\nTipo de conta: Corrente \n";
		
		return informacoes;
	}
	
	// Metodo pagarMensalidade da classe ContaCorrente que herda do metodo pagarMensalidade
	// da classe Conta e realiza o pagamento da mensalidade para contas correntes (polimorfismo)
	public void pagarMensalidade() {
		if(this.getSaldo() > mensalidade) { // Se o saldo for maior que o valor da mensalidade
			this.setSaldo(this.getSaldo() - mensalidade); // Valor da mensalidade e retirado do saldo da conta
			System.out.println("Mensalidade paga com sucesso! ");
		} else { // Se o valor da mensalidade for maior que o saldo, nao sera possivel pagar mensalidade
			System.out.println("Erro! Saldo e menor que a mensalidade a ser paga.");
		}
	}
	
	// Metodo renderSaldo da classe ContaCorrente que herda do metodo renderSaldo
	// da classe Conta e aplica o rendimento sobre o saldo para contas correntes (polimorfismo)
	public void renderSaldo() {		
		System.out.println("Rentabilidade da conta corrente: 12%");
		System.out.println("Saldo atual da conta: " + this.getSaldo());
		
		this.setSaldo(getSaldo()*taxaRendimento + getSaldo()); // Valor obtido do rendimento e adicionado a conta
		
		System.out.println("Rentabilidade aplicada com sucesso!");
	}
}
