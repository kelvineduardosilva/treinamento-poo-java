package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.ItemPedido;
import entities.Pedido;
import entities.Produto;
import enumeracoes.StatusPedido;
import excessoes.ExcessaoCategoriaInvalida;
import excessoes.ExcessaoCodigoInvalido;
import excessoes.ExcessaoCodigoPedidoInexistente;
import excessoes.ExcessaoFormaPagamentoInvalida;
import excessoes.ExcessaoNomeInvalido;
import excessoes.ExcessaoNumeroPagamentoInvalido;
import excessoes.ExcessaoPrecoInvalido;
import excessoes.ExecessaoListaProdutoVazia;
import services.AdicionaProdutoAoPedido;
import services.CadastroProduto;
import services.CriarPedido;
import services.EfetuarPagamento;
import services.ListarPedidos;

public class Program {

	public static void main(String[] args) throws ExcessaoFormaPagamentoInvalida {
		Scanner entrada = new Scanner(System.in);

		boolean controle = true;
		List<Produto> listaProduto = new ArrayList<>();
		List<Pedido> listaPedido = new ArrayList<>();
		while (controle) {
			

			System.out.println("Oque deseja fazer?: ");
			System.out.println("1 - Cadastrar Produto");
			System.out.println("2 - Listar Produto");
			System.out.println("3 - Criar Pedido");
			System.out.println("4 - Adicionar Produto ao pedido");
			System.out.println("5 - Efetuar Pagamento");
			System.out.println("6 - Listar Pedidos");
			System.out.println("0 - SAIR");

			int dec = entrada.nextInt();
			entrada.nextLine();
	
			if (dec == 1) {
				try {

					CadastroProduto.cadastrar(listaProduto);

				} catch (ExcessaoPrecoInvalido e) {
					System.out.println("Erro: " + e.getMessage());
				} catch (ExcessaoNomeInvalido e) {
					System.out.println("Erro: " + e.getMessage());
				} catch (InputMismatchException e) {
					System.out.println("Erro: código, gramas, mls e calorias só pode conter números!");
				} catch (ExcessaoCategoriaInvalida e) {
					System.out.println("Erro" + e.getMessage());
				} catch (ExcessaoCodigoInvalido e) {
					System.out.println("Erro" + e.getMessage());
				}

			} else if (dec == 2) {

				for (int i = 0; i < listaProduto.size(); i++) {
					int pos = i;
					listaProduto.get(i).listarProduto(listaProduto, i);
				}

			} else if (dec == 3) {
				CriarPedido.criarPedido(listaPedido);
			} else if (dec == 4) {
				StatusPedido status = StatusPedido.PENDENTE;
				try {
					List<ItemPedido> itens = new ArrayList<>();
					AdicionaProdutoAoPedido.Adicionar(listaPedido, listaProduto,itens, status);
				} catch (ExcessaoCodigoPedidoInexistente e) {
					System.out.println("Erro" + e.getMessage());
				} catch (ExecessaoListaProdutoVazia e) {
					System.out.println("Erro" + e.getMessage());
				}
			} else if (dec == 5) {
				try {
					EfetuarPagamento.efetuarPagamento(listaPedido);
				} catch (ExcessaoNumeroPagamentoInvalido e) {
					System.out.println("Erro" + e.getMessage());
				}
			} else if (dec == 6) {
				ListarPedidos.listarPedidos(listaPedido);
			}

			else if (dec == 0) {
				controle = false;
			}

		}
	}
}
