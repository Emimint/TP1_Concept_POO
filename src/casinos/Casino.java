package casinos;

import jeux.Jeu;
import joueurs.Joueur;
import joueurs.JoueurPauvre;
import joueurs.JoueurRiche;

public abstract class Casino implements Comparable<Casino>, ImpotsFonciers {

	private String nom;
	private Joueur[] joueurs;
	private int joueursPresents;
	private Jeu jeu;
	private int capital;

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
		this.capital = autre.capital;
		this.joueurs = new Joueur[autre.joueurs.length];
		if (autre.getJeu() != null)
			this.jeu = new Jeu(autre.jeu);
		else
			this.jeu = null;
	}

	public Casino(String nom, int maxJoueurs) {
		nbrCasinosCrees++;
		this.nom = nom;
		this.capital = 100000;
		;
		joueursPresents = 0;
		joueurs = new Joueur[maxJoueurs];
		this.jeu = new Jeu();
	}

	public Casino(String nomJeu, int nbrResultatsJeu, int champResultatJeu) {
		this("casino_" + ++nbrCasinosCrees, 3, nomJeu, nbrResultatsJeu, champResultatJeu);
		nbrCasinosCrees--;
	}

	public Casino(String nom, int maxJoueurs, String nomJeu, int nbrResultatsJeu, int champResultatJeu) {
		nbrCasinosCrees++;
		this.nom = nom;
		this.capital = 100000;
		joueursPresents = 0;
		joueurs = new Joueur[maxJoueurs];
		this.jeu = new Jeu(nomJeu, nbrResultatsJeu, champResultatJeu);
	}

	public boolean ajouterJoueur(Joueur nouveauJoueur) {
		if (joueursPresents < joueurs.length) {
			if (aDesSous(nouveauJoueur)) {
				joueurs[joueursPresents] = nouveauJoueur;
				joueursPresents++;

				System.out.printf(
						"Le joueur \"%s\" a rejoint le casino \"%s\". Il y a maintenant %d joueur(s) dans cette salle.\n",
						nouveauJoueur.getNom(), nom, joueursPresents);
				return true;
			}
		} else
			System.out.println("Ce casino est complet.\n");
		return false;
	}

	public void enleverJoueur(Joueur joueur) {
		this.shiftTab(this.rechercherIndice(joueur));
		joueursPresents--;

		System.out.printf(
				"Le joueur \"%s\" a quitté le casino \"%s\". Il y a maintenant %d joueur(s) dans cette salle.\n",
				joueur.getNom(), nom, joueursPresents);
	}

	public void jouer(Joueur joueur, int mise) {
		if (joueur.aDesSous(mise)) {
			int gains = jeu.calculerGains(mise);
			capital += -gains + mise;
			System.out.printf("Le casino \"%s\" a un capital actuel de %d$.\n\n", getNom(), getCapital());
			gains += joueur.getCapital() - mise;
			joueur.setCapital(gains);
			System.out.printf("%s a maintenant %d$.\n", joueur.getNom(), joueur.getCapital());
		}
	}

	/*
	 * fait jouer tous les joueurs présents pour une mise donnée
	 */
	public void jouer(int mise) {

		if (joueursPresents > 0) {
			
			jeu.faireUnTirage();

			System.out.println("\n==================================");
			System.out.println("Faites vos jeux , rien ne va plus! ");
			System.out.println("==================================");

			for (int i = 0; i < joueursPresents; i++) {

				System.out.printf("\n%d) %s joue:\n", i + 1, joueurs[i].getNom());
				System.out.println();

				jouer(joueurs[i], mise);
			}
		} else
			System.out.println("\nLe casino est vide ...");
	}

	/**
	 * Permet de trouver un Joueur dans une liste de Joueur.
	 *
	 * @param aTrouver: Joueur dont l'existence est déjà confirmée
	 * @return int l'indice auquel le joueur a été trouvé dans le tableau. Si le
	 *         joueur n'est pas trouvé, la fonction retourne -1
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
	 * Permet de réassigner successivement, dans un tableau de Joueurs, la référence
	 * d'une case avec la valeur de la case suivante.
	 *
	 * @param indice: indice de la case de démarrage
	 */
	public void shiftTab(int indice) {
		for (int i = indice + 1; i < joueursPresents; i++) {
			joueurs[i - 1] = joueurs[i];
		}
	}

	public int evaluationMunicipale() {
		return 1000 * joueursPresents;
	}

	public int compareTo(Casino autre) {
		if (capital == autre.capital)
			return 0;
		else if (capital > autre.capital)
			return 1;
		else
			return -1;
	}

	public boolean aDesSous(Joueur joueurEntrant) {
		return ((joueurEntrant instanceof JoueurRiche) && joueurEntrant.aDesSous(1000))
				|| ((joueurEntrant instanceof JoueurPauvre) && joueurEntrant.aDesSous(10));
	}

	public String toString() {

		String chaine;

		chaine = String.format("Le casino s'apelle \"%s\". Il a une capacité maximale de %d joueur(s). ", nom,
				joueurs.length);
		chaine += String.format("Présentement, ce casino propose ce jeu:\n \"%s\"\n", jeu);

		if (capital > 0) {
			chaine += String.format("\nLe capital actuel de ce casino est de %d$. ", capital);
		} else
			chaine += "Ce casino a fait banqueroute...\n";
		if (joueursPresents > 0) {
			chaine += String.format("\nIl a présentement %d joueur(s) dans cette salle. ", joueursPresents);
			chaine += "\nLes voici: ";
			for (int i = 0; i < joueursPresents; i++) {
				chaine += "\n" + joueurs[i];
			}
		} else
			chaine += "Cette salle est actuellement vide. ";

		return chaine;
	}

	public boolean equals(Casino autre) {
		if (!this.nom.equalsIgnoreCase(autre.nom)) {
			return false;
		}
		if (this.capital != autre.capital) {
			return false;
		}
		if (this.joueurs.length != autre.joueurs.length) {
			return false;
		}
		if (!this.jeu.equals(autre.jeu)) {
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
		return joueurs.length;
	}

	public int getJoueursPresents() {
		return joueursPresents;
	}
	
	public Joueur[] getJoueurs() {
		return joueurs;
	}

	public Jeu getJeu() {
		return jeu;
	}

	public String getNomJeu() {
		return jeu.getNom();
	}

	public int getCapital() {
		return capital;
	}

	public void setCapital(int capital) {
		this.capital = capital;
	}

}
