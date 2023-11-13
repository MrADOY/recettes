package fr.uphf.recettes.services.recette.odt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecetteListODT {
    private String id;
    private String titre;
    private LocalTime duree;
    private String description;
}
