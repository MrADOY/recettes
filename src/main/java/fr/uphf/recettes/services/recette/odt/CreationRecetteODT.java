package fr.uphf.recettes.services.recette.odt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreationRecetteODT {

    private String titre;
    private LocalTime duree;
    private Auteur auteur;
    private String description;
    private List<Ingredient> ingredient;
    private List<Etape> etapes;
    private MacroNutriment macroNutriment;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Auteur {
        private String id;
        private String nom;
        private String prenom;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Ingredient {
        private String nom;
        private Float quantite;
        private String uniteDeMesure;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Etape {
        private String instruction;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class MacroNutriment {
        private Integer calories;
        private Integer proteines;
        private Integer glucides;
        private Integer lipides;
    }
}
