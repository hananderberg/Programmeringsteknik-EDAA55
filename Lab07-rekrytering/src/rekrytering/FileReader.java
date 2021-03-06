package rekrytering;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	/**
	 * Returnerar max nbrOfRows rader från filen som en vektor av Applicant-objekt.
	 * Läser i filen tills det inte finns fler rader eller tills man läst nbrOfRows
	 * rader (det som inträffar först). 
	 * Returnerar null om filen inte finns.
	 */
	public static Applicant[] readFromFile(String fileName, int nbrOfRows) {
		Scanner scan;
		try {
			scan = new Scanner(new File(fileName), "utf-8");
		} catch (FileNotFoundException e) {
			System.err.println("File not found" + fileName);
			e.printStackTrace();
			return null;
		}
		
		Applicant[] personer = new Applicant[nbrOfRows];
		
		int k = 0;
		while(scan.hasNextLine() && k < nbrOfRows) {
			String rad = scan.nextLine();
			String [] res = rad.split(" ");
			String betygen = res[2];
			personer[k] = new Applicant(res[0] + " " + res[1], betygen);
			k++;
		}
		
		//Här kan du använda Scannern för att läsa från filen fileName.
		//Varje rad motsvarar en Applicant. Kontrollera vad Applicants konstruktor kräver
		//Alla Applicant-objekt (max nbrOfRows stycken) ska lagras i en Applicant-vektor och returneras på slutet
		return personer; //Byt ut denna rad mot hela lösningen
	}
}
