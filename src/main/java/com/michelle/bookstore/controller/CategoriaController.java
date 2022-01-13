package com.michelle.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michelle.bookstore.domain.Categoria;
import com.michelle.bookstore.repositories.CategoriaRepository;
import com.michelle.bookstore.services.CategoriaService;


@RestController
@RequestMapping( value= "/categorias")
public class CategoriaController {
	
	@Autowired
	public CategoriaService service;
	
	@Autowired
	public CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll(){
		List<Categoria> list = repository.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value= "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}

