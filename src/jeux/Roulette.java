package jeux;

import java.util.ArrayList;
import java.util.List;

/*
 * Implementation du jeu de roulette francaise
 * ===========================================
 * 
 * Sources: - https://www.regles-de-jeux.com/regle-de-la-roulette/ -
 * https://www.casino-zen.com/annonce-mise-roulette/ -
 * https://www.casino-zen.com/mises-gains-roulette/ -
 * https://www.playojo.com/fr-ca/blog/roulette/roulette-voisins/
 */

public final class Roulette extends Jeu {

	public static int[] chiffresRoue = { 0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30, 8, 23, 10, 5, 24,
			16, 33, 1, 20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26 }; // chiffres sur la roue de la roulette

	public static int[] voisinsDuZero = { 22, 18, 29, 7, 28, 12, 35, 3, 26, 0, 32, 15, 19, 4, 21, 2, 25 };
	public static int[] tiersDuCylindre = { 27, 13, 36, 11, 30, 8, 23, 10, 5, 24, 16, 33 };
	public static int[] orphelins = { 17, 34, 6, 1, 20, 14, 31, 9 };

	public static int[] premiereColonne = { 1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34 };
	public static int[] deuxiemeColonne = { 2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35 };
	public static int[] troisiemeColonne = { 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36 };

	public static int[][] lesColonnes = { premiereColonne, deuxiemeColonne, troisiemeColonne };

	public static String[] typeDeParis = { "couleur", "simple", "parité", "moitié de cylindre", "les douzaines",
			"paris sur les voisins" };
	public static String[] choixPariSurChiffres = { "cheval", "transversale", "carré", "sizain", "les voisins du zéro",
			"les tiers du cylindre", "les orphelins", "un chiffre et ses voisins" };

	public static List<String> cheval = genererCheval();
	public static List<String> transversale = genererTransversale();
	public static List<String> carre = genererCarre();
	public static List<String> sizain = genererSizain();

	private String strCouleur;
	private int resultatChiffre;
	private ArrayList<Object> resultatDuJoueur;

	public void faireUnTirage() {

		int resultatCouleur = getRandom(0, 1);
		strCouleur = resultatCouleur == 1 ? "Noir" : "Rouge";

		resultatChiffre = getRandom(0, 36);

		System.out.printf("\nLes jeux sont faits: %d, %s.\n\n", resultatChiffre, strCouleur);
	}

	public int calculerGains(int mise) {

		int gains = 0;
		String validation;

		System.out.printf("Vous avez misé %d$.\n", mise);

		resultatJoueur();

		String typeDePari = (String) resultatDuJoueur.get(0);

		switch (typeDePari) {

		case "couleur":
			if (strCouleur == (String) resultatDuJoueur.get(1))
				gains = mise;
			break;

		case "simple":
			if (Integer.toString(resultatChiffre).equals(resultatDuJoueur.get(1)))
				gains = mise * 36;
			break;

		case "parité":
			validation = resultatChiffre % 2 == 0 ? "Pair" : "Impair";
			if (validation == (String) resultatDuJoueur.get(1))
				gains = mise;
			break;

		case "moitié de cylindre":
			validation = resultatChiffre < 19 ? "Manque" : "Passe";
			if (validation == (String) resultatDuJoueur.get(1))
				gains = mise;
			break;

		case "les douzaines":

			int choix = Character.getNumericValue(((String) resultatDuJoueur.get(1)).charAt(0));

			if (trouveIndice(resultatChiffre, lesColonnes[choix - 1]) > -1) {
				System.out.println();
				gains = mise * 2;

			}
			break;

		default:

			String selectionPari = (String) resultatDuJoueur.get(1);

			if (trouveIndice(resultatChiffre, (int[]) resultatDuJoueur.get(2)) > -1) {
				switch (selectionPari) {

				case "cheval":
					gains = mise * 17;
					break;

				case "transversale":
					gains = mise * 11;
					break;

				case "carré":
					gains = mise * 8;
					break;

				case "sizain":
					gains = mise * 5;
					break;

				case "les voisins du zéro":
				case "les tiers du cylindre":
				case "les orphelins":
				default:
					gains = mise / ((int[]) resultatDuJoueur.get(2)).length + mise;
					break;
				}
			}
			break;
		}

		if (gains > 0)
			System.out.printf("Total des gains: %d$.\n", gains);
		else
			System.out.printf("\nPerdu :( ... \n");

		return gains;
	}

