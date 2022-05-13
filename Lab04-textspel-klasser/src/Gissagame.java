import java.util.Random;
import java.util.Scanner;

public class Gissagame {
	private int svar = 0;
	private int försök = 0;
	boolean vinna = false;

public Gissagame() {
    svar = generateRandomNumber();
}

private int generateRandomNumber() {
    Random rand = new Random();
    int randomnbr = rand.nextInt(100) + 1; 
    return randomnbr;
}

public void gissa() {
	long start = System.currentTimeMillis();
    while (vinna == false) {
    	if (försök  == 0) {
        System.out.println("Gissa ett nummer mellan 1 och 100");
    	} else {
        System.out.println("Gissa igen");
        }
    	
    	Scanner scan = new Scanner(System.in);
        int gissning = scan.nextInt();

        if (gissning > 100) {
            System.out.println("Ditt nummer är högre än maxgränsen");
        } else if (gissning < 1) {
            System.out.println("Ditt nummer är lägre än minimigränsen");
        } else if (gissning == svar) {
            vinna = true;
            försök++;
        } else if (gissning < svar) {
            System.out.println("Din gissning är för låg");
            försök++;
        } else if (gissning > svar) {
            System.out.println("Din gissning är för hög");
            försök++;
        }
    }
    long end = System.currentTimeMillis();
    long elapsed = end - start;
    
    System.out.println("Grattis, du gissade rätt! "+ "Det tog " + försök + " försök.");
    System.out.println("Det tog " + elapsed/1000 + " sekunder." );

}
}