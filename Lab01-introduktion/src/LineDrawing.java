import se.lth.cs.pt.window.SimpleWindow;
import java.awt.Color;

public class LineDrawing {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(500, 500, "LineDrawing");
		w.moveTo(0, 0);
		while (true) {
			w.setLineColor(Color.red);
			w.waitForMouseClick();
			int mouseX = w.getMouseX();
			int mouseY = w.getMouseY(); 
			w.lineTo(mouseX, mouseY);
			
		}
	}
}
