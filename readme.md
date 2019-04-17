MicroProfile Université Devoxx FR 2019
==
Ce produit correspond à l'ensemble des démonstrations de l'université à DevoxxFR 2019

Général
=
 - [Présentation](https://speakerdeck.com/lbenoit/creer-facilement-des-microservices-ou-cloud-native-java-avec-eclipse-microprofile)

 - CFP Devoxx FR [Annonce](https://cfp.devoxx.fr/2019/talk/LGU-0798/Creer_facilement_des_microservices__avec_Eclipse_MicroProfile)

Contenu
=
Voici la liste des projets :
 - jaxrs : Projet Java utilisant uniquement JavaEE / JakartaEE,
  		   pour générer un war à déployer sur serveur d'application
 - mp-config : Pour manipuler la spécification MicroProfile Config
 - mp-fault-tolerance : Pour manipuler la spécification MicroProfile Fault Tolerance
 - mp-health : Pour manipuler la spécification MicroProfile Health Checks
 - mp-jaxrs : Même code que jaxrs mais avec une dépendance MicroProfile au lieu de JavaEE / JakartaEE
 - mp-jwt : Pour manipuler la spécification MicroProfile JWT
 - mp-metrics : Pour manipuler la spécification MicroProfile Metrics
 - mp-openapi : Pour manipuler la spécification MicroProfile OpenAPI
 - mp-opentracing : Pour manipuler la spécification MicroProfile OpenTracing
 - mp-rest-client : Pour manipuler la spécification MicroProfile Rest Client

Le projet microprofile-parent permet de définir deux profils avec les plugins Maven nécessaire au implémentation. (Thorntail et Open Liberty)

Utilisation de branches
= 
Les branches sont utilisées pour obtenir les différentes solutions.
Par défaut, il faut commencer avec la branche mp-start afin de commencer l'exercice.
Pour avoir la solution, il suffit de choisir la branche correspondant ayant le nom spécification-finish
 
Compilation
= 
Pour réaliser la compilation, il suffit d'utiliser maven  
Pour Thorntail
``mvn package -P thorntail-v2``

> Le plugin Thorntail est configuré pour créer un hollow-jar.  
> L'exécution est faite par ``java -jar nom-projet-thorntail.jar mon-projet.war``

Pour OpenLiberty
``mvn package -P liberty``

Liens utiles
=
Projet [MicroProfile](https://microprofile.io)
[Liste](https://wiki.eclipse.org/MicroProfile/Implementation) des Implémentations
Projet [Thorntail](https://thorntail.io/)  
Projet [Open Liberty](https://openliberty.io/) 
Starter [lien](https://start.microprofile.io/)