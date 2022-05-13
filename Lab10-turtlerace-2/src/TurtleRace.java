import java.util.ArrayList;
import java.util.Random;

public class TurtleRace {

	public static void main(String[] args) {
		RaceWindow w1 = new RaceWindow();
		Random rand = new Random();
		ArrayList<RaceTurtle> raceturtles = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> vinnare = new ArrayList<RaceTurtle>();
		
		int k = 1;
		
		while(raceturtles.size() < 8) {
			int p = rand.nextInt(3);
			if (p == 0) {
				MoleTurtle m = new MoleTurtle (w1, k);
				raceturtles.add(m);
				k++;
			} if (p == 1) {
				int dg = rand.nextInt(5) + 1;
				DizzyTurtle d = new DizzyTurtle (w1, k, dg);
				raceturtles.add(d);
				k++;
			} if (p == 2) {
				int am = rand.nextInt(101);
				AbsentMindedTurtle a = new AbsentMindedTurtle(w1, k, am);
				raceturtles.add(a);
				k++;
			}
		}
		
		for (RaceTurtle r : raceturtles) {
			String s = r.toString();
			System.out.println(s);
		}
				
		while(vinnare.size() < 8) {
			int s = rand.nextInt(raceturtles.size());
			RaceTurtle u = raceturtles.get(s);
			u.raceStep();
			RaceWindow.delay(10);
			for (int i = 0; i < raceturtles.size(); i++) {
			RaceTurtle p = raceturtles.get(i);
				if (p.getX() >= RaceWindow.X_END_POS) {
					raceturtles.remove(i);
					vinnare.add(u);
				}
			}
		}
		
		RaceTurtle forsta = vinnare.get(0);
		RaceTurtle andra = vinnare.get(1);
		RaceTurtle tredje = vinnare.get(2);
		String forstaString = forsta.toString();
		String andraString = andra.toString();
		String tredjeString = tredje.toString();
		
		System.out.println("På plats 1: " + forstaString); 
		System.out.println("På plats 2: " + andraString); 
		System.out.println("På plats 3: " + tredjeString);
		
	}
}

