package entidades;

public class ContaPoupanca extends Conta{//Classe Conta Poupanca e um tipo de Classe Conta
	// Atributos
	private float taxaRendimento = 0.03f;
	private float mensalidade = 0.0f;
	
	public float getTaxaRendimento() {
		return taxaRendimento;
	}

	public void setTaxaRendimento(float taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}

	// Construtor
	public ContaPoupanca(Pessoa pessoa) {
		super(pessoa);
	}
	
	// Metodo toString da classe ContaPoupanca que herda do metodo toString
	// da classe Conta e adiciona o tipo de conta (polimorfismo)
	public String toString() {
		String informacoes = super.toString();
		
		informacoes += "\nTipo de Conta: Poupanca \n";
		
		return informacoes;
	}
	
	// Metodo pagarMensalidade da classe ContaPoupanca que herda do metodo pagarMensalidade
	// da classe Conta e realiza o pagamento da mensalidade para contas poupancas (polimorfismo)
	public void pagarMensalidade() {
		System.out.println("Conta do tipo poupanca e isenta de taxa de mensalidade.");
	}
	
	// Metodo renderSaldo da classe ContaPoupanca que herda do metodo renderSaldo
		// da classe Conta e aplica o rendimento sobre o saldo para contas poupancas (polimorfismo)
	public void renderSaldo() {
		
		System.out.println("Rentabilidade da conta poupanca: 3%");
		System.out.println("Saldo atual da conta: " + this.getSaldo());
		
		this.setSaldo(getSaldo()*taxaRendimento + getSaldo());
		
		System.out.println("Rentabilidade aplicada com sucesso!");
	}
}
