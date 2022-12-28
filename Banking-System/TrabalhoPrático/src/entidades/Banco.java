package entidades;

import java.util.Scanner;
import java.util.ArrayList;

public class Banco {
	// Criando um array da classe conta com o nome de "ContasBancarias".
	static ArrayList<Conta> ContasBancarias = new ArrayList<>();
	// Declarando a variavel "input" da classe scanner para auxiliar na leitura de dados
	static Scanner input = new Scanner(System.in);
	
	public static void operacoes() {
		//Apresentacao do menu
		System.out.println("===========================================");
		System.out.println("======= Bem-vindo a agencia Olimpia =======");
		System.out.println("===========================================");
		System.out.println("Selecione uma operacao que deseja realizar: ");
		System.out.println("===========================================");
		System.out.println("[1] Criar conta");
		System.out.println("[2] Apagar conta");
		System.out.println("[3] Mostrar todas as contas");
		System.out.println("[4] Transferir");
		System.out.println("[5] Depositar");
		System.out.println("[6] Sacar");
		System.out.println("[7] Pagar mensalidade");
		System.out.println("[8] Aplicar rendimento");
		System.out.println("[9] Mostrar conta");
		System.out.println("[10] Sair");
		
		int opcao = input.nextInt(); // Variavel declarada para receber a entrada de opcao do usuario
		
		switch(opcao) {
		case 1:
			abrirConta(); // Chamada do metodo abrirConta
			break;
		case 2:
			apagarConta(); // Chamada do metodo apagarConta
			break;
		case 3:
			listar(); // Chamada do metodo listar
			break;
		case 4:
			transferir(); // Chamada do metodo transferir
		case 5:
			depositar(); // Chamada do metodo depositar
		case 6:
			sacar(); // Chamada do metodo sacar
		case 7:
			pagarMensalidade(); // Chamada do metodo pagarMensalidade
		case 8:
			renderSaldo(); // Chamada do metodo renderSaldo
		case 9:
			mostrarDados(); // Chamada do metodo mostrarDados
		case 10: // Caso o usuario escolha a opcao 10, o programa ira parar
			System.out.println("Saindo....."); // Mensagem informativa
			System.out.println("Agradecemos a preferencia :)"); // Mensagem informativa
			System.exit(0);
		
		default: // Caso o usuario digite uma opcao invalida, o procedimento operacoes e chamado novamente
			System.out.println("Opcao invalida!"); // Mensagem informativa
			operacoes(); // Chamada das operacoes
			break;
		}
	}
	
	// Metodo abrirConta
	public static void abrirConta() {
		System.out.println("========== Abrindo conta ==========");
		// Pedindo dados ao usuario
		System.out.println("\nNome: "); // Pedindo dados ao usuario
		input.nextLine();
		String nome = input.nextLine(); // Instaciacao do objeto nome da classe String que recebe por atribuicao o 
										// nome inserido pelo usuario
		
		System.out.println("\nInserindo endereco... ");
		System.out.println("Rua: ");
		String rua = input.nextLine(); // Instaciacao do objeto rua da classe String que recebe por atribuicao o 
									   // nome da rua inserido pelo usuario
		
		System.out.println("Numero: ");
		int numero = input.nextInt(); // Declaracao da variavel numero do tipo inteiro que recebe por atribuicao
									  // o numero da residencia inserido pelo usuario
		
		System.out.println("Bairro: ");
		input.nextLine();
		String bairro = input.nextLine(); // Instanciacao do objeto bairro da classe String que recebe por atribuicao o 
		   								  // nome do bairro inserido pelo usuario
		
		System.out.println("CPF: ");
		String cpf = input.next(); // Instanciacao do objeto cpf da classe String que recebe por atribuicao o 
			  					   // cpf inserido pelo usuario
		
		System.out.println("RG: ");
		String rg = input.next(); // Instanciacao do objeto rg da classe String que recebe por atribuicao o 
		   						  // cpf inserido pelo usuario
		
		System.out.println("Numero de celular: ");
		String numero_celular = input.next(); // Instaciacao do objeto numero_elular da classe String que recebe por atribuicao o 
			  							      // numero do celular inserido pelo usuario
		
		// Instancia de um objeto da classe Endereco
		Endereco endereco = new Endereco(rua, numero, bairro);
		
		// Instancia de um objeto da classe Pessoa
		Pessoa pessoa = new Pessoa(nome, endereco, cpf, rg, numero_celular);
		
		System.out.println("Qual sera o tipo de conta?");
		System.out.println("(Digite C para Corrente ou P para Poupanca)");
		String tipo = input.next(); // Declaracao do objeto tipo da classe
									// String que recebe por atribuicao
									// o tipo de conta que o usuario deseja
		
		if(tipo.equals("C") || tipo.equals("c")){ // Se o tipo de conta for do tipo Corrente
			ContaCorrente contac = new ContaCorrente(pessoa); // Instanciacao do objeto contac
															  // da classe Conta Corrente
			
			ContasBancarias.add(contac); // A conta criada e inserida no ArrayList
			
			System.out.println("Sua conta foi criada com sucesso!");
			System.out.println(contac.toString()); // Mostra os dados da conta recem criada
			operacoes();
		} else if (tipo.equals("P") || tipo.equals("p")) { // Se o tipo de conta for do tipo Poupanca
			ContaPoupanca contap = new ContaPoupanca(pessoa); // Instanciacao do objeto contap
			  												  // da classe Conta Poupanca
			
			ContasBancarias.add(contap); // A conta criada e inserida no ArrayList
			
			System.out.println("Sua conta foi criada com sucesso!");
			System.out.println(contap.toString()); // Mostra os dados da conta recem criada
			operacoes();  // Apos realizada a operacao abrirConta, o usuario e levado
			 			  // novamente ao menu
		} else {
			System.out.println("Erro! Insira uma resposta valida.");
			abrirConta(); // O metodo abrirConta e chamado ate que o usuario insira uma resposta valida
		}
		
	}
	
