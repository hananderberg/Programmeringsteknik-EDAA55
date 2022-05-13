package life;

public class LifeBoard {
	private boolean [][] board = null;
	private int rows;
	private int cols;
	private int genNbr;
	
	/** Skapar en spelplan med rows rader och cols kolonner.
	    Spelplanen är från början tom, dvs alla rutorna är
	    tomma och generationsräknaren är 1. */	
	public LifeBoard(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		genNbr = 1;
		board = new boolean [rows][cols];
	}

	/** Undersöker om det finns en individ i rutan med index row,col, 
	    Om index row,col hamnar utanför spelplanen returneras false. */
	public boolean get(int row, int col) {
		if (row >= rows || col >= cols || col < 0 || row < 0) {
			return false;
		} else {
			if (board[row][col] == false) {
				return false;
			} else {
				return true;
			}
		}
	}

	/** Lagrar värdet val i rutan med index row,col. */
	public void put(int row, int col, boolean val) {
		board[row][col] = val;
	}

	/** Tar reda på antalet rader. */
	public int getRows() {
		return rows;
	}

 	/** Tar reda på antalet kolonner. */
	public int getCols() {
		return cols;
	}

	/** Tar reda på aktuellt generationsnummer. */
	public int getGeneration() {
		return genNbr;
	}

	/** Ökar generationsnumret med ett. */
	public void increaseGeneration() {
		genNbr = getGeneration() + 1;
		
	}
}
