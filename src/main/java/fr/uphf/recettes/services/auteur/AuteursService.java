package fr.uphf.recettes.services.auteur;

import fr.uphf.recettes.entities.Auteur;
import fr.uphf.recettes.repositories.AuteurRepository;
import fr.uphf.recettes.services.auteur.odt.AuteurSauvegarderOuMettreAJourDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuteursService {

    private AuteurRepository auteurRepository;

    public AuteursService(AuteurRepository auteurRepository) {
        this.auteurRepository = auteurRepository;
    }

    public Auteur sauvegarderOuMettreAJourAuteur(AuteurSauvegarderOuMettreAJourDTO auteur) {
        return this.auteurRepository
                .save(Auteur.builder()
                        .id(auteur.getId() != null ? UUID.fromString(auteur.getId()): null)
                        .nom(auteur.getNom())
                        .prenom(auteur.getPrenom())
                        .build());
    }

    public Optional<Auteur> findById(String id) {
        if(id == null || id.isBlank()) {
            return Optional.empty();
        }
        return this.auteurRepository.findById(UUID.fromString(id));
    }

}
