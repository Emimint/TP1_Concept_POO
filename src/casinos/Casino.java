package casinos;

import jeux.Jeu;
import joueurs.Joueur;

public class Casino {

	private String nom;
	private Joueur[] joueurs;
	private int maxJoueurs;
	private int joueursPresents;
	private Jeu jeu;
	
	public static int nbrCasinosCrees;
	
	public Casino() {
		this(3);
	}
	
	public Casino(int maxJoueurs) {
		this("salle",maxJoueurs);
		this.nom = this.nom + "_" + nbrCasinosCrees;
	}
	
	public Casino(Casino autre) {
		this(autre.nom,autre.maxJoueurs);
		this.jeu = new Jeu(autre.jeu);
	}
	
	public Casino(String nom, int maxJoueurs) {
		nbrCasinosCrees++;
		this.nom = nom;
		this.maxJoueurs = maxJoueurs;
		joueurs = new Joueur[maxJoueurs];
		this.jeu = new Jeu();
	}
	
	public boolean equals(Casino autre) {
		if(this.maxJoueurs != autre.maxJoueurs) {
			return false;
		}
		if(!this.jeu.equals(autre.jeu)) {
			return false;
		}	
		return true;
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

}
