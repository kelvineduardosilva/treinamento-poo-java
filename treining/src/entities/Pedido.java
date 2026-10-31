package entities;

import java.util.ArrayList;
import java.util.List;

import enumeracoes.StatusPedido;

public class Pedido {
	private int numero;
	private List<ItemPedido> itens = new ArrayList<>();
	private String cliente;
	private StatusPedido status;

	public Pedido(int numero, List<ItemPedido> itens, String cliente, StatusPedido status) {
		this.numero = numero;
		this.itens = itens;
		this.cliente = cliente;
		this.status = status;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

}
