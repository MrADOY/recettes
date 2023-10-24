package fr.uphf.recettes.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class RecetteIngredientPrimaryKey implements Serializable {

    @Column(name = "RECETTE_ID")
    private UUID recetteId;

    @Column(name = "INGREDIENT_ID")
    private UUID ingredientId;

}