	// Metodo apagarConta
	public static void apagarConta() {
		System.out.println("========== Apagando conta =========="); // Mensagem informativa
		if(ContasBancarias.size() > 0) { // Verifica se o ArrayList possui contas cadastradas
			System.out.println("Numero da conta a ser removida: "); // Pedindo o numero da conta
			int numConta = input.nextInt(); // Declaracao da variavel numContaRemetente do tipo
											// inteiro que recebe por atribuicao o numero
											// inserido pelo usuario
			
			ContasBancarias.remove(numConta - 1); // Conta e removida do Arraylist pela sua verdadeira posicao
			
			System.out.println("Conta " + numConta + " removida com sucesso! "); // Mensagem informativa
		} else {
			System.out.println("Nao ha nenhuma conta cadastrada."); // Nao e possivel apagar conta se nao houverem contas cadastradas
		}
		operacoes(); // Apos realizada a operacao apagarConta, o usuario e levado
		 			 // novamente ao menu  
	}
	
	// Metodo listar
	public static void listar() {
		System.out.println("========== Contas cadastradas =========="); // Mensagem informativa
		if(ContasBancarias.size() > 0) { // Verifica se o ArrayList possui contas cadastradas
			for(Conta conta: ContasBancarias) { // Para cada objeto "conta" de ContasBancarias da classe Conta
				System.out.println(conta); // Imprime o objeto conta
			} 
		} else {
				System.out.println("Nao ha contas cadastradas"); // Caso nao existam contas cadastradas
																 // e exibida uma mensagem de aviso
		}
		operacoes(); // Apos realizada a operacao listar, o usuario e levado
	     			 // novamente ao menu 
	}
	
	public static Conta encontrarConta(int numConta) { // Metodo do tipo Conta que recebe o numero
													   // da conta por parâmetro inserida pelo usuario
		Conta conta = null; // Declaracao do objeto conta da classe Conta que
							// e anulado
		
		if(ContasBancarias.size() > 0) { // Verifica se o ArrayList possui contas cadastradas
			for(Conta c: ContasBancarias) { // ArrayList sera percorrido para c 
				if(c.getNumConta() == numConta) { // Verifica se o objeto c possui um numero
												  // de conta igual ao numConta
					conta = c; // conta recebe por atribuicao o objeto c
				}
			}
		}
		
		return conta; // Retorna o objeto conta
	}
	
