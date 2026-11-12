package model.dao;

import db.DB;
import model.dao.impl.ProdutoDaoJDBC;

public interface DaoFactory {
	public static ProdutoDao createProdutoDao() {
		ProdutoDao produtodao = new ProdutoDaoJDBC(DB.getConnection());
		return produtodao;
	}

}