	public void resultatJoueur() {

		resultatDuJoueur = new ArrayList<>();

		int choix = getRandom(0, 5);

		resultatDuJoueur.add(typeDeParis[choix]);

		int resultatJoueur = getRandom(0, 1);

		String strResultatJoueur = "";

		System.out.printf("\nLe joueur fait un pari de type \"%s\" : " + "il a choisi \"", typeDeParis[choix]);

		if (choix != 5) {

			switch (choix) {
			case 0:
				strResultatJoueur = resultatJoueur == 1 ? "Noir" : "Rouge";
				break;
			case 1:
				resultatJoueur = getRandom(0, 36);
				strResultatJoueur = "" + resultatJoueur;
				break;
			case 2:
				strResultatJoueur = resultatJoueur == 1 ? "Pair" : "Impair";
				break;
			case 3:
				strResultatJoueur = resultatJoueur == 1 ? "Manque" : "Passe";
				break;
			default:
				resultatJoueur = getRandom(1, 3);
				strResultatJoueur += "" + resultatJoueur;
				strResultatJoueur += resultatJoueur == 1 ? "ère" : "ème";
				strResultatJoueur += " douzaine";
				break;
			}
			resultatDuJoueur.add(strResultatJoueur);
		} else {
			resultatDuJoueur.add(selectionPariChiffre());
		}

		System.out.print(strResultatJoueur + "\".\n");
	}

	public int[] selectionPariChiffre() {

		String strResultatJoueur = "";

		int choix = getRandom(0, 7);

		System.out.print(choixPariSurChiffres[choix]);

		resultatDuJoueur.add(choixPariSurChiffres[choix]);

		int[] listResultatJoueur;

		switch (choix) {

		case 0:
			strResultatJoueur = cheval.get(getRandom(0, cheval.size() - 1));
			listResultatJoueur = getIntList(strResultatJoueur, 2);
			break;
		case 1:
			strResultatJoueur = transversale.get(getRandom(0, transversale.size() - 1));
			listResultatJoueur = getIntList(strResultatJoueur, 3);
			break;
		case 2:
			strResultatJoueur = carre.get(getRandom(0, carre.size() - 1));
			listResultatJoueur = getIntList(strResultatJoueur, 4);
			break;
		case 3:
			strResultatJoueur = sizain.get(getRandom(0, sizain.size() - 1));
			listResultatJoueur = getIntList(strResultatJoueur, 6);
			break;
		case 4:
			listResultatJoueur = voisinsDuZero;
			break;
		case 5:
			listResultatJoueur = tiersDuCylindre;
			break;
		case 6:
			listResultatJoueur = orphelins;
			break;
		default:
			int val = getRandom(0, 36);
			listResultatJoueur = getVoisins(chiffresRoue, val);
			break;
		}
		return listResultatJoueur;
	}