	// Metodo transferir
	public static void transferir() {
		System.out.println("============== Transferencia =============="); // Mensagem informativa
		System.out.println("Numero da conta do remetente: "); // Pedindo o numero da conta do remetente
		int numContaRemetente = input.nextInt(); // Declaracao da variavel numContaRemetente do tipo
												 // inteiro que recebe por atribuicao o numero
												 // inserido pelo usuario
		
		Conta contaRemetente = encontrarConta(numContaRemetente); // Instanciacao do objeto contaRemetente da
																  // clase Conta, que recebe por atribuicao
																  // o retorno do metodo encontrarConta
																	
		if(contaRemetente != null) { // Verifica se a conta retornada pelo metodo encontrarConta nao esta vazia
			System.out.println("Numero da conta do destinatario: "); // Pedindo ao usuario o numero da conta do destinatario
			int numContaDestinatario = input.nextInt(); // Declaracao da variavel numContaDestinatario do tipo
														// inteiro que recebe por atribuicao o numero
														// inserido pelo usuario
			
			Conta contaDestinatario = encontrarConta(numContaDestinatario); // Instanciacao do objeto contaDestinatario da
																			// clase Conta, que recebe por atribuicao
																			// o retorno do metodo encontrarConta
			
			if(contaDestinatario != null) { // Verifica se a conta retornada pelo metodo encontrarConta nao esta vazia
				System.out.println("Valor da transferencia: "); // Mensagem informativa
				float valor = input.nextFloat(); // Declaracao da variavel valor do tipo float, que recebe
												 // por atribuicao o valor inserido pelo usuario
				
				System.out.println("=============================");
				System.out.println("Dados antes da transferencia: ");// Sera mostrado na tela o retorno do metodo toString dos objetos 
																	 // contaRemetente e contaDestinatario antes da transferencia
				System.out.println(contaRemetente.toString()); 
				System.out.println(contaDestinatario.toString());
				
				contaRemetente.transferir(contaDestinatario, valor);
				
				System.out.println("Dados depois da transferencia: ");// Sera mostrado na tela o retorno do metodo toString dos objetos 
				 													  // contaRemetente e contaDestinatario depois da transferencia
				System.out.println(contaRemetente.toString());
				System.out.println(contaDestinatario.toString());
				System.out.println("============================");
				operacoes(); // Apos realizada a operacao transferir, o usuario e levado
	 			    	     // novamente ao menu 
			} else {
				System.out.println("Conta destinataria nao encontrada! Insira uma conta valida.");
				transferir(); // O metodo depositar e chamado ate o usuario inserir um
	 			 			  // numero de conta destinataria valido
			}	
		} else {
			System.out.println("Conta remetente nao encontrada! Insira uma conta valida.");
			transferir(); // O metodo depositar e chamado ate o usuario inserir um
			 			  // numero de conta remetente valido
		}
	}
	
	// Metodo depositar
	public static void depositar() {
		System.out.println("============== Deposito =============="); // Mensagem informativa
		System.out.println("Numero da conta: "); // Pedindo ao usuario o numero da conta
		int numConta = input.nextInt(); // Declaracao da variavel numConta do tipo
										// inteiro que recebe por atribuicao o numero
										// inserido pelo usuario
		
		Conta conta = encontrarConta(numConta); // Instanciacao do objeto conta da
												// clase Conta, que recebe por atribuicao
												// o retorno do metodo encontrarConta
		
		if(conta != null) {  // Verifica se a conta retornada pelo metodo encontrarConta nao esta vazia
			System.out.println("Insira o valor a ser depositado: "); // Pedindo o valor que ira ser depositado
			float valorDeposito = input.nextFloat(); // Declaracao da variavel valorDeposito
													 // do tipo float que recebe por atribuicao
													 // o valor desejado pelo usuario
			
			System.out.println("============ Antes do deposito ============");
			System.out.println(conta.toString()); // Sera mostrado na tela o retorno do metodo toString do objeto conta
			   									  // antes do deposito
			
			conta.depositar(valorDeposito); // Chamada do metodo depositar do objeto conta
			
			System.out.println("============ Depois do deposito ============");
			System.out.println(conta.toString()); // Sera mostrado na tela o retorno do metodo toString do objeto conta
			   								      // depois do deposito
			operacoes(); // Apos realizada a operacao depositar, o usuario e levado
			 			 // novamente ao menu 
		} else {
			System.out.println("Conta nao encontrada! Insira um numero de conta valido.");
			depositar(); // O metodo depositar e chamado ate o usuario inserir um
			 			 // numero de conta valido
		}
	}
	
	// Metodo sacar
	public static void sacar() {
		System.out.println("========== Saque =========="); // Mensagem informativa
		System.out.println("Numero da conta: ");  // Pedindo o numero da conta
		int numConta = input.nextInt(); // Declaracao da variavel numConta do tipo
										// inteiro que recebe por atribuicao o numero
										// inserido pelo usuario
		
		Conta conta = encontrarConta(numConta); // Instanciacao do objeto conta da
												// clase Conta, que recebe por atribuicao
												// o retorno do metodo encontrarConta
		
		if(conta != null) { // Verifica se a conta retornada pelo metodo encontrarConta nao esta vazia
			System.out.println("Insira o valor a ser sacado: "); // Pedindo o valor que ira ser sacado
			float valorSacado = input.nextFloat(); // Declaracao da variavel valorSacado
												   // do tipo float que recebe por atribuicao
												   // o valor desejado pelo usuario
			
			System.out.println("============ Antes do saque ============");
			System.out.println(conta.toString());  // Sera mostrado na tela o retorno do metodo toString do objeto conta
			  									   // antes do saque
			
			conta.sacar(valorSacado); // Chamada do metodo sacar do objeto conta
			
			System.out.println("============ Depois do saque ============");
			System.out.println(conta.toString());  // Sera mostrado na tela o retorno do metodo toString do objeto conta
			  									 // depois do saque
			operacoes(); // Apos realizada a operacao sacar, o usuario e levado
			 			 // novamente ao menu 
		} else {
			System.out.println("Conta nao encontrada! Insira um numero de conta valido.");
			sacar(); // O metodo sacar e chamado ate o usuario inserir um
					 // numero de conta valido
		}
	}
	
