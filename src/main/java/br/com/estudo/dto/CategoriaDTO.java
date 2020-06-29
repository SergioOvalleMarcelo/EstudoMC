package br.com.estudo.dto;

import java.io.Serializable;


import br.com.estudo.domain.Categoria;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;


public class CategoriaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "Preenchimento obrigatorio")
	@Length(min = 5, max = 80, message = "Quantidade de caracteres deve ser entre 5 e 80")
	private String nome;
	
	public CategoriaDTO() {
		
	}

	public CategoriaDTO(Categoria categoria) {
		id = categoria.getId();
		nome = categoria.getNome();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
