import java.util.Random;

public class RaceTurtle extends Turtle {
	private int nbr;
	
	/**Skapar en sköldpadda som springer i fönstret w.*/
	public RaceTurtle(RaceWindow w, int nbr) {
		super(w, w.getStartXPos(nbr), w.getStartYPos(nbr));
		penDown();
		left(270);
		this.nbr = nbr;
	}
	
	/**Låter sköldpaddan gå framår ett steg. Stegets längd ges av ett 
	 * slumptal mellan 1 och 6.*/
	public void raceStep() {
		Random rand = new Random();
		int s = rand.nextInt(6) + 1;
		forward(s);
	}
	
	/** Returnerar en läsbar represenation av denna RaceTurtle, på formen
	 * "Nummer x" där x är sköldpaddans startnummer.*/
	 public String toString() {
		 String nummer = Integer.toString(nbr);
		 return "Nummer " + nummer;
	 }
	
}
