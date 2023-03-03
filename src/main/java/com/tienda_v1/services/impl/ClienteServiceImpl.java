package com.tienda_v1.services.impl;

import com.tienda_v1.dao.ClienteDao;
import com.tienda_v1.domain.Cliente;
import com.tienda_v1.services.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class ClienteServiceImpl implements ClienteService{
    //Esto crea una unica copia de un objeto
    @Autowired
    private ClienteDao clienteDao;
    
    @Override
    public List<Cliente> getclientes() {
        return (List<Cliente>) clienteDao.findAll();
        
    }

    @Override
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    public void deleteCliente(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    public void saveCliente(Cliente cliente) {
        clienteDao.save(cliente);
    }
    
}
