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
		System.out.println("Le gouvernement a tout saisi :( !");
		setCapital(0);
		quitterCasino();
		System.out.printf("Le joueur %s a maintenant un capital de %d$...\n", getNom(), getCapital());
	}
}
