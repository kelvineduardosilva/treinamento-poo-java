
package services;

import java.util.List;

import entities.ItemPedido;
import entities.Pedido;

public class ListarPedidos {

    public static void listarPedidos(List<Pedido> p) {

        for (int i = 0; i < p.size(); i++) {

            Pedido pedido = p.get(i);

            // Não listar pedidos sem produtos
            if (pedido.getItens() == null || pedido.getItens().isEmpty()) {
                continue;
            }

            double totalPedido = 0;

            System.out.println("----------------------------");
            System.out.println("Cliente: " + pedido.getCliente());
            System.out.println("Número Pedido: " + pedido.getNumero());

            for (int j = 0; j < pedido.getItens().size(); j++) {

                ItemPedido item = pedido.getItens().get(j);

                System.out.println("----------------------------");
                System.out.println("Código Produto: " + item.getProduto().getCodigo());
                System.out.println("Nome Produto: " + item.getProduto().getNome());
                System.out.println("Categoria Produto: " + item.getProduto().getCategoria());
                System.out.println("Preço Produto: " + item.getProduto().getPreco());
                System.out.println("Quantidade: " + item.getQuantidade());
                System.out.println("Status" + pedido.getStatus());
                

                double subtotal = item.getProduto().getPreco() * item.getQuantidade();

                System.out.println("Subtotal: " + subtotal);

                totalPedido += subtotal;
            }

            System.out.println("----------------------------");
            System.out.println("TOTAL DO PEDIDO: R$ " + totalPedido);
            System.out.println("----------------------------");
        }
    }
}
