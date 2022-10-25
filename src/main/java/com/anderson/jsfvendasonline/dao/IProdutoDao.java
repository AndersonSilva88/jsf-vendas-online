package com.anderson.jsfvendasonline.dao;

import com.anderson.jsfvendasonline.dao.generic.IGenericDao;
import com.anderson.jsfvendasonline.domain.Produto;

import java.util.List;

public interface IProdutoDao extends IGenericDao<Produto, String> {

    List<Produto> filtrarProdutos(String query);
}
