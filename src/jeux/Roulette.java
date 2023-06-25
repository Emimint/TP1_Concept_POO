package jeux;

import java.util.ArrayList;
import java.util.List;

/*
 * Implementation du jeu de roulette francaise
 * ===========================================
 * 
 * 
 * Sources: - https://www.regles-de-jeux.com/regle-de-la-roulette/ -
 * https://www.casino-zen.com/annonce-mise-roulette/ -
 * https://www.casino-zen.com/mises-gains-roulette/ -
 * https://www.playojo.com/fr-ca/blog/roulette/roulette-voisins/
 * 
 * int nbrChiffresMises : nombre de chiffres mises par le joueur
 * 
 * int valeurChiffreMise :
 * 
 * 
 * I) Paris internes: ==================
 * 
 * 1) mise simple (inclus le 0) ==> 36 fois la mise
 * 
 * 2) mise "a cheval" (exclus le 0): mise sur 2 chiffres adjacents ==> 17 fois
 * la mise
 * 
 * 3) mise "transversale" : Trios de chiffres: 1 a 3, 4 a 6, 7 a 9, ect... mise
 * sur 3 chiffres adjacents ==> 11 fois la mise
 * 
 * 4) mise "carre" : mise sur 4 chiffres adjacents ==> 8 fois la mise
 * 
 * 5) mise "sizain" : mise sur 6 chiffres adjacents ==> 5 fois la mise
 * 
 * 
 * II) Paris voisins: ==================
 * 
 * Se base sur l'ordre des chiffres de la roue du jeu de roulette:
 * 
 * 1) mise "sur un tiers": -----------------------
 * 
 * On mise sur un chiffre d'un tier de la roue et de ses voisins. Dependemment
 * du tiers, on peut avoir different gains:
 * 
 * Les tiers mise sur 1)) les voisins du zéro (17 numéros), 2)) les tiers du
 * cylindre (12 chiffres) et 3)) les orphelins (8 chiffres).
 * 
 * 1)) les voisins du zéro : "9 jetons ou multiples de 9 sont misés. 2 jetons
 * sont placés sur la transversale 0, 2, 3 ; 1 sur le cheval 4/7 ; 1 sur 12/15 ;
 * 1 sur 18/21 ; 1 sur 19/22 ; 2 sur le carré 25/26/28/29 et 1 sur 32/35."
 * 
 * 2)) les tiers du cylindre : "6 jetons ou multiples de 6 sont misés. 1 jeton
 * est placé sur chacun des chevaux suivants : 5/8 ; 10/11 ; 13/16 ; 23/24 ;
 * 27/30 ; 33/36."
 * 
 * 3)) les orphelins : "5 jetons ou multiples de 5 sont misés. 1 jeton est placé
 * directement sur le 1 et 1 jeton sur chacun des chevaux suivants : 6/9 ; 14/17
 * ; 17/20 et 31/34."
 * 
 * 2) mise sur les voisins: ------------------------
 * 
 * On mise 5 jetons sur un numero et ses 2 voisins adjacents ==> 35 fois la mise
 * divise par 5.
 * 
 * 
 * III) Paris externes: ====================
 * 
 * 1) mise sur "rouge" ou "noir" ==> 1 fois la mise
 * 
 * 2) mise sur "pair" ou "impair" ==> 1 fois la mise
 * 
 * 3) mise sur moitie de cylindre ==> 1 fois la mise - int[] premiereMoitie : de
 * 1 a 18 - int[] deuxiemeMoitie : de 19 a 36
 * 
 * 4) mise sur les douzaines ==> 2 fois la mise - int[] tiers1 = {1 a 12}; -
 * int[] tiers2 = {13 a 24}; - int[] tiers3 = {25 a 36};
 * 
 * 2) mise sur les colonnes ==> 2 fois la mise - int[] premiereColonne = {1, 4,
 * 7, 10, 13, 16, 19, 22, 25, 28, 31, 34}; - int[] deuxiemeColonne = {2, 5, 8,
 * 11, 14, 17, 20, 23, 26, 29, 32, 35}; - int[] troisiemeColonne = {3, 6, 9, 12,
 * 15, 18, 21, 24, 27, 30, 33, 36};
 * 
 * 
 * 
 * 
 */

public class Roulette extends Jeu {

	public static void main(String[] args) {

		int[] chiffresRoue = { 0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30, 8, 23, 10, 5, 24, 16, 33, 1,
				20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26 }; // chiffres sur la roue de la roulette
		int[] voisinsDuZero = { 22, 18, 29, 7, 28, 12, 35, 3, 26, 0, 32, 15, 19, 4, 21, 2, 25 };
		int[] tiersDuCylindre = { 27, 13, 36, 11, 30, 8, 23, 10, 5, 24, 16, 33 };
		int[] orphelins = { 17, 34, 6, 1, 20, 14, 31, 9 };

		List<String> cheval = genererCheval();
		List<String> transversal = genererTransversal();
		List<String> carre = genererCarre();
		List<String> sizain = genererSizain();

		// Print all six line bet combinations
		for (String pari : transversal) {
			System.out.println(pari);
		}

		System.out.println(cheval.size());
		System.out.println(transversal.size());
		System.out.println(carre.size());
		System.out.println(sizain.size());
		System.out.println(chiffresRoue.length);
	}

	public static List<String> genererCheval() {
		List<String> cheval = new ArrayList<>();

		int[] horizontal = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
				26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36 };
		int[] vertical = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
				26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36 };

		// Generate horizontal split bets
		for (int i = 0; i < horizontal.length - 1; i++) {
			int choix1 = horizontal[i];
			int choix2 = horizontal[i + 1];
			if (choix1 % 3 != 0)
				cheval.add(choix1 + "-" + choix2);
		}

		// Generate vertical split bets
		for (int i = 0; i < vertical.length; i++) {
			int choix = vertical[i];

			// Check if the number is not in the last row
			if (choix <= 33) {
				int choix1 = vertical[i];
				int choix2 = vertical[i + 3];

				cheval.add(choix1 + "-" + choix2);
			}
		}

		return cheval;
	}

	public static List<String> genererTransversal() {
		List<String> transversal = new ArrayList<>();

		for (int rangee = 1; rangee <= 12; rangee++) {
			int debut = (rangee - 1) * 3 + 1;
			int fin = debut + 2;
			transversal.add(debut + "-" + fin);
		}

		return transversal;
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

	public void resultatJoueur(int[] tab) {

		// 1 ) choix de mise : cheval, orphelin, sizain, ect...
		// 2 ) choix precision : random sur la liste des choix
		// 3 ) creation liste resultat du joueur

	}
}
