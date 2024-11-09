# TP Jakarta EE - INFO706

Binôme : Dupraz-Roget Léo, Coulmeau Paul

Ceci est une application exemple générée par le générateur de démarrage de la Fondation Eclipse pour Jakarta EE.

## Lancer l'application ##
Vous pouvez exécuter l'application en lançant la commande suivante depuis le répertoire où se trouve ce fichier. Assurez-vous d'avoir installé une [implémentation Java SE](https://adoptium.net) appropriée pour la version Jakarta EE et le runtime choisis (cet exemple suppose Java SE 17). Notez que le [Maven Wrapper](https://maven.apache.org/wrapper/) est déjà inclus dans le projet, donc une installation de Maven n'est pas nécessaire. Vous devrez peut-être d'abord exécuter `chmod +x mvnw`.

```
./mvnw clean package wildfly:dev
```

Une fois le runtime démarré, vous pouvez accéder au projet à l'adresse suivante : [http://localhost:8080/jakartaee-deliver-transport](http://localhost:8080/jakartaee-deliver-transport).

## Choix d'implémentation ##

Nous avons fais le choix de faire 3 pages Web qui représsentes les 3 clients. Un pour créer un colis, un pour modifier un colis, et enfin un dernier pour voir l'avancer du colis (l'historique).
Nous avons ajouté une page qui permet de voir l'ensemble des colis, qui s'appelle le "dashboard".
Dans le code, nous avons fais 3 servlets pour alimenter nos pages, un pour chacun d'entre eux qui sont :
```
main |
     - colisDashboard.java
     - HistoryColisServlet.java
     - storeColisServlet.java
     - ModifColis.java
```
Et pour gérer la base de donnée pour les colis et les historiques nous avons un fichier ```colisRepository.java``` qui le fais pour chacune des pages.
Nos objets EJB sont les fichiers ``Colis.java`` et ``ColisHistory.java``.
Pour la base de donnéee nous avons fais le choix d'utiliser une base de donnée H2 qui utilise le language SQL.

Au moment du push sur Github ce projet tourne correctement et compile sans erreur. Il peux toutefois sur une autre machine comme Linux, ne pas fonctionner correctemement. Nous ne savons malheuresement pas pourquois.
Mais si vous le souhaitez, nous pouvons vous faire une démonstration sur une de nos machines pour voir le resultat sur un navigateur.
Les instructions pour lancer l'application sont présenté plus haut.