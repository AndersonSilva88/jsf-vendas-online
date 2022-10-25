package com.anderson.jsfvendasonline.service;

import com.anderson.jsfvendasonline.dao.IClienteDao;
import com.anderson.jsfvendasonline.domain.Cliente;
import com.anderson.jsfvendasonline.exception.DAOException;
import com.anderson.jsfvendasonline.exception.MaisDeUmRegistroException;
import com.anderson.jsfvendasonline.exception.TableException;
import com.anderson.jsfvendasonline.service.generic.GenericService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    private IClienteDao clienteDao;
    @Inject
    public ClienteService(IClienteDao clienteDao) {
        super(clienteDao);
        this.clienteDao = clienteDao;
    }

    @Override
    public Cliente buscarPorCpf(Long cpf) throws DAOException {
        try {
            return this.dao.consultar(cpf);
        } catch (MaisDeUmRegistroException | TableException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Cliente> filtrarClientes(String query) {
        return clienteDao.filtrarCliente(query);
    }
}
