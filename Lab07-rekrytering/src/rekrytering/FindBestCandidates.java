package rekrytering;

import java.util.Arrays;

public class FindBestCandidates {
	private static final double MIN_AVG_GRADE = 4.0;

	public static void main(String[] args) {
		Applicant[] helaFilen = FileReader.readFromFile("applications_all.txt", 500);
		
		// Läs från fil (Börja med "applications_small.txt), spara resultatet i en
		// vektor
		/*for(int i = 0; i < helaFilen.length; i++) {
			Applicant c = helaFilen[i];
			String s = c.toString(c);
			System.out.println(s);
		}*/
		
		// Skicka in Applicant-vektorn (som du fick i föregående steg) till metoden
		// findBestCandidiates (nedan)
		// Spara resultatet i en vektor
		// Printa resultatet från findBestCandidates
		
		Applicant[] brasokande = findBestCandidates(helaFilen);
		Arrays.sort(brasokande);
		
		for(int i = 0; i < brasokande.length; i++) {
			Applicant c = brasokande[i];
			String s = c.toString(c);
			System.out.println(s);
		}
		
	}

	public static Applicant[] findBestCandidates(Applicant[] applicants) {	
		int k = 0;
		for (int i = 0; i < applicants.length; i++) {
			if (applicants[i]==null) {
				//gör ingenting
			} else {
			if (applicants[i].getAvgGrade(applicants[i]) >= MIN_AVG_GRADE) {
				k++;
			} 
			}
		
		}
		
		Applicant[] brasokande = new Applicant[k];
		
		int p = 0;
		for(int i = 0; i < applicants.length; i++) {
			if (applicants[i]==null) {
				//gör ingenting
			} else {
			if (applicants[i].getAvgGrade(applicants[i]) >= MIN_AVG_GRADE) {
				brasokande[p] = applicants[i];
				p++;
			}
			}
		}				
			
		//Loopa och räkna antalet applicants som kommer över gränsen.
		//Skapa vektor vars storlek du fick fram i föregående loop.
		//Loopa igen och lägg in alla applicants som kommer över gränsen i den nya vektorn. 
		
		
		// Hitta alla kandidater som har medelbetyg över MIN_AVG_GRADE
		// Lagra alla dessa kandidater i en vektor, returnera vektorn
		return brasokande; //Byt ut denna rad mot hela din egen lösning
	}
}
