package fr.uphf.recettes.entities;

import jakarta.persistence.*;


@Entity
public class RecetteIngredient {

    @EmbeddedId
    private RecetteIngredientPrimaryKey id;

    @ManyToOne
    @MapsId("recetteId") // Nom de l'attribut dans la classe RecetteIngredientPrimaryKey
    @JoinColumn(name = "RECETTE_ID")
    private Recette recette;

    @ManyToOne
    @MapsId("ingredientId") // Nom de l'attribut dans la classe RecetteIngredientPrimaryKey
    @JoinColumn(name = "INGREDIENT_ID")
    private Ingredient ingredient;

    private Float quantite;
    private String uniteDeMesure;
}
