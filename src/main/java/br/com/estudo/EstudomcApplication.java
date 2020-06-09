package br.com.estudo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.estudo.domain.Categoria;
import br.com.estudo.domain.Cidade;
import br.com.estudo.domain.Estado;
import br.com.estudo.domain.Produto;
import br.com.estudo.repositories.CategoriaRepository;
import br.com.estudo.repositories.CidadeRepository;
import br.com.estudo.repositories.EstadoRepository;
import br.com.estudo.repositories.ProdutoRepository;

@SpringBootApplication
public class EstudomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository; 
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EstudomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria objCategoria1 = new Categoria(null, "Informática");
		Categoria objCategoria2 = new Categoria(null, "Escritório");
		
		Produto objProduto1 = new Produto(null, "Computador", 2000.00);
		Produto objProduto2 = new Produto(null, "Impressora", 800.00);
		Produto objProduto3 = new Produto(null, "Mouse", 80.00);
		
		objCategoria1.getProdutos().addAll(Arrays.asList(objProduto1, objProduto2, objProduto3));
		objCategoria2.getProdutos().addAll(Arrays.asList(objProduto2));
		
		objProduto1.getCategorias().addAll(Arrays.asList(objCategoria1));
		objProduto2.getCategorias().addAll(Arrays.asList(objCategoria1, objCategoria2));
		objProduto3.getCategorias().addAll(Arrays.asList(objCategoria1));
		
		categoriaRepository.saveAll(Arrays.asList(objCategoria1, objCategoria2));
		produtoRepository.saveAll(Arrays.asList(objProduto1, objProduto2, objProduto3));
		
		Estado objEstado1 = new Estado(null, "Minas Gerais");
		Estado objEstado2 = new Estado(null, "São Paulo");
		
		Cidade objCidade1 = new Cidade(null, "Uberlândia", objEstado1);
		Cidade objCidade2 = new Cidade(null, "São Paulo", objEstado2);
		Cidade objCidade3 = new Cidade(null, "Campinas", objEstado2);
		
		objEstado1.getCidades().addAll(Arrays.asList(objCidade1));
		objEstado2.getCidades().addAll(Arrays.asList(objCidade2, objCidade3));
		
		estadoRepository.saveAll(Arrays.asList(objEstado1, objEstado2));
		cidadeRepository.saveAll(Arrays.asList(objCidade1, objCidade2, objCidade3));
		
	}

}
