package jeux;

public abstract class JeuSimple extends Jeu {

	// variables propres à un jeu de tirages multiples:
	private int nbrResultats; // nombre de résultats attendus
	private int champResultat; // valeur limite maximale pour un des résultats
	private int[] resultats; // tableau des résultats à remplir dans la classe Casino

	public JeuSimple() {
		this("jeu", 3, 6);
		setNom(this.getNom() + "_" + nbrJeuxCrees);
	}

	public JeuSimple(String nom) {
		this(nom, 3, 6);
	}

	public JeuSimple(JeuSimple autre) {
		this(autre.getNom(), autre.getNbrResultats(), autre.getChampResultat());
	}

	public JeuSimple(String nom, int nbrResultats, int champResultat) {
		nbrJeuxCrees++;

		setNom(nom);
		this.nbrResultats = nbrResultats;
		this.champResultat = champResultat;
		resultats = new int[nbrResultats];
	}
	
	/*
	 * Fait un tirage; les résultats sont stockés dans le tableau des résultats.
	 * C'est dans le casino qu'on appelle cette méthode.
	 */
	public void faireUnTirage() {
		genererNumeros(resultats);
	}

	/*
	 * génère le choix du joueur. Le joueur ne doit pas choisir plusieurs fois le
	 * même numéro. Ici, on se contente de faire jouer le joueur en faisant
	 * automatiquement son choix (on pourra changer plus tard pour qu'il fasse
	 * réellement un choix.)
	 */
	public void resultatJoueur(int[] tab) {
		genererNumeros(tab);
	}
	
	
	public void genererNumeros(int[] tab) {
		
		int ctr = 0;

		while (ctr < tab.length) {

			int choixNum = getRandom(1, champResultat);

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
	
	public boolean equals(JeuSimple autre) {
		if (!this.getNom().equalsIgnoreCase(autre.getNom())) {
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
	

	public int getNbrResultats() {
		return nbrResultats;
	}

	public int getChampResultat() {
		return champResultat;
	}

	public int[] getResultats() {
		return resultats;
	}

}
