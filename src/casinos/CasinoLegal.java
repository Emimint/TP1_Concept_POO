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
		System.out.println("Pas de chance! C'est le jour des impots :( ...\n");
		super.setCapital((int) (super.getCapital() * 0.85));
	}

	public void debutSpectacle() {
		System.out.println("Go, go, Gregory!!! Les joueurs s'arretent tous de jouer!");
		peutJouer = false;
	}

	public void finSpectacle() {
		System.out.println("Super concert!!! Les joueurs recommencent tous à jouer!");
		peutJouer = true;
	}

	public void jouer(Joueur joueur, int mise) {
		if (peutJouer) {
			super.jouer(joueur, mise);
		} else
			System.out.printf("\nLe concert n'est pas fini, le joueur \"%s\" ne joue pas.\n", joueur.getNom());
	}

	
	public boolean isPeutJouer() {
		return peutJouer;
	}

}
