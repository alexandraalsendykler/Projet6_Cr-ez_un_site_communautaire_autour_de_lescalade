Pré-requis : GDK8, un IDE (Eclipse par exemple), Maven installé sur votre machine, un gestionnaire de données (PgAdmin par exemple).

1) Télécharger le fichier Structure_climbing.sql et le sauvegarder dans le répertoir de votre choix

2) Importer le dans un gestionnaire de base de données (ici réalisé avec PgAdmin) en effectuant ces manipulations :
1. Se connecter au serveur PGSQL avec pgAdmin.
2. Créer une base de données vierge (clic droit, Create, Database) sauf si elle existe déjà.
3. Faire un clic droit sur la base de données, Restore.
4. A l’onglet General, dans le champ Filename, charger le fichier depuis le disque du serveur local ou un partage du réseau.

3) Cloner le répertoire GitHub

4) Se placer dans le répertoire du projet Maven, là où se trouve le pom.xml. Lancer la commande mvn eclipse:eclipse.

5) Importer le projet en faisant : Import > Existing Maven Projects > Browse > Select file > Finish 

6) Ouvrir le fichier application.properties et rentrer les données ci-dessous (au besoin adapter avec vos propres informations de connexion) :

spring.datasource.url=jdbc:postgresql://localhost:5432/climbing  
spring.datasource.username=postgres  
spring.datasource.password= <mot de passe>  
spring.jpa.show-sql=true  
server.port=9001  

7) Faire run as, lancer la commande spring-boot : run

8) Pour afficher le site rendez-vous sur http://localhost:9001/
