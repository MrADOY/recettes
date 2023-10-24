package fr.uphf.recettes;

import fr.uphf.recettes.entities.Recette;
import fr.uphf.recettes.repositories.RecettesRepositories;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class RecettesApplication implements CommandLineRunner {

	@Autowired
	private RecettesRepositories recettesRepositories;

	public static void main(String[] args) {
		SpringApplication.run(RecettesApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) {
		List<Recette> recettes = this.recettesRepositories.findAll();
		recettes.forEach(System.out::println);
	}
}
