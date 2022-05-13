import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {
	private SimpleWindow w; //nytt fönster
	private double x; // x-startpositionen för sköldpaddan
	private double y; // y-startpositionen för sköldpaddan
	private boolean pen;
	//private double direction = (Math.PI / 4); //riktning i radianer
	private double direction = 90; //riktning i grader
	
	/** Skapar en sköldpadda som ritar i ritfönstret w. Från början 
	    befinner sig sköldpaddan i punkten x, y med pennan lyft och 
	    huvudet pekande rakt uppåt i fönstret (i negativ y-riktning). */
	public Turtle(SimpleWindow w, double x, double y) {
		this.w = w;
		this.x = x;
		this.y = y;
	}
	
	/** Sänker pennan. */
	public void penDown() {
		pen = true;
	}
	
	/** Lyfter pennan. */
	public void penUp() {
		pen = false;
	}
	
	
	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) {
		if (pen)
			w.moveTo((int) Math.round(x), (int) Math.round(y));
		//SimpleWindow.delay(10);
		x += n * Math.cos((direction * Math.PI)/180);
		y -= n * Math.sin((direction * Math.PI)/180);
		if (pen)
			w.lineTo((int) Math.round(x), (int) Math.round(y));
		//SimpleWindow.delay(10);
	}
		
	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) {
		direction = direction + beta; 
	}

	/** Går till punkten newX, newY utan att rita. Pennans läge (sänkt
	    eller lyft) och huvudets riktning påverkas inte. */
	public void jumpTo(int newX, int newY) {
		x = newX;
		y = newY;
	}
	
	/** Återställer huvudriktningen till den ursprungliga för racet. */
	public void turnRaktSidan() {
		direction = 0; 
	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() {
		direction = 90; 
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return (int) Math.round(x);
	}

 	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return (int) Math.round(y);
	}
  
	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
 	public int getDirection() {
 		//return (int) Math.toDegrees(direction);
 		return (int) direction;
	}
}
