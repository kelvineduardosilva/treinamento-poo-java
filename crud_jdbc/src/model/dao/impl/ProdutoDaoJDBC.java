package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ProdutoDao;
import model.entities.Produto;

public class ProdutoDaoJDBC implements ProdutoDao {

	private Connection conn;

	public ProdutoDaoJDBC(Connection conn) {

		this.conn = conn;

	}

	String sql = "";

	@Override

	public void insert(Produto produto) {

		PreparedStatement st = null;

		try {

			sql = "INSERT INTO produto "

					+ "(nome, preco, quantidade) "

					+ "VALUES (?, ?, ?) ";

			st = conn.prepareStatement(sql);

			st.setString(1, produto.getNome());

			st.setDouble(2, produto.getPreco());

			st.setInt(3, produto.getQuantidade());

			int linhasAfetadas = st.executeUpdate();

			if (linhasAfetadas < 1) {

				throw new DbException("Nenhuma linha afetada!");

			}

			else {

				System.out.println("Produto inserido com sucesso!");

			}

		}

		catch (DbException e) {

			System.out.println(e.getMessage());

		}

		catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		finally {

			DB.closeStatement(st);

		}

	}

	@Override

	public void update(Produto produto, int id) {

		PreparedStatement st = null;

		try {

			sql = sql = "UPDATE produto "
			        + "SET nome = ?, "
			        + "preco = ?, "
			        + "quantidade = ? "
			        + "WHERE id = ?";

			st = conn.prepareStatement(sql);

			st.setString(1, produto.getNome());

			st.setDouble(2, produto.getPreco());

			st.setInt(3, produto.getQuantidade());

			st.setInt(4, id);

			int linhasAfetadas = st.executeUpdate();

			if (linhasAfetadas < 1) {

				throw new DbException("Nenhuma linha afetada!");

			}

			else {

				System.out.println("Produto alterado com sucesso!");

			}

		}

		catch (DbException e) {

			System.out.println(e.getMessage());

		}

		catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		finally {

			DB.closeStatement(st);

		}

	}

	@Override

	public void deleteById(Integer id) {

		
		PreparedStatement st = null;

		try {

			sql = "DELETE FROM produto WHERE id = ?";
			st = conn.prepareStatement(sql);

			st.setInt(1, id);

			int linhasAfetadas = st.executeUpdate();

			if (linhasAfetadas < 1) {
				throw new DbException("Erro, Nenhuma linha afetada!");
			}

			else {

				System.out.println("Produto deletado com sucesso!");

			}

		}

		catch (DbException e) {

			System.out.println(e.getMessage());

		}

		catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		finally {

			DB.closeStatement(st);

		}
	}


	@Override

	public Produto findById(Integer id) {

		PreparedStatement st = null;

		try {

			sql = "SELECT * FROM produto WHERE id = ?";
			st = conn.prepareStatement(sql);

			st.setInt(1, id);

			ResultSet resultado = st.executeQuery();

			if (resultado.next()) {
				Produto produto = new Produto();
				produto.setId(resultado.getInt(1));
				produto.setNome(resultado.getString(2));
				produto.setPreco(resultado.getDouble(3));
				produto.setQuantidade(resultado.getInt(4));
				
				return produto;
			}

			else {

				System.out.println("Produto não encontrado!");

			}

		}

		catch (DbException e) {

			System.out.println(e.getMessage());

		}

		catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		finally {

			DB.closeStatement(st);

		}

		return null;

	}

	@Override

	public List<Produto> findAll() {

		PreparedStatement st = null;
		List<Produto> produtos = new ArrayList<>();

		try {

			sql = "SELECT * FROM produto ";
			st = conn.prepareStatement(sql);

			ResultSet resultado = st.executeQuery();

			while(resultado.next()) {
				Produto produto = new Produto();
				produto.setId(resultado.getInt(1));
				produto.setNome(resultado.getString(2));
				produto.setPreco(resultado.getDouble(3));
				produto.setQuantidade(resultado.getInt(4));
			
				produtos.add(produto);
			}
			return produtos;

		}

		catch (DbException e) {

			System.out.println(e.getMessage());

		}

		catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		finally {

			DB.closeStatement(st);

		}

		return null;

	}

	}
