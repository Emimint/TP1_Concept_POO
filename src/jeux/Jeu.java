package jeux;

public abstract class Jeu {

	private String nom;

	public static int nbrJeuxCrees;

	//// **** METHODES ABSTRAITES **** ////
	
	/*
	 * prend la mise d'un joueur et retourne ses gains
	 */
	public abstract void faireUnTirage();
	
	public abstract int calculerGains(int mise);
	
	public abstract String toString();
	
	
	
	//// **** METHODES CONCRETES **** ////

	public void afficherNumeros(int[] tab, String delimiteur) {
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i]);
			if (i < tab.length - 1)
				System.out.print(delimiteur);
		}
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


	public int getRandom(int min, int max) {
		return min + (int) (Math.random() * (max - min + 1));
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
