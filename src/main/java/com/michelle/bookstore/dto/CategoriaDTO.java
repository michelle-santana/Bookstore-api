package com.michelle.bookstore.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.michelle.bookstore.domain.Categoria;

public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message= "Campo NOME é requirido")
	@Length(min= 3, max= 100, message="O campo NOME deve ter entre 3 e 100 caracteres")
	private String name;
	
	@NotEmpty(message= "Campo DESCRIÇÃO é requirido")
	@Length(min= 3, max= 200, message="O campo DESCRIÇÃO deve ter entre 3 e 200 caracteres")
	private String description;

	public CategoriaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.description = obj.getDescription();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
