package application;

import java.util.Scanner;
import entities.ContaBancaria;

public class ProgramContaBancaria {

	public static void main(String[] args) {

		int numero = 0;
		String nome = "";
		double saldo = 0;
		String simOuNao;
		double saldoAtualizado;
		double saque;
		int numeroValid;
		String nomeValid;
		Scanner entrada = new Scanner(System.in);

		boolean controle = true;
		while (controle) {
			System.out.println("Digite o número da sua conta bancária(Precisa conter no minimo 5 digitos): ");
			numeroValid = entrada.nextInt();
			entrada.nextLine();
			if (String.valueOf(numeroValid).length() < 5) { // precisamos tranformar numero em str pq int nao tem
															// length() em java
				System.out.println("Erro! sua conta deve ter no minimo 5 digitos!");
			} else {
				numero += numeroValid;
				controle = false;
			}
		}
		
		controle = true;
		while(controle) {
			System.out.println("Digite o nome do titular: ");
			nomeValid = entrada.nextLine();
			if(nomeValid.length() < 3) {
				System.out.println("Digite um nome com no minimo 3 letras!");
			}
			else {
				nome = nomeValid;
				controle = false;
			}
		}
		

		controle = true;
		while (controle) {
			System.out.println("Você tem algum saldo inicial? (s/n)");
			simOuNao = entrada.nextLine();

			if (simOuNao.trim().toLowerCase().equals("s")) {
				System.out.println("Òtimo! Digite o seu saldo inicial: ");
				saldo = entrada.nextDouble();
				controle = false;
			} else if (simOuNao.trim().toLowerCase().equals("n")) {
				saldo = 0;
				controle = false;
			} else {
				System.out.println("Digite uma resposta válida! (s/n)");
			}

		}
		ContaBancaria contabancaria = new ContaBancaria(numero, nome, saldo);
		System.out.println("Dados da conta: ");
		listarDados(contabancaria);

		System.out.println("Digite o valor a ser depositado: ");
		saldoAtualizado = entrada.nextInt();
		saldo += saldoAtualizado;
		contabancaria.setSaldoConta(saldo);

		System.out.println("Dados atualizados: ");

		listarDados(contabancaria);

		System.out.println("Digite o valor a ser sacado(Cobramos R$5 de taxa!): ");
		saque = entrada.nextDouble();
		saldo -= saque + 5;
		contabancaria.setSaldoConta(saldo);

		System.out.println("Saque bem sucedido! dados: ");
		listarDados(contabancaria);

	}

	public static void listarDados(ContaBancaria conta) {

		System.out.println("Número da conta: " + conta.getNumeroConta());
		System.out.println("Nome: " + conta.getNomeConta());
		System.out.printf("Saldo: %.2f%n", conta.getSaldoConta());
		/*
		 * aqui aconteceu uma coisa interessante. Criamos o metodo listarDados
		 * justamente pra eu economizar tempo e deixar o codigo menor ja que vou listar
		 * os dados varias vezes! porem, como nesse metodo eu teria que criar um objeto
		 * da classe pra poder usar os gets, eu teria que passar parametros ao criar o
		 * objeto pq eu coloquei um construtor na minha classe, e eu nao tenho os
		 * valores nesse metodo pra passar como parametro, entao eu crio o metodo,
		 * dizendo que pra ele funcionar, ele vai precisar de um valor no parametro do
		 * tipo ContaBancaria, e esse valor vai cair dentro da variavel conta. E ai
		 * quando for utilizar esse método na main, basta passar o objeto de
		 * ContaBancaria como parametro! com isso, a variavel conta la no metodo, recebe
		 * o objeto de ContaBancaria como valor, e podemos usar a variavel conta pra
		 * acessar os gets
		 */
	}

}
