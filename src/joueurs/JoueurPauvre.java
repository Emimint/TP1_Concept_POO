package joueurs;

import java.time.LocalDate;

public class JoueurPauvre extends Joueur {
	
	public JoueurPauvre() {
		super();
	}

	public JoueurPauvre(int capital) {
		super(capital);
	}

	public JoueurPauvre(Joueur autre) {
		super(autre);
	}

	public JoueurPauvre(String nom, int capital) {
		super(nom, capital);
	}

	public JoueurPauvre(String nom) {
		super(nom);
	}

	public void collecterCheque() {

		int today = LocalDate.now().getDayOfMonth();

		if (today == 1) {
			System.out.println("C'est le premier du mois :D !");
			setCapital(getCapital() + 700);
			System.out.printf("Le joueur %s a maintenant un capital de %d$.\n", getNom(), getCapital());
		} else 
			System.out.println("Ce n'est pas encore le temps...");

	}
}
