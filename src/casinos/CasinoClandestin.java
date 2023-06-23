package casinos;

public class CasinoClandestin extends Casino {

	@Override
	public void payerImpots() {
		int chance = (int)((100 * Math.random()) + 1);
		System.out.println("chance = " + chance);
		if (chance >= 99) {
			System.out.println("Pas de chance! C'est le jour des impots :( ...");
			super.setCapital((int)(super.getCapital()*0.5));			
		}
	}

}
