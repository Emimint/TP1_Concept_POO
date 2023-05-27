package jeux;

public class Jeu {

	private String nom;

	// variables propres a un jeu de hasard:
	private int nbrResultats;
	private int champResultat;
	private int[] resultats;
	
	public static int nbrJeuxCrees;

	public Jeu() {
		this("jeu", 3, 6);
		this.nom = this.nom + "_" + nbrJeuxCrees;
		resultats = new int[nbrResultats];
	}

	public Jeu(String nom) {
		this(nom, 3, 6);
		resultats = new int[nbrResultats];
	}

	public Jeu(Jeu autre) {
		this(autre.nom, autre.nbrResultats, autre.champResultat);
		this.resultats = new int[autre.nbrResultats];

		for (int i = 0; i < nbrResultats; i++) {
			this.resultats[i] = autre.resultats[i];
		}
	}

	public Jeu(String nom, int nbrResultats, int champResultat) {
		nbrJeuxCrees++;
		this.nom = nom;
		this.nbrResultats = nbrResultats;
		this.champResultat = champResultat;
		resultats = new int[nbrResultats];
	}
	
	/*
	 * Fait un tirage; les resultats sont stocke dans le tableau des resultats. C'est dans le casino qu'on appelle cette methode.
	 * 
	 * @params nbrResultats : nombre de resultats attendus champResultat: limite
	 * maximale du resultat resultats: tableau des resultats a remplir
	 */
	public void faireUnTirage() {
		for (int i = 0; i < nbrResultats; i++) {
			resultats[i] = 1 + (int) (Math.random() * champResultat);
		}
		triNumeros(resultats);
	}

	/*
	 * prend la mise d'un joueur lance une phase de 
	 * jeu et retourne les gains du joueur
	 */
	public int calculerGains(int mise) {

		int gains , gainsReels = 0;
		int[] resultatsJoueur = new int[nbrResultats];
		double ratio = 0.5; // remise des gains

		System.out.printf("Vous avez mise %d$.\n", mise);
		System.out.println("Resultats du tirage:");
		afficherNumeros(resultats);
		
		resultatJoueur(resultatsJoueur);
		
		System.out.println("Resultats du joueur:");
		afficherNumeros(resultatsJoueur);

		int numerosTrouves = resultatTirage(resultatsJoueur, resultats);

		gains = (int) (numerosTrouves > 0 ? mise * numerosTrouves * ratio : 0);
		gainsReels = gains - mise;

		System.out.printf("Total des gains: %d$ (Gains: %d$ - Mise: %d$), car vous avez trouve %d numéro(s).\n", gainsReels,gains, mise, numerosTrouves);

		return gains;
	}

	public void afficherNumeros(int[] tab) {
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i] + "  ");
		}
		System.out.println();
	}
	
	/*
	 * genere le choix du joueur. Le joueur ne doit pas choisir plusieurs fois le
	 * meme numero. Ici, on se contente de faire jouer le joueur en faisant
	 * automatiquement son choix (on pourra changer plus tard pour qu'il 
	 * fasse reellement un choix.)
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
	 * cherche une valeur dans un tableau et retourne
	 * vrai si la valeur est trouvee.
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
	 * trie les valeurs d'un tableau par
	 * ordre croissant.
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
	 * compare les resultats du joueur avec ceux tires
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

	public int[] getResultats() {
		return resultats;
	}

	public String toString() {
		return "Jeu [" + nom + "]:\n"
				+ String.format("Dans ce jeu, choississez un chiffre entre 1 et %d.\n", champResultat)
				+ String.format("Le croupier fait %d tirages.\n", nbrResultats)
				+ "Gains: vous gagnez la moitie de votre mise autant de fois que vous trouvez votre numero au tirage.";
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

		for (int i = 0; i < nbrResultats; i++) {
			if(this.resultats[i] != autre.resultats[i])
				return false;
		}
		return true;
	}

}
