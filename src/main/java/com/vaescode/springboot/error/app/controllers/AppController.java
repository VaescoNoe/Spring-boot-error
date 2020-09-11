package com.vaescode.springboot.error.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vaescode.springboot.error.app.erros.UsuarioNoEncontradoException;
import com.vaescode.springboot.error.app.models.domain.Usuario;
import com.vaescode.springboot.error.app.services.UsuarioService;

@Controller
public class AppController {

	@Autowired
	private UsuarioService usuarioService;
	
	@SuppressWarnings("unused")
	@GetMapping("/index")
	public String index() {
		//Integer valor = 100/0;
		//Integer valor = Integer.parseInt("A");
		return "index";
	}
	
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable Integer id, Model model) {
		
		
		//Usuario u = usuarioService.obtenerPorId(id);
		
//		if(u == null) {
//			throw new UsuarioNoEncontradoException(id.toString());
//		}
			
		Usuario u = usuarioService.obtenerPorIdOptional(id).orElseThrow(()->new UsuarioNoEncontradoException(id.toString()));
		
		model.addAttribute("usuario", u);
		model.addAttribute("titulo", "Detalle de usuario: ".concat(u.getNombre()));
		
		return "ver/usuario";
		
	}
}
