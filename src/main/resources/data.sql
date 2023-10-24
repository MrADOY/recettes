-- Génération d'UUID
SET @uuid_auteur = random_uuid();
SET @uuid_recette_1 = random_uuid();
SET @uuid_ingredient_pates = random_uuid();
SET @uuid_ingredient_viande = random_uuid();
SET @uuid_ingredient_sauce = random_uuid();
SET @uuid_ingredient_oignon = random_uuid();
SET @uuid_ingredient_ail = random_uuid();
SET @uuid_ingredient_huile_olive = random_uuid();
SET @uuid_ingredient_herbes = random_uuid();
SET @uuid_ingredient_sel = random_uuid();
SET @uuid_ingredient_poivre = random_uuid();
SET @uuid_ingredient_sucre = random_uuid();
SET @uuid_ingredient_basilic = random_uuid();
SET @uuid_macronutriment_1 = random_uuid();

-- Création de l'auteur
INSERT INTO AUTEUR (ID, NOM, PRENOM)
VALUES (@uuid_auteur, 'PIETRZAK', 'AURELIEN');

-- Création de la recette
INSERT INTO RECETTE (ID, TITRE, DUREE, AUTEUR_ID, DESCRIPTION)
VALUES (@uuid_recette_1, 'Spaghetti à la Bolognaise', '00:45', @uuid_auteur, 'Une délicieuse recette de spaghetti à la sauce bolognaise.');

-- Création des ingrédients
INSERT INTO INGREDIENT (ID, NOM)
VALUES
    (@uuid_ingredient_pates, 'Spaghetti'),
    (@uuid_ingredient_viande, 'Viande hachée de bœuf'),
    (@uuid_ingredient_sauce, 'Sauce tomate'),
    (@uuid_ingredient_oignon, 'Oignon'),
    (@uuid_ingredient_ail, 'Ail'),
    (@uuid_ingredient_huile_olive, 'Huile d''olive'),
    (@uuid_ingredient_herbes, 'Herbes italiennes'),
    (@uuid_ingredient_sel, 'Sel'),
    (@uuid_ingredient_poivre, 'Poivre'),
    (@uuid_ingredient_sucre, 'Sucre'),
    (@uuid_ingredient_basilic, 'Feuilles de basilic');

-- Association des ingrédients à la recette
INSERT INTO RECETTE_INGREDIENT (INGREDIENT_ID, RECETTE_ID, QUANTITE, UNITE_DE_MESURE)
VALUES
    (@uuid_ingredient_pates, @uuid_recette_1, 70, 'GRAMMES'),
    (@uuid_ingredient_viande, @uuid_recette_1, 80, 'GRAMMES'),
    (@uuid_ingredient_sauce, @uuid_recette_1, 40, 'GRAMMES'),
    (@uuid_ingredient_oignon, @uuid_recette_1, 0.5, 'UNITAIRE'),
    (@uuid_ingredient_ail, @uuid_recette_1, 0.5, 'UNITAIRE'),
    (@uuid_ingredient_huile_olive, @uuid_recette_1, 0.03, 'LITRE'),
    (@uuid_ingredient_herbes, @uuid_recette_1, 0.5, 'CUILLERE'),
    (@uuid_ingredient_sel, @uuid_recette_1, 0.5, 'CUILLERE'),
    (@uuid_ingredient_poivre, @uuid_recette_1, 0.5, 'CUILLERE'),
    (@uuid_ingredient_sucre, @uuid_recette_1, 0.5, 'CUILLERE'),
    (@uuid_ingredient_basilic, @uuid_recette_1, 2, 'UNITAIRE');

-- Informations nutritionnelles
INSERT INTO MACRO_NUTRIMENT (ID, CALORIES, GLUCIDES, LIPIDES, PROTEINES, RECETTE_ID)
VALUES
    (@uuid_macronutriment_1, 620, 70, 25, 30, @uuid_recette_1);

-- Étapes de préparation (chaque étape dans une ligne SQL)
INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_1, 'Faites bouillir une grande casserole d''eau salée et faites cuire les spaghetti selon les instructions sur l''emballage jusqu''à ce qu''ils soient al dente.');

INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_1, 'Dans une grande poêle, faites chauffer de l''huile d''olive à feu moyen. Ajoutez l''oignon haché et l''ail émincé dans la poêle et faites sauter jusqu''à ce qu''ils soient dorés et parfumés.');

INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_1, 'Incorporez la viande hachée de bœuf et faites cuire jusqu''à ce qu''elle soit bien dorée et émiettée.');

INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_1, 'Ajoutez la sauce tomate et les herbes italiennes à la viande dans la poêle. Assaisonnez avec du sel, du poivre et du sucre selon votre goût.');

INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_1, 'Laissez mijoter la sauce à feu doux pendant environ 20 minutes, en remuant de temps en temps.');

INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_1, 'Égouttez les spaghetti cuits et mélangez-les avec la sauce à la viande dans la poêle.');

INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_1, 'Servez chaud, garni de fromage râpé et de feuilles de basilic frais.');

-- Génération d'UUID
SET @uuid_auteur = random_uuid();
SET @uuid_recette_hamburger = random_uuid();

-- Création de l'auteur
INSERT INTO AUTEUR (ID, NOM, PRENOM)
VALUES (@uuid_auteur, 'SMITH', 'JOHN');

-- Création de la recette de hamburger
INSERT INTO RECETTE (ID, TITRE, DUREE, AUTEUR_ID, DESCRIPTION)
VALUES
    (@uuid_recette_hamburger, 'Hamburger', '00:20', @uuid_auteur, 'Une recette classique de hamburger fait maison.');

-- Création des ingrédients
SET @uuid_ingredient_pain_hamburger = random_uuid();
SET @uuid_ingredient_viande_hachee = random_uuid();
SET @uuid_ingredient_salade = random_uuid();
SET @uuid_ingredient_tomate = random_uuid();
SET @uuid_ingredient_oignon = random_uuid();
SET @uuid_ingredient_fromage = random_uuid();
SET @uuid_ingredient_ketchup = random_uuid();
SET @uuid_ingredient_moutarde = random_uuid();

INSERT INTO INGREDIENT (ID, NOM)
VALUES
    (@uuid_ingredient_pain_hamburger, 'Pain à hamburger'),
    (@uuid_ingredient_viande_hachee, 'Viande hachée de bœuf'),
    (@uuid_ingredient_salade, 'Feuilles de laitue'),
    (@uuid_ingredient_tomate, 'Tranches de tomate'),
    (@uuid_ingredient_oignon, 'Oignon tranché'),
    (@uuid_ingredient_fromage, 'Fromage cheddar'),
    (@uuid_ingredient_ketchup, 'Ketchup'),
    (@uuid_ingredient_moutarde, 'Moutarde');

-- Association des ingrédients à la recette de hamburger
INSERT INTO RECETTE_INGREDIENT (INGREDIENT_ID, RECETTE_ID)
VALUES
    (@uuid_ingredient_pain_hamburger, @uuid_recette_hamburger),
    (@uuid_ingredient_viande_hachee, @uuid_recette_hamburger),
    (@uuid_ingredient_salade, @uuid_recette_hamburger),
    (@uuid_ingredient_tomate, @uuid_recette_hamburger),
    (@uuid_ingredient_oignon, @uuid_recette_hamburger),
    (@uuid_ingredient_fromage, @uuid_recette_hamburger),
    (@uuid_ingredient_ketchup, @uuid_recette_hamburger),
    (@uuid_ingredient_moutarde, @uuid_recette_hamburger);

-- Informations nutritionnelles
SET @uuid_macronutriment_hamburger = random_uuid();

INSERT INTO MACRO_NUTRIMENT (ID, CALORIES, GLUCIDES, LIPIDES, PROTEINES, RECETTE_ID)
VALUES
    (@uuid_macronutriment_hamburger, 500, 45, 25, 20, @uuid_recette_hamburger);

