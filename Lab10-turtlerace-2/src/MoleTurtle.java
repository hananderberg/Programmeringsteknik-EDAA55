import java.util.Random;

public class MoleTurtle extends RaceTurtle {
	
	/**Skapar en sköldpadda som springer i fönstret w.*/
	public MoleTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
	}
	
	/**Låter sköldpaddan gå framår ett steg. Stegets längd ges av ett 
	 * slumptal mellan 1 och 6.*/
	public void raceStep() {
		Random rand = new Random();
		int k = rand.nextInt(2);
		if (k == 0) {
			penDown();
		} if (k == 1) {
			penUp();
		}
		super.raceStep();
	}
	
	/** Returnerar en läsbar represenation av denna RaceTurtle, på formen
	 * "Nummer x" där x är sköldpaddans startnummer.*/
	 public String toString() {
		 String s = super.toString();
		 
		 return s + " - MoleTurtle";
	 }
	
}
