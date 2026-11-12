package classesConcretas;

import java.util.List;

import entities.Produto;
import enumeracoes.CategoriaProduto;

public class Lanche extends Produto {
	private int gramas;

	public Lanche(String nome, Double preco,int codigo, CategoriaProduto categoria, int gramas) {
		super(nome, preco, codigo, categoria);
		this.gramas = gramas;
	}

	public int getGramas() {
		return gramas;
	}

	public void setGramas(int gramas) {
		this.gramas = gramas;
	}
	@Override
	public void listarProduto(List<Produto> p, int pos) {

			super.listarProduto(p, pos); //isso tras a logica inteira sem eu precisar escrever denovo
			if(p.get(pos) instanceof Lanche lanche) {
				System.out.println("gramas: " + lanche.getGramas());// como produto é do tipo Produto nao do tipo lanche, o java nao encontrava o 
				                                                    // o getLanche. O intanceof verifica se o tipo do dado da lista é do mesmo tipo
																	// de lanche, e permite achar o getLanche.
		}
	}
	
	

}
