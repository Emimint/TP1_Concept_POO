package jeux;

public class PileOuFace extends JeuSimple {
	
	String resultat;

	public PileOuFace() {
		this("pile_ou_face");
	}

	public PileOuFace(String nom) {
		super(nom, 1, 2);
	}

	public PileOuFace(LotoQuebec autre) {
		super(autre);
	}
	
	public void faireUnTirage() {
		super.faireUnTirage();
		afficherNumeros(getResultats(), ",");
		
		System.out.println();
		
		resultat = getResultats()[0] == 1 ? "Pile" : "Face";
		
	}
	

	public int calculerGains(int mise) {

		int gains = 0, choixJoueur = getRandom(1, 2), choixCroupier = getRandom(0, 1);

		String resultatJoueur = choixJoueur == 1 ? "Pile" : "Face";

		System.out.printf("Vous avez misé %d$.\n\n" + "Vous avez choisi \"%s\".\n\n" + "Le croupier joue: \"%s\".\n\n", mise,
				resultatJoueur, resultat);

		if (resultat == resultatJoueur) {
			gains = mise * 2;
			System.out.printf("\nBravo! Vous avez gagné %d$\n", gains);
		} else
			System.out.println("Perdu...\n");

		return gains;
	}

	public String toString() {
		return "Pile ou Face:\n\n" + "Dans ce jeu classique, le croupier lance une pièce et "
				+ "dépendemment de votre choix, vous doublez votre mise ou la perdez intégralement.\n\n";
	}

}
