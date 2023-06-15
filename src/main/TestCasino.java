package main;

import casinos.Casino;
import joueurs.Joueur;
import jeux.Jeu;

public class TestCasino {

	public static void main(String[] args) {

		System.out.println("\n*********************************************");
		System.out.println("************ Tests pour classe Jeu **********");
		System.out.println("*********************************************\n");

		System.out.println("\n--------------------- 1 ------------------");
		System.out.println("-------- Tests des constructeurs ---------\n");

		System.out.println("\n----------------*1*--------------\n");

		Jeu jeu1 = new Jeu();
		System.out.println(jeu1);

		System.out.println("\n----------------*2*--------------\n");

		Jeu jeu2 = new Jeu("bingo");
		System.out.println(jeu2);

		System.out.println("\n----------------*3*--------------\n");

		Jeu jeu3 = new Jeu(jeu1);
		System.out.println(jeu3);

		System.out.println("\n----------------*4*--------------\n");

		Jeu jeu4 = new Jeu("loto Québec", 10, 49);
		System.out.println(jeu4);

		System.out.println("\n---------------------------------");
		System.out.printf("Il y a %d jeux crées.\n", Jeu.nbrJeuxCrees);

		System.out.println("\n--------------------- 2 ------------------");
		System.out.println("-------- getters, setters, equals --------\n");

		System.out.printf("Le jeu \"%s\" génère %d tirages allant de 1 à %d numeros.\n\n", jeu1.getNom(),
				jeu1.getNbrResultats(), jeu1.getChampResultat());

		System.out.println("---------------------------------");

		System.out.println("1er cas: " + jeu1.equals(jeu3));

		jeu1.setNom("roulette");

		System.out.println("2ème cas: " + jeu1.equals(jeu3));

		jeu3.setNom("Roulette");

		System.out.println("3ème cas: " + jeu1.equals(jeu3));

		jeu1.faireUnTirage();

		System.out.println("4ème cas: " + jeu1.equals(jeu3));

		System.out.println("5ème cas: " + jeu1.equals(jeu4));

		System.out.println("\n**************************************************");
		System.out.println("****  Tests pour méthode Jeu.calculerGains()  ****");
		System.out.println("**************************************************\n");

		System.out.println("\n----------------*1*--------------\n");

		Jeu loto = jeu4;

		System.out.println(loto);

		System.out.println("\n-------------------------\n");

		loto.calculerGains(150);

		System.out.println("\n----------------*2*--------------\n");

		loto.faireUnTirage();

		loto.calculerGains(100);

		System.out.println("\n**********************************************");
		System.out.println("************ Tests pour classe Casino ********");
		System.out.println("**********************************************\n");

		System.out.println("\n--------------------- 1 ------------------");
		System.out.println("-------- Tests des constructeurs ---------\n");

		System.out.println("\n-------------------------");
		System.out.println("------------1------------\n");

		Casino casino1 = new Casino();
		System.out.println(casino1);
		System.out.printf("Il y a %d jeux crées.\n", Jeu.nbrJeuxCrees);

		System.out.println("\n-------------------------");
		System.out.println("------------2------------\n");

		Casino casino2 = new Casino(10);
		System.out.println(casino2);
		System.out.printf("Il y a %d jeux crées.\n", Jeu.nbrJeuxCrees);

		System.out.println("\n-------------------------");
		System.out.println("------------3------------\n");

		Casino casino3 = new Casino(casino1);
		System.out.println(casino3);
		System.out.printf("Il y a %d jeux crées.\n", Jeu.nbrJeuxCrees);

		System.out.println("\n-------------------------");
		System.out.println("------------4------------\n");

		Casino casino4 = new Casino("Salle_roulette", 5);
		System.out.println(casino4);
		System.out.printf("Il y a %d jeux crées.\n", Jeu.nbrJeuxCrees);

		System.out.println("\n-------------------------");
		System.out.println("------------5------------\n");

		Casino casino5 = new Casino("BelleArnaque", 1, 2);
		System.out.println(casino5);
		System.out.printf("Il y a %d jeux crées.\n", Jeu.nbrJeuxCrees);

		System.out.println("\n-------------------------");
		System.out.println("------------6------------\n");

		Casino casino6 = new Casino("Salle loto", 20, "Loto Québec", 10, 49);
		System.out.println(casino6);
		System.out.printf("Il y a %d jeux crées.\n", Jeu.nbrJeuxCrees);

		System.out.println("\n-------------------------");
		System.out.printf("Il y a %d casinos crées.\n", Casino.nbrCasinosCrees);
		System.out.println("-------------------------");

		System.out.println("\n-------------------2----------------------");
		System.out.println("-------- getters, setters, equals --------\n");

		System.out.println(casino1);

		System.out.println("\n-------------------------");
		System.out.println("------------1------------\n");

		System.out.printf("Le casino \"%s\" a une capacité de %d personnes. On y joue à ce jeu: %s.\n\n",
				casino1.getNom(), casino1.getMaxJoueurs(), casino1.getNomJeu());

		System.out.println("\n-------------------------");
		System.out.println("------------3------------\n");

		System.out.println("1er cas: " + casino1.equals(casino5));

		System.out.println("2ème cas: " + casino1.equals(casino3));

		casino1.setNom("new_room");

		System.out.println("3ème cas: " + casino1.equals(casino3));

		System.out.println("\n**********************************************");
		System.out.println("************ Tests pour classe Joueur ********");
		System.out.println("**********************************************\n");

		System.out.println("\n--------------------- 1 ------------------");
		System.out.println("-------- Tests des constructeurs ---------\n");

		System.out.println("\n-------------------------");
		System.out.println("------------1------------\n");

		Joueur joueur1 = new Joueur();
		System.out.println(joueur1);
		System.out.printf("Il y a %d joueurs crées.\n", Joueur.nbrJoueursCrees);

		System.out.println("\n-------------------------");
		System.out.println("------------2------------\n");

		Joueur joueur2 = new Joueur("Mouli");
		System.out.println(joueur2);
		System.out.printf("Il y a %d joueurs crées.\n", Joueur.nbrJoueursCrees);

		System.out.println("\n-------------------------");
		System.out.println("------------3------------\n");

		Joueur joueur3 = new Joueur(2000);
		System.out.println(joueur3);
		System.out.printf("Il y a %d joueurs crées.\n", Joueur.nbrJoueursCrees);

		System.out.println("\n-------------------------");
		System.out.println("------------4------------\n");

		Joueur joueur4 = new Joueur("Mimi", 2500);
		System.out.println(joueur4);
		System.out.printf("Il y a %d joueurs crées.\n", Joueur.nbrJoueursCrees);

		System.out.println("\n-------------------------");
		System.out.println("------------5------------\n");

		Joueur joueur5 = new Joueur(joueur1);
		System.out.println(joueur5);
		System.out.printf("Il y a %d joueurs crées.\n", Joueur.nbrJoueursCrees);

		System.out.println("\n-------------------------");
		System.out.println("------------6------------\n");

		Joueur joueur6 = new Joueur("Kevin");
		System.out.println(joueur6);
		System.out.printf("Il y a %d joueurs crées.\n", Joueur.nbrJoueursCrees);

		System.out.println("\n--------------------- 2 ------------------");
		System.out.println("-------- getters, setters, equals --------\n");

		System.out.println("\n----------------*1*--------------\n");

		System.out.printf("Le joueur \"%s\" possède %d$. Son identifiant unique est #%d.\n", joueur4.getNom(),
				joueur4.getCapital(), joueur4.getID());

		System.out.println("\n----------------*2*--------------\n");

		System.out.printf("Joueur #%d (%s,%d$) vs Joueur #%d (%s,%d$):\n", joueur1.getID(), joueur1.getNom(),
				joueur1.getCapital(), joueur5.getID(), joueur5.getNom(), joueur5.getCapital());

		System.out.println("1er cas: " + joueur1.equals(joueur5));

		joueur1.setCapital(300);

		System.out.printf("Joueur #%d (%s,%d$) vs Joueur #%d (%s,%d$):\n", joueur1.getID(), joueur1.getNom(),
				joueur1.getCapital(), joueur5.getID(), joueur5.getNom(), joueur5.getCapital());

		System.out.println("2ème cas: " + joueur1.equals(joueur5));

		joueur5.setCapital(joueur1.getCapital());

		System.out.printf("Joueur #%d (%s,%d$) vs Joueur #%d (%s,%d$):\n", joueur1.getID(), joueur1.getNom(),
				joueur1.getCapital(), joueur5.getID(), joueur5.getNom(), joueur5.getCapital());

		System.out.println("3ème cas: " + joueur1.equals(joueur5));

		joueur5.setNom("Dan");

		System.out.printf("Joueur #%d (%s,%d$) vs Joueur #%d (%s,%d$):\n", joueur1.getID(), joueur1.getNom(),
				joueur1.getCapital(), joueur5.getID(), joueur5.getNom(), joueur5.getCapital());

		System.out.println("4ème cas: " + joueur1.equals(joueur5));

		System.out.printf("Joueur #%d (%s,%d$) vs Joueur #%d (%s,%d$):\n", joueur1.getID(), joueur1.getNom(),
				joueur1.getCapital(), joueur1.getID(), joueur1.getNom(), joueur1.getCapital());

		System.out.println("5ème cas: " + joueur1.equals(joueur1));

		System.out.println("\n**************************************************");
		System.out.println("*** Tests pour méthodes Joueur.joindreCasino() ***");
		System.out.println("************** et Joueur.quitterCasino() *********");
		System.out.println("**************************************************\n");

		System.out.println("\n-------------------------");
		System.out.println("------------1------------\n");

		System.out.println(joueur1);
		joueur1.joindreCasino(casino1);

		System.out.println("\n-------------------------");
		joueur1.joindreCasino(casino1);

		System.out.println("\n-------------------------");
		System.out.println("------------2------------\n");

		joueur5.setNom("Momo");
		joueur5.setCapital(0);
		System.out.println(joueur5);

		System.out.println("\n-------------------------");

		joueur5.joindreCasino(casino1);

		System.out.println("\n-------------------------");
		System.out.println("------------3------------\n");

		joueur4.joindreCasino(casino1);

		System.out.println("\n-------------------------");
		joueur2.joindreCasino(casino1);

		System.out.println("\n-------------------------");
		joueur3.joindreCasino(casino1);

		System.out.println("\n-------------------------");
		System.out.println("------------4------------\n");

		System.out.println(casino1);

		System.out.println("\n-------------------------");
		System.out.println("------------5------------\n");

		joueur5.quitterCasino();

		System.out.println("\n-------------------------");
		System.out.println("------------6------------\n");

		System.out.println(joueur1.getCasino());

		System.out.println("\n-------------------------");
		joueur1.quitterCasino();

		System.out.println("\n-------------------------");
		System.out.println(joueur1);

		System.out.println("\n-------------------------");
		System.out.println(joueur1.getCasino());

		System.out.println("\n-------------------------");
		System.out.println("------------7------------\n");

		System.out.println(casino1);

		System.out.println("\n-------------------------");
		System.out.println("------------8------------\n");

		joueur4.joindreCasino(casino2);

		System.out.println("\n-------------------------");
		System.out.println("------------9------------\n");

		System.out.println(casino1);

		System.out.println("\n-------------------------");
		System.out.println(casino2);

		System.out.println("\n-------------------------");
		System.out.println("------------10-----------\n");

		joueur5.setCapital(1000);
		System.out.println();
		joueur5.joindreCasino(casino1);

		System.out.println("\n-------------------------");
		joueur5.joindreCasino(casino2);

		System.out.println("\n-------------------------");
		System.out.println(casino1);

		System.out.println("\n-------------------------");
		System.out.println(casino2);

		System.out.println("\n*******************************************");
		System.out.println("**** Tests pour methode jouer() ***********");
		System.out.println("*******************************************\n");

		System.out.println("\n-------------------------");
		System.out.println("------------1------------\n");

		System.out.println(joueur1.getCasino());

		System.out.println("\n-------------------------");

		joueur1.jouer(150);

		System.out.println("\n-------------------------");
		System.out.println("------------2------------\n");

		joueur5.setCapital(1000);
		joueur5.getCasino().getJeu().faireUnTirage();
		joueur5.jouer(150);

		System.out.println("\n-------------------------");
		System.out.println("------------3------------\n");

		System.out.println(joueur4);

		System.out.println("\n-------------------------");
		joueur4.getCasino().getJeu().faireUnTirage();
		joueur4.jouer(150);

		System.out.println("\n-------------------------");
		System.out.println("------------4------------\n");

		System.out.println("\n-----------*1*-----------");
		joueur1.joindreCasino(casino2);

		System.out.println("\n-----------*2*-----------");
		joueur2.joindreCasino(casino2);

		System.out.println("\n-----------*3*-----------");
		joueur3.joindreCasino(casino2);

		System.out.println("\n-----------*4*-----------");
		joueur4.joindreCasino(casino2);

		System.out.println("\n-----------*5*-----------");
		joueur6.joindreCasino(casino2);

		System.out.println("\n-----------*6*-----------");
		joueur5.joindreCasino(casino2);

		System.out.println("\n-------------------------");
		System.out.println("------------5------------\n");

		System.out.println(casino1);

		System.out.println("\n-------------------------");

		casino1.jouer(150);

		System.out.println("\n-------------------------");
		System.out.println("------------6------------\n");

		System.out.println(casino2);

		System.out.println();

		joueur1.setCapital(150);
		joueur4.setCapital(150);
		joueur6.setCapital(150);

		System.out.println("----------------------");
		System.out.println("Première phase de jeu:");
		System.out.println("----------------------");

		casino2.jouer(150);

		System.out.println("----------------------");
		System.out.println("Deuxième phase de jeu:");
		System.out.println("----------------------");

		casino2.jouer(150);

		System.out.println("\n-------------------------");
		System.out.println("------------7------------\n");

		joueur1.joindreCasino(casino5);
		System.out.println("\n-------------------------");
		joueur2.joindreCasino(casino5);
		System.out.println("\n-------------------------");
		joueur3.joindreCasino(casino5);
		System.out.println("\n-------------------------");
		joueur4.joindreCasino(casino5);

		System.out.println("\n-------------------------");

		System.out.println(casino5);

		System.out.println("\n-------------------------");

		casino5.getJeu().faireUnTirage();

		casino5.jouer(100);

		/*
		 * System.out.println("\n****************************************************");
		 * System.out.println("******** Tests supplémentaires pour méthode ********");
		 * System.out.println("************** Joueur.quitterCasino() **************");
		 * System.out.println("****************************************************\n");
		 * 
		 * System.out.println("Effectifs dans les casinos:");
		 * System.out.printf("casino #%s: %d joueur(s)\n", casino2.getNom(),
		 * casino2.getJoueursPresents());
		 * System.out.printf("casino #%s: %d joueur(s)\n", casino5.getNom(),
		 * casino5.getJoueursPresents());
		 * 
		 * 
		 * System.out.println("\n-------------------------");
		 * System.out.println("------------1------------\n");
		 * 
		 * joueur1.quitterCasino();
		 * 
		 * 
		 * System.out.println("\n-------------------------");
		 * System.out.println("------------2------------\n");
		 * 
		 * System.out.println(casino5);
		 * 
		 * System.out.println("\n-------------------------");
		 * System.out.println("------------3------------\n");
		 * 
		 * joueur2.quitterCasino();
		 * 
		 * System.out.println("\n-------------------------");
		 * System.out.println(casino5);
		 * 
		 * System.out.println("\n-------------------------");
		 * System.out.println("------------4------------\n");
		 * 
		 * joueur6.quitterCasino();
		 * 
		 * System.out.println("\n-------------------------");
		 * System.out.println(casino2);
		 * 
		 * System.out.println("\n-------------------------");
		 * System.out.println("------------5------------\n");
		 * 
		 * joueur4.quitterCasino();
		 * 
		 * System.out.println("\n-------------------------"); joueur4.quitterCasino();
		 * 
		 * System.out.println("\n-------------------------");
		 * System.out.println(casino2);
		 * 
		 * System.out.println("\n-------------------------");
		 * System.out.println("------------6------------\n");
		 * 
		 * joueur3.quitterCasino();
		 * 
		 * System.out.println("\n-------------------------");
		 * System.out.println(casino5);
		 * 
		 * System.out.println("\n-------------------------");
		 * System.out.println("------------7------------\n");
		 * 
		 * joueur5.quitterCasino();
		 * 
		 * System.out.println("\n-------------------------");
		 * System.out.println(casino2);
		 * 
		 * System.out.println("\n-------------------------\n");
		 * 
		 * System.out.println("Effectifs dans les casinos:");
		 * System.out.printf("casino #%s: %d joueur(s)\n", casino2.getNom(),
		 * casino2.getJoueursPresents());
		 * System.out.printf("casino #%s: %d joueur(s)\n", casino5.getNom(),
		 * casino5.getJoueursPresents());
		 */
	}

}
