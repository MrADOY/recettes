package fr.uphf.recettes.repositories;

import fr.uphf.recettes.entities.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecettesRepository extends JpaRepository<Recette, UUID> {
}
