package com.anderson.jsfvendasonline.dao.generic;

import com.anderson.jsfvendasonline.domain.Persistence;
import com.anderson.jsfvendasonline.exception.DAOException;
import com.anderson.jsfvendasonline.exception.MaisDeUmRegistroException;
import com.anderson.jsfvendasonline.exception.TableException;
import com.anderson.jsfvendasonline.exception.TipoChaveNaoEncontradaException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class GenericDao <T extends Persistence, E extends Serializable> implements IGenericDao<T,E> {

    protected Class<T> persistenteClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public GenericDao(Class<T> persistenteClass) {
        this.persistenteClass = persistenteClass;
    }

    @Override
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public void excluir(T entity) throws DAOException {
         if (entityManager.contains(entity)) {
             entityManager.remove(entity);
         } else {
             T managedCustomer = entityManager.find(this.persistenteClass, entity.getId());
             if (managedCustomer != null) {
                 entityManager.remove(managedCustomer);
             }
         }
    }

    @Override
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        entity = entityManager.merge(entity);
        return entity;
    }

    @Override
    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException {
        T entity = entityManager.find(this.persistenteClass, valor);
        return entity;
    }

    @Override
    public Collection<T> buscarTodos() throws DAOException {
        List<T> list =
                entityManager.createQuery(getSelectSql(), this.persistenteClass).getResultList();
        return list;
    }

    private String getSelectSql() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT OBJ FROM");
        sb.append(this.persistenteClass.getSimpleName());
        sb.append(" obj");
        return sb.toString();
    }
}
