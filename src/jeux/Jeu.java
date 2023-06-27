package jeux;

public class Jeu {

	private String nom;

	// variables propres à un jeu de hasard:
	private int nbrResultats; // nombre de résultats attendus
	private int champResultat; // valeur limite maximale pour un des résultats
	private int[] resultats; // tableau des résultats à remplir dans la classe Casino

	public static int nbrJeuxCrees;

	public Jeu() {
		this("jeu", 3, 6);
		this.nom = this.nom + "_" + nbrJeuxCrees;
	}

	public Jeu(String nom) {
		this(nom, 3, 6);
	}

	public Jeu(Jeu autre) {
		this(autre.nom, autre.nbrResultats, autre.champResultat);
	}

	public Jeu(String nom, int nbrResultats, int champResultat) {
		nbrJeuxCrees++;
		this.nom = nom;
		this.nbrResultats = nbrResultats;
		this.champResultat = champResultat;
		resultats = new int[nbrResultats];
	}

	/*
	 * Fait un tirage; les résultats sont stockés dans le tableau des résultats.
	 * C'est dans le casino qu'on appelle cette méthode.
	 */
	public void faireUnTirage() {
		for (int i = 0; i < nbrResultats; i++) {
			resultats[i] = 1 + (int) (Math.random() * champResultat);
		}
		triNumeros(resultats);
	}

	/*
	 * prend la mise d'un joueur et retourne ses gains
	 */
	public int calculerGains(int mise) {

		int gains, gainsReels, numerosTrouves;
		int[] resultatsJoueur = new int[nbrResultats];
		double ratio = 0.5; // remise sur les gains

		System.out.printf("Vous avez misé %d$.\n", mise);
		System.out.println("Résultats du tirage:");
		afficherNumeros(resultats, " ");

		resultatJoueur(resultatsJoueur);

		System.out.println("Résultats du joueur:");
		afficherNumeros(resultatsJoueur, " ");

		numerosTrouves = resultatTirage(resultatsJoueur, resultats);

		gains = (int) (numerosTrouves > 0 ? mise * numerosTrouves * ratio : 0);
		gainsReels = gains - mise;

		System.out.printf("Total des gains: %d$ (Gains: %d$ - Mise: %d$), car vous avez trouvé %d numéro(s).\n",
				gainsReels, gains, mise, numerosTrouves);

		return gains;
	}

	public void afficherNumeros(int[] tab, String delimiteur) {
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i]);
			if (i < tab.length - 1)
				System.out.print(delimiteur);
		}
	}

	/*
	 * génère le choix du joueur. Le joueur ne doit pas choisir plusieurs fois le
	 * même numéro. Ici, on se contente de faire jouer le joueur en faisant
	 * automatiquement son choix (on pourra changer plus tard pour qu'il fasse
	 * réellement un choix.)
	 */
	public void resultatJoueur(int[] tab) {

		int ctr = 0;

		while (ctr < tab.length) {

			int choixNum = 1 + (int) (Math.random() * champResultat);

			if (!trouve(choixNum, tab)) {
				tab[ctr] = choixNum;
				ctr++;
			}
		}
		triNumeros(tab);
	}

	/*
	 * cherche une valeur dans un tableau et retourne vrai si la valeur est trouvée.
	 */
	public boolean trouve(int aTrouver, int[] tableau) {
		boolean trouve = false;
		int i = 0;

		while (!trouve && i < tableau.length) {
			if (tableau[i] == aTrouver) {
				trouve = true;
			}
			if (aTrouver > champResultat || aTrouver < 1) {
				trouve = true;
			}
			i++;
		}
		return trouve;
	}

	/*
	 * trie les valeurs d'un tableau par ordre croissant.
	 */
	public void triNumeros(int[] numeros) {
		for (int i = 0; i < numeros.length - 1; i++) {
			for (int j = 0; j < numeros.length - i - 1; j++) {
				if (numeros[j] > numeros[j + 1]) {
					int tempCode = numeros[j];
					numeros[j] = numeros[j + 1];
					numeros[j + 1] = tempCode;
				}
			}
		}
	}

	/*
	 * compare les résultats du joueur avec ceux tirés.
	 * 
	 */
	public int resultatTirage(int[] noUsager, int[] noTires) {
		int nbrTrouves = 0;

		for (int i = 0; i < noTires.length; i++) {
			for (int j = 0; j < noUsager.length; j++) {
				if (noTires[i] == noUsager[j]) {
					nbrTrouves++;
				}

			}
		}
		return nbrTrouves;
	}

	public String toString() {
		return "Jeu [" + nom + "]:\n"
				+ String.format("Dans ce jeu, choississez un chiffre entre 1 et %d.\n", champResultat)
				+ String.format("Le croupier fait %d tirage(s).\n", nbrResultats)
				+ "Gains: vous gagnez la moitié de votre mise autant de fois que vous trouvez votre numero au tirage.";
	}

	public boolean equals(Jeu autre) {
		if (!this.nom.equalsIgnoreCase(autre.nom)) {
			return false;
		}
		if (this.nbrResultats != autre.nbrResultats) {
			return false;
		}
		if (this.champResultat != autre.champResultat) {
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

	public int getNbrResultats() {
		return nbrResultats;
	}

	public int getChampResultat() {
		return champResultat;
	}

	public void getResultats() {
		afficherNumeros(resultats," ");
	}

}
