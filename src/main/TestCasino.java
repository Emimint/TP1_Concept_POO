package main;

import casinos.Casino;
import joueurs.Joueur;
import jeux.Jeu;

public class TestCasino {

	public static void main(String[] args) {

		/**********************************************
		 ************ Tests pour classe Jeu ***********
		 *********************************************/
		System.out.println("\n*********************************************");
		System.out.println("************ Tests pour classe Jeu **********");
		System.out.println("*********************************************\n");

		System.out.printf("Il y a %d jeux crees.\n", Jeu.nbrJeuxCrees);

		Jeu jeu1 = new Jeu();
		System.out.println(jeu1);
		Jeu jeu2 = new Jeu("bingo");
		System.out.println(jeu2);
		Jeu jeu3 = new Jeu(jeu1);
		System.out.println(jeu3);
		Jeu jeu4 = new Jeu("loto Quebec", 10, 49);
		System.out.println(jeu4);
		Jeu jeu5 = new Jeu();
		System.out.println(jeu5);

		System.out.printf("Il y a %d jeux crees.\n", Jeu.nbrJeuxCrees);

		System.out.println("------------ 1 -----------");

		System.out.printf("Le jeu \"%s\" genere %d tirages allant de 1 a %d numeros.\n\n", jeu1.getNom(),
				jeu1.getNbrResultats(), jeu1.getChampResultat());

		System.out.println("------------ 2 -----------");

		System.out.println("1er cas: " + jeu1.equals(jeu3));

		jeu1.setNom("roulette");

		System.out.println("2e cas: " + jeu1.equals(jeu3));

		jeu3.setNom("Roulette");

		System.out.println("3e cas: " + jeu1.equals(jeu3));

		jeu1.faireUnTirage();

		System.out.println("4e cas: " + jeu1.equals(jeu3));

		System.out.println("5e cas: " + jeu1.equals(jeu5));
		
		System.out.println("6e cas: " + jeu1.equals(jeu4));

		System.out.println("------------------- 3 --------------");
		System.out.println("-------- methodes de classe --------\n");

		Jeu loto = jeu4;

		loto.faireUnTirage();

		System.out.println(loto);
		
		System.out.println();

		System.out.println("---------------------------------");

		loto.calculerGains(50);
		
		System.out.println("---------------------------------");

		loto.calculerGains(100);

		System.out.println("---------------------------------");

		loto.faireUnTirage();
		
		loto.calculerGains(100);

		/**********************************************
		 ********** Tests pour classe Casino **********
		 *********************************************/

		System.out.println("\n**********************************************");
		System.out.println("************ Tests pour classe Casino ********");
		System.out.println("**********************************************\n");

		System.out.printf("Il y a %d casinos crees.\n", Casino.nbrCasinosCrees);

		Casino casino1 = new Casino();
		System.out.println(casino1);
		System.out.printf("Il y a %d jeux crees.\n", Jeu.nbrJeuxCrees);
		System.out.println("-------------------------");
		Casino casino2 = new Casino(10);
		System.out.println(casino2);
		System.out.printf("Il y a %d jeux crees.\n", Jeu.nbrJeuxCrees);
		System.out.println("-------------------------");
		Casino casino3 = new Casino(casino1);
		System.out.println(casino3);
		System.out.printf("Il y a %d jeux crees.\n", Jeu.nbrJeuxCrees);
		System.out.println("-------------------------");
		Casino casino4 = new Casino("Salle_roulette", 5);
		System.out.println(casino4);
		System.out.printf("Il y a %d jeux crees.\n", Jeu.nbrJeuxCrees);
		System.out.println("-------------------------");
		Casino casino5 = new Casino();
		System.out.println(casino5);
		System.out.printf("Il y a %d jeux crees.\n", Jeu.nbrJeuxCrees);
		System.out.println("-------------------------");
		Casino casino6 = new Casino("Salle loto", 20, "Loto Quebec", 10, 49);
		System.out.println(casino6);
		System.out.printf("Il y a %d jeux crees.\n", Jeu.nbrJeuxCrees);
		System.out.println("-------------------------");
		Casino casino7 = new Casino("Bingo", 15, 100);
		System.out.println(casino7);
		System.out.printf("Il y a %d jeux crees.\n", Jeu.nbrJeuxCrees);

		System.out.printf("Il y a %d casinos crees.\n", Casino.nbrCasinosCrees);
		System.out.println("-------------------------");

		System.out.println("------------- 1 ------------");
		System.out.println("-------- accesseurs --------");

		System.out.println(casino1);
		
		System.out.println("-------------------------");
		
		System.out.printf("Le casino \"%s\" a une capacite de %d personnes. On y joue a ce jeu: %s.\n\n",
				casino1.getNom(), casino1.getMaxJoueurs(), casino1.getNomJeu());
		
		System.out.println("\n-------------------------");
		System.out.println("------------2------------\n");

		System.out.println("1er cas: " + casino1.equals(casino5));

		System.out.println("2e cas: " + casino1.equals(casino3));

		casino1.setNom("new_room");

		System.out.println("3e cas: " + casino1.equals(casino3));

		/**********************************************
		 ********** Tests pour classe Joueur **********
		 *********************************************/

		System.out.println("\n**********************************************");
		System.out.println("************ Tests pour classe Joueur ********");
		System.out.println("**********************************************\n");

		Joueur joueur1 = new Joueur();
		System.out.println(joueur1);
		System.out.printf("Il y a %d joueurs crees.\n", Joueur.nbrJoueursCrees);
		System.out.println("-------------------------");
		Joueur joueur2 = new Joueur("Mouli");
		System.out.println(joueur2);
		System.out.printf("Il y a %d joueurs crees.\n", Joueur.nbrJoueursCrees);
		System.out.println("-------------------------");
		Joueur joueur3 = new Joueur(2000);
		System.out.println(joueur3);
		System.out.printf("Il y a %d joueurs crees.\n", Joueur.nbrJoueursCrees);
		System.out.println("-------------------------");
		Joueur joueur4 = new Joueur("Mimi", 2500);
		System.out.println(joueur4);
		System.out.printf("Il y a %d joueurs crees.\n", Joueur.nbrJoueursCrees);
		System.out.println("-------------------------");
		Joueur joueur5 = new Joueur(joueur1);
		System.out.println(joueur5);
		System.out.printf("Il y a %d joueurs crees.\n", Joueur.nbrJoueursCrees);
		System.out.println("-------------------------");
		Joueur joueur6 = new Joueur(joueur1);
		System.out.println(joueur6);
		System.out.printf("Il y a %d joueurs crees.\n", Joueur.nbrJoueursCrees);

		System.out.println("--------------------- 2 ------------------");
		System.out.println("-------- getters, setters, equals --------");

		System.out.println("\n----------------*1*--------------\n");
		
		System.out.printf("Le joueur \"%s\" possede %d$. Son identifiant unique est #%d.\n"
				, joueur4.getNom(), joueur4.getCapital(), joueur4.getID());
		
		System.out.println("\n----------------*2*--------------\n");
		
		System.out.printf("Joueur #%d (%s,%d$) vs Joueur #%d (%s,%d$):\n"
				, joueur1.getID(), joueur1.getNom(), joueur1.getCapital()
				, joueur5.getID(), joueur5.getNom(), joueur5.getCapital());
		
		System.out.println("1er cas: " + joueur1.equals(joueur5));

		joueur1.setCapital(300);
		
		System.out.printf("Joueur #%d (%s,%d$) vs Joueur #%d (%s,%d$):\n"
				, joueur1.getID(), joueur1.getNom(), joueur1.getCapital()
				, joueur5.getID(), joueur5.getNom(), joueur5.getCapital());

		System.out.println("2e cas: " + joueur1.equals(joueur5));

		joueur5.setCapital(joueur1.getCapital());
		
		System.out.printf("Joueur #%d (%s,%d$) vs Joueur #%d (%s,%d$):\n"
				, joueur1.getID(), joueur1.getNom(), joueur1.getCapital()
				, joueur5.getID(), joueur5.getNom(), joueur5.getCapital());

		System.out.println("3e cas: " + joueur1.equals(joueur5));
		
		joueur5.setNom("Dan");
		
		System.out.printf("Joueur #%d (%s,%d$) vs Joueur #%d (%s,%d$):\n"
				, joueur1.getID(), joueur1.getNom(), joueur1.getCapital()
				, joueur5.getID(), joueur5.getNom(), joueur5.getCapital());
		
		System.out.println("4e cas: " + joueur1.equals(joueur5));
		
		System.out.printf("Joueur #%d (%s,%d$) vs Joueur #%d (%s,%d$):\n"
				, joueur1.getID(), joueur1.getNom(), joueur1.getCapital()
				, joueur1.getID(), joueur1.getNom(), joueur1.getCapital());

		System.out.println("4e cas: " + joueur1.equals(joueur1));

		/**********************************************
		 ** Tests pour methode Joueur.joindreCasino ***
		 *********************************************/

		System.out.println("\n**************************************************");
		System.out.println("*** Tests pour methodes Joueur.joindreCasino() ***");
		System.out.println("************** et Joueur.quitterCasino() *********");
		System.out.println("**************************************************\n");

//		Casino casino1 = new Casino();
//		System.out.println(casino1);

//		Joueur joueur1 = new Joueur();
		System.out.println(joueur1);
		
		joueur1.joindreCasino(casino1);
		System.out.println("\n-------------------------");
		joueur1.joindreCasino(casino1);
		System.out.println("-----------1-------------");
		joueur5.setNom("Momo");
		joueur5.setCapital(0);
		joueur5.joindreCasino(casino1);
		System.out.println("-----------2-------------");
		joueur4.joindreCasino(casino1);
		joueur2.joindreCasino(casino1);
		joueur3.joindreCasino(casino1);
		System.out.println("-----------3-------------");
		System.out.println(casino1);
		System.out.println("-----------4-------------");
		joueur5.quitterCasino();
		System.out.println("-----------5-------------");
		System.out.println(joueur1.getCasino());
		System.out.println("\n-------------------------");
		joueur1.quitterCasino();
		System.out.println("\n-------------------------");
		System.out.println(joueur1);
		System.out.println("\n-------------------------");
		System.out.println(joueur1.getCasino());
		System.out.println("-----------6-------------");
		System.out.println(casino1);
		System.out.println("\n-------------------------");
		joueur4.joindreCasino(casino2);
		System.out.println("\n-------------------------");
		System.out.println(casino1);
		System.out.println("\n-------------------------");
		System.out.println(casino2);
		System.out.println("-----------7-------------");
		joueur5.setCapital(1000);
		System.out.println();
		joueur5.joindreCasino(casino1);
		System.out.println("\n-------------------------");
		joueur5.joindreCasino(casino2);
		System.out.println("\n-------------------------");
		System.out.println(casino1);
		System.out.println("\n-------------------------");
		System.out.println(casino2);

		
		/**********************************************
		 ** Tests pour methodes jouer() ***
		 *********************************************/
		
		System.out.println("\n*******************************************");
		System.out.println("**** Tests pour methode jouer() ***********");
		System.out.println("*******************************************\n");
		
		joueur1.jouer(150);
		System.out.println("\n-------------------------");
		joueur5.setCapital(1000);
		joueur5.getCasino().getJeu().faireUnTirage();
		joueur5.jouer(150);
		System.out.println("\n-------------------------");
		System.out.println(joueur4);
		System.out.println("\n-------------------------");
		joueur4.getCasino().getJeu().faireUnTirage();
		joueur4.jouer(150);
		System.out.println("\n-------------------------");
		System.out.println("------------4------------\n");
		
		System.out.println("\n-----------*1*-----------");
		joueur1.joindreCasino(casino2);
		System.out.println("------------2------------");
		joueur2.joindreCasino(casino2);
		System.out.println("------------3------------");
		joueur3.joindreCasino(casino2);
		System.out.println("------------4------------");
		joueur4.joindreCasino(casino2);
		System.out.println("------------5------------");
		joueur6.joindreCasino(casino2);
		System.out.println("------------6------------");
		joueur5.joindreCasino(casino2);
		System.out.println("------------7------------");
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
		System.out.println("Premiere phase de jeu:");
		System.out.println("----------------------");
		
		casino2.jouer(150);
		
		System.out.println("----------------------");
		System.out.println("Deuxieme phase de jeu:");
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
		 * System.out.println("******** Tests supplementaires pour methode ********");
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
