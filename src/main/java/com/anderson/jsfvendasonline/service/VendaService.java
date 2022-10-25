package com.anderson.jsfvendasonline.service;

import com.anderson.jsfvendasonline.dao.IVendaDao;
import com.anderson.jsfvendasonline.domain.Venda;
import com.anderson.jsfvendasonline.exception.DAOException;
import com.anderson.jsfvendasonline.exception.TipoChaveNaoEncontradaException;
import com.anderson.jsfvendasonline.service.generic.GenericService;

import javax.ejb.Stateless;

@Stateless
public class VendaService extends GenericService<Venda, Long> implements IVendaService {

    IVendaDao dao;

    public VendaService(IVendaDao dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
        venda.setStatus(Venda.Status.CONCLUIDA);
        dao.finalizarVenda(venda);
    }

    @Override
    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
        venda.setStatus(Venda.Status.CANCELADA);
        dao.cancelarVenda(venda);
    }

    @Override
    public Venda consultarComCollection(Long id) {
        return dao.consultarComCollection(id);
    }

     @Override
    public Venda cadastrar(Venda entity) throws TipoChaveNaoEncontradaException, DAOException {
        entity.setStatus(Venda.Status.INICIADA);
        return super.cadastrar(entity);
     }
}
