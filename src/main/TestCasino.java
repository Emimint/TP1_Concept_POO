package main;

import casinos.Casino;
import joueurs.Joueur;
import jeux.Jeu;

public class TestCasino {

	public static void main(String[] args) {

		/**********************************************
		 ************ Tests pour classe Jeu ***********
		 *********************************************/
		System.out.println("/**********************************************");
		System.out.println("************ Tests pour classe Jeu ***********");
		System.out.println("*********************************************");

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

		System.out.println("------------------- 3 --------------");
		System.out.println("-------- methodes de classe --------");

		Jeu loto = jeu4;

//		loto.faireUnTirage();

		System.out.println(loto);

		loto.calculerGains(50);

		loto.calculerGains(100);

		loto.faireUnTirage();

		loto.calculerGains(100);

		/**********************************************
		 ********** Tests pour classe Casino **********
		 *********************************************/

		System.out.println("/**********************************************");
		System.out.println("************ Tests pour classe Casino ***********");
		System.out.println("*********************************************");

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
		System.out.printf("Le casino \"%s\" a une capacite de %d personnes. On y joue a ce jeu: %s.\n\n",
				casino1.getNom(), casino1.getMaxJoueurs(), casino1.getNomJeu());
		System.out.println("------------- 2 ------------");
		System.out.println("-------- accesseurs --------");

		System.out.println("1er cas: " + casino1.equals(casino5));

		System.out.println("2e cas: " + casino1.equals(casino3));

		casino1.setNom("new_room");

		System.out.println("3e cas: " + casino1.equals(casino3));

		/**********************************************
		 ********** Tests pour classe Joueur **********
		 *********************************************/

		System.out.println("/**********************************************");
		System.out.println("************ Tests pour classe Joueur ***********");
		System.out.println("*********************************************");

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

		System.out.println("------------- 2 ------------");
		System.out.println("-------- accesseurs et equals --------");

		System.out.println("1er cas: " + joueur1.equals(joueur5));

		joueur1.setCapital(300);

		System.out.println("2e cas: " + joueur1.equals(joueur5));

		joueur5.setCapital(joueur1.getCapital());

		System.out.println("3e cas: " + joueur1.equals(joueur5));

		/**********************************************
		 ** Tests pour methode Joueur.joindreCasino ***
		 *********************************************/

		System.out.println("/**********************************************");
		System.out.println("************ Tests pour methode Joueur.joindreCasino ***********");
		System.out.println("*********************************************");

//		Casino casino1 = new Casino();
//		System.out.println(casino1);

//		Joueur joueur1 = new Joueur();
		System.out.println(joueur1);
		
		joueur1.joindreCasino(casino1);
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
		joueur1.quitterCasino();
		System.out.println(joueur1);
		System.out.println(joueur1.getCasino());
		System.out.println("-----------6-------------");
		System.out.println(casino1);
		joueur4.joindreCasino(casino2);
		System.out.println(casino1);
		System.out.println(casino2);
		System.out.println("-----------7-------------");
		joueur5.setCapital(1000);
		System.out.println();
		joueur5.joindreCasino(casino1);
		joueur5.joindreCasino(casino2);
		System.out.println(casino1);
		System.out.println(casino2);

		
		/**********************************************
		 ** Tests pour methodes jouer() ***
		 *********************************************/
		
		System.out.println("/**********************************************");
		System.out.println("************ Tests pour methode jouer() ***********");
		System.out.println("*********************************************");
		
		joueur1.jouer(150);
		joueur5.setCapital(1000);
		joueur5.jouer(150);
		System.out.println(joueur4);
		joueur4.getCasino().faireUnTirage();
		joueur4.jouer(150);
		System.out.println(joueur4.getCapital());
		
		System.out.println("------------1------------");
		joueur1.joindreCasino(casino2);
		System.out.println("------------2------------");
		joueur2.joindreCasino(casino2);
		System.out.println("------------3------------");
		joueur3.joindreCasino(casino2);
		System.out.println("------------4------------");
		joueur4.joindreCasino(casino2);
		System.out.println("------------5------------");
		joueur5.joindreCasino(casino2);
		System.out.println("------------6------------");
		System.out.println(casino1);
		casino1.jouer(150);
		System.out.println();
		System.out.println("------------7------------");
		System.out.println(casino2);
		casino2.jouer(150);
	}
	
	
	

}
