package entities;

import java.util.List;

import enumeracoes.CategoriaProduto;

public class Produto {
	private String nome;
	private Double preco;
	private int codigo;
	private CategoriaProduto categoria;

	public Produto(String nome, Double preco, int codigo, CategoriaProduto categoria) {
		this.nome = nome;
		this.preco = preco;
		this.codigo = codigo;
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public CategoriaProduto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProduto categoria) {
		this.categoria = categoria;
	}

	public void listarProduto(List<Produto> p, int pos) {
		
			System.out.println("Nome : " + p.get(pos).getNome());
			System.out.println("Preço: " + p.get(pos).getPreco());
			System.out.println("Código do produto: " + p.get(pos).getCodigo());
			System.out.println("Categoria: " + p.get(pos).getCategoria());
	}
}
