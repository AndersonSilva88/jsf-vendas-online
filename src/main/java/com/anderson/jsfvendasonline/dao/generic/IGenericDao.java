package com.anderson.jsfvendasonline.dao.generic;

import com.anderson.jsfvendasonline.domain.Persistence;
import com.anderson.jsfvendasonline.exception.DAOException;
import com.anderson.jsfvendasonline.exception.MaisDeUmRegistroException;
import com.anderson.jsfvendasonline.exception.TableException;
import com.anderson.jsfvendasonline.exception.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericDao<T extends Persistence, E extends Serializable> {

    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
    public void excluir(T entity) throws DAOException;
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
    public T consultar(E id) throws MaisDeUmRegistroException, TableException, DAOException;
    public Collection<T> buscarTodos() throws DAOException;
}
