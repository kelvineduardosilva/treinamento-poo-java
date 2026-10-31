package classesConcretas;

import java.util.List;

import entities.Produto;
import enumeracoes.CategoriaProduto;

public class Sobremesa extends Produto {
	private int calorias;

	public Sobremesa(String nome, double preco, int cod, CategoriaProduto categoria, int calorias) {
		super(nome, preco, cod, categoria);
		this.calorias = calorias;

	}

	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	@Override
	public void listarProduto(List<Produto> p, int pos) {
		
			super.listarProduto(p, pos);
			if (p.get(pos) instanceof Sobremesa sob) {
				System.out.println("Calorias: " + sob.getCalorias());
			
		}
	}
}
 