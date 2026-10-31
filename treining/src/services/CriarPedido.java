
package services;

import java.util.List;

import entities.Pedido;

public class CriarPedido {

	public static List<Pedido> criarPedido(List<Pedido> p) {

		int pedido = 1;

		boolean existe = true;

		while (existe) {

			existe = false;

			for (int i = 0; i < p.size(); i++) {

				if (pedido == p.get(i).getNumero()) {

					pedido++;
					existe = true;
					break;

				}
			}
		}

		Pedido pedidoI = new Pedido(pedido, null, null, null);

		p.add(pedidoI);

		System.out.println("Pedido " + pedido + " criado com sucesso!");

		return p;
	}
}
