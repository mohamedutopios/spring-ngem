# Gestion Patient
1-Architecture :
![architecture](https://user-images.githubusercontent.com/92646945/233733151-a0dfbb86-820e-412c-bb5e-8b6f8a184008.png)

L'architecture JEE (Java Enterprise Edition) pour les applications Web se compose de trois couches principales : la couche présentation, la couche métier et la couche d'accès aux données. La couche présentation est la partie visible de l'application, qui est généralement composée de pages JSP (JavaServer Pages) et de contrôleurs (Servlets) qui communiquent avec le client HTTP.

Le modèle de conception MVC (Modèle-Vue-Contrôleur) est généralement utilisé pour structurer la couche présentation d'une application JEE. Dans ce modèle, les pages JSP agissent comme la vue, qui est responsable de la présentation des données à l'utilisateur final. Les contrôleurs, qui sont des Servlets, agissent comme le contrôleur, qui reçoit les demandes du client HTTP, traite les données et retourne une réponse appropriée.

La couche métier est la partie de l'application qui contient la logique métier et est généralement composée de classes Java. Cette couche est responsable de la validation des données, de l'exécution de la logique métier et de la communication avec la couche d'accès aux données.

Enfin, la couche d'accès aux données est responsable de l'interaction avec les sources de données, telles que les bases de données, les fichiers ou les services Web. Cette couche est généralement composée de classes DAO (Data Access Object) qui fournissent une interface pour interagir avec les sources de données.

Dans l'ensemble, les composants JSP, Servlet, couche métier et couche d'accès aux données travaillent ensemble pour créer des applications Web JEE dynamiques et robustes. Les Servlets agissent comme un contrôleur pour les demandes HTTP, communiquent avec la couche métier pour traiter les données et utilisent les pages JSP pour présenter les résultats au client HTTP.

2-Les interfaces de l'application :

Interface Login :
---
![login](https://user-images.githubusercontent.com/92646945/233733176-35400734-5f86-43b1-8c05-99a42fba2b03.png)

Interface User :
---
![interface_user](https://user-images.githubusercontent.com/92646945/233733192-cf5c72f0-f345-4498-910a-75614fb91d3b.png)

Barre de recherche :
---
![recherche](https://user-images.githubusercontent.com/92646945/233733207-fad7bea6-4218-49e4-809e-2c27b35888aa.png)

Interface Admin :
---
![interface_admin](https://user-images.githubusercontent.com/92646945/233733228-9d082d82-73aa-4c39-8ba3-804a4f00a1aa.png)

Ajouter :
---
![ajout](https://user-images.githubusercontent.com/92646945/233733264-5e31408c-4cf9-48ec-8a5f-102f6f8f5f40.png)

Editer :
---
![edit](https://user-images.githubusercontent.com/92646945/233733271-f4fb4b81-c7fb-4018-b135-ef57f92bdef9.png)
Supprimer :
---
![delete 1](https://user-images.githubusercontent.com/92646945/233733285-404854da-2a88-4e0b-b5cf-82ccf5618a7d.png)
![delete2](https://user-images.githubusercontent.com/92646945/233733293-ed5d839a-ca2f-452c-b55b-e737b9f92786.png)

3-Structure de Projet & Code

![structure1](https://user-images.githubusercontent.com/92646945/233782910-6060a762-b231-4633-85eb-ca21531ae2a0.png)

La structure de projet Spring Initializr dans IntelliJ intègre le système de gestion de projet Maven. Maven est un outil qui permet de gérer les dépendances du projet, de compiler le code source, de créer des exécutables et de les déployer. Il utilise un fichier de configuration appelé "pom.xml" pour décrire le projet et ses dépendances. Dans le cas de Spring Initializr, Maven est utilisé pour gérer les dépendances de Spring et d'autres bibliothèques, afin de faciliter la création de projets à partir de modèles pré-définis. La structure de projet fournie par Spring Initializr inclut également des dossiers et des fichiers pré-configurés pour les tests, les ressources, les vues, les contrôleurs, les entités et les configurations de base de données.

--> Fichier de configuration application.properties :
---
![applicationproperties](https://user-images.githubusercontent.com/92646945/233785695-2608f826-3652-4c0b-b649-320fd4eaf576.png)

Ceci est un fichier de configuration pour une application Spring Boot qui utilise une base de données MySQL:

*server.port=8086: cette ligne définit le port sur lequel le serveur Spring sera accessible.
*spring.datasource.url=jdbc:mysql://localhost:3306/pat_db?createDatabaseIfNotExist=true: cette ligne définit l'URL de la base de données MySQL à utiliser. Ici, la base de données est nommée "pat_db" et elle sera créée si elle n'existe pas déjà. La base de données sera accessible sur le serveur MySQL local sur le port 3306.
*spring.datasource.username=root: cette ligne spécifie le nom d'utilisateur de la base de données MySQL.
*spring.datasource.password=: cette ligne spécifie le mot de passe de la base de données MySQL.
*spring.jpa.hibernate.dialect=org.hibernate.dialect.MariaDBDialect: cette ligne définit le dialecte Hibernate à utiliser pour communiquer avec la base de données. Ici, le dialecte MariaDB est utilisé.
*spring.jpa.hibernate.ddl-auto=update: cette ligne spécifie comment Hibernate doit gérer les modifications apportées à la structure de la base de données. Ici, Hibernate mettra automatiquement à jour la structure de la base de données si nécessaire.
*spring.jpa.show-sql=true: cette ligne active l'affichage des requêtes SQL générées par Hibernate dans la console.
*spring.thymeleaf.cache=false: cette ligne désactive le cache Thymeleaf pour permettre une mise à jour en temps réel des pages HTML lors du développement.

-->Classe Patient
---
![Patient](https://user-images.githubusercontent.com/92646945/233783161-25a8353a-97f3-44a7-b86d-040294f8e5d1.png)

L'entité Patient définit la structure des données pour représenter les informations relatives aux patients dans une application web basée sur le modèle MVC. La classe contient plusieurs champs qui correspondent aux attributs du patient, tels que le nom, la date de naissance, l'état de santé, le score, etc. Ces champs sont annotés avec des contraintes de validation pour garantir l'intégrité des données.

En utilisant l'API de persistence Jakarta, l'entité Patient peut être facilement stockée en base de données, ce qui permet de récupérer et de manipuler les données à l'aide de requêtes SQL. L'entité est également utilisée dans la couche modèle de l'application pour encapsuler la logique métier et interagir avec la base de données. Dans l'ensemble, l'entité Patient est un élément clé de l'architecture d'une application web MVC, car elle permet de représenter et de stocker les données des patients de manière structurée et fiable.

--> Interface Patient repository : 
---
![repoPatient](https://user-images.githubusercontent.com/92646945/233783261-496452ae-5c0f-4753-80c8-937927c7dcf7.png)

Ce code définit une interface PatientRepository qui étend l'interface JpaRepository fournie par Spring Data JPA. Cette interface permet de définir les méthodes de la couche Métier pour interagir avec les données de l'entité Patient stockées en base de données. En étendant JpaRepository, cette interface hérite de méthodes CRUD de base telles que save(), findById(), deleteById(), etc.

La méthode findByNomContains() permet de rechercher les patients dont le nom contient un mot-clé spécifique. Elle prend en paramètre une chaîne de caractères (kw) et un objet Pageable pour spécifier la pagination. Cette méthode utilise la convention de nommage de méthode de Spring Data JPA, qui génère automatiquement la requête SQL correspondante à partir du nom de la méthode.

--> Classe Patient Controller : 
---
![PatientController1](https://user-images.githubusercontent.com/92646945/233783316-81b0026d-02ac-4535-9b26-86b8aab2d145.png)
![PatientController2](https://user-images.githubusercontent.com/92646945/233783517-b453a8a7-9637-4b34-83e4-e5a27c026ea5.png)
![PatientController3](https://user-images.githubusercontent.com/92646945/233783674-65b26c7b-1aee-4b5c-9934-5bca9a4eed98.png)

Ces extraits de code font partie d'une application web de gestion de patients qui utilise Spring Boot et Spring Security. Le contrôleur gère les requêtes HTTP et interagit avec le modèle de données via le repository. Le contrôleur permet d'afficher la liste des patients, de supprimer un patient, d'afficher le formulaire pour ajouter un nouveau patient, de sauvegarder les modifications d'un patient existant et d'afficher le formulaire pour éditer un patient existant. L'application dispose d'un système de sécurité qui vérifie les rôles des utilisateurs avant de leur permettre d'effectuer certaines actions.

--> Classe SecuController :
---
![SecuController2](https://user-images.githubusercontent.com/92646945/233783839-4060fad8-fb57-4fb1-b68d-db9727357709.png)

Ce code définit un contrôleur Spring qui gère les requêtes pour deux pages web : "/notAuthorized" et "/login". La méthode "notAuthorize" retourne la chaîne "notAuthorized" qui correspond à une vue de l'application, tandis que la méthode "login" retourne la chaîne "login" qui correspond également à une vue.

--> Classe SecurityConfig :
---
![security](https://user-images.githubusercontent.com/92646945/233784045-a6ca9d81-1f49-49bd-bde2-187a692c9d89.png)

Ce code configure la sécurité pour l'application web en utilisant Spring Security. Il définit un InMemoryUserDetailsManager qui stocke les informations d'identification pour les utilisateurs, y compris leurs noms d'utilisateur, leurs mots de passe et leurs rôles. Il définit également une SecurityFilterChain qui gère les demandes HTTP en fonction des autorisations accordées aux utilisateurs. Les pages de connexion et d'accès refusé sont également définies. Les règles de sécurité pour les pages de l'application ne sont pas encore activées, mais sont commentées dans le code.

--> Les templates :
---
![templates](https://user-images.githubusercontent.com/92646945/233784180-f0c4ad84-9805-446c-81e5-c9d1d8a1aba8.png)

-Template Login :

![LoginCode](https://user-images.githubusercontent.com/92646945/233784281-037e2a61-06e2-45d2-8c27-b0b6edde205b.png)

Ce code HTML est une page de formulaire d'authentification. La balise HTML <head> contient les informations sur le titre de la page et l'encodage du texte. La balise <body> contient le contenu de la page.La page utilise Bootstrap pour le style, qui est chargé depuis le dépôt Maven (webjars).
Elle contient un formulaire de connexion avec les champs "Nom" et "Password", ainsi qu'une case à cocher pour "Remember me" et un bouton de connexion. Le formulaire envoie les données en utilisant la méthode HTTP POST à l'URL "/login", qui sera géré par le serveur.
Thymeleaf est également utilisé pour la génération dynamique de la page HTML. Les attributs th:* sont des attributs spéciaux de Thymeleaf qui permettent d'ajouter des fonctionnalités dynamiques à la page, telles que les expressions conditionnelles, les itérations et les variables.
    
-Layout template1 :
    
![Layout](https://user-images.githubusercontent.com/92646945/233785140-d05abbd8-b0c8-454b-bede-9f70bc203408.png)

Ce code HTML correspond à une page web avec une barre de navigation en haut. La barre de navigation contient deux onglets "Home" et "Patients". L'onglet "Patients" est un menu déroulant qui contient deux sous-onglets "Chercher" et "Nouveau". Il y a également un troisième onglet dans la barre de navigation qui affiche le nom de l'utilisateur connecté et qui contient un bouton de déconnexion.
La section principale de la page est vide et est destinée à contenir le contenu spécifique à chaque page. Ce code utilise également le framework Thymeleaf pour générer dynamiquement la page HTML.

-Template Patients :
    
![codeUser1](https://user-images.githubusercontent.com/92646945/233784579-6b40f535-eb88-4dc2-b130-4aada80d0fa4.png)
![codeUser2](https://user-images.githubusercontent.com/92646945/233784583-49ddf070-d3ac-4f10-97be-19984c66d627.png)

La page affiche une liste de patients avec leurs informations personnelles telles que leur nom, date de naissance, s'ils sont malades ou non, et leur score. La liste peut être filtrée par mot-clé avec un champ de recherche et un bouton de recherche.Elle est également intégrée à un modèle de mise en page appelé "template1.html" avec l'attribut "layout:decorate".
La liste est affichée dans un tableau avec des boutons pour supprimer ou éditer chaque patient, mais seulement si l'utilisateur a le rôle d'administrateur. La pagination est également implémentée avec des boutons pour naviguer entre les différentes pages de la liste.
    
-Template formPatients et editPatients :

![formPatient](https://user-images.githubusercontent.com/92646945/233785234-7fa03663-1ce5-410d-b856-07ddeae5f2e4.png)
![editPatient](https://user-images.githubusercontent.com/92646945/233785401-c44ca935-3cb4-4f66-89c2-c2c5d138a04f.png)
    
L'application comprend deux formulaires permettant d'ajouter ou de modifier des informations de patients dans une base de données. Ces formulaires contiennent les champs suivants : ID,nom, date de naissance, statut de malade (sous forme de case à cocher) et score. Pour soumettre le formulaire, la méthode POST est utilisée, envoyant les données à l'URL /admin/save. Si une erreur survient, l'attribut Thymeleaf th:errors est utilisé pour gérer les erreurs et les afficher en rouge à côté du champ correspondant.
    
-Template notAuthorized :
    
![CodeErreur](https://user-images.githubusercontent.com/92646945/233785545-67a5d38e-6966-48e7-8200-738dbb85715d.png)
![PageNotZuthorized](https://user-images.githubusercontent.com/92646945/233785547-8f59455e-3338-4aba-a841-245896c6be51.png)

 
