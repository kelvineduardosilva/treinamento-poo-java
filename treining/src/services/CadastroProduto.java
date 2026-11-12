package services;

import java.util.List;
import java.util.Scanner;

import classesConcretas.Bebidas;
import classesConcretas.Lanche;
import classesConcretas.Sobremesa;
import entities.Produto;
import enumeracoes.CategoriaProduto;
import excessoes.ExcessaoCategoriaInvalida;
import excessoes.ExcessaoCodigoInvalido;
import excessoes.ExcessaoNomeInvalido;
import excessoes.ExcessaoPrecoInvalido;

public class CadastroProduto {

	public static List cadastrar(List<Produto> lista) throws ExcessaoPrecoInvalido, ExcessaoNomeInvalido, ExcessaoCategoriaInvalida,
																ExcessaoCodigoInvalido {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Qual nome do produto?: ");
		String nome = entrada.nextLine();

		if(nome.matches(".*\\d.*")){
			 throw new ExcessaoNomeInvalido("O nome só pode conter letras!");
		}
		System.out.println("Qual Preço: ");
		double preco = entrada.nextDouble();
		entrada.nextLine();
		
			if(preco == 0 || preco == - 0) {
				 throw new ExcessaoPrecoInvalido("Preço não pode ser zero ou negativo!");
			}
		
		System.out.println("Qual código do produto?: ");
		int cod = entrada.nextInt();
		entrada.nextLine();
		
		for(int i = 0; i < lista.size(); i++) {
			int codigo = lista.get(i).getCodigo();
			if(codigo == cod) {
				 throw new ExcessaoCodigoInvalido(" Código ja existe!");
			}
		}


		System.out.println("Qual categoria?: ");
		System.out.println("1 - Lanche");
		System.out.println("2 - Bebidas");
		System.out.println("3 - Sobremesa");

		int dec = entrada.nextInt();
		entrada.nextLine();
		
		if(dec != 1 && dec != 2 && dec != 3) {
			throw new ExcessaoCategoriaInvalida(" Digite uma categoria válida!");
		}

		if (dec == 1) {
			System.out.println("Quantas gramas tem o Lanche?: ");
			int gramas = entrada.nextInt();
			CategoriaProduto categoria = CategoriaProduto.LANCHE;
			entrada.nextLine();
			Produto produto = new Lanche(nome, preco, cod, categoria, gramas);
			lista.add(produto);
		} else if (dec == 2) {
			System.out.println("Quantas Mls tem a Bebida?: ");
			int mls = entrada.nextInt();
			CategoriaProduto categoria = CategoriaProduto.BEBIDA;
			entrada.nextLine();
			Produto produto = new Bebidas(nome, preco, cod, categoria, mls);
			lista.add(produto);
		} else {
			System.out.println("Quantas calorias tem a sobremesa?: ");
			int calorias = entrada.nextInt();
			CategoriaProduto categoria = CategoriaProduto.SOBREMESA;
			entrada.nextLine();
			Produto produto = new Sobremesa(nome, preco, cod, categoria, calorias);
			lista.add(produto);
		}
		return lista;
	}
}
