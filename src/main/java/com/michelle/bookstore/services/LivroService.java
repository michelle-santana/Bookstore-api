package com.michelle.bookstore.services;

import java.util.List;
import java.util.Optional;

import com.michelle.bookstore.services.exception.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michelle.bookstore.domain.Categoria;
import com.michelle.bookstore.domain.Livro;
import com.michelle.bookstore.repositories.LivroRepository;
import com.michelle.bookstore.services.exception.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Livro não encontrado! id: " + id + ", tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Integer id_cat) {
		categoriaService.findById(id_cat);
		return repository.findAllByCategoria(id_cat);
	}

	public Livro update(Integer id, Livro obj) {
		Livro newObj = findById(id);
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Livro newObj, Livro obj) {
		newObj.setTitle(obj.getTitle());
		newObj.setAuthorName(obj.getAuthorName());
		newObj.setText(obj.getText());
	}

	public Livro create(Integer id_cat, Livro obj) {
		obj.setId(null);
		Categoria cat = categoriaService.findById(id_cat);
		obj.setCategoria(cat);
		return repository.save(obj);

	}


	public void delete(Integer id) {
		Livro obj = findById(id);
		try {
			repository.delete(obj);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException
			("Livro não pode ser deletado! Possui categorias associadas");
		}
}
	
}
