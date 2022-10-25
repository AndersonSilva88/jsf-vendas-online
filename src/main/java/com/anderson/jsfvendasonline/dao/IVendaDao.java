package com.anderson.jsfvendasonline.dao;

import com.anderson.jsfvendasonline.dao.generic.IGenericDao;
import com.anderson.jsfvendasonline.domain.Venda;
import com.anderson.jsfvendasonline.exception.DAOException;
import com.anderson.jsfvendasonline.exception.TipoChaveNaoEncontradaException;

public interface IVendaDao extends IGenericDao<Venda, Long> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    public Venda consultarComCollection(Long id);
}