	// Metodo pagarMensalidade
	public static void pagarMensalidade() {
		System.out.println("============ Pagar mensalidade ============"); // Mensagem informativa
		System.out.println("Numero da conta: "); // Pedindo ao usuario o numero da conta 
		int numConta = input.nextInt(); // Declaracao da variavel numConta do tipo
										// inteiro que recebe por atribuicao o numero
										// inserido pelo usuario
		
		Conta conta = encontrarConta(numConta); // Instanciacao do objeto conta da
		   										// clase Conta, que recebe por atribuicao
		   										// o retorno do metodo encontrarConta
		
		if(conta != null) { // Verifica se a conta retornada pelo metodo encontrarConta nao esta vazia
			System.out.println("========== Antes do pagamento ===========");
			System.out.println(conta.toString()); // Sera mostrado na tela o retorno do metodo toString do objeto conta
			  									  // antes do pagamento da mensalidade
			
			conta.pagarMensalidade(); // Chamada do metodo pagarMensalidade do objeto conta
			
			System.out.println("========== Depois do pagamento ==========");
			System.out.println(conta.toString()); // Sera mostrado na tela o retorno do metodo toString do objeto conta
			  									  // depois do pagamento da mensalidade
			operacoes(); // Apos realizada a operacao pagarMensalidade, o usuario e levado
			 			 // novamente ao menu 
		} else {
			System.out.println("Conta nao encontrada! Insira um numero de conta valido.");
			pagarMensalidade(); // O metodo pagarMensalidade e chamado ate o usuario inserir um
			   					// numero de conta valido
		}
	}
	
	// Metodo renderSaldo
	public static void renderSaldo() {
		System.out.println("=========== Rendimento ============="); // Mensagem ilustrativa
		System.out.println("Numero da conta: "); // Interacao com o usuario pedindo o numero da conta
		int numConta = input.nextInt(); // Declaracao da variavel numConta do tipo inteiro, que
										// recebe por atribuicao o numero inserido
										// pelo usuario
		
		Conta conta= encontrarConta(numConta); // Instanciacao do objeto conta da
											   // clase Conta, que recebe por atribuicao
											   // o retorno do metodo encontrarConta
		
		if(conta != null) { // Verifica se a conta retornada pelo metodo encontrarConta nao esta vazia
			System.out.println("========== Antes do rendimento =======");
			System.out.println(conta.toString()); // Sera mostrado na tela o retorno do metodo toString do objeto conta
												  // antes do rendimento
			conta.renderSaldo(); // Chamada do metodo renderSaldo 
			
			System.out.println("========== Rendimento apos 1 ano ========");
			System.out.println(conta.toString());// Sera mostrado na tela o retorno do metodo toString do objeto conta
			  									 // depois do rendimento
			operacoes(); // Apos realizada a operacao renderSaldo, o usuario e levado
						 // novamente ao menu 
		} else {
			System.out.println("Conta nao encontrada! Insira um numero de conta valido."); // Mensagem informativa
			renderSaldo(); // O metodo renderSaldo e chamado ate o usuario inserir um
						   // numero de conta valido
		}
	}
	
	// Metodo mostrarDados
	public static void mostrarDados() {
		System.out.println("=========== Mostrar conta =========="); // Mensagem informativa
		System.out.println("Numero da conta: "); // Pedindo o numero da conta que voce deseja consultar
		int numConta = input.nextInt(); // Variavel recebe a entrada do teclado e armazena 
		
		Conta conta = encontrarConta(numConta); // Instancia do objeto conta da classe Conta
												// que recebe por atribuicao o retorno do
												// metodo encontrarConta
		
		System.out.println("================================="); // Mensagem ilustrativa
		if(conta != null) { //Verifica se a conta retornada pelo metodo encontrarConta nao esta vazia
			System.out.println("Dados da conta encontrada: "); // Mensagem informativa
			System.out.println(conta.toString()); // Sera mostrado na tela o retorno do metodo toString da classe Conta
			operacoes(); /// Operacao realizada, o usuario e levado novamente ao menu
		} else if(ContasBancarias.size() > 0){ // Verifica se existem contas no ArrayList
			System.out.println("Conta nao existente! Insira um numero de conta valido.");// Mensagem informativa
			mostrarDados(); // Caso existam contas no ArrayList e o numero de conta for invalido,
							// o usuario sera levado novamente ao metodo mostrarDados
		} else {
			System.out.println("Nao existem contas cadastradas no momento."); // Mensagem informativa
			operacoes(); // Nao existem contas no ArrayList e o usuario e levado
						 // ao menu
		}
	}
}

