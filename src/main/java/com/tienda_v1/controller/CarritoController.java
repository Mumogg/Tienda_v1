package com.tienda_v1.controller;

import com.tienda_v1.domain.Articulo;
import com.tienda_v1.domain.Item;
import com.tienda_v1.service.ArticuloService;
import com.tienda_v1.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class CarritoController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/carrito/listado")
    public String inicio(Model model) {
        var items = itemService.gets();
        model.addAttribute("items", items);
        var carritoTotalVenta = 0;
        for (Item i : items) {
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return "/carrito/listado";
    }

    @GetMapping("/carrito/agregar/{idArticulo}")
    public ModelAndView agregarItem(Model model, Item item) {
        Item item2 = itemService.get(item);
        if (item2 == null) {
            Articulo articulo = articuloService.getArticulo(item);
            item2 = new Item(articulo);
        }
        itemService.save(item2);
        var lista = itemService.gets();
        var totalCarritos = 0;
        var carritoTotalVenta = 0;
        for (Item i : lista) {
            totalCarritos += i.getCantidad();
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", totalCarritos);
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return new ModelAndView("/carrito/fragmentosCarrito :: verCarrito");
    }

    @GetMapping("/carrito/modificar/{idArticulo}")
    public String modificarItem(Item item, Model model) {
        item = itemService.get(item);
        model.addAttribute("item", item);
        return "/carrito/modificar";
    }

    @GetMapping("/carrito/eliminar/{idArticulo}")
    public String eliminarItem(Item item) {
        itemService.delete(item);
        return "redirect:/carrito/listado";
    } 

    @PostMapping("/carrito/guardar")
    public String guardarItem(Item item) {
        itemService.actualiza(item);
        return "redirect:/carrito/listado";
    }
    
    @GetMapping("/facturar/carrito")
    public String facturarCarrito() {
        itemService.facturar();
        return "redirect:/";
    }
}
