import java.util.Scanner;
import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

public class MazeMain {
	
	public static void main (String [] args) {
	SimpleWindow w = new SimpleWindow(400, 400, "TurtleIMaze");
	Scanner scan = new Scanner(System.in);
	System.out.println("Skriv ett nummer mellan 1-5 som kommer bli numret på labyrinten");
	int nbrMaze = scan.nextInt();
	
	while (nbrMaze > 5 || nbrMaze <= 0) {
		if (nbrMaze > 5) {
		System.out.println("Största möjliga nummer är 5");
		} else if (nbrMaze <= 0) {
		System.out.println("Minsta möjliga nummer är 1");
		}
	nbrMaze = scan.nextInt();
	}
	
	Maze m = new Maze(nbrMaze);
	
	Turtle t1 = new Turtle (w, 100, 100);
	t1.penDown();
	
	MazeWalker m1 = new MazeWalker(t1);
	
	m.draw(w);
	m1.walk(m);

	}
	
}
