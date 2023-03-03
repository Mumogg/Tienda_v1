package com.tienda_v1.services;

import com.tienda_v1.domain.Cliente;
import java.util.List;

public interface ClienteService {
    public List<Cliente> getclientes();
    
    public Cliente getCliente(Cliente cliente);
    
    public void deleteCliente(Cliente cliente);
    
    public void saveCliente(Cliente cliente);
}
