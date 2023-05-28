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
		nbrCasinosCrees++;
		this.nom = autre.nom;
		this.maxJoueurs = autre.maxJoueurs;
		joueursPresents = 0;
		joueurs = new Joueur[autre.maxJoueurs];
		this.jeu = new Jeu(autre.jeu);
		
		// Avant (a discuter):
//		this(autre.nom, autre.maxJoueurs);
//		this.jeu = new Jeu(autre.jeu);
	}

	public Casino(String nom, int maxJoueurs) {
		nbrCasinosCrees++;
		this.nom = nom;
		this.maxJoueurs = maxJoueurs;
		joueursPresents = 0;
		joueurs = new Joueur[maxJoueurs];
		this.jeu = new Jeu();
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
		
		chaine = String.format("Le casino s'apelle \"%s\". Il a une capacite maximale de %d joueurs. ", nom, maxJoueurs);
		
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
		if (this.maxJoueurs != autre.maxJoueurs) {
			return false;
		}
		if (!this.jeu.equals(autre.jeu)) {
			return false;
		}
		return true;
	}
}
