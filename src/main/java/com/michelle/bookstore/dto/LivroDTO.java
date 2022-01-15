package com.michelle.bookstore.dto;

import java.io.Serializable;

import com.michelle.bookstore.domain.Livro;

public class LivroDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String title;
	private String authorName;
	private String text;

	public LivroDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LivroDTO(Livro obj) {
		super();
		this.id = obj.getId();
		this.title = obj.getTitle();
		this.authorName = obj.getAuthorName();
		this.text = obj.getText();
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

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
