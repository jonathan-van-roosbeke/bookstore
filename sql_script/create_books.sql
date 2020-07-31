
-- -----------------------------
-- CREATION LIVRE --------------
-- -----------------------------
DROP TABLE IF EXISTS t_livre;
CREATE TABLE bookstore.t_livre (
	reference_livre INT auto_increment NOT NULL,
	id_auteur INT NOT NULL,
	titre_livre varchar(100) NOT NULL,
	quantite_stock INT NOT NULL,
	nombre_page INT NOT NULL,
	synopsis varchar(300) NOT NULL,
	nom_image varchar(100) NOT NULL,
	prix FLOAT NOT NULL,
	CONSTRAINT t_livre_pk PRIMARY KEY (reference_livre)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

-- -----------------------------
-- CREATION AUTEUR -------------
-- -----------------------------
DROP TABLE IF EXISTS t_auteur;
CREATE TABLE bookstore.t_auteur (
	id_auteur INT auto_increment NOT NULL REFERENCES t_livre(id_auteur),
	nom_auteur varchar(100) NOT NULL,
	prenom_auteur varchar(100) NOT NULL,
	CONSTRAINT t_auteur_pk PRIMARY KEY (id_auteur)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

-- -----------------------------
-- INSERT LIVRE-----------------
-- -----------------------------
INSERT into t_livre ()
values (
	1, 				-- reference_livre
	1, 				-- id_auteur
	"The Shark", 	-- titre_livre
	3, 				-- quantite en stock
	255, 			-- nombre de page
	"Les requins, squales ou s�lachimorphes forment un super-ordre de poissons cartilagineux, poss�dant cinq � sept fentes branchiales sur les c�t�s de la t�te et les nageoires pectorales qui ne sont pas fusionn�es � la t�te.", -- synopsis
	"shark.jpg", 	-- nom de l'image
	33.2 			-- prix
);

INSERT into t_livre ()
values (
	2, 				-- reference_livre
	2, 				-- id_auteur
	"L�-haut", 		-- titre_livre
	15, 				-- quantite en stock
	455, 			-- nombre de page
	"Denis suit un vendeur de ballons de 78 ans, Carl Fredricksen, au moment o� il r�alise enfin le r�ve de sa vie. Son d�sir de vivre une grande aventure le pousse � attacher des milliers de ballons � sa maison pour s'envoler vers les r�gions sauvages de l'Am�rique du Sud", -- synopsis
	"la-haut.jpg", 	-- nom de l'image
	45 				-- prix
);

INSERT into t_livre ()
values (
	3, 				-- reference_livre
	3, 				-- id_auteur
	"Le renouveau", 	-- titre_livre
	2, 				-- quantite en stock
	233, 			-- nombre de page
	"Une saison est une p�riode de l'ann�e qui observe une relative constance du climat et de la temp�rature. D'un point de vue astronomique, une saison correspond � l'intervalle de temps durant lequel la Terre occupe une portion de l'espace de sa r�volution (rotation) autour du Soleil. ", -- synopsis
	"saison.jpg", 	-- nom de l'image
	18.5			-- prix
);

INSERT into t_livre ()
values (
	4, 				-- reference_livre
	4, 				-- id_auteur
	"Jon Doe", 		-- titre_livre
	7, 				-- quantite en stock
	677, 			-- nombre de page
	"La d�nomination � John Doe � appara�t en 17682 dans le droit coutumier anglais, o� elle d�signe un plaignant inconnu, alors qu'un accus� anonyme est appel� � Richard Roe �.", -- synopsis
	"jondoe.jpg", 	-- nom de l'image
	27.2			-- prix
);

INSERT into t_livre ()
values (
	5, 				-- reference_livre
	5, 				-- id_auteur
	"Jon Doe", 		-- titre_livre
	9, 				-- quantite en stock
	521, 			-- nombre de page
	"Noble de V�rone apparent� aux Capulet. Il tombe amoureux de Juliette et, voyant l� un bon parti, demande sa main � son p�re. Il obtient l'autorisation de lui faire la cour.", -- synopsis
	"romeo.jpg", 	-- nom de l'image
	18.55			-- prix
);

INSERT into t_livre ()
values (
	6, 				-- reference_livre
	1, 				-- id_auteur
	"Artic", 	-- titre_livre
	6, 				-- quantite en stock
	273, 			-- nombre de page
	"un homme nomm� Overgard est bloqu� dans l�Arctique. Il vit dans la carcasse de son avion et parvient � se nourrir en p�chant du poisson. Alors qu'il se croit sauv� par l'arriv�e d'un h�licopt�re, celui-ci s'�crase.", -- synopsis
	"artic.jpg", 	-- nom de l'image
	15.6			-- prix
);

INSERT into t_livre ()
values (
	7, 				-- reference_livre
	1, 				-- id_auteur
	"Uruguay", 	-- titre_livre
	21, 				-- quantite en stock
	421, 			-- nombre de page
	"Le nom Uruguay vient du guarani. Bien que sa signification ne soit pas tr�s claire, F�lix de Azara affirma que ce nom d�signe un petit oiseau nomm� el ur� qui vit sur les rives du fleuve Uruguay", -- synopsis
	"uruguay.jpg", 	-- nom de l'image
	15.6			-- prix
);

INSERT into t_livre ()
values (
	8, 				-- reference_livre
	1, 				-- id_auteur
	"La r�ussite", 	-- titre_livre
	10, 				-- quantite en stock
	423, 			-- nombre de page
	"La diversit� ordinaire des parcours scolaires du secondaire, les singularit�s personnelles et la derni�re r�forme du baccalaur�at avec les sp�cialit�s et leurs associations complexes.", -- synopsis
	"reussite.jpg", -- nom de l'image
	20.3			-- prix
);

INSERT into t_livre ()
values (
	9, 				-- reference_livre
	2, 				-- id_auteur
	"Le chateau dans le ciel", 	-- titre_livre
	23, 				-- quantite en stock
	652, 			-- nombre de page
	"Des pirates du ciel, la � bande de Dora �, attaquent une forteresse volante ; ils recherchent une � pierre volante � appartenant � une jeune fille, Sheeta, retenue prisonni�re. Cette derni�re arrive � s'enfuir pour atterrir chez Pazu, un gar�on de son �ge. ", -- synopsis
	"chateau.jpg", -- nom de l'image
	29.3			-- prix
);

INSERT into t_livre ()
values (
	10, 				-- reference_livre
	2, 				-- id_auteur
	"Membrane d'argent", 	-- titre_livre
	13, 				-- quantite en stock
	512, 			-- nombre de page
	"Tim passe une bonne partie de ses jeunes ann�es � l'�tranger, ce qui lui permet de ma�triser parfaitement l'allemand et le fran�ais, gr�ce au travail de son p�re comme repr�sentant � l'�tranger de la firme britannique d'�quipement militaire Vickers. ", -- synopsis
	"membraneargent.jpg", -- nom de l'image
	26.2			-- prix
);

INSERT into t_livre ()
values (
	11, 				-- reference_livre
	3, 				-- id_auteur
	"Aristote", 	-- titre_livre
	23, 				-- quantite en stock
	429, 			-- nombre de page
	"La vie d'Aristote n�est connue que dans ses grandes. Son oeuvre ne comporte que tr�s peu de d�tails biographiques et peu de t�moignages de ses contemporains nous sont parvenus ", -- synopsis
	"aristote.jpg", -- nom de l'image
	30.5			-- prix
);

INSERT into t_livre ()
values (
	12, 				-- reference_livre
	4, 				-- id_auteur
	"Le salut", 	-- titre_livre
	28, 				-- quantite en stock
	456, 			-- nombre de page
	"La deuxi�me guerre d'Irak a �t� men�e sous l'impulsion des �tats-Unis. Apr�s avoir lanc� une offensive en Afghanistan, lieu o� Oussama Ben Laden se serait r�fugi� apr�s les attentats du 11 septembre 2001, et suspectant des liens entre le r�gime irakien et les terroristes d'Al-Qa�da", -- synopsis
	"lesalut.jpg", -- nom de l'image
	18.99			-- prix
);



-- -----------------------------
-- INSERT AUTEUR----------------
-- -----------------------------

INSERT INTO	T_AUTEUR ()
VALUES (1, "Michel", "Dupont");

INSERT INTO	T_AUTEUR ()
VALUES (2, "Robin", "Desbois");

INSERT INTO	T_AUTEUR ()
VALUES (3, "Maxime", "Chattam");

INSERT INTO	T_AUTEUR ()
VALUES (4, "Sandrine", "Ledoux");

INSERT INTO	T_AUTEUR ()
VALUES (5, "Romeo", "Tutzani");


SELECT * FROM T_LIVRE;
SELECT * FROM T_AUTEUR;

SELECT * FROM T_LIVRE TL
JOIN T_AUTEUR TA ON tl.ID_AUTEUR = ta.ID_AUTEUR;
