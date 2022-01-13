package com.michelle.bookstore.servicies;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michelle.bookstore.domain.Categoria;
import com.michelle.bookstore.domain.Livro;
import com.michelle.bookstore.repositories.CategoriaRepository;
import com.michelle.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;

	
	public void instantiateDatabase() {
		Categoria cat1 = new Categoria(null, "Informatica", "Livro de TI");
		Categoria cat2 = new Categoria(null, "Romance", "Como eu Era, antes de vc");
		Categoria cat3 = new Categoria(null, "Terror", "Assasin's Creed");
		Categoria cat4 = new Categoria(null, "Romance", "Amanhecer");
		
		Livro liv1 = new Livro(null, "Clean Code", "JJ abrahm", "lore ypisun", cat1);
		Livro liv2 = new Livro(null, "Como eu era", "Jordan Sparkle", "lore ypisun", cat2);
		Livro liv3 = new Livro(null, "Assasin's creed", "Micina Turnhelle", "lore ypisun", cat3);
		Livro liv4 = new Livro(null, "Amanhecer", "Gianina brown", "lore ypisun", cat4);

		cat1.getLivros().addAll(Arrays.asList(liv1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		this.livroRepository.saveAll(Arrays.asList(liv1, liv2, liv3, liv4));
	}

}