	public static List<String> genererCheval() {
		List<String> cheval = new ArrayList<>();

		int[] horizontal = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
				26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36 };
		int[] vertical = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
				26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36 };

		for (int i = 0; i < horizontal.length - 1; i++) {
			int choix1 = horizontal[i];
			int choix2 = horizontal[i + 1];
			if (choix1 % 3 != 0)
				cheval.add(choix1 + "-" + choix2);
		}

		for (int i = 0; i < vertical.length; i++) {
			int choix = vertical[i];

			if (choix <= 33) {
				int choix1 = vertical[i];
				int choix2 = vertical[i + 3];

				cheval.add(choix1 + "-" + choix2);
			}
		}

		return cheval;
	}

	public static List<String> genererTransversale() {
		List<String> transversale = new ArrayList<>();

		for (int rangee = 1; rangee <= 12; rangee++) {
			int debut = (rangee - 1) * 3 + 1;
			int fin = debut + 2;
			transversale.add(debut + "-" + fin);
		}

		return transversale;
	}

	public static List<String> genererCarre() {
		List<String> carre = new ArrayList<>();

		for (int rangee = 1; rangee <= 11; rangee++) {
			for (int colonne = 1; colonne <= 2; colonne++) {
				int topLeft = (rangee - 1) * 3 + colonne;
				int topRight = topLeft + 1;
				int bottomLeft = topLeft + 3;
				int bottomRight = bottomLeft + 1;
				if (topLeft % 3 != 0 && bottomRight <= 36)
					carre.add(topLeft + "-" + topRight + "-" + bottomLeft + "-" + bottomRight);
			}
		}

		return carre;
	}

	public static List<String> genererSizain() {
		List<String> sizain = new ArrayList<>();

		for (int rangee = 1; rangee <= 11; rangee++) {
			int debut = (rangee - 1) * 3 + 1;
			int fin = debut + 5;
			sizain.add(debut + "-" + fin);
		}

		return sizain;
	}

	public int trouveIndice(int aTrouver, int[] tableau) {
		boolean trouve = false;
		int indice = 0;

		while (!trouve && indice < tableau.length) {
			if (tableau[indice] == aTrouver) {
				return indice;
			}

			indice++;
		}
		return -1;
	}

	public int[] getVoisins(int[] tab, int selection) {

		int[] resultats = new int[5];

		int milieu = trouveIndice(selection, tab);
		int voisin1 = milieu - 2;
		int voisin2 = milieu - 1;
		int voisin3 = milieu + 1;
		int voisin4 = milieu + 2;

		if (voisin1 == -1) {
			voisin1 = tab.length - 1;
		}
		if (voisin1 == -2) {
			voisin1 = tab.length - 2;
			voisin2 = tab.length - 1;
		}
		if (voisin4 == tab.length) {
			voisin4 = tab.length - tab.length;
		}
		if (voisin4 == tab.length + 1) {
			voisin4 = tab.length - tab.length + 1;
			voisin3 = tab.length - tab.length;
		}

		resultats[0] = tab[voisin1];
		resultats[1] = tab[voisin2];
		resultats[2] = tab[milieu];
		resultats[3] = tab[voisin3];
		resultats[4] = tab[voisin4];

		System.out.print(" (");

		afficherNumeros(resultats, ",");

		System.out.print(")");

		return resultats;
	}

	public int[] getIntList(String liste, int taille) {

		System.out.printf(" (%s)", liste);

		String[] listeChiffres = liste.split("-");
		int[] resultats = new int[taille];

		if (taille == 4 || taille == 2) {
			for (int i = 0; i < resultats.length; i++) {
				resultats[i] = Integer.parseInt(listeChiffres[i]);
			}
		} else {
			int debutIncrement = Integer.parseInt(listeChiffres[0]);
			for (int i = 0; i < taille; i++) {
				resultats[i] = debutIncrement++;
			}
		}
		return resultats;
	}

	public void afficherDetailsGains() {

		String commentaire = "\n.:*~*:._.:*~*:._.:*~*\n\n   Table des gains\n\n.:*~*:._.:*~*:._.:*~*\n\n\n"
				+ "==================\n" + "I) Paris internes: \n" + "==================\n\n"
				+ "1) mise simple (inclus le 0) ==> 36 fois la mise.\n\n"
				+ "2) mise \"à cheval\" (exclus le 0): mise sur 2 chiffres adjacents ==> 17 fois la mise.\n\n"
				+ "3) mise \"transversale\" : Trios de chiffres: 1 à 3, 4 à 6, 7 à 9, ect... "
				+ "mise sur 3 chiffres adjacents ==> 11 fois la mise.\n\n"
				+ "4) mise \"carré\" : mise sur 4 chiffres adjacents ==> 8 fois la mise.\n\n"
				+ "5) mise \"sizain\" : mise sur 6 chiffres adjacents ==> 5 fois la mise.\n\n\n"
				+ "==================\n" + "II) Paris voisins: \n" + "==================\n\n"
				+ "Se base sur l'ordre des chiffres de la roue du jeu de roulette.\n\n" + "1) mise \"sur un tiers\": \n"
				+ "-----------------------\n\n" + "On mise sur un chiffre d'un tiers de la roue et de ses voisins. "
				+ "Dépendamment du tiers, on peut avoir different gains.\n\n"
				+ "Les tiers misés sont : *1* les voisins du zéro (17 numéros), "
				+ "*2* les tiers du cylindre (12 chiffres) et *3* les orphelins (8 chiffres).\n\n"
				+ "1) les voisins du zéro : \"9 jetons ou multiples de 9 sont misés. 2 jetons "
				+ "sont placés sur la transversale 0, 2, 3 ; 1 sur le cheval 4/7 ; 1 sur 12/15 ; "
				+ "1 sur 18/21 ; 1 sur 19/22 ; 2 sur le carré 25/26/28/29 et 1 sur 32/35.\"\n\n"
				+ "2) les tiers du cylindre : \"6 jetons ou multiples de 6 sont misés. "
				+ "1 jeton est placé sur chacun des chevaux suivants : 5/8 ; 10/11 ; 13/16 ; 23/24 ; 27/30 ; 33/36.\"\n\n"
				+ "3) les orphelins : \"5 jetons ou multiples de 5 sont misés. 1 jeton est placé directement sur le 1 "
				+ "et 1 jeton sur chacun des chevaux suivants : 6/9 ; 14/17; 17/20 et 31/34.\"\n\n"
				+ "2) mise sur les voisins: \n" + "------------------------\n\n"
				+ "On mise 5 jetons sur un numéro et ses 2 voisins adjacents ==> 35 fois la mise divisée par 5.\n\n\n"
				+ "====================\n" + "III) Paris externes: \n" + "====================\n\n"
				+ "1) mise sur \"rouge\" ou \"noir\" ==> 1 fois la mise.\n\n"
				+ "2) mise sur \"pair\" ou \"impair\" ==> 1 fois la mise.\n\n"
				+ "3) mise sur moitié de cylindre ==> 1 fois la mise (première moitié : de 1 à 18 - deuxième moitié : de 19 à 36).\n\n"
				+ "4) mise sur les douzaines ==> 2 fois la mise (premier tiers : 1 à 12 - deuxième tiers : 13 à 24 - troisième tiers : 25 à 36).\n\n"
				+ "2) mise sur les colonnes ==> 2 fois la mise (première colonne : {1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34} "
				+ "- deuxième colonne : {2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35} "
				+ "- troisième colonne : {3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36}).\n\n";

		System.out.println(commentaire);
	}

	public String toString() {
		return "\n\nRoulette Francaise:\n" + "===================\n\n"
				+ "Dans ce jeu, le croupier lance une bille dans un cylindre de roulette fait d'une "
				+ "combinaison de cases de couleurs chiffrées.\n"
				+ "Choississez une combinaison de couleur (noir ou rouge) et/ou de chiffres (de 0 à 36) et "
				+ "placez les jetons des mises correspondantes sur le tapis de jeu (voir tableau des mises).\n"
				+ "Attention! Une fois que le croupier a lancé la bille, vous ne pouvez plus parier.\n";

	}

}
