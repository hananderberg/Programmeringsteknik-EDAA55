package life;

public class Life {
	private LifeBoard board;

	public Life(LifeBoard board) {
		this.board = board;
	}

	/** Skapar en ny generation. */
	public void newGeneration() {
		boolean[][] boardcopy = new boolean[board.getRows()][board.getCols()];

		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				if (board.get(i, j) == false) {
					boardcopy[i][j] = false;
				}
				if (board.get(i, j) == true) {
					boardcopy[i][j] = true;
				}
			}
		}

		// Beräkna om en ruta ska dö eller leva.
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				int g = grannar(i, j, board);
				if (g >= 4 || g == 0 || g == 1) {
					boardcopy[i][j] = false;
				}
				if (g == 3 || g == 2 && boardcopy[i][j] == true) {
					boardcopy[i][j] = true;
				}
				if (g == 3 && boardcopy[i][j] == false) {
					boardcopy[i][j] = true;
				}
			}
		}

		// Kopiera boardcopy till det vanliga brädet.
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				if (boardcopy[i][j] == false) {
					board.put(i, j, false);
				}
				if (boardcopy[i][j] == true) {
					board.put(i, j, true);
				}
			}
		}

	}

	/** Privat hjälpmetod som beräknar antalet grannar till en ruta. */
	private int grannar(int row, int col, LifeBoard board) {
		int g = 0;

		// hörnbiten i vänstra hörnet uppe
		if (row == 0 && col == 0) {
			if (board.get(row, col + 1) == true) {
				g++;
			}
			if (board.get(row + 1, col + 1) == true) {
				g++;
			}
			if (board.get(+1, col) == true) {
				g++;
			}
		}
		// hörnbiten i högra hörnet uppe
		else if (row == 0 && col == board.getCols() - 1) {
			if (board.get(row + 1, col - 1) == true) {
				g++;
			}
			if (board.get(+1, col) == true) {
				g++;
			}
			if (board.get(row, col - 1) == true) {
				g++;
			}
		}
		// hörnbiten i vänstra hörnet nere
		else if (row == board.getRows() - 1 && col == 0) {
			if (board.get(row - 1, col) == true) {
				g++;
			}
			if (board.get(row - 1, col + 1) == true) {
				g++;
			}
			if (board.get(row, col - 1) == true) {
				g++;
			}
		}
		// hörnbiten i högra hörnet nere
		else if (row == board.getRows() - 1 && col == board.getCols() - 1) {
			if (board.get(row, col - 1) == true) {
				g++;
			}
			if (board.get(row - 1, col - 1) == true) {
				g++;
			}
			if (board.get(row - 1, col) == true) {
				g++;
			}
		}
		// kantbitarna högst upp
		else if (row == 0 && col < board.getCols() - 1 && col > 0) {
			if (board.get(row, col - 1) == true) {
				g++;
			}
			if (board.get(row, col + 1) == true) {
				g++;
			}
			if (board.get(+1, col) == true) {
				g++;
			}
			if (board.get(row + 1, col - 1) == true) {
				g++;
			}
			if (board.get(row + 1, col + 1) == true) {
				g++;
			}
		}
		// kantbitarna till höger
		else if (row > 0 && row < board.getRows() - 1 && col == board.getCols() - 1) {
			if (board.get(row, col - 1) == true) {
				g++;
			}
			if (board.get(row - 1, col - 1) == true) {
				g++;
			}
			if (board.get(row + 1, col - 1) == true) {
				g++;
			}
			if (board.get(row - 1, col) == true) {
				g++;
			}
			if (board.get(+1, col) == true) {
				g++;
			}
		}
		// kantbitarna längst ned
		else if (row == board.getRows() - 1 && col > 0 && col < board.getCols() - 1) {
			if (board.get(row, col - 1) == true) {
				g++;
			}
			if (board.get(row, col + 1) == true) {
				g++;
			}
			if (board.get(row - 1, col - 1) == true) {
				g++;
			}
			if (board.get(row - 1, col + 1) == true) {
				g++;
			}
			if (board.get(row - 1, col) == true) {
				g++;
			}
		}
		// kantbitarna till vänster
		else if (row > 0 && row < board.getRows() - 1 && col == 0) {
			if (board.get(row - 1, col) == true) {
				g++;
			}
			if (board.get(row - 1, col + 1) == true) {
				g++;
			}
			if (board.get(row, col + 1) == true) {
				g++;
			}
			if (board.get(row + 1, col + 1) == true) {
				g++;
			}
			if (board.get(row + 1, col) == true) {
				g++;
			}
		}
		// vanliga bitar
		else {
			if (board.get(row - 1, col) == true) {
				g++;
			}
			if (board.get(row - 1, col + 1) == true) {
				g++;
			}
			if (board.get(row - 1, col - 1) == true) {
				g++;
			}
			if (board.get(row + 1, col + 1) == true) {
				g++;
			}
			if (board.get(row + 1, col) == true) {
				g++;
			}
			if (board.get(row + 1, col - 1) == true) {
				g++;
			}
			if (board.get(row, col + 1) == true) {
				g++;
			}
			if (board.get(row, col - 1) == true) {
				g++;
			}
		}

		return g;
	}

	/**
	 * Ändrar innehållet i rutan med index row, col från individ till tom eller
	 * tvärtom.
	 */
	public void flip(int row, int col) {
		if (board.get(row, col) == true) {
			board.put(row, col, false);
		} else if (board.get(row, col) == false) {
			board.put(row, col, true);
		}
	}

	public int count() {
		int k = 0;

		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				if (board.get(i, j) == true) {
					k++;
				}
			}
		}
		return k;
	}

}
