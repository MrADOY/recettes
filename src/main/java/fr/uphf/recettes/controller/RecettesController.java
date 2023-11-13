package fr.uphf.recettes.controller;

import fr.uphf.recettes.services.recette.RecettesService;
import fr.uphf.recettes.services.recette.odt.CreationRecetteODT;
import fr.uphf.recettes.services.recette.odt.RecetteDetailODT;
import fr.uphf.recettes.services.recette.odt.RecetteListODT;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("recettes")
public class RecettesController {

    private RecettesService recettesService;

    public RecettesController(RecettesService recettesService) {
        this.recettesService = recettesService;
    }

    @GetMapping
    public ResponseEntity<List<RecetteListODT>> listerRecettes() {
        return ResponseEntity.ok(this.recettesService.listerRecettes());
    }

    @GetMapping("/{id}")
    public ResponseEntity getRecetteParId(@PathVariable("id") String id,
                                          @RequestParam(value = "nombrePersonne", required = false) Integer nombrePersonne) {
        try {
            if(id == null || id.isBlank()) {
                return ResponseEntity.badRequest()
                        .body("l'idenfitiant de la recette est manquant"); // retourne un code HTTP 400
            }
            try {
                RecetteDetailODT recette = recettesService.getDetailRecetteEnFonctionNombrePersonne(id, nombrePersonne);
                return ResponseEntity.ok().body(recette); // retourne un code HTTP 200
            } catch (NoSuchElementException e) {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Erreur de traitement"); // retourne un code HTTP 500
        }
    }

    @PostMapping
    public ResponseEntity createRecette(@RequestBody CreationRecetteODT recette) {
        return ResponseEntity.ok().body(this.recettesService.creerRecette(recette));
    }
}
