package com.tienda_v1.service.impl;

import com.tienda_v1.domain.Item;
import com.tienda_v1.service.ItemService;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public List<Item> gets() {
        return listaItems;
    }

    @Override
    public void save(Item item) {
        boolean existe = false;
        for (Item i : listaItems) {
            if (Objects.equals(i.getIdArticulo(), item.getIdArticulo())) {
                if (i.getCantidad() < item.getExistencias()) {
                    i.setCantidad(i.getCantidad() + 1);
                }
                existe = true;
                break;
            }
        }
        if (!existe) {          
            item.setCantidad(1);
            listaItems.add(item);
        }
    }

    @Override
    public void delete(Item item) {
        var posicion = -1;
        var existe = false;
        for (Item i : listaItems) {
            ++posicion;
            if (Objects.equals(i.getIdArticulo(), item.getIdArticulo())) {
                existe = true;
                break;
            }
        }
        if (existe) {
            listaItems.remove(posicion);
        }
    }

    @Override
    public Item get(Item item) {
        for (Item i : listaItems) {
            if (Objects.equals(i.getIdArticulo(), item.getIdArticulo())) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void actualiza(Item item) {
        for (Item i : listaItems) {
            if (Objects.equals(i.getIdArticulo(), item.getIdArticulo())) {
                i.setCantidad(item.getCantidad());
                break;
            }
        }
    }

    @Override
    public void facturar() {
        System.out.println("Facturando");
        for (Item i : listaItems) {
            System.out.println("Producto: " + i.getDescripcion() + 
                    " Cantidad: " + i.getCantidad() + 
                    " Total: " + i.getPrecio() * i.getCantidad());

        }
        listaItems.clear();
    }
}
