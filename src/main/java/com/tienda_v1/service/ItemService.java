package com.tienda_v1.service;

import com.tienda_v1.domain.Item;
import java.util.ArrayList;
import java.util.List;

public interface ItemService {     
    List<Item> listaItems = new ArrayList<>();
    
    public List<Item> gets();
    
    public Item get(Item item);

    public void delete(Item item);

    public void save(Item item);
    
    public void actualiza(Item item);
    
    public void facturar();
}
