package com.michelle.bookstore.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Livro implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message= "Campo TITULO é requirido")
	@Length(min= 3, max= 50, message="O campo TITULO deve ter entre 3 e 50 caracteres")
	private String title;
	
	@NotEmpty(message= "Campo NOME DO AUTOR é requirido")
	@Length(min= 3, max= 50, message="O campo NOME DO AUTOR deve ter entre 3 e 50 caracteres")
	private String authorName;
	
	@NotEmpty(message= "Campo TEXTO é requirido")
	@Length(min= 10, max= 200000000, message="O campo NOME deve ter entre 3 e 200.000.000 caracteres")
	private String text;
	
	@JsonIgnore //protege contra serialização;
	@ManyToOne
	@JoinColumn(name= "categoriaId")
	private Categoria categoria;

	public Livro() {
		super();
	}

	

	public Livro(Integer id, String title, String authorName, String text, Categoria categoria) {
		super();
		this.id = id;
		this.title = title;
		this.authorName = authorName;
		this.text = text;
		this.categoria = categoria;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	

}
