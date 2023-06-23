package main;

import casinos.Casino;
import casinos.CasinoClandestin;
import casinos.CasinoLegal;
import jeux.Jeu;

public class TestCasino2 {

	public static void main(String[] args) {
		
		System.out.println("\n**************************************************");
		System.out.println("***      Tests pour méthodes payerImpots()     ***");
		System.out.println("**************************************************\n");

		Casino casino1 = new CasinoClandestin();
		
		System.out.printf("Le casino \"%s\" a une capacité de %d personnes. On y joue à ce jeu: %s."
				+ " Son capital actuel est de %d$.\n\n",
				casino1.getNom(), casino1.getMaxJoueurs(), casino1.getNomJeu(), casino1.getCapital());


		casino1.payerImpots();
		
		System.out.printf("Le casino \"%s\" a une capacité de %d personnes. On y joue à ce jeu: %s."
				+ " Son capital actuel est de %d$.\n\n",
				casino1.getNom(), casino1.getMaxJoueurs(), casino1.getNomJeu(), casino1.getCapital());

		Casino casino2 = new CasinoLegal();
		
		System.out.printf("Le casino \"%s\" a une capacité de %d personnes. On y joue à ce jeu: %s."
				+ " Son capital actuel est de %d$.\n\n",
				casino2.getNom(), casino2.getMaxJoueurs(), casino2.getNomJeu(), casino2.getCapital());
		
		
		casino2.payerImpots();
		
		System.out.printf("Le casino \"%s\" a une capacité de %d personnes. On y joue à ce jeu: %s."
				+ " Son capital actuel est de %d$.\n\n",
				casino2.getNom(), casino2.getMaxJoueurs(), casino2.getNomJeu(), casino2.getCapital());
		

	}

}
