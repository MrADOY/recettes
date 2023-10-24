package fr.uphf.recettes.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@Entity
@Data
public class MacroNutriment {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private Integer calories;

    @Column
    private Integer proteines;

    @Column
    private Integer glucides;

    @Column
    private Integer lipides;

    @OneToOne
    @ToString.Exclude
    private Recette recette;
}
