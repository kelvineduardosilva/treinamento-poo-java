
package services;

import java.util.List;
import java.util.Scanner;

import entities.ItemPedido;
import entities.Pedido;
import entities.Produto;
import enumeracoes.StatusPedido;
import excessoes.ExcessaoCodigoPedidoInexistente;
import excessoes.ExecessaoListaProdutoVazia;

public class AdicionaProdutoAoPedido {

    public static List<Pedido> Adicionar(
            List<Pedido> listaPedido,
            List<Produto> listaProduto,
            List<ItemPedido> itens,
            StatusPedido status)
            throws ExcessaoCodigoPedidoInexistente, ExecessaoListaProdutoVazia {

        Scanner entrada = new Scanner(System.in);

        if (listaProduto.isEmpty()) {
            throw new ExecessaoListaProdutoVazia("Nenhum produto existente!");
        }

        System.out.println("Qual código do produto?: ");
        int cod = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Qual quantidade?: ");
        int quantidade = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Qual nome do cliente?: ");
        String nomeCliente = entrada.nextLine();

        System.out.println("Qual número do pedido? ");

        System.out.println("Pedidos existentes: ");
        for (int i = 0; i < listaPedido.size(); i++) {
            System.out.println(listaPedido.get(i).getNumero());
        }

        int numeroP = entrada.nextInt();
        entrada.nextLine();

        Pedido pedido = null;

        for (int i = 0; i < listaPedido.size(); i++) {

            if (listaPedido.get(i).getNumero() == numeroP) {
                pedido = listaPedido.get(i);
                break;
            }
        }

        if (pedido == null) {
            throw new ExcessaoCodigoPedidoInexistente("Pedido não encontrado!");
        }

        Produto produto = null;

        for (int i = 0; i < listaProduto.size(); i++) {

            if (listaProduto.get(i).getCodigo() == cod) {
                produto = listaProduto.get(i);
                break;
            }
        }

        if (produto == null) {
            throw new ExcessaoCodigoPedidoInexistente("Produto não encontrado!");
        }

        ItemPedido item = new ItemPedido(produto, quantidade);

        if (pedido.getItens() == null) {
            pedido.setItens(new java.util.ArrayList<>());
        }

        pedido.getItens().add(item);
        pedido.setCliente(nomeCliente);
        pedido.setStatus(status);

        System.out.println("Produto adicionado ao pedido " + numeroP + " com sucesso!");

        return listaPedido;
    }
}
