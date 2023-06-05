package joueurs;

import casinos.Casino;
import jeux.Jeu;

public class Joueur {

	private String nom;
	private int capital;
	private int joueurID;
	private Casino casino;

	public static int nbrJoueursCrees;

	public Joueur() {
		this("Joueur", 100);
		this.nom += "_" + nbrJoueursCrees;
	}

	public Joueur(String nom) {
		this(nom, 100);
	}

	public Joueur(int capital) {
		this();
		this.capital = capital;
	}

	public Joueur(Joueur autre) {
		this(autre.nom, autre.capital);
	}

	public Joueur(String nom, int capital) {
		this.nom = nom;
		this.capital = capital;
		this.joueurID = ++nbrJoueursCrees;
	}

	public void joindreCasino(Casino casino) {
		if (aDesSous()) {
			if (this.casino != casino) {
				if (casino.ajouterJoueur(this)) {
					if (this.casino != null) {
						this.quitterCasino();	
					}
					this.casino = casino;
				}
			}else {
				System.out.printf("%s est deja dans ce casino...\n", nom);
			}

		}
	}

	public void quitterCasino() {
		if (aUnCasino()) {
			casino.enleverJoueur(this);
			this.casino = null;
		}
	}

	public boolean aUnCasino() {
		if (this.casino != null) {
			return true;
		} else {
			System.out.printf("%s n'est dans aucun casino...\n", nom);
			return false;
		}
	}

	public boolean aUnCasino(Casino autre) {
		if (this.casino != autre) {
			return true;
		} else {
			System.out.printf("Vous etes dans le casino \"%s\"...\n", autre.getNom());
			return false;
		}
	}

	public boolean aDesSous() {
		if (capital > 0) {
			return true;
		} else {
			System.out.printf("%s n'a pas d'argent...\n", nom);
			return false;
		}
	}
	
	public boolean aDesSous( int montant) {
		if (capital >= montant) {
			return true;
		} else {
			System.out.printf("%s n'a pas assez d'argent...\n", nom);
			return false;
		}
	}

	public void jouer(int mise) {
		if (aDesSous(mise) && aUnCasino()) {
			casino.jouer(this, mise);
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCapital() {
		return capital;
	}

	public void setCapital(int capital) {
		this.capital = capital;
	}

	public Casino getCasino() {
		return casino;
	}

	public String toString() {
		String chaine;

		chaine = String.format("Le joueur s'apelle %s. ", nom);
		if (casino != null) {
			chaine += String.format("\nCe joueur est presentement dans cette salle \"%s\". ", casino.getNom());
		}
		if (capital > 0)
			chaine += String.format("Il a un capital de %d$. ", capital);
		else
			chaine += "Il n'a plus d'argent.\n";
		return chaine;
	}

	public boolean equals(Joueur autre) {
		if (!this.nom.equalsIgnoreCase(autre.nom)) {
			return false;
		}
		if (this.capital != autre.capital) {
			return false;
		}
		if (this.joueurID != autre.joueurID) {
			return false;
		}
		return true;
	}
}
