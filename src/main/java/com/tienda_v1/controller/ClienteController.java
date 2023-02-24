
package com.tienda_v1.controller;

import com.tienda_v1.domain.Cliente;
import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class ClienteController {
    @GetMapping("/")
    public String inicio(Model model){
        var saludo="Saludos desde el Back End";
        model.addAttribute("mensaje", saludo);
        
        Cliente cliente1=new Cliente("Juan","Contreras","Jcontreras@gmail.com","22222222");
        Cliente cliente2=new Cliente("Pedro","Contreras","Pcontreras@gmail.com","22222223");
        Cliente cliente3=new Cliente("Rita","Contreras","Rcontreras@gmail.com","22222224");
        
        var clientes=Arrays.asList(cliente1,cliente2,cliente3);
        model.addAttribute("clientes", clientes);
        
        return "index";
    }
}
