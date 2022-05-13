import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

public class MazeMain {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleIMaze");
		Turtle t = new Turtle(w, 300, 300);
		Maze m = new Maze(5);
		
		m.draw(w);
	}

}
