package casinos;

import joueurs.Joueur;

import jeux.Jeu;

public class CasinoLegal extends Casino {

	private boolean peutJouer;

	public CasinoLegal() {
		this(3);
	}

	public CasinoLegal(Casino autre) {
		super(autre);
		peutJouer = true;
	}

	public CasinoLegal(int maxJoueurs) {
		this("salle", maxJoueurs);
		this.setNom(this.getNom() + "_" + nbrCasinosCrees);
	}

	public CasinoLegal(String nom, int maxJoueurs) {
		super(nom, maxJoueurs);
		peutJouer = true;
	}

	public CasinoLegal(int maxJoueurs, Jeu jeu) {
		this("salle", maxJoueurs, jeu);
		this.setNom(this.getNom() + "_" + nbrCasinosCrees);
	}

	public CasinoLegal(String nom, int maxJoueurs, Jeu jeu) {
		this(nom, maxJoueurs);
		setJeu(jeu);
	}

	public void payerImpots() {
		System.out.println("Pas de chance! C'est le jour des impôts :( ...\n");
		super.setCapital((int) (super.getCapital() * 0.85));
	}

	public void debutSpectacle() {
		System.out.println("Go, go, Grégory!!! Les joueurs s'arrêtent tous de jouer!");
		peutJouer = false;
	}

	public void finSpectacle() {
		System.out.println("Super concert!!! Les joueurs recommencent tous à jouer!");
		peutJouer = true;
	}

	public void jouer(Joueur joueur, int mise) {
		if (isPeutJouer())
			super.jouer(joueur, mise);
	}

	public void jouer(int mise) {
		if (isPeutJouer())
			super.jouer(mise);
	}

	public boolean isPeutJouer() {
		if (peutJouer) {
			return true;
		} else
			System.out.printf("\nLe concert n'est pas fini, personne ne peut jouer.\n");
		return false;
	}
}
