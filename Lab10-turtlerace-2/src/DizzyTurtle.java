import java.util.Random;

public class DizzyTurtle extends RaceTurtle {
	private int gradYrsel;
		
	/**Skapar en sköldpadda som springer i fönstret w.*/
	public DizzyTurtle(RaceWindow w, int nbr, int gradYrsel) {
		super(w, nbr);
		this.gradYrsel = gradYrsel;
	}
		
	/**Låter sköldpaddan gå framår ett steg. Stegets längd ges av ett 
	 * slumptal mellan 1 och 6.*/
	public void raceStep() {
		Random rand = new Random();
		int k = rand.nextInt(2);
		if (k == 0) {
			left(-gradYrsel*2);
		} if (k == 1) {
			left(gradYrsel*2);
		}
		super.raceStep();
		turnRaktSidan();
	}
		
	/** Returnerar en läsbar represenation av denna RaceTurtle, på formen
		 * "Nummer x" där x är sköldpaddans startnummer.*/
	public String toString() {
		String s = super.toString();
		String yrsel = Integer.toString(gradYrsel);
		return s + " - DizzyTurtle (Yrsel: " + yrsel + ")";
		}
		
	}
