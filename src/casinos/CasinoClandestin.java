package casinos;

import jeux.Jeu;

public class CasinoClandestin extends Casino {

	public CasinoClandestin() {
		super(3);
	}

	public CasinoClandestin(Casino autre) {
		super(autre);
	}

	public CasinoClandestin(int maxJoueurs) {
		super(maxJoueurs);
	}

	public CasinoClandestin(String nom, int maxJoueurs) {
		super(nom, maxJoueurs);
	}
	
	public CasinoClandestin(int maxJoueurs, Jeu jeu) {
		super(maxJoueurs, jeu);
	}
	
	public CasinoClandestin(String nom, int maxJoueurs, Jeu jeu) {
		super(nom, maxJoueurs, jeu);
	}

	public void payerImpots() {
		int chance = (int) ((100 * Math.random()) + 1);
		if (chance >= 99) {
			System.out.println("Pas de chance! C'est le jour des impots :( ...");
			super.setCapital((int) (super.getCapital() * 0.5));
		} else {
			System.out.println("Quelle chance! Pas d'impots a payer :) !\n");
		}
	}

	public void descentePolice() {
		System.out.println("Oh-oh... C'est la police :o !!!");
		while (getJoueursPresents() > 0) {
			getJoueurs()[getJoueursPresents() - 1].quitterCasino();
		}
		System.out.println("Le casino est vide...");
	}

}
