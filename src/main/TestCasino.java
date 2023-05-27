package main;

import jeux.Jeu;

public class TestCasino {

	public static void main(String[] args) {

		/**********************************************
		 ************ Tests pour classe Jeu ***********
		 *********************************************/

		Jeu jeu1 = new Jeu();
		Jeu jeu2 = new Jeu("bingo");
		Jeu jeu3 = new Jeu(jeu1);
		Jeu jeu4 = new Jeu("loto Quebec", 10, 49);

		System.out.println("------------ 1 -----------");

		System.out.println(jeu1);
		System.out.printf("Le jeu \"%s\" genere %d tirages allant de 1 a %d numeros.\n\n", jeu1.getNom(),
				jeu1.getNbrResultats(), jeu1.getChampResultat());
		System.out.println(jeu2);
		System.out.printf("Le jeu \"%s\" genere %d tirages allant de 1 a %d numeros.\n\n", jeu2.getNom(),
				jeu2.getNbrResultats(), jeu2.getChampResultat());
		System.out.println(jeu3);
		System.out.printf("Le jeu \"%s\" genere %d tirages allant de 1 a %d numeros.\n\n", jeu3.getNom(),
				jeu3.getNbrResultats(), jeu3.getChampResultat());
		System.out.println(jeu4);
		System.out.printf("Le jeu \"%s\" genere %d tirages allant de 1 a %d numeros.\n\n", jeu4.getNom(),
				jeu4.getNbrResultats(), jeu4.getChampResultat());

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

		loto.faireUnTirage();

		System.out.println(loto);

		loto.calculerGains(50);

		loto.calculerGains(100);

		loto.faireUnTirage();

		loto.calculerGains(100);

	}

}
