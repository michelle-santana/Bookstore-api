package com.michelle.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.michelle.bookstore.domain.Livro;
import com.michelle.bookstore.dto.LivroDTO;
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

	public Livro create(Livro obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Livro update(Integer id, LivroDTO objDTO) {
		Livro livro = findById(id);
		livro.setTitle(objDTO.getTitle());
		livro.setAuthorName(objDTO.getAuthorName());
		livro.setText(objDTO.getText());
		return repository.save(livro);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.michelle.bookstore.services.DataIntegrityViolationException
			("Livro não pode ser deletado! Possui categorias associadas");
		}
		
	}

}
