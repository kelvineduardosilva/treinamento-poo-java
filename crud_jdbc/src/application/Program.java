package application;
import java.util.List;
import db.DB;
import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import model.entities.Produto;

public class Program {
	public static void main(String[] args) {
		ProdutoDao produtodao = DaoFactory.createProdutoDao();

		try {

			System.out.println("======================================");
			System.out.println("       SISTEMA DE PRODUTOS - CRUD      ");
			System.out.println("======================================");

			// TESTE 1 - INSERT

			System.out.println("\n===== TESTE 1 - INSERIR PRODUTO =====");

			String nome = "Monitor Gamer ";

			Produto produto = new Produto(null, nome, 850.00, 5);

			produtodao.insert(produto);


			// TESTE 2 - FIND ALL

			System.out.println("\n===== TESTE 2 - LISTAR PRODUTOS =====");

			List<Produto> produtos = produtodao.findAll();

			if(produtos == null) {
				System.out.println("Erro ao listar produtos!");
				return;
			}

			for(Produto p : produtos) {

				System.out.println("------------------------------");
				System.out.println("ID: " + p.getId());
				System.out.println("Nome: " + p.getNome());
				System.out.printf("Preço: R$ %.2f%n", p.getPreco());
				System.out.println("Quantidade: " + p.getQuantidade());

				if(nome.equals(p.getNome())) {
					produto = p;
				}

			}

			if(produto.getId() == null) {
				System.out.println("Produto de teste não encontrado!");
				return;
			}

			Integer id = produto.getId();


			// TESTE 3 - FIND BY ID

			System.out.println("\n===== TESTE 3 - BUSCAR POR ID =====");

			System.out.println("Buscando produto de ID: " + id);

			produto = produtodao.findById(id);

			if(produto == null) {
				System.out.println("Produto não encontrado!");
				return;
			}

			System.out.println("Nome: " + produto.getNome());
			System.out.printf("Preço: R$ %.2f%n", produto.getPreco());
			System.out.println("Quantidade: " + produto.getQuantidade());


			// TESTE 4 - UPDATE

			System.out.println("\n===== TESTE 4 - ATUALIZAR PRODUTO =====");

			System.out.println("Nome anterior: " + produto.getNome());

			produto.setNome("Monitor Gamer PRO");
			produto.setPreco(1200.00);
			produto.setQuantidade(10);

			produtodao.update(produto, id);

			produto = produtodao.findById(id);

			if(produto != null) {

				System.out.println("Dados atuais no banco:");
				System.out.println("Nome: " + produto.getNome());
				System.out.printf("Preço: R$ %.2f%n", produto.getPreco());
				System.out.println("Quantidade: " + produto.getQuantidade());

			}


			// TESTE 5 - DELETE

			System.out.println("\n===== TESTE 5 - DELETAR PRODUTO =====");

			produtodao.deleteById(id);


			// TESTE 6 - VERIFICAR EXCLUSÃO

			System.out.println("\n===== VERIFICANDO EXCLUSÃO =====");

			produto = produtodao.findById(id);

			if(produto == null) {

				System.out.println("Produto não encontrado no banco!");

			}
			else {

				System.out.println("O produto ainda existe no banco!");

			}

			System.out.println("\n======================================");
			System.out.println("          TESTES FINALIZADOS!          ");
			System.out.println("======================================");

		}
		finally {

			DB.closeConnection();

		}

	}

}
