1) Telecharger les données dans le fichier Structure_climbing.sql et les sauvegarder dans le répertoir de votre choix

2) Importer les dans un gestionnaire de base de données (ici réalisé avec PgAdmin) en effectuant ces manipulations :
1. Se connecter au serveur PGSQL avec pgAdmin.
2. Créer une base de données vierge (clic droit, Create, Database) sauf si elle existe déjà.
3. Faire un clic droit sur la base de données, Restore.
4. A l’onglet General, dans le champ Filename, charger le fichier depuis le disque du serveur local ou un partage du réseau.

3) Placer dans le répertoire du projet Maven, là où se trouve le pom.xml. Lancer la commande mvn eclipse:eclipse.

4) Importer le projet en faisant : Import > Existing Maven Projects > Browse > Selectionner le fichier concerné > finish

5) Compiler

6) Cliquer sur l'icone "run"

7) Pour afficher le site rendez-vous sur http://localhost:9001/


