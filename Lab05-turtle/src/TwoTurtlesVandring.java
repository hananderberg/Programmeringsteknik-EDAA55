import java.util.Random;
import se.lth.cs.pt.window.SimpleWindow;

public class TwoTurtlesVandring {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TwoTurtlesVandring");
		Turtle t1 = new Turtle(w, 250, 250);
		Turtle t2 = new Turtle(w, 350, 350);
		
		t1.penDown();
		t2.penDown();

		Random rand = new Random();
		
		int x1 = t1.getX();
		int y1 = t1.getY();
		int x2 = t2.getX();
		int y2 = t2.getY();
		double avstånd = Math.sqrt(Math.pow((x1 - x2), 2)+ Math.pow((y1 - y2), 2));
		
		while (avstånd >= 99) {
			t1.left(rand.nextInt(360) - 180);
			t1.forward(rand.nextInt(10) + 1);
			
			t2.left(rand.nextInt(360) - 180);
			t2.forward(rand.nextInt(10) + 1);
			
			x1 = t1.getX();
			y1 = t1.getY();
			x2 = t2.getX();
			y2 = t2.getY();
			
			avstånd = Math.sqrt(Math.pow((x1 - x2), 2)+ Math.pow((y1 - y2), 2));			
			SimpleWindow.delay(10);
		}
		
		
			
	}
	

	
}
