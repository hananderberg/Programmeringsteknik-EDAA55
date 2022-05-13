import se.lth.cs.pt.window.SimpleWindow;

public class Mole {
	private Graphics g = new Graphics(30, 50, 10);
	
	public static void main(String[] args) {
		Mole m = new Mole();
		m.drawWorld();
		m.dig();
	}

	public void drawWorld() {
		g.rectangle(0, 0, 30, 50, Colors.SOIL);
	}

	public void dig() {
		int x = g.getWidth() / 2;
		int y = g.getHeight() / 2;
		
		while (true) {
			if (x > 29) {
				x = 29;
			} else if (x < 0 ) {
				x = 0;
			} else if (y < 0) {
				y = 0;
			} else if (y > 49) {
				y = 49;
			} 
			g.block(x, y, Colors.MOLE);
			char key = g.waitForKey();
		
			g.block(x, y, Colors.TUNNEL);
			
			if(key == 'w') {
				g.block(x, y - 1, Colors.MOLE);
				y = y - 1;
			} else if (key == 'a') {
				g.block(x - 1, y, Colors.MOLE);
				x = x - 1;
			} else if (key == 's') {
				g.block(x, y + 1, Colors.MOLE);
				y = y + 1;
			} else if (key == 'd') {
				g.block(x + 1, y, Colors.MOLE);
				x = x + 1;
			}
			
			
			}
		}
}
			
 
