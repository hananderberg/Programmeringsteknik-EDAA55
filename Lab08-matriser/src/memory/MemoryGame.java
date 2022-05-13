package memory;

public class MemoryGame {
	
	public static void main(String[] args) {
		String[] frontFileNames = {"can.jpg", "flopsy_mopsy_cottontail.jpg",
				"friends.jpg", "mother_ladybird.jpg", "mr_mcgregor.jpg",
				"mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };
		String backFileName = "back.jpg";
		
		MemoryBoard board = new MemoryBoard(4, backFileName, frontFileNames);
		MemoryWindow w = new MemoryWindow(board);
		w.drawBoard();
		
		int försök = 0;
		
		while (board.hasWon() == false) {
			w.waitForMouseClick();
			while (board.frontUp(w.getMouseRow(), w.getMouseCol()) == true) {
				w.waitForMouseClick();
			}
			
			int r1 = w.getMouseRow();
			int c1 = w.getMouseCol();
			board.turnCard(r1, c1);
			w.drawBoard();
			
			w.waitForMouseClick();
			while (board.frontUp(w.getMouseRow(), w.getMouseCol()) == true) {
				w.waitForMouseClick();
			}
			int r2 = w.getMouseRow();
			int c2 = w.getMouseCol();
			board.turnCard(r2, c2);
			w.drawBoard();
			
			
			if (board.getCard(r1, c1) == board.getCard(r2, c2)) {
				w.delay(1000);
				board.frontUp(r2, c2);
				board.frontUp(r1, c1);
			} else {
				w.delay(1500);
				board.turnCard(r1, c1);
				board.turnCard(r2, c2);
				w.drawBoard();
			}
			
			försök++;
		}
		
		System.out.println("Du klarade det! Det tog " + försök + " st försök." );
		
	}
}
