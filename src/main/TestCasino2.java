package main;

import casinos.Casino;
import casinos.CasinoClandestin;
import casinos.CasinoLegal;

import joueurs.Joueur;
import joueurs.JoueurPauvre;
import joueurs.JoueurRiche;

import jeux.Jeu;
import jeux.JeuSimple;
import jeux.LotoQuebec;
import jeux.PileOuFace;
import jeux.Roulette;

public class TestCasino2 {

	public static void main(String[] args) {

		System.out.println("\n**********************************************");
		System.out.println("*******  **   Tests pour classe Jeu   **  ****");
		System.out.println("**********************************************\n");

		JeuSimple jeu1 = new JeuSimple();
		PileOuFace jeu2 = new PileOuFace();
		Roulette roulette = new Roulette();
		LotoQuebec loto = new LotoQuebec();

		System.out.println(jeu1);

		System.out.println("\n-------------------------\n");

		System.out.println(jeu2);

		System.out.println("\n-------------------------\n");

		System.out.println(roulette);

		System.out.println("\n-------------------------\n");

		System.out.println(loto);

		System.out.println("\n---------------------2--------------------");
		System.out.println("----------------  equals  ----------------\n");

		System.out.println("1er cas: " + jeu1.equals(roulette));

		JeuSimple copieJeu = new JeuSimple(jeu1);

		System.out.println("2ème cas: " + jeu1.equals(copieJeu));

		JeuSimple jeu5 = new JeuSimple(12, 22);

		System.out.println("3ème cas: " + jeu1.equals(jeu5));

		System.out.println("4ème cas: " + jeu1.equals(jeu1));

		System.out.println("\n----------------------3-------------------");
		System.out.println("-----------  test jeu Roulette  ----------\n");

		roulette.faireUnTirage();

		System.out.println("\n-------------------------\n");

		roulette.calculerGains(100);

		System.out.println("\n-------------------------\n");

		roulette.afficherDetailsGains();

		System.out.println("\n-------------------4----------------------");
		System.out.println("----------  test jeu LotoQuebec  ---------\n");

		loto.faireUnTirage();

		loto.calculerGains(1000);

		System.out.println("\n**********************************************");
		System.out.println("*********     Ajouts de CasinoLegal     ******");
		System.out.println("**********************************************\n");

		Casino casino1 = new CasinoLegal();
		Casino casino3 = new CasinoLegal(casino1);
		Casino casino4 = new CasinoLegal("Salle_roulette", 5);
		Casino casino5 = new CasinoLegal("BelleArnaque", 6, new Roulette());

		System.out.println("\n------------------------------------------");
		System.out.println("-------- getters, setters, equals --------\n");

		System.out.printf(
				"Le casino \"%s\" a une capacité de %d personnes. On y joue à ce jeu: %s."
						+ " Son capital actuel est de %d$.\n\n",
				casino1.getNom(), casino1.getMaxJoueurs(), casino1.getNomJeu(), casino1.getCapital());
		System.out.printf(
				"Le casino \"%s\" a une capacité de %d personnes. On y joue à ce jeu: %s."
						+ " Son capital actuel est de %d$.\n\n",
				casino3.getNom(), casino3.getMaxJoueurs(), casino3.getNomJeu(), casino3.getCapital());
		System.out.printf(
				"Le casino \"%s\" a une capacité de %d personnes. On y joue à ce jeu: %s."
						+ " Son capital actuel est de %d$.\n\n",
				casino5.getNom(), casino5.getMaxJoueurs(), casino5.getNomJeu(), casino5.getCapital());
		System.out.printf(
				"Le casino \"%s\" a une capacité de %d personnes. On y joue à ce jeu: %s."
						+ " Son capital a4tuel est de %d$.\n\n",
				casino4.getNom(), casino4.getMaxJoueurs(), casino4.getNomJeu(), casino4.getCapital());

		System.out.println("\n-------------------------\n");

		System.out.println("1er cas: " + casino1.equals(casino5));

		System.out.println("2ème cas: " + casino1.equals(casino3));

		casino1.setNom("new_room");

		System.out.println("3ème cas: " + casino1.equals(casino3));

		System.out.println("4ème cas: " + casino4.equals(new CasinoLegal("salle_roulette", 5)));

		System.out.println("\n**********************************************");
		System.out.println("******     Ajouts de CasinoClandestin     ****");
		System.out.println("**********************************************\n");

		Casino casino9 = new CasinoClandestin(casino1);
		Casino casino11 = new CasinoClandestin(3, new JeuSimple());
		Casino casino12 = new CasinoClandestin("Salle loto", 20, new LotoQuebec());

		System.out.println("\n------------------------------------------");
		System.out.println("-------- getters, setters, equals --------\n");

		System.out.printf(
				"Le casino \"%s\" a une capacité de %d personnes. On y joue à ce jeu: %s."
						+ " Son capital actuel est de %d$. C'est un %s.\n \n",
				casino9.getNom(), casino9.getMaxJoueurs(), casino9.getNomJeu(), casino9.getCapital(),
				casino9.getClass().getSimpleName());
		System.out.printf(
				"Le casino \"%s\" a une capacité de %d personnes. On y joue à ce jeu: %s."
						+ " Son capital actuel est de %d$. C'est un %s.\n\n",
				casino11.getNom(), casino11.getMaxJoueurs(), casino11.getNomJeu(), casino11.getCapital(),
				casino11.getClass().getSimpleName());
		System.out.printf(
				"Le casino \"%s\" a une capacité de %d personnes. On y joue à ce jeu: %s."
						+ " Son capital actuel est de %d$. C'est un %s.\n\n",
				casino1.getNom(), casino1.getMaxJoueurs(), casino1.getNomJeu(), casino1.getCapital(),
				casino1.getClass().getSimpleName());

		System.out.println("\n-------------------------\n");

		System.out.println("1er cas: " + casino9.equals(casino1));

		System.out.println("2ème cas: " + casino9.equals(casino11));

		casino11.setNom("new_room");

		System.out.println("3ème cas: " + casino11.equals(casino9));

		System.out.println("\n**************************************************");
		System.out.println("***      Tests pour méthode payerImpots()      ***");
		System.out.println("**************************************************\n");

		Casino casinoBasFonds = new CasinoClandestin("Les Bas-Fonds", 10);

		System.out.printf("Le casino \"%s\" a une capacité de %d personnes. Son capital actuel est de %d$.\n\n",
				casinoBasFonds.getNom(), casinoBasFonds.getMaxJoueurs(), casinoBasFonds.getCapital());

		System.out.println("\n-------------------------\n");

		casinoBasFonds.payerImpots();

		System.out.println("\n-------------------------\n");

		System.out.printf("Le casino \"%s\" a un capital actuel est de %d$.\n\n", casinoBasFonds.getNom(),
				casinoBasFonds.getCapital());

		System.out.println("\n-------------------------\n");

		Casino casinoMontreal = new CasinoLegal("Casino de Montréal", 15, new Roulette());

		System.out.printf(
				"Le casino \"%s\" a une capacité de %d personnes. On y joue à ce jeu: %s."
						+ " Son capital actuel est de %d$.\n\n",
				casinoMontreal.getNom(), casinoMontreal.getMaxJoueurs(), casinoMontreal.getNomJeu(),
				casinoMontreal.getCapital());

		System.out.println("\n-------------------------\n");

		casinoMontreal.payerImpots();

		System.out.println("\n-------------------------\n");

		System.out.printf("Le casino \"%s\" a un capital actuel est de %d$.\n\n", casinoMontreal.getNom(),
				casinoMontreal.getCapital());

		System.out.println("\n**************************************************");
		System.out.println("***    Tests pour méthode compareTo(Casino)    ***");
		System.out.println("**************************************************\n");

		System.out.printf("Ils ont %d$ de difference.\n\n", Math.abs(casinoBasFonds.compareTo(casinoMontreal)));

		System.out.println("\n-------------------------\n");

		casinoBasFonds.setCapital(45000);

		System.out.printf("Ils ont %d$ de difference.\n\n", Math.abs(casinoBasFonds.compareTo(casinoMontreal)));

		System.out.println("\n-------------------------\n");

		casinoMontreal.setCapital(45000);

		System.out.printf("Ils ont %d$ de difference.\n\n", Math.abs(casinoBasFonds.compareTo(casinoMontreal)));

		System.out.println("\n**********************************************");
		System.out.println("**** Tests pour méthode aDesSous(Casino) *****");
		System.out.println("**********************************************\n");

		System.out.println("\n-------------------------");
		System.out.println("------------1------------\n");

		Joueur joueur1 = new JoueurRiche();
		System.out.println(joueur1);

		System.out.println("\n-------------------------\n");

		Joueur joueur2 = new JoueurPauvre();
		System.out.println(joueur2);

		System.out.println("\n-------------------------\n");

		if (casinoBasFonds.aDesSous(joueur1))
			System.out.println("Ce joueur peut rentrer au casino " + casinoBasFonds.getNom());

		System.out.println("\n-------------------------\n");

		if (casinoBasFonds.aDesSous(joueur2))
			System.out.println("Ce joueur peut rentrer au casino " + casinoBasFonds.getNom());

		System.out.println("\n-------------------------");
		System.out.println("------------2------------\n");

		joueur1.setCapital(1500);
		joueur2.setCapital(9);

		if (casinoBasFonds.aDesSous(joueur1))
			System.out.println("Ce joueur peut rentrer au casino " + casinoBasFonds.getNom());

		System.out.println("\n-------------------------\n");

		if (casinoBasFonds.aDesSous(joueur2))
			System.out.println("Ce joueur peut rentrer au casino " + casinoBasFonds.getNom());

		System.out.println("\n-------------------------");
		System.out.println("------------3------------\n");

		joueur1.setCapital(500);
		joueur2.setCapital(9);

		joueur1.joindreCasino(casinoBasFonds);

		System.out.println("\n-------------------------\n");

		joueur2.joindreCasino(casinoBasFonds);

		System.out.println("\n-------------------------\n");

		System.out.println(joueur1.getCasino());

		System.out.println("\n-------------------------\n");

		System.out.println(joueur2.getCasino());

		System.out.println("\n-------------------------");
		System.out.println("------------4------------\n");

		joueur1.setCapital(1500);
		joueur1.joindreCasino(casinoBasFonds);

		System.out.println("\n-------------------------");

		joueur2.setCapital(19);
		joueur2.joindreCasino(casinoBasFonds);

		System.out.println("\n*******************************************");
		System.out.println("**** Tests pour compareTo(Joueur) *********");
		System.out.println("*******************************************\n");

		joueur1.setNom("Tom");
		joueur2.setNom("Tommy");

		System.out.println(joueur1);

		System.out.println("\n-------------------------\n");

		System.out.println(joueur2);

		System.out.println("\n------------1------------\n");

		joueur1.compareTo(joueur2);

		System.out.println("\n------------2------------\n");

		joueur1.setCapital(50);
		joueur2.setCapital(50000);

		joueur1.compareTo(joueur2);

		System.out.println("\n------------3------------\n");

		joueur1.setCapital(50000);

		joueur1.compareTo(joueur2);

		System.out.println("\n------------4------------\n");

		joueur1.setNom("Manu");
		joueur2.setNom("Manu");

		joueur1.compareTo(joueur2);

		System.out.println("\n**************************************************");
		System.out.println("****** Tests pour méthodes debutSpectacle() ******");
		System.out.println("******          et finSpectacle()           ******");
		System.out.println("**************************************************\n");

		joueur1.joindreCasino(casinoMontreal);

		System.out.println("\n-------------------------\n");

		joueur2.setNom("Lionel");
		joueur2.joindreCasino(casinoMontreal);

		System.out.println("\n-------------------------\n");

		casinoMontreal.jouer(150);

		System.out.println("\n-------------------------\n");

		((CasinoLegal) (casinoMontreal)).debutSpectacle();

		System.out.println("\n-------------------------\n");

		joueur2.jouer(10000);

		System.out.println("\n-------------------------\n");

		casinoMontreal.jouer(150);

		System.out.println("\n-------------------------\n");

		((CasinoLegal) (casinoMontreal)).finSpectacle();

		System.out.println("\n-------------------------\n");

		casinoMontreal.jouer(150);

		System.out.println("\n************************************************");
		System.out.println("***   Tests pour méthodes descentePolice()   ***");
		System.out.println("***           et evaluationMunicipale()      ***");
		System.out.println("************************************************\n");

		Joueur mouli = new JoueurPauvre("Mouli");
		Joueur joueur3 = new JoueurPauvre(2000);
		Joueur mimi = new JoueurPauvre("Mimi", 2500);
		Joueur joueur5 = new JoueurPauvre(mouli);
		Joueur kevin = new JoueurPauvre("Kevin");

		System.out.println("\n-------------------------");
		System.out.println("-----------*1*-----------\n");

		joueur1.setCapital(1500);
		joueur1.joindreCasino(casinoBasFonds);

		System.out.println("\n-----------*2*-----------");

		joueur2.setCapital(1150);
		joueur2.joindreCasino(casinoBasFonds);

		System.out.println("\n-----------*3*-----------");

		joueur3.joindreCasino(casinoBasFonds);

		System.out.println("\n-----------*4*-----------");

		joueur5.joindreCasino(casinoBasFonds);

		System.out.println("\n-----------*5*-----------");

		mouli.joindreCasino(casinoBasFonds);

		System.out.println("\n-----------*6*-----------");

		kevin.joindreCasino(casinoBasFonds);

		System.out.println("\n-----------*7*-----------");

		mimi.joindreCasino(casinoBasFonds);

		System.out.println("\n-----------*8*-----------");

		System.out.println(casinoBasFonds);

		System.out.println("\n-----------*9*-----------");

		mouli.quitterCasino();

		System.out.println("\n-------------------------");
		System.out.println("------------2------------\n");

		System.out.printf("Le casino \"%s\" est présentement évalué à %d$.\n\n", casinoMontreal.getNom(),
				casinoMontreal.evaluationMunicipale());

		System.out.println("\n-------------------------\n");

		System.out.printf("Le casino \"%s\" est présentement évalué à %d$.\n\n", casinoBasFonds.getNom(),
				casinoBasFonds.evaluationMunicipale());

		System.out.println("\n-------------------------");
		System.out.println("------------3------------\n");

		((CasinoClandestin) (casinoBasFonds)).descentePolice();

		System.out.println("\n-------------------------");

		System.out.println(casinoBasFonds);

		System.out.println("\n-------------------------");

		((CasinoClandestin) (casinoBasFonds)).descentePolice();

		System.out.println("\n**************************************************");
		System.out.println("***    Tests pour méthodes collecterCheque()   ***");
		System.out.println("***               et banqueRoute()             ***");
		System.out.println("**************************************************\n");

		((JoueurPauvre) joueur2).collecterCheque();

		System.out.println("\n-------------------------");

		System.out.printf("Le joueur %s a un capital de %d$.\n", joueur1.getNom(), joueur1.getCapital());

		joueur1.joindreCasino(casinoMontreal);

		System.out.println("\n-------------------------");

		casinoMontreal.jouer(400);

		System.out.println("\n-------------------------");

		((JoueurRiche) (joueur1)).banqueRoute();

		System.out.println("\n-------------------------");

		Joueur joueurAlpha = new JoueurRiche(200000);
		System.out.println(joueurAlpha);
		((JoueurRiche) (joueurAlpha)).banqueRoute();

		System.out.println("\n**************************************************");
		System.out.println("***      Tests pour méthode changerJeu()       ***");
		System.out.println("**************************************************\n");

		System.out.println("\n-------------------------");
		System.out.println("------------1------------\n");

		joueur1.setCapital(1500);
		joueur1.joindreCasino(casinoBasFonds);

		System.out.println("\n-----------*2*-----------");

		joueur2.setCapital(1150);
		joueur2.joindreCasino(casinoBasFonds);

		System.out.println("\n-----------*3*-----------");

		joueur3.joindreCasino(casinoBasFonds);

		System.out.println("\n-------------------------");
		System.out.println("------------2------------\n");

		System.out.printf("Dans le casino \"%s\", on joue a: %s.\n", casinoBasFonds.getNom(),
				casinoBasFonds.getJeu().getNom());

		System.out.println("\n-----------*2*-----------");

		casinoBasFonds.jouer(100);

		System.out.println("\n-------------------------");
		System.out.println("------------3------------\n");

		casinoBasFonds.changerJeu(new LotoQuebec());

		System.out.println("\n-------------------------\n");

		casinoBasFonds.jouer(10);

		System.out.println("\n-------------------------\n");

		casinoBasFonds.changerJeu(new Roulette());

		System.out.println("\n-------------------------\n");

		casinoBasFonds.jouer(1000);
	}

}
