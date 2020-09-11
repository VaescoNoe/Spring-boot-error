package com.vaescode.springboot.error.app.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vaescode.springboot.error.app.models.domain.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private List<Usuario> lista;
	
	
	
	public UsuarioServiceImpl() {
		lista = Arrays.asList(
				new Usuario(1, "Noe", "Vargas"),
				new Usuario(2, "Hugo", "Vargas"),
				new Usuario(3, "Diana", "Vargas"),
				new Usuario(4, "Cesar", "Vargas"),
				new Usuario(5, "Hilda", "Vargas"),
				new Usuario(6, "Paulina", "Pastrana")
				);
	}

	@Override
	public List<Usuario> listar() {
		return this.lista;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {
		Usuario usuario= null;
		
		for(Usuario u: this.lista) {
			
			if(u.getId().equals(id)) {
				usuario = u;
				break;
			}
		}
		
		return usuario;
	}

	@Override
	public Optional<Usuario> obtenerPorIdOptional(Integer id) {
		 Usuario usuario = this.obtenerPorId(id);
		return Optional.ofNullable(usuario);
	}

}
