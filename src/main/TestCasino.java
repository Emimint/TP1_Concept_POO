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
		
		Jeu jeu4 = new Jeu("loto Quebec", 10, 49);
		System.out.println(jeu4);
		
		System.out.println("\n---------------------------------");
		System.out.printf("Il y a %d jeux crees.\n", Jeu.nbrJeuxCrees);

		System.out.println("\n--------------------- 2 ------------------");
		System.out.println("-------- getters, setters, equals --------\n");


		System.out.printf("Le jeu \"%s\" genere %d tirages allant de 1 a %d numeros.\n\n", jeu1.getNom(),
				jeu1.getNbrResultats(), jeu1.getChampResultat());

		System.out.println("---------------------------------");

		System.out.println("1er cas: " + jeu1.equals(jeu3));

		jeu1.setNom("roulette");

		System.out.println("2e cas: " + jeu1.equals(jeu3));

		jeu3.setNom("Roulette");

		System.out.println("3e cas: " + jeu1.equals(jeu3));

		jeu1.faireUnTirage();

		System.out.println("4e cas: " + jeu1.equals(jeu3));
		
		System.out.println("5e cas: " + jeu1.equals(jeu4));

		System.out.println("\n**************************************************");
		System.out.println("****  Tests pour methode Jeu.calculerGains()  ****");
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
		System.out.printf("Il y a %d jeux crees.\n", Jeu.nbrJeuxCrees);
		
		System.out.println("\n-------------------------");
		System.out.println("------------2------------\n");
		
		Casino casino2 = new Casino(10);
		System.out.println(casino2);
		System.out.printf("Il y a %d jeux crees.\n", Jeu.nbrJeuxCrees);
		
		System.out.println("\n-------------------------");
		System.out.println("------------3------------\n");
		
		Casino casino3 = new Casino(casino1);
		System.out.println(casino3);
		System.out.printf("Il y a %d jeux crees.\n", Jeu.nbrJeuxCrees);
		
		System.out.println("\n-------------------------");
		System.out.println("------------4------------\n");
		
		Casino casino4 = new Casino("Salle_roulette", 5);
		System.out.println(casino4);
		System.out.printf("Il y a %d jeux crees.\n", Jeu.nbrJeuxCrees);
		
		System.out.println("\n-------------------------");
		System.out.println("------------5------------\n");
		
		Casino casino5 = new Casino("BelleArnaque", 1, 2);
		System.out.println(casino5);
		System.out.printf("Il y a %d jeux crees.\n", Jeu.nbrJeuxCrees);
		
		System.out.println("\n-------------------------");
		System.out.println("------------6------------\n");
		
		Casino casino6 = new Casino("Salle loto", 20, "Loto Quebec", 10, 49);
		System.out.println(casino6);
		System.out.printf("Il y a %d jeux crees.\n", Jeu.nbrJeuxCrees);

		System.out.println("\n-------------------------");
		System.out.printf("Il y a %d casinos crees.\n", Casino.nbrCasinosCrees);
		System.out.println("-------------------------");
  
		System.out.println("\n-------------------2----------------------");
		System.out.println("-------- getters, setters, equals --------\n");

		System.out.println(casino1);
		
		System.out.println("\n-------------------------");
		System.out.println("------------1------------\n");
		
		System.out.printf("Le casino \"%s\" a une capacite de %d personnes. On y joue a ce jeu: %s.\n\n",
				casino1.getNom(), casino1.getMaxJoueurs(), casino1.getNomJeu());
		
		System.out.println("\n-------------------------");
		System.out.println("------------3------------\n");

		System.out.println("1er cas: " + casino1.equals(casino5));

		System.out.println("2e cas: " + casino1.equals(casino3));

		casino1.setNom("new_room");

		System.out.println("3e cas: " + casino1.equals(casino3));


		System.out.println("\n**********************************************");
		System.out.println("************ Tests pour classe Joueur ********");
		System.out.println("**********************************************\n");
		
		System.out.println("\n--------------------- 1 ------------------");
		System.out.println("-------- Tests des constructeurs ---------\n");

		System.out.println("\n-------------------------");
		System.out.println("------------1------------\n");
		
		Joueur joueur1 = new Joueur();
		System.out.println(joueur1);
		System.out.printf("Il y a %d joueurs crees.\n", Joueur.nbrJoueursCrees);
		
		
		System.out.println("\n-------------------------");
		System.out.println("------------2------------\n");
		
		Joueur joueur2 = new Joueur("Mouli");
		System.out.println(joueur2);
		System.out.printf("Il y a %d joueurs crees.\n", Joueur.nbrJoueursCrees);


		System.out.println("\n-------------------------");
		System.out.println("------------3------------\n");
		
		Joueur joueur3 = new Joueur(2000);
		System.out.println(joueur3);
		System.out.printf("Il y a %d joueurs crees.\n", Joueur.nbrJoueursCrees);
		
		System.out.println("\n-------------------------");
		System.out.println("------------4------------\n");
		
		Joueur joueur4 = new Joueur("Mimi", 2500);
		System.out.println(joueur4);
		System.out.printf("Il y a %d joueurs crees.\n", Joueur.nbrJoueursCrees);

		System.out.println("\n-------------------------");
		System.out.println("------------5------------\n");
		
		Joueur joueur5 = new Joueur(joueur1);
		System.out.println(joueur5);
		System.out.printf("Il y a %d joueurs crees.\n", Joueur.nbrJoueursCrees);

		System.out.println("\n-------------------------");
		System.out.println("------------6------------\n");
		
		Joueur joueur6 = new Joueur("Kevin");
		System.out.println(joueur6);
		System.out.printf("Il y a %d joueurs crees.\n", Joueur.nbrJoueursCrees);

		System.out.println("\n--------------------- 2 ------------------");
		System.out.println("-------- getters, setters, equals --------\n");

		System.out.println("1er cas: " + joueur1.equals(joueur5));

		joueur1.setCapital(300);

		System.out.println("2e cas: " + joueur1.equals(joueur5));

		joueur5.setCapital(joueur1.getCapital());

		System.out.println("3e cas: " + joueur1.equals(joueur5));
		
		joueur5.setNom("Dan");
		
		System.out.println("4e cas: " + joueur1.equals(joueur5));

		System.out.println("5e cas: " + joueur1.equals(joueur1));


		System.out.println("\n**************************************************");
		System.out.println("*** Tests pour methodes Joueur.joindreCasino() ***");
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
		
		joueur1.jouer(150);
		
		System.out.println("\n-------------------------");
		System.out.println("------------2------------\n");
		
		joueur5.setCapital(1000);
		joueur5.getCasino().faireUnTirage();
		joueur5.jouer(150);

		System.out.println("\n-------------------------");
		System.out.println("------------3------------\n");
		
		System.out.println(joueur4);
		
		System.out.println("\n-------------------------");
		joueur4.getCasino().faireUnTirage();
		joueur4.jouer(150);
		
		System.out.println("\n-------------------------");
		System.out.println(joueur4.getCapital());
		
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
		System.out.println("\n-------------------------");
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
		
		casino5.faireUnTirage();
		
		casino5.jouer(10);
		
		System.out.println("\n****************************************************");
		System.out.println("******** Tests supplementaires pour methode ********");
		System.out.println("************** Joueur.quitterCasino() **************");
		System.out.println("****************************************************\n");

		System.out.println("\n-------------------------");
		System.out.println("------------1------------\n");
		
		joueur1.quitterCasino();


		System.out.println("\n-------------------------");
		System.out.println("------------2------------\n");
		
		System.out.println(casino2);

		System.out.println("\n-------------------------");
		System.out.println("------------3------------\n");
		
		joueur2.quitterCasino();
		
		System.out.println("\n-------------------------");
		System.out.println(casino2);
		
		System.out.println("\n-------------------------");
		System.out.println("------------4------------\n");
		
		joueur6.quitterCasino();
		
		System.out.println("\n-------------------------");
		System.out.println(casino2);
		
		System.out.println("\n-------------------------");
		System.out.println("------------5------------\n");
		
		joueur4.quitterCasino();
		
		System.out.println("\n-------------------------");
		joueur4.quitterCasino();
		
		System.out.println("\n-------------------------");
		System.out.println(casino2);
		
		System.out.println("\n-------------------------");
		System.out.println("------------6------------\n");
		
		joueur3.quitterCasino();
		
		System.out.println("\n-------------------------");
		System.out.println(casino2);
		
		System.out.println("\n-------------------------");
		System.out.println("------------7------------\n");
		
		joueur5.quitterCasino();
		
		System.out.println("\n-------------------------");
		System.out.println(casino2);
	}
	
	
	

}
