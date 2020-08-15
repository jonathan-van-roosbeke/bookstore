DROP TABLE IF EXISTS t_article_cmd;
DROP TABLE IF EXISTS t_commande;
DROP TABLE IF EXISTS t_utilisateur;
DROP TABLE IF EXISTS t_adresse;
DROP TABLE IF EXISTS t_livre;
DROP TABLE IF EXISTS t_auteur;
-- -----------------------------
-- CREATION LIVRE --------------
-- -----------------------------
CREATE TABLE t_livre (
	reference_livre INT auto_increment NOT NULL,
	id_auteur INT NOT NULL,
	titre_livre varchar(100) NOT NULL,
	quantite_stock INT NOT NULL,
	nombre_page INT NOT NULL,
	synopsis varchar(300) NOT NULL,
	nom_image varchar(100) NOT NULL,
	prix_livre Decimal(4,2) NOT NULL,
	CONSTRAINT t_livre_pk PRIMARY KEY (reference_livre)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

-- -----------------------------
-- CREATION AUTEUR -------------
-- -----------------------------
CREATE TABLE t_auteur (
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
	"Les requins, squales ou sélachimorphes forment un super-ordre de poissons cartilagineux, possédant cinq à sept fentes branchiales sur les cétés de la tête et les nageoires pectorales qui ne sont pas fusionnées à la tête.", -- synopsis
	"shark.jpg", 	-- nom de l'image
	33.20 			-- prix
);

INSERT into t_livre ()
values (
	2, 				-- reference_livre
	2, 				-- id_auteur
	"Là-haut", 		-- titre_livre
	15, 				-- quantite en stock
	455, 			-- nombre de page
	"Denis suit un vendeur de ballons de 78 ans, Carl Fredricksen, au moment où il réalise enfin le rêve de sa vie. Son désir de vivre une grande aventure le pousse à attacher des milliers de ballons à sa maison pour s'envoler vers les régions sauvages de l'Amérique du Sud", -- synopsis
	"la-haut.jpg", 	-- nom de l'image
	45.00 				-- prix
);

INSERT into t_livre ()
values (
	3, 				-- reference_livre
	3, 				-- id_auteur
	"Le fil des saisons", 	-- titre_livre
	2, 				-- quantite en stock
	233, 			-- nombre de page
	"Une saison est une période de l'année qui observe une relative constance du climat et de la température. D'un point de vue astronomique, une saison correspond à l'intervalle de temps durant lequel la Terre occupe une portion de l'espace de sa révolution (rotation) autour du Soleil. ", -- synopsis
	"fil-saison.jpg", 	-- nom de l'image
	18.50			-- prix
);

INSERT into t_livre ()
values (
	4, 				-- reference_livre
	4, 				-- id_auteur
	"John Doe", 		-- titre_livre
	7, 				-- quantite en stock
	677, 			-- nombre de page
	"La dénomination à John Doe est apparaût en 17682 dans le droit coutumier anglais,  alors qu'un accusé anonyme est appelé à Richard Roe.", -- synopsis
	"johndoe.jpg", 	-- nom de l'image
	27.25			-- prix
);

INSERT into t_livre ()
values (
	5, 				-- reference_livre
	5, 				-- id_auteur
	"Noblesse", 	-- titre_livre
	9, 				-- quantite en stock
	521, 			-- nombre de page
	"Noble de Vérone apparenté aux Capulet. Il tombe amoureux de Juliette et, voyant là un bon parti, demande sa main à son père. Il obtient l'autorisation de lui faire la cour.", -- synopsis
	"noblesse.jpg", 	-- nom de l'image
	18.55			-- prix
);

INSERT into t_livre ()
values (
	6, 				-- reference_livre
	1, 				-- id_auteur
	"Arctic", 		-- titre_livre
	6, 				-- quantite en stock
	273, 			-- nombre de page
	"un homme nommé Overgard est bloqué dans l'Arctique. Il vit dans la carcasse de son avion et parvient à se nourrir en pêchant du poisson. Alors qu'il se croit sauvé par l'arrivée d'un hélicoptère, celui-ci...", -- synopsis
	"arctic.jpg", 	-- nom de l'image
	15.60			-- prix
);

INSERT into t_livre ()
values (
	7, 				-- reference_livre
	1, 				-- id_auteur
	"Uruguay", 		-- titre_livre
	21, 				-- quantite en stock
	421, 			-- nombre de page
	"Le nom Uruguay vient du guarani. Bien que sa signification ne soit pas très claire,...", -- synopsis
	"uruguay.jpg", 	-- nom de l'image
	17.10			-- prix
);

INSERT into t_livre ()
values (
	8, 				-- reference_livre
	1, 				-- id_auteur
	"La réussite", 	-- titre_livre
	10, 				-- quantite en stock
	423, 			-- nombre de page
	"La diversité ordinaire des parcours scolaires du secondaire, les singularités personnelles et la dernière réforme du baccalauréat avec les spécialités et leurs associations complexes.", -- synopsis
	"reussite.jpg", -- nom de l'image
	20.30			-- prix
);

INSERT into t_livre ()
values (
	9, 				-- reference_livre
	2, 				-- id_auteur
	"Le chateau dans le ciel", 	-- titre_livre
	23, 				-- quantite en stock
	652, 			-- nombre de page
	"Des pirates du ciel, la à bande de Dora, attaquent une forteresse volante ; ils recherchent une pierre volante appartenant une jeune fille, Sheeta, retenue prisonnière. Cette dernière arrive à s'enfuir pour atterrir chez Pazu, un garçon de son âge. ", -- synopsis
	"chateau.jpg", -- nom de l'image
	29.30			-- prix
);

INSERT into t_livre ()
values (
	10, 				-- reference_livre
	2, 				-- id_auteur
	"Silver Eyes", 	-- titre_livre
	13, 				-- quantite en stock
	512, 			-- nombre de page
	"Tim passe une bonne partie de ses jeunes années à l'étranger, ce qui lui permet de maîtriser parfaitement l'allemand et le français, grâce au travail de son père comme représentant à l'étranger de la firme britannique d'équipement militaire Vickers. ", -- synopsis
	"silvereyes.jpg", -- nom de l'image
	26.20			-- prix
);

INSERT into t_livre ()
values (
	11, 				-- reference_livre
	3, 				-- id_auteur
	"Aristote", 	-- titre_livre
	23, 				-- quantite en stock
	429, 			-- nombre de page
	"La vie d'Aristote n'est connue que dans ses grandes. Son oeuvre ne comporte que très peu de détails biographiques et peu de témoignages de ses contemporains nous sont parvenus ", -- synopsis
	"aristote.jpg", -- nom de l'image
	30.50			-- prix
);

INSERT into t_livre ()
values (
	12, 				-- reference_livre
	4, 				-- id_auteur
	"Le salut", 	-- titre_livre
	28, 				-- quantite en stock
	456, 			-- nombre de page
	"La deuxième guerre d'Irak a été menée sous l'impulsion des États-Unis. Après avoir lancé une offensive en Afghanistan, lieu où Oussama Ben Laden se serait réfugié après les attentats du 11 septembre 2001, et suspectant des liens entre le régime irakien et les terroristes d'Al-Qaida", -- synopsis
	"lesalut.jpg", -- nom de l'image
	18.99			-- prix
);



-- -----------------------------
-- INSERT AUTEUR----------------
-- -----------------------------

INSERT INTO	t_auteur ()
VALUES (1, "Michel", "Dupont");

INSERT INTO	t_auteur ()
VALUES (2, "Robin", "Desbois");

INSERT INTO	t_auteur ()
VALUES (3, "Maxime", "Chattam");

INSERT INTO	t_auteur ()
VALUES (4, "Sandrine", "Ledoux");

INSERT INTO	t_auteur ()
VALUES (5, "Romeo", "Tutzani");

-- -----------------------------
-- CREATION ADRESSE ------------
-- -----------------------------
CREATE TABLE t_adresse (
	id_adresse INT not null primary key auto_increment,
   	numero INT NOT NULL,
   	rue VARCHAR(50),
   	ville VARCHAR(50) NOT NULL,
   	cp VARCHAR(10) NOT NULL,
	pays VARCHAR(50) NOT NULL
	
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;



-- -----------------------------
-- CREATION UTILISATEUR --------
-- -----------------------------
CREATE TABLE t_utilisateur (
	login varchar(30) not NULL PRIMARY key,
	motdepasse varchar(200) not null,
	uid int(50) NOT NULL,
	nom varchar(100) not null,
	prenom varchar(100) not null,
	email varchar(200) not null,
	status_utilisateur int(2) not null,
	id_adresse int not null,
	Foreign key (id_adresse) references t_adresse(id_adresse)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;



-- -----------------------------
-- CREATION COMMANDE -----------
-- -----------------------------
CREATE TABLE t_commande (
	numero_cmd varchar(50) NOT NULL primary key,
	date_creation datetime NOT NULL,
	status_cmd INT(2) NOT NULL,
	total_cmd Decimal(11,2) NOT NULL,
	login varchar(30) NOT NULL,
	Foreign key (login) references t_utilisateur(login)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;


-- -----------------------------
-- CREATION ACTICLE COMMANDE ---
-- -----------------------------
CREATE TABLE t_article_cmd (
	id_article int not null,
 	titre varchar(100) NOT NULL,
	quantite int NOT NULL,
	prix Decimal(11,2) NOT NULL,
	total_prix Decimal(11,2) NOT NULL,
	numero_cmd varchar(50) not null,
	Foreign key (numero_cmd) references t_commande(numero_cmd)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;


INSERT INTO t_adresse 
values (1,100,"rue de paris","Lille",59000,"France");

INSERT INTO t_adresse 
values (2,59,"rue de lille","Lille",59000,"France");

insert into t_utilisateur()
values ("admin", md5("admin"), 1, "kayne","boby","admin@afpa.fr",2,1);

INSERT into t_utilisateur()
VALUES ("client", md5("client"), 2,  "dupond", "jean", "dj@client.fr", 1, 2);



-- -----------------------------
-- VERIFICATION ----------------
-- -----------------------------

SELECT * FROM t_livre;
SELECT * FROM t_auteur;

SELECT * FROM t_livre tl
JOIN t_auteur ta ON tl.id_auteur = ta.id_auteur;

SELECT * FROM t_adresse;

SELECT * FROM t_utilisateur;