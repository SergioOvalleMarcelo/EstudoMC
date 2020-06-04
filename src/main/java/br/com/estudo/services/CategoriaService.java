package br.com.estudo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudo.domain.Categoria;
import br.com.estudo.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id){
//		Categoria objCategoria = repo.findById(id).get();
		Optional<Categoria> objCategoria = repo.findById(id); 
		return objCategoria.orElse(null);
	};
	
}
