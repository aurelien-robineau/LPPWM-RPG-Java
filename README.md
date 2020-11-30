# LPPWM - JAVA - Jeu RPG
Jeu RPG dans la console réalisé en JAVA dans le cadre d'un TP à la licence professionelle Projet Web et Mobile de Sorbonne Université.

## Déroulement
Le joueur commence par choisir son personnage.  
Son point de départ est en bas à gauche de la carte. Il doit parvenir jusqu'à la case en haut à droite de la carte.  
Cette case est gardée par un dragon. Afin de pouvoir battre le dragon, le joueur doit aller tuer d'autres monstres afin d'acheter des armes et des boissons.

## Particularité des personnages
### Nain
Le nain inflige plus de dégâts à mains nues. Son nombre de points de vie maximal est supérieur aux autres personnages.  
Il récupère plus de points de vie en buvant de la bière que les autres personnages.  
Il inflige plus de dégâts avec une hache que les autres personnages.

### Elfe
L'elfe récupère plus de points de vie en buvant de l'élixir que les autres personnages.  
Il inflige plus de dégâts avec un arc que les autres personnages. Lorsqu'il possède un arc dans son inventaire, les monstres lui infligent moins de dégâts.

### Sorcier
Le sorcier a un nombre de points de vie maximal inférieur aux autres personnages.  
Il récupère plus de points de vie en buvant de la potion que les autres personnages. Les potions lui permettent aussi d'augmenter son nombre de points de vie miximal.  
Armé d'un bâton en bois, c'est cependant le plus puissant des personnages.

## Représentations des entités sur la carte
### Personnages
* Nain : `Dw`
* Elfe : `Ef`
* Sorcier : `Wz`

### Monstres
* Gnome : `Gn`
* Zombie : `Zb`
* Loup-garou : `Ww`
* Dragon : `Dg`

### Obstacles
* Mur : `##`
* Pierre : `[]`
* Buisson : `**`
* Feu : `^^`
