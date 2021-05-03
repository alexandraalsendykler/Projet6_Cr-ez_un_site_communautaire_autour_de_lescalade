Pré-requis : GDK8, un IDE (Eclipse par exemple), Maven installé sur votre machine, un gestionnaire de données (PgAdmin par exemple).

1) Télécharger le fichier Structure_climbing.sql et le sauvegarder dans le répertoir de votre choix

2) Importer le dans un gestionnaire de base de données (ici réalisé avec PgAdmin) en effectuant ces manipulations :
1. Se connecter au serveur PGSQL avec pgAdmin.
2. Créer une base de données vierge (clic droit, Create, Database) sauf si elle existe déjà.
3. Faire un clic droit sur la base de données, Restore.
4. A l’onglet General, dans le champ Filename, charger le fichier depuis le disque du serveur local ou un partage du réseau.

3) Cloner le répertoire GitHub

4) Se placer dans le répertoire du projet Maven, là où se trouve le pom.xml. Lancer la commande mvn eclipse:eclipse.

4) Importer le projet en faisant : Import > Existing Maven Projects > Browse > Select file > Finish 

5) Ouvrir le fichier application.properties et rentrer les données ci-dessous (au besoin adapter avec vos propres informations de connexion) :

server.port=8181

com.bibliotheque.batch.apiUrl=http://127.0.0.1:9001

spring.mail.host=smtp.gmail.com

spring.mail.port=587

spring.mail.username=<relance.pret.bibliotheque.oc@gmail.com>

spring.mail.password=<alex160383!>

spring.mail.properties.mail.smtp.auth=true

spring.mail.properties.mail.smtp.starttls.enable=true

6) Faire run as, lancer la commande spring-boot : run


