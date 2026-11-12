package classesConcretas;

import java.util.List;

import entities.Produto;
import enumeracoes.CategoriaProduto;

public class Bebidas extends Produto {
	private int mm;

	public Bebidas(String nome, Double preco, int cod, CategoriaProduto categoria, int mm) {
		super(nome, preco , cod, categoria);
		this.mm = mm;
	}

	public int getMm() {
		return mm;
	}

	public void setMm(int mm) {
		this.mm = mm;
	}

	@Override
	public void listarProduto(List<Produto> p, int pos) {
		
			super.listarProduto(p, pos);
			if (p.get(pos) instanceof Bebidas bebidas) {
				System.out.println("Mls: " + bebidas.getMm());
			
		}

	}
}
