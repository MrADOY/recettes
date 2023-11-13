package fr.uphf.recettes.services.auteur.odt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuteurSauvegarderOuMettreAJourDTO {
    private String id;
    private String nom;
    private String prenom;
}
