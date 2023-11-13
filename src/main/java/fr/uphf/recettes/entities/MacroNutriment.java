package fr.uphf.recettes.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToOne(cascade = CascadeType.ALL)
    private Recette recette;
}
