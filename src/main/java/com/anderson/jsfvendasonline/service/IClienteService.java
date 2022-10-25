package com.anderson.jsfvendasonline.service;

import com.anderson.jsfvendasonline.domain.Cliente;
import com.anderson.jsfvendasonline.exception.DAOException;
import com.anderson.jsfvendasonline.service.generic.IGenericService;

import java.util.List;

public interface IClienteService extends IGenericService<Cliente, Long> {

    Cliente buscarPorCpf(Long cpf) throws DAOException;

    List<Cliente> filtrarClientes(String query);
}
