package jeux;

public class LotoQuebec extends JeuSimple {

	public LotoQuebec() {
		this("loto");
	}

	public LotoQuebec(String nom) {
		super(nom, 6, 49);
	}

	public LotoQuebec(LotoQuebec autre) {
		super(autre);
	}

	public int calculerGains(int mise) {

		int gains = 0, numerosTrouves, gainsTotals = 0;
		int[] resultatsJoueur = new int[getNbrResultats()];

		int nbrTicketsJoueur = mise <= 30 ? mise / 3 : 10;
		
		System.out.printf("Vous avez misé %d$, ce qui vous donne %d tickets.\n\n", mise, nbrTicketsJoueur);

		mise = mise <= 30 ? 0 : mise - 30;

		System.out.println("Résultats du tirage:");
		afficherNumeros(getResultats(), " ");

		System.out.println("\n\nRésultats du joueur:\n");

		for (int i = 1; i <= nbrTicketsJoueur; i++) {

			resultatJoueur(resultatsJoueur);

			System.out.printf("Ticket #%d : ", i);
			afficherNumeros(resultatsJoueur, " ");
			System.out.println();

			numerosTrouves = resultatTirage(resultatsJoueur, getResultats());

			switch (numerosTrouves) {
			case 2:
				gains = 3;
				break;
			case 3:
				gains = 10;
				break;
			case 4:
				gains = 50;
				break;
			case 5:
				gains = 1500;
				break;
			case 6:
				gains = 5000000;
				break;
			}

			if (numerosTrouves > 1) {
				System.out.printf("\nVous avez gagné %d$, car vous avez %d numéros.\n\n", gains, numerosTrouves);
				gainsTotals += gains;
			} else
				System.out.println("Perdu...\n");
		}

		System.out.printf("Total des gains: %d$.\n", gainsTotals);

		return gainsTotals + mise;
	}

	public String toString() {
		return "Le gros lot du Lotto 6/49 online:\n\n"
				+ "Le principe du jeu est simple. Vous choisissez sur votre grille de jeu six numéros "
				+ "différents entre 1 et 49 inclusivement. Le croupier tire six numéros au hasard. "
				+ "Si au moins deux numéros choisis correspondent aux numéros tirés, on gagne un prix en argent. "
				+ "Voici une grille simplifiée des gains potentiels :\n\n" + "6 / 6 : 5,000,000$\n" + "5 / 6 : 1,500$\n"
				+ "4 / 6 : 50$\n" + "3 / 6 : 10$\n" + "2 / 6 : 3$\n\n"
				+ "Plus vous misez gros, plus vous augmentez vos chances de gagner: la mise minimale"
				+ "est de 3$, donc vous pouvez choisir une nouvelle combinaison pour chaque 3 dollars misés.\n"
				+ "(Notez que vous êtes limité à 10 billets par tirage)\n\n";
	}

}
