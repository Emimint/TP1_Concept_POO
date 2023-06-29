package jeux;

public class Test {

	public static void main(String[] args) {
		
		Roulette roulette = new Roulette();
		LotoQuebec loto = new LotoQuebec();
		PileOuFace destin = new PileOuFace();
		PileOuFace destin1 = new PileOuFace(destin);
		
		JeuSimple jeu = new JeuSimple();
		



//		for (String pari : Roulette.cheval) {
//			System.out.println(pari);
//		}
//		for (String pari : Roulette.transversale) {
//			System.out.println(pari);
//		}
//		for (String pari : Roulette.carre) {
//			System.out.println(pari);
//		}
//		for (String pari : Roulette.sizain) {
//			System.out.println(pari);
//		}
//
//		System.out.println(Roulette.cheval.size());
//		System.out.println(Roulette.transversale.size());
//		System.out.println(Roulette.carre.size());
//		System.out.println(Roulette.sizain.size());
//		System.out.println(Roulette.chiffresRoue.length);

//		int res = ((Roulette) roulette).getRandom(0, 5);
//		((Roulette) roulette).getVoisins(Roulette.chiffresRoue, res);
//
//		roulette.faireUnTirage();
////		
//		roulette.calculerGains(100);
		
//		roulette.afficherDetailsGains();
		
//		System.out.println(roulette);
		
		
//		System.out.println("\n-------------------------");
//		
//		System.out.println(loto);
//		
//		loto.faireUnTirage();
//		
//		loto.calculerGains(1000);
//		
//		System.out.println(destin);
//		
//		destin.faireUnTirage();
//		
//		destin.calculerGains(1000);
//		
//		System.out.println(jeu);
//		
//		jeu.faireUnTirage();
////		
//		jeu.calculerGains(1000);
		
		
		JeuSimple jeu2 = new JeuSimple(10, 6);
		
		Jeu loto1 = jeu2;
		
		((JeuSimple)loto1).faireUnTirage();
		loto1.faireUnTirage();
//		
		((JeuSimple)loto1).calculerGains(1000);
		loto1.calculerGains(1000);
		
		
		
		
		
		
	}

}
