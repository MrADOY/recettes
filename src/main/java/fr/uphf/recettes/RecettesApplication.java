package fr.uphf.recettes;

import fr.uphf.recettes.entities.Recette;
import fr.uphf.recettes.repositories.RecettesRepositories;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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


		System.out.println("Modification de la recette");
		Recette recette = recettes.stream().findFirst().get();

		recette.setDescription("Super ma nouvelle description");

		this.recettesRepositories.save(recette);

		List<Recette> recettesModifiees = this.recettesRepositories.findAll();
		recettesModifiees.forEach(System.out::println);
	}
}