-- Étapes de préparation
INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_hamburger, '1. Préchauffez le grill ou la poêle à feu moyen-élevé.');
INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_hamburger, '2. Formez des galettes de viande hachée et assaisonnez-les avec du sel et du poivre.');
INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_hamburger, '3. Faites cuire les galettes de viande jusqu''à ce qu''elles soient cuites à votre goût.');
INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_hamburger, '4. Pendant ce temps, faites griller les pains à hamburger.');
INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_hamburger, '5. Disposez la laitue, les tranches de tomate et les oignons sur la base du pain à hamburger.');
INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_hamburger, '6. Placez les galettes de viande cuites sur les légumes.');
INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_hamburger, '7. Ajoutez une tranche de fromage cheddar sur chaque galette.');
INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_hamburger, '8. Refermez les hamburgers avec les parties supérieures des pains.');
INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_hamburger, '9. Servez chaud avec du ketchup et de la moutarde.');

-- Génération d'UUID
SET @uuid_recette_pizza = random_uuid();

-- Création de la recette de Pizza Margherita
INSERT INTO RECETTE (ID, TITRE, DUREE, AUTEUR_ID, DESCRIPTION)
VALUES
    (@uuid_recette_pizza, 'Pizza Margherita', '00:30', @uuid_auteur, 'La classique pizza Margherita avec de la mozzarella et des tomates.');

-- Création des ingrédients
SET @uuid_ingredient_pate_pizza = random_uuid();
SET @uuid_ingredient_tomates = random_uuid();
SET @uuid_ingredient_mozzarella = random_uuid();
SET @uuid_ingredient_basilic = random_uuid();
SET @uuid_ingredient_huile_olive = random_uuid();
SET @uuid_ingredient_sel = random_uuid();
SET @uuid_ingredient_poivre = random_uuid();

INSERT INTO INGREDIENT (ID, NOM)
VALUES
    (@uuid_ingredient_pate_pizza, 'Pâte à pizza'),
    (@uuid_ingredient_tomates, 'Tomates mûres'),
    (@uuid_ingredient_mozzarella, 'Fromage mozzarella'),
    (@uuid_ingredient_basilic, 'Feuilles de basilic frais'),
    (@uuid_ingredient_huile_olive, 'Huile d''olive extra vierge'),
    (@uuid_ingredient_sel, 'Sel'),
    (@uuid_ingredient_poivre, 'Poivre noir');

-- Association des ingrédients à la recette de Pizza Margherita
INSERT INTO RECETTE_INGREDIENT (INGREDIENT_ID, RECETTE_ID)
VALUES
    (@uuid_ingredient_pate_pizza, @uuid_recette_pizza),
    (@uuid_ingredient_tomates, @uuid_recette_pizza),
    (@uuid_ingredient_mozzarella, @uuid_recette_pizza),
    (@uuid_ingredient_basilic, @uuid_recette_pizza),
    (@uuid_ingredient_huile_olive, @uuid_recette_pizza),
    (@uuid_ingredient_sel, @uuid_recette_pizza),
    (@uuid_ingredient_poivre, @uuid_recette_pizza);

-- Informations nutritionnelles
SET @uuid_macronutriment_pizza = random_uuid();

INSERT INTO MACRO_NUTRIMENT (ID, CALORIES, GLUCIDES, LIPIDES, PROTEINES, RECETTE_ID)
VALUES
    (@uuid_macronutriment_pizza, 800, 100, 30, 25, @uuid_recette_pizza);

-- Étapes de préparation
INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_pizza, '1. Préchauffez le four à 220°C (430°F).');
INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_pizza, '2. Abaissez la pâte à pizza sur une plaque de cuisson.');
INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_pizza, '3. Étalez une fine couche de sauce tomate sur la pâte.');
INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_pizza, '4. Disposez les tranches de mozzarella sur la sauce tomate.');
INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_pizza, '5. Coupez les tomates en rondelles et placez-les sur la pizza.');
INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_pizza, '6. Assaisonnez avec du sel, du poivre et quelques feuilles de basilic.');
INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_pizza, '7. Arrosez d''huile d''olive.');
INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_pizza, '8. Faites cuire au four préchauffé pendant 15-20 minutes ou jusqu''à ce que la croûte soit dorée et croustillante.');
INSERT INTO ETAPE (id, recette_id, instruction)
VALUES
    (random_uuid(), @uuid_recette_pizza, '9. Servez chaud et dégustez votre Pizza Margherita.');
