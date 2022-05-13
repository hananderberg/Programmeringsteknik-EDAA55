package life;

public class LifeController {
	public static void main(String[] args) {
		LifeBoard board = new LifeBoard(13, 13);
		LifeView window = new LifeView(board);
		window.drawBoard();
		Life life = new Life(board);
		
		while (true) {	
			int click = window.getCommand();
			
			if (click == 1) {
				int r = window.getRow();
				int c = window.getCol();
				life.flip(r, c);
				window.update();
			}
			if (click == 3) {
				System.exit(0);
			}
			if (click == 2) {
				board.increaseGeneration();
				life.newGeneration();
				window.update();
				int k = life.count();
				System.out.println("Antalet individer är "+k);
			}
	
		}
	}
}
