package fr.uphf.recettes.services.recette;

import fr.uphf.recettes.entities.*;
import fr.uphf.recettes.repositories.RecettesRepository;
import fr.uphf.recettes.services.auteur.AuteursService;
import fr.uphf.recettes.services.auteur.odt.AuteurSauvegarderOuMettreAJourDTO;
import fr.uphf.recettes.services.recette.odt.CreationRecetteODT;
import fr.uphf.recettes.services.recette.odt.RecetteDetailODT;
import fr.uphf.recettes.services.recette.odt.RecetteListODT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static fr.uphf.recettes.services.recette.utils.RecetteServiceUtils.createRecetteDetailODT;

@Service
public class RecettesService {
    private RecettesRepository recettesRepository;
    private AuteursService auteursService;

    @Autowired
    public RecettesService(RecettesRepository recettesRepository,
                           AuteursService auteursService) {
        this.recettesRepository = recettesRepository;
        this.auteursService = auteursService;
    }

    public List<RecetteListODT> listerRecettes() {
        return this.recettesRepository.findAll().stream().map(recette ->
                RecetteListODT.builder()
                        .id(recette.getId().toString())
                        .titre(recette.getTitre())
                        .duree(recette.getDuree())
                        .description(recette.getDescription())
                        .build()).collect(Collectors.toList());
    }

    public RecetteDetailODT getDetailRecetteEnFonctionNombrePersonne(String id, Integer nombrePersonne) {
        Recette recette = recupererRecetteParId(id);
        RecetteDetailODT recetteDetailODT = createRecetteDetailODT(recette);

        if (nombrePersonne != null) {
            calculerQuantiteIngredientEnFonctionNombrePersonne(recetteDetailODT, nombrePersonne);
        }
        return recetteDetailODT;
    }

    private Recette recupererRecetteParId(String id) {
        return this.recettesRepository.findById(UUID.fromString(id)).orElseThrow();
    }

    private void calculerQuantiteIngredientEnFonctionNombrePersonne(RecetteDetailODT recetteDetailODT, Integer nombrePersonne) {
        recetteDetailODT.getIngredients().forEach(
                ingredient -> ingredient.setQuantite(ingredient.getQuantite() * nombrePersonne)
        );
    }

    public String creerRecette(CreationRecetteODT recette) {
        Auteur auteur = this.auteursService.findById(recette.getAuteur().getId()).orElseGet(() ->
                this.auteursService.sauvegarderOuMettreAJourAuteur(
                AuteurSauvegarderOuMettreAJourDTO.builder()
                        .nom(recette.getAuteur().getNom())
                        .prenom(recette.getAuteur().getPrenom())
                        .build()));

        Recette recetteASauvegarder = Recette.builder()
                .titre(recette.getTitre())
                .description(recette.getDescription())
                .duree(recette.getDuree())
                .auteur(auteur).build();

        recetteASauvegarder.setEtapes(recette.getEtapes().stream().map(etape ->
                        Etape.builder().instruction(etape.getInstruction()).recette(recetteASauvegarder)
                                .build())
                        .collect(Collectors.toList()));

        recetteASauvegarder.setMacroNutriment(MacroNutriment.builder()
                        .calories(recette.getMacroNutriment().getCalories())
                        .lipides(recette.getMacroNutriment().getLipides())
                        .glucides(recette.getMacroNutriment().getGlucides())
                        .proteines(recette.getMacroNutriment().getProteines())
                        .recette(recetteASauvegarder)
                        .build());

        recetteASauvegarder.setRecetteIngredient(null);

        Recette recetteSauvegardee = this.recettesRepository.save(recetteASauvegarder);
        return recetteSauvegardee.getId().toString();
    }
}
