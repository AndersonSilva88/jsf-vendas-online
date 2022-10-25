package com.anderson.jsfvendasonline.service.generic;

import com.anderson.jsfvendasonline.dao.generic.IGenericDao;
import com.anderson.jsfvendasonline.domain.Persistence;
import com.anderson.jsfvendasonline.exception.DAOException;
import com.anderson.jsfvendasonline.exception.MaisDeUmRegistroException;
import com.anderson.jsfvendasonline.exception.TableException;
import com.anderson.jsfvendasonline.exception.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public class GenericService<T extends Persistence, E extends Serializable> implements IGenericService<T, E> {

    protected IGenericDao<T,E> dao;

    public GenericService(IGenericDao<T,E> dao) {
        this.dao = dao;
    }

    @Override
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.dao.cadastrar(entity);
    }

    @Override
    public void excluir(T entity) throws DAOException {
        this.dao.excluir(entity);
    }

    @Override
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.dao.alterar(entity);
    }

    @Override
    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException {
        return this.dao.consultar(valor);
    }

    @Override
    public Collection<T> buscarTodos() throws DAOException {
        return this.dao.buscarTodos();
    }
}
