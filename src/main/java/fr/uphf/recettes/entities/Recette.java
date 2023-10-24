package fr.uphf.recettes.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Data
public class Recette {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 100, nullable = false)
    @NotBlank
    private String titre;

    @Column(nullable = false)
    private LocalTime duree;

    @ManyToOne
    private Auteur auteur;

    @Column(length = 300)
    private String description;

    @OneToMany(mappedBy = "recette")
    private List<RecetteIngredient> recetteIngredient = new ArrayList<>();

    @OneToMany(mappedBy = "recette")
    private List<Etape> etapes;

    @OneToOne(mappedBy = "recette")
    private MacroNutriment macroNutriment;
}

