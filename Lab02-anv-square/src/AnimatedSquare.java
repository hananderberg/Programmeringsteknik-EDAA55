import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class AnimatedSquare {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "UPPGIFT8");
		Square sq = new Square(100, 100, 100);
		sq.draw(w);
		
		int oldx = 100;
		int oldy = 100; 
		
		while (true) {
			w.waitForMouseClick(); 
			sq.erase(w);
			int x = w.getMouseX();
			int y = w.getMouseY();
			
		for (int i = 0; i < 10; i++) {
			sq.move((x - oldx)/10, (y - oldy)/10);
			sq.draw(w);
			SimpleWindow.delay(200);			
			sq.erase(w);
		}
		
		w.clear();
		sq = new Square(x, y, 100);
		sq.draw(w);
				
		oldx = x;
		oldy = y;
		
		}
	}
}
