package fr.uphf.recettes.services.recette.utils;

import fr.uphf.recettes.entities.Recette;
import fr.uphf.recettes.services.recette.odt.RecetteDetailODT;
import java.util.List;
import java.util.stream.Collectors;

public class RecetteServiceUtils {

    public static RecetteDetailODT createRecetteDetailODT(Recette recette) {
        return RecetteDetailODT.builder()
                .id(recette.getId().toString())
                .titre(recette.getTitre())
                .description(recette.getDescription())
                .duree(recette.getDuree())
                .auteur(buildAuteur(recette))
                .ingredients(buildIngredients(recette))
                .etapes(buildEtapes(recette))
                .macroNutriment(buildMacroNutriment(recette))
                .build();
    }

    private static RecetteDetailODT.Auteur buildAuteur(Recette recette) {
        return RecetteDetailODT.Auteur.builder()
                .id(recette.getAuteur().getId())
                .nom(recette.getAuteur().getNom())
                .prenom(recette.getAuteur().getPrenom())
                .build();
    }

    private static List<RecetteDetailODT.Ingredient> buildIngredients(Recette recette) {
        return recette.getRecetteIngredient().stream().map(ingredient ->
                RecetteDetailODT.Ingredient.builder()
                        .uniteDeMesure(ingredient.getUniteDeMesure())
                        .quantite(ingredient.getQuantite())
                        .nom(ingredient.getIngredient().getNom())
                        .build()
        ).collect(Collectors.toList());
    }

    private static List<RecetteDetailODT.Etape> buildEtapes(Recette recette) {
        return recette.getEtapes().stream().map(etape ->
                RecetteDetailODT.Etape.builder()
                        .instruction(etape.getInstruction())
                        .build()
        ).collect(Collectors.toList());
    }

    private static RecetteDetailODT.MacroNutriment buildMacroNutriment(Recette recette) {
        return RecetteDetailODT.MacroNutriment.builder()
                .calories(recette.getMacroNutriment().getCalories())
                .glucides(recette.getMacroNutriment().getGlucides())
                .lipides(recette.getMacroNutriment().getLipides())
                .proteines(recette.getMacroNutriment().getProteines())
                .build();
    }
}
