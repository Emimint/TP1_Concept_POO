package joueurs;

public class JoueurRiche extends Joueur{

	public JoueurRiche() {
		super();
	}

	public JoueurRiche(int capital) {
		super(capital);
	}

	public JoueurRiche(Joueur autre) {
		super(autre);
	}

	public JoueurRiche(String nom, int capital) {
		super(nom, capital);
	}

	public JoueurRiche(String nom) {
		super(nom);
	}
	
	public void banqueRoute() {
		System.out.println("Le gouvernement a tout saisi : vos investissements à l’étranger ont ete saisis par le gouvernement\n"
				+ "et vos comptes dans les paradis fiscaux sont fermés...");
		setCapital(0);
		quitterCasino();
		System.out.printf("Le joueur %s a maintenant un capital de %d$.\n", getNom(), getCapital());
	}
}
