package com.tienda_v1.controller;

import com.tienda_v1.domain.Cliente;
import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {
    
    @GetMapping("/")
    public String inicio(Model model){
        var saludo="saludos desde el Banck end";
        model.addAttribute("mensaje", saludo);
        Cliente cliente1=new Cliente("Juan","Contreras","jcontreras@gmail.com","25289974");
        Cliente cliente2=new Cliente("Pedro","Contreras","pcontreras@gmail.com","25289974");
        Cliente cliente3=new Cliente("Rita","Contreras","rcontreras@gmail.com","25289974");
        
        var clientes=Arrays.asList(cliente1, cliente2, cliente3);
        
        model.addAttribute("cliente",clientes);
       
        return "index"; 
    }
        
}
