import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;


public class Ritaettkvadratobjekt {
		public static void main(String[] args) {
			Square sq = new Square(100, 200, 40);
			if (sq.getSide() > 500) {
				sq.setSide(500);
			}
			System.out.println(sq);
		}
	}

