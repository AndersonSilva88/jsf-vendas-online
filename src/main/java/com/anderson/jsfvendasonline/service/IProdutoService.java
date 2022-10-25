package com.anderson.jsfvendasonline.service;

import com.anderson.jsfvendasonline.domain.Produto;
import com.anderson.jsfvendasonline.service.generic.IGenericService;

import java.util.List;

public interface IProdutoService extends IGenericService<Produto, String> {

    List<Produto> filtrarProdutos(String query);
}
