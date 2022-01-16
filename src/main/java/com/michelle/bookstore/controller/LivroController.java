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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.michelle.bookstore.domain.Livro;
import com.michelle.bookstore.dto.LivroDTO;
import com.michelle.bookstore.services.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

	private static final Logger log = LoggerFactory.getLogger(CategoriaController.class);

	@Autowired
	public LivroService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id) {

		log.info("Controller - BUSCANDO LIVROS POR ID");
		Livro obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat ) {

		log.info("Controller - BUSCANDO TODOS OS LIVROS DO BANCO");
		List<Livro> list = service.findAll(id_cat);
		List<LivroDTO> listDto = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

//	@PostMapping
//	public ResponseEntity<Livro> create(@RequestBody Livro obj) {
//
//		log.info("Controller - CRIANDO NOVOS LIVROS");
//
//		obj = service.create(obj);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
//		return ResponseEntity.created(uri).build();
//	}
//
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<LivroDTO> update(@PathVariable Integer id, @RequestBody LivroDTO objDTO) {
//
//		log.info("Controller - INSERINDO NOVOS LIVROS");
//
//		Livro newLivro = service.update(id, objDTO);
//		return ResponseEntity.ok().body(new LivroDTO(newLivro));
//	}

//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<Void> delete(@PathVariable Integer id) {
//		service.delete(id);
//		return ResponseEntity.noContent().build();
//	}

}
