package com.michelle.bookstore.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michelle.bookstore.domain.Livro;
import com.michelle.bookstore.dto.LivroDTO;
import com.michelle.bookstore.repositories.LivroRepository;
import com.michelle.bookstore.services.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {
	
	private static final Logger log = LoggerFactory.getLogger(CategoriaController.class);

	@Autowired
	public LivroService service;

	@Autowired
	public LivroRepository repository;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id) {

		log.info("Controller - BUSCANDO LIVROS POR ID");

		Livro livro = service.findById(id);
		return ResponseEntity.ok().body(livro);
	}
	
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll() {
		
		log.info("Controller - BUSCANDO TODOS OS LIVROS DO BANCO");
		
		List<Livro> list = service.findAll();
		List<LivroDTO> listDto = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	
	

}
