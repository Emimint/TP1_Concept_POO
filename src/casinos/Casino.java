package casinos;

import jeux.Jeu;
import joueurs.Joueur;

public class Casino {

	private String nom;
	private Joueur[] joueurs;
	private int maxJoueurs;
	private int joueursPresents;
	private Jeu jeu;

// A gerer si j'ai le temps (ca implique d'atres methodes!!!):

//	private int capital;
//	private int gains;

	public static int nbrCasinosCrees;

	public Casino() {
		this(3);
	}

	public Casino(int maxJoueurs) {
		this("salle", maxJoueurs);
		this.nom = this.nom + "_" + nbrCasinosCrees;
	}

	public Casino(Casino autre) {

		// a DISCUTER!!! :

		// SOLUTION 1 :
		this.nom = autre.nom;
		this.maxJoueurs = autre.maxJoueurs;
		this.joueurs = new Joueur[autre.maxJoueurs];
		this.jeu = new Jeu(autre.jeu);

		nbrCasinosCrees++;

		// SOLUTION 2 :
//		this(autre.nom, autre.maxJoueurs);
//		this.jeu = new Jeu(autre.jeu);
//		
//		Jeu.nbrJeuxCrees--;
	}

	public Casino(String nom, int maxJoueurs) {
		nbrCasinosCrees++;
		this.nom = nom;
		this.maxJoueurs = maxJoueurs;
		joueursPresents = 0;
		joueurs = new Joueur[maxJoueurs];
		this.jeu = new Jeu();
	}

	public Casino(String nomJeu, int nbrResultatsJeu, int champResultatJeu) {
		this();
		this.jeu = new Jeu(nomJeu, nbrResultatsJeu, champResultatJeu);
		Jeu.nbrJeuxCrees--;
	}

	public Casino(String nom, int maxJoueurs, String nomJeu, int nbrResultatsJeu, int champResultatJeu) {
		this(nom, maxJoueurs);
		this.jeu = new Jeu(nomJeu, nbrResultatsJeu, champResultatJeu);
		Jeu.nbrJeuxCrees--;
	}

	public boolean ajouterJoueur(Joueur nouveauJoueur) {
		if (joueursPresents < maxJoueurs) {
			joueurs[joueursPresents] = nouveauJoueur;
			joueursPresents++;
			System.out.printf(
					"Le joueur \"%s\" a rejoins le casino \"%s\". Il y a maintenant %d joueur(s) dans cette salle.\n",
					nouveauJoueur.getNom(), nom, joueursPresents);
			return true;
		} else
			System.out.println("Ce casino est complet.\n");
		return false;
	}

	public void enleverJoueur(Joueur joueur) {
		this.shiftTab(this.rechercherIndice(joueur));
		joueursPresents--;
		System.out.printf(
				"Le joueur \"%s\" a quitte le casino \"%s\". Il y a maintenant %d joueur(s) dans cette salle.\n",
				joueur.getNom(), nom, joueursPresents);
	}

	public void faireUnTirage() {
		jeu.faireUnTirage();
	}

	public void jouer(Joueur joueur, int mise) {
		if (joueur.getCasino().equals(this)) {
			if (joueur.aDesSous(mise)) {
				int gains = 0;
				gains = joueur.getCapital() + jeu.calculerGains(mise) - mise;
				joueur.setCapital(gains);
				System.out.printf("%s a maintenant %d$.\n", joueur.getNom(), joueur.getCapital());
			}
		} else
			System.out.printf("Ce joueur (\"%s\") n'appartient pas a ce casino.\n", joueur.getNom());
	}

	/*
	 * fait jouer tous les joueurs presents pour une mise donnee
	 */
	public void jouer(int mise) {
		faireUnTirage();
		for (int i = 0; i < joueursPresents; i++) {
			jouer(joueurs[i], mise);
		}
	}

	/**
	 * Permet de trouver un Joueur dans une liste de Joueur.
	 *
	 * @param aTrouver Joueur dont l'existence est deja confirme
	 * @return int l'indice auquel l'item a été trouvé dans le tableau. Si l'item
	 *         n'est pas trouvé, la fonction retourne -1
	 */
	public int rechercherIndice(Joueur aTrouver) {

		boolean trouve = false;
		int counter = 0;

		while (!trouve && (counter < joueursPresents)) {
			if (joueurs[counter].equals(aTrouver)) {
				return counter;
			} else
				counter++;
		}
		return --counter;
	}

	/**
	 * Permet de reassigner successivement, dans un tableau de Joueurs, la reference
	 * d'une case avec la valeur de la case suivante.
	 *
	 * @param tableau Joueur[] dont on veut shifter les valeurs
	 * @param indice  int de l'indice de la case visée
	 */
	public void shiftTab(int indice) {
		for (int i = indice + 1; i < joueursPresents; i++) {
			joueurs[i - 1] = joueurs[i];
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getMaxJoueurs() {
		return maxJoueurs;
	}

	public int getJoueursPresents() {
		return joueursPresents;
	}

	public String getNomJeu() {
		return jeu.getNom();
	}

	public String toString() {

		String chaine;

		chaine = String.format("Le casino s'apelle \"%s\". Il a une capacite maximale de %d joueurs. ", nom,
				maxJoueurs);
		chaine += String.format("Presentement, ce casino propose ce jeu:\n \"%s\"\n", jeu);

		if (joueursPresents > 0) {
			chaine += String.format("\nIl a presentement %d joueur(s) dans cette salle. ", joueursPresents);
			chaine += "\nLes voici: ";
			for (int i = 0; i < joueursPresents; i++) {
				chaine += "\n" + joueurs[i];
			}
		} else
			chaine += "Cette salle actuellement est vide. ";

		return chaine;
	}

	public boolean equals(Casino autre) {
		if (!this.nom.equals(autre.nom)) {
			return false;
		}
		if (this.maxJoueurs != autre.maxJoueurs) {
			return false;
		}
		if (this.joueursPresents != autre.joueursPresents) {
			return false;
		}
		if (!this.jeu.equals(autre.jeu)) {
			return false;
		}
		for (int i = 0; i < joueursPresents; i++) {
			if (!this.joueurs[i].equals(autre.joueurs[i]))
				return false;
		}
		return true;
	}
}
