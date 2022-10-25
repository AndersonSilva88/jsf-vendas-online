package com.anderson.jsfvendasonline.dao;

import com.anderson.jsfvendasonline.dao.generic.GenericDao;
import com.anderson.jsfvendasonline.domain.Produto;

import javax.persistence.TypedQuery;
import java.util.List;

public class ProdutoDao extends GenericDao<Produto, String> implements IProdutoDao {

    public ProdutoDao() {
        super(Produto.class);
    }

    @Override
    public List<Produto> filtrarProdutos(String query) {
        TypedQuery<Produto> tpQuery =
                this.entityManager.createNamedQuery("Produto.findByNome", this.persistenteClass);
        tpQuery.setParameter("nome", "%" + query + "%");
        return tpQuery.getResultList();
    }
}
