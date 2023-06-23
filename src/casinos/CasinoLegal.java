package casinos;

public class CasinoLegal extends Casino {

	@Override
	public void payerImpots() {
		System.out.println("Pas de chance! C'est le jour des impots :( ...");
		super.setCapital((int) (super.getCapital() * 0.85));
	}

}
