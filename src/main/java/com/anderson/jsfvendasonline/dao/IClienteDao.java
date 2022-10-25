package com.anderson.jsfvendasonline.dao;

import com.anderson.jsfvendasonline.dao.generic.IGenericDao;
import com.anderson.jsfvendasonline.domain.Cliente;

import java.util.List;

public interface IClienteDao extends IGenericDao<Cliente, Long> {

    List<Cliente> filtrarCliente(String query);
}
