package memory;

import java.util.Random;

public class MemoryBoard {
	private int size;
	private String backFileName;
	private String[] frontFileNames;
	private boolean [][] board;
	private MemoryCardImage [][] memory;

	/** Skapar ett memorybräde med size * size kort. backFileName är filnamnet 
	    för filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen 
	    för frontbilderna. */
	public MemoryBoard(int size, String backFileName, String[] frontFileNames) {
		this.size = size;
		this.backFileName = backFileName;
		this.frontFileNames = frontFileNames;
		memory = new MemoryCardImage[size][size];
		board = new boolean [size][size];
		createCards(backFileName, frontFileNames);
	}

	/* Skapar size * size / 2 st memorykortbilder.
	   Placerar ut varje kort på två slumpmässiga ställen på spelplanen. */
	private void createCards(String backFileName, String[] frontFileNames) {		
		Random rand = new Random();
			
		for (int i = 0; i < 8; i++) {
			String frontFileName = frontFileNames[i];
			MemoryCardImage m = new MemoryCardImage (frontFileName, backFileName);
			
		int k = 0;
		while (k < 2) {
			int r = rand.nextInt(4);
			int c = rand.nextInt(4);
			
			if (memory[r][c] == null) {
				memory[r][c] = m;
				k++;
			}
			
		}
			
		}
	}

	/** Tar reda på brädets storlek. */
	public int getSize() {
		return size;
	}
	
	/** Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c.
	    Raderna och kolonnerna numreras från 0 och uppåt. */
	public MemoryCardImage getCard(int r, int c) {
		return memory[r][c];
	}

	/** Vänder kortet på rad r, kolonn c. */
	public void turnCard(int r, int c) {
		if (board[r][c] == true) {
			board[r][c] = false;
		} else if (board[r][c] == false){
			board[r][c] = true;
		}
	}
	
	/** Returnerar true om kortet r, c har framsidan upp. */
	public boolean frontUp(int r, int c) {
		if (board[r][c] == true) {
			return true; 
		} else {
			return false;
		}
	}
	
	/** Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2, 
	    kolonn c2. */
	public boolean same(int r1, int c1, int r2, int c2) {
		if (memory [r1][c1] == memory[r2][c2]) {
			return true;
		} else {
		return false;
		}
	}

	/** Returnerar true om alla kort har framsidan upp. */
	public boolean hasWon() {
		int k = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (board [i][j] == true)
					k++;
			}
		}
		if (k == size * size) {
			return true;
		} else {
			return false;
		}
	}	
}

