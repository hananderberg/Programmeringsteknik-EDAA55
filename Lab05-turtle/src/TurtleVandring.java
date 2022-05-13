import java.util.Random;
import se.lth.cs.pt.window.SimpleWindow;

public class TurtleVandring {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleVandring");
		Turtle t = new Turtle(w, 300, 300);
		t.penDown();

		int totsteg = 0;

		Random rand = new Random();

		while (totsteg < 1000) {
			int flyttagrader = rand.nextInt(360) - 180;
			t.left(flyttagrader);
			
			int antalsteg = 1 + rand.nextInt(9);
			t.forward(antalsteg);
			totsteg = totsteg + antalsteg;
		}
	}

}
