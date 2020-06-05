package br.com.estudo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.estudo.domain.Categoria;
import br.com.estudo.repositories.CategoriaRepository;

@SpringBootApplication
public class EstudomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository; 
	
	public static void main(String[] args) {
		SpringApplication.run(EstudomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria objCategoria1 = new Categoria(null, "Informática");
		Categoria objCategoria2 = new Categoria(null, "Escritório");
		
		categoriaRepository.saveAll(Arrays.asList(objCategoria1, objCategoria2));
		
	}

}
