import java.util.Random;

public class AbsentMindedTurtle extends RaceTurtle {
	private int tankspriddGrad;
	
	/**Skapar en sköldpadda som springer i fönstret w.*/
	public AbsentMindedTurtle(RaceWindow w, int nbr, int tankspriddGrad) {
		super(w, nbr);
		this.tankspriddGrad = tankspriddGrad;
	}
	
	/**Låter sköldpaddan gå framår ett steg. Stegets längd ges av ett 
	 * slumptal mellan 1 och 6.*/
	public void raceStep() {
		Random rand = new Random();
		int k = rand.nextInt(99) + 1;
		if (k > tankspriddGrad) {
			super.raceStep();
		}
	}
	
	/** Returnerar en läsbar represenation av denna RaceTurtle, på formen
	 * "Nummer x" där x är sköldpaddans startnummer.*/
	 public String toString() {
		 String s = super.toString();
		 String tankspridd  = Integer.toString(tankspriddGrad);
		 return s + " - AbsentMindedTurtle (" + tankspridd + "% frånvarande)";
	 }
	
}

