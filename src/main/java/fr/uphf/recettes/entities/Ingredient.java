package fr.uphf.recettes.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(length = 250, nullable = false)
    private String nom;

    @OneToMany(mappedBy = "ingredient")
    private List<RecetteIngredient> recetteIngredient = new ArrayList<>();
}
