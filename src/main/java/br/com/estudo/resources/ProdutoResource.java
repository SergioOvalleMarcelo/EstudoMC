package br.com.estudo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.domain.Produto;
import br.com.estudo.dto.ProdutoDTO;
import br.com.estudo.resources.util.URL;
import br.com.estudo.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> find(@PathVariable Integer id ) {
		Produto objProduto = service.find(id);
		return ResponseEntity.ok().body(objProduto);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page <ProdutoDTO>> findPage(
			@RequestParam(value = "nome", defaultValue = "") String nome, 
			@RequestParam(value = "categorias", defaultValue = "") String categorias, 
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		String nomeDecoded = URL.decodeParam(nome);
		List<Integer> ids = URL.decodeIntList(categorias);
		Page<Produto> lista = service.search(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
		Page<ProdutoDTO> listaDTO = lista.map(obj -> new ProdutoDTO(obj)); 
		return ResponseEntity.ok().body(listaDTO);
	}
}
