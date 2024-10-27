package com.example.mywebapp.controller;

import com.example.mywebapp.models.Usuario;
import com.example.mywebapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.model.IModel;

import java.util.List;


@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public String getUsuarios(Model model){
        List<Usuario> usuarios = usuarioService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("usuario", new Usuario());
        return "usuarios";
    }

    @PostMapping("/usuarios")
    public String saveUsuario(@ModelAttribute Usuario usuario){
        usuarioService.saveUsuario(usuario);
        return "redirect:/usuarios";
    }


}
