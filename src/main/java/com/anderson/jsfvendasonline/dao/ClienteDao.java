package com.anderson.jsfvendasonline.dao;

import com.anderson.jsfvendasonline.dao.generic.GenericDao;
import com.anderson.jsfvendasonline.domain.Cliente;

import javax.persistence.TypedQuery;
import java.util.List;

public class ClienteDao extends GenericDao<Cliente, Long> implements IClienteDao {

    public ClienteDao() {
        super(Cliente.class);
    }

    @Override
    public List<Cliente> filtrarCliente(String query) {
        TypedQuery<Cliente> typedQuery =
                this.entityManager.createNamedQuery("Cliente.findByNome", this.persistenteClass);
        typedQuery.setParameter("nome", "%" + query + "%");
        return typedQuery.getResultList();
    }
}
