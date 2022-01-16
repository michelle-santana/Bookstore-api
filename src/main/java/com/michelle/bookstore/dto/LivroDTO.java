package com.michelle.bookstore.dto;

import java.io.Serializable;

import com.michelle.bookstore.domain.Livro;

public class LivroDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String title;
	
	public LivroDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LivroDTO(Livro obj) {
		super();
		this.id = obj.getId();
		this.title = obj.getTitle();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
