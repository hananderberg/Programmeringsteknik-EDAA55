import se.lth.cs.pt.maze.Maze;

public class MazeWalker {
	private Turtle turtle;
	private int x;
	private int y;
	private int direction;

	public MazeWalker(Turtle turtle) {
		this.turtle = turtle;
	}

/** Låter sköldpaddan vandra genom labyrinten maze, från ingången till utgången. */
	public void walk(Maze maze) {
		int xm = maze.getXEntry();
		int ym = maze.getYEntry();
		turtle.jumpTo(xm,ym);
		turtle.turnNorth();
		direction = 90;
		x = turtle.getX();
		y = turtle.getY();
				
		boolean atExit = maze.atExit(x, y);
		boolean wallInFront = maze.wallInFront(direction, x, y);
		boolean wallAtLeft = maze.wallAtLeft(direction, x, y);
		
		int steg = 0;
		int riktningsändringar = 0;
		
	while (!atExit) {
		
		if (wallAtLeft == false) {
			turtle.left(90);
			riktningsändringar++;
			direction += 90;
			turtle.forward(1);
			steg++; 
		} else if (wallAtLeft == true && wallInFront == false) {
			turtle.forward(1);
			steg++;
		} else if (wallAtLeft == true && wallInFront == true) {
			turtle.left(270);
			riktningsändringar++;
			direction += 270;
			turtle.forward(1);
			steg++;
		}
		
		direction = turtle.getDirection();
		x = turtle.getX();
		y = turtle.getY();
		atExit = maze.atExit(x, y);
		wallInFront = maze.wallInFront(direction, x, y);
		wallAtLeft = maze.wallAtLeft(direction, x, y);
	}
		
	System.out.println("Sköldpaddan tog " + steg + " antal steg och ändrade riktning " + riktningsändringar + " gånger.");
	
	
	}
}