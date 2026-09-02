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
		ContaBancaria contabancaria;
		if(saldo > 0.00) {
		     contabancaria = new ContaBancaria(numero, nome, saldo);
		}
		else {
			 contabancaria = new ContaBancaria(numero, nome);
		}
		/*dessa forma eu crio a variavel do objeto fora do if else e atribuo um valor a ele dentro do if else. Caso eu nao fizesse
		 * isso eu nao conseguiria usar o objeto por conta do escopo do if else que não deixaria*/
		
		
		/*aqui eu preciso de um if else a parte só pra ver qual objeto criar pq o java nao aceita o if else que esta no while,
		 * pelo fato dele nao levar em consideração a lógica que faz que o while rode pelo menos uma vez, criando um objeto. en
		 * tao por nao confiar que o while vai rodar, ele recusa a deixar. Portanto criei um if else só pra isso. */
		
		System.out.println("Dados da conta: ");
		System.out.println(contabancaria.toString());

		System.out.println("Digite o valor a ser depositado: ");
		saldoAtualizado = entrada.nextInt();
		saldo = saldoAtualizado;
		contabancaria.deposito(saldo);

		System.out.println("Dados atualizados: ");

		System.out.println(contabancaria.toString());

		System.out.println("Digite o valor a ser sacado(Cobramos R$5 de taxa!): ");
		saque = entrada.nextDouble();
		
		contabancaria.saque(saque);

		System.out.println("Saque bem sucedido! dados: ");
		System.out.println(contabancaria.toString());
		
		
		
		entrada.close();

	}


}
