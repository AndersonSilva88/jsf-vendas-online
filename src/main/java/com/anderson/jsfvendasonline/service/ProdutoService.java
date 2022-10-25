package com.anderson.jsfvendasonline.service;

import com.anderson.jsfvendasonline.dao.IProdutoDao;
import com.anderson.jsfvendasonline.domain.Produto;
import com.anderson.jsfvendasonline.service.generic.GenericService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    private IProdutoDao produtoDao;

    @Inject
    public ProdutoService(IProdutoDao produtoDao) {
        super(produtoDao);
        this.produtoDao = produtoDao;
    }

    @Override
    public List<Produto> filtrarProdutos(String query) {
        return produtoDao.filtrarProdutos(query);
    }
}
