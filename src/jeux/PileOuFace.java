package jeux;

public final class PileOuFace extends JeuSimple {

	String resultat;

	public PileOuFace() {
		super(1, 2);
	}

	public void faireUnTirage() {
		
		super.faireUnTirage();
		resultat = getResultats()[0] == 1 ? "Pile" : "Face";
	}

	public int calculerGains(int mise) {

		int gains = 0, choixJoueur = getRandom(1, 2), choixCroupier = getRandom(0, 1);

		String resultatJoueur = choixJoueur == 1 ? "Pile" : "Face";

		System.out.printf("Vous misez %d$.\n\n" + "Vous choisissez \"%s\".\n\n" + "Le croupier a joué: \"%s\".\n\n",
				mise, resultatJoueur, resultat);

		if (resultat == resultatJoueur) {
			gains = mise * 2;
			System.out.printf("\nBravo! Vous avez gagné %d$\n", gains);
		} else
			System.out.println("Perdu...\n");

		return gains;
	}

	public String toString() {
		return "Pile ou Face:\n\n Dans ce jeu classique, le croupier lance une pièce et "
				+ "dépendemment de votre choix, vous doublez votre mise ou la perdez intégralement.\n\n";
	}

	public String getResultat() {
		return resultat;
	}
}
