package casinos;

import joueurs.Joueur;

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

	@Override
	public void payerImpots() {
		int chance = (int) ((100 * Math.random()) + 1);
		System.out.println("chance = " + chance);
		if (chance >= 99) {
			System.out.println("Pas de chance! C'est le jour des impots :( ...");
			super.setCapital((int) (super.getCapital() * 0.5));
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
