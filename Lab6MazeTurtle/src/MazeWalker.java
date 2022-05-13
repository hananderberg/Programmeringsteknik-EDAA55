import se.lth.cs.pt.maze.Maze;

public class MazeWalker {
	private Turtle turtle;
	
	public MazeWalker(Turtle turtle) {
		this.turtle = turtle; 
	}

	/** Låter sköldpaddan vandra genom labyrinten maze, från ingången till utgången. */
	public void walk(Maze maze) {	
		int direction = 90;
		
		boolean väggvänster = maze.wallAtLeft(direction, maze.getXEntry(), maze.getYEntry());
		boolean väggframför = maze.wallInFront(direction, maze.getXEntry(), maze.getYEntry());
		
		if (atExit == false) {
			if (väggvänster == true && väggframför == false) {
				if (direction == 90) {
					y = y + 1;
				} if (direction == 0) {
					x = x + 1;
				} if (direction == 180) {
					x = x - 1;
				} if (direction == 270) {
					y = y - 1;
				}
					
			} if else (väggvänster == true && väggframför == true) {
				direction = direction - 90;
			} if else (väggvänster == false && väggframför == true) {
				direction = direction + 90;
			} if else (väggvänster == false && väggframför == false) {
				if (direction == 90) {
					y = y + 1;
				} if (direction == 0) {
					x = x + 1;
				} if (direction == 180) {
					x = x - 1;
				} if (direction == 270) {
					y = y - 1;
				}
			}
		
		
		} 

}
