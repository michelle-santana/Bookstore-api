package com.michelle.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.michelle.bookstore.domain.Categoria;
import com.michelle.bookstore.domain.Livro;
import com.michelle.bookstore.repositories.CategoriaRepository;
import com.michelle.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
		Categoria cat1 = new Categoria(null, "Informatica", "Livro de TI");
		Livro liv1 = new Livro(null, "Clean Code", "Michelle Santana", "lore ypisun", cat1);

		cat1.getLivros().addAll(Arrays.asList(liv1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(liv1));
		
	}

}
