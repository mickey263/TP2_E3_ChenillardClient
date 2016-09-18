# TP2_E3_ChenillardClient

Consignes :

Exercice 3 : Le chenillard UDP auto adaptatif

Réalisation de deux programmes :

• un programme serveur ordonnanceur

• un programme client


Le programme client sera lancé N fois et correspond à un terminal clignotant, le programme
serveur sera lancé une seule fois.

Le fonctionnement du programme client sera le suivant :

• démarrage du programme

• il s'enregistre auprès du serveur

• il attend ensuite les ordres du serveur : un ordre pour passer en rouge, un ordre pour
passer en vert


Le fonctionnement du programme serveur sera le suivant :

  • il gère l'enregistrement des clients les uns après les autres

  • le dernier client se connecte (pour cela, un paramètre sur la ligne de commande permet
d'indiquer au programme client qu'il est le dernier, le dernier client s'enregistre avec un
message spécifique)

  • le programme serveur envoie ensuite les ordres aux clients pour gérer correctement
l'affichage des couleurs


Optionnel :

• ajouter la possibilité pour le serveur de donner l'ordre à tous les clients de s'arrêter
