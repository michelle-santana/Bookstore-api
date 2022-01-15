package com.michelle.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michelle.bookstore.domain.Livro;
import com.michelle.bookstore.repositories.LivroRepository;
import com.michelle.bookstore.services.exception.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	public LivroRepository repository;


	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Livro não encontrado! id: " + id + ", tipo: " + Livro.class.getName()));
	}
	
	public List<Livro> findAll() {
		return repository.findAll();
	}

}
