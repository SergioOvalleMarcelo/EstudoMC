package br.com.estudo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listar() {
		Categoria objCategoria1 = new Categoria(1, "Informatica");
		Categoria objCategoria2 = new Categoria(2, "Escritorio");
		List<Categoria> lista = new ArrayList<>();
		lista.add(objCategoria1);
		lista.add(objCategoria2);
		return lista;
	}
}
