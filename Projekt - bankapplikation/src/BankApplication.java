import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankApplication {

	public static void main(String[] args) {
		Bank bank = new Bank();
		Scanner scan = new Scanner(System.in);

		while (true) {
			writeMenu();
			boolean righttype = false;
			int v = 0;

			while (!righttype)
				try {
					v = scan.nextInt();
					righttype = true;
				} catch (InputMismatchException e) {
					scan.next();
					System.out.println("Du måste ange ett nummer.");
					System.out.print("Vänligen gör ett nytt menyval: ");
				}

			if (v == 9) {
				break;
			} else {
				runApplication(bank, scan, v);
				System.out.println(" ");

				for (int i = 0; i < 6; i++) {
					System.out.print("¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
				}
				System.out.println(" ");
			}
		}
	}

	public static void runApplication(Bank bank, Scanner scan, int v) {
		if (v == 1) {
			hittaKonto(bank, scan);
		} else if (v == 2) {
			sökPåNamn(bank, scan);
		} else if (v == 3) {
			sättInPengar(bank, scan);
		} else if (v == 4) {
			taUtPengar(bank, scan);
		} else if (v == 5) {
			överförPengar(bank, scan);
		} else if (v == 6) {
			nyttKonto(bank, scan);
		} else if (v == 7) {
			taBortKonto(bank, scan);
		} else if (v == 8) {
			skrivUtKonton(bank);
		} else if (v > 9 || v < 0) {
			System.out.println("Ange ett nummer mellan 1 och 9.");
		}
	}

	public static int kontoNr(Scanner scan) {
		int kontoNr = 0;
		boolean righttype = false;

		while (!righttype) {
			try {
				kontoNr = scan.nextInt();
				righttype = true;
			} catch (InputMismatchException e) {
				scan.next();
				System.out.println("Fel typ av indata.");
				System.out.println("Vänligen skriv in kontonummer: ");
			}
		}
		return kontoNr;
	}

	public static long idNr(Scanner scan) {
		long idNr = 0;
		boolean righttype = false;

		while (!righttype) {
			try {
				idNr = scan.nextLong();
				righttype = true;
			} catch (InputMismatchException e) {
				scan.next();
				System.out.println("Fel typ av indata.");
				System.out.println("Vänligen skriv in ID-nummer: ");
			}
		}
		return idNr;
	}

	public static double amount(Scanner scan) {
		double amount = 0;
		boolean righttype = false;

		while (!righttype) {
			try {
				amount = scan.nextDouble();
				righttype = true;
			} catch (InputMismatchException e) {
				scan.next();
				System.out.println("Fel typ av indata.");
				System.out.println("Vänligen skriv in ett belopp: ");
			}
		}
		return amount;
	}

	public static String namn(Scanner scan) {
		String namn = scan.next();
		return namn;
	}

	public static void taBortKonto(Bank bank, Scanner scan) {
		System.out.print("Ange kontonummer som ska tas bort: ");
		int kontoNr = kontoNr(scan);

		boolean tagitsbort = bank.removeAccount(kontoNr);

		if (tagitsbort == true) {
			System.out.println("Kontot " + kontoNr + " har tagits bort.");
		} else {
			System.out.println("Kontot " + kontoNr + " finns inte.");
		}

	}

	public static void nyttKonto(Bank bank, Scanner scan) {
		System.out.print("Ange namn: ");
		String namn = namn(scan);
		namn += scan.nextLine();
		System.out.print("Ange ID-nummer: ");
		long idNr = idNr(scan);

		int kontonummer = bank.addAccount(namn, idNr);
		System.out.println("Konto skapat med kontonummer: " + kontonummer);
	}

	public static void överförPengar(Bank bank, Scanner scan) {
		System.out.print("Från konto: ");
		int frånkontoNr = kontoNr(scan);
		System.out.print("Till konto: ");
		int tillkontoNr = kontoNr(scan);
		System.out.print("Välj hur mycket du till föra över: ");
		double belopp = amount(scan);

		BankAccount fr = bank.findByNumber(frånkontoNr);
		BankAccount ti = bank.findByNumber(tillkontoNr);

		if (fr == null || ti == null) {
			System.out.println("Något av kontona finns inte.");
		} else {
			if (fr.getAmount() >= belopp) {
				fr.withdraw(belopp);
				ti.deposit(belopp);
				System.out.println(fr.toString());
				System.out.println(ti.toString());
			} else {
				System.out.println("Du har inte tillräckligt med pengar på kontot");
			}
		}

	}

	public static void taUtPengar(Bank bank, Scanner scan) {
		System.out.print("Vänligen skriv in kontonummer: ");
		int kontoNr = kontoNr(scan);
		System.out.print("Välj hur mycket du vill ta ut: ");
		double belopp = amount(scan);

		BankAccount b = bank.findByNumber(kontoNr);
		if (b == null) {
			System.out.println("Kontot finns inte.");
		} else {
			if (b.getAmount() >= belopp) {
				b.withdraw(belopp);
				String s = b.toString();
				System.out.println(s);
			} else {
				System.out.println("Du har inte tillräckligt med pengar på kontot.");
			}
		}

	}

	public static void sättInPengar(Bank bank, Scanner scan) {
		System.out.print("Vänligen skriv in kontonummer: ");
		int kontoNr = kontoNr(scan);
		System.out.print("Välj hur mycket du vill sätta in: ");
		double belopp = amount(scan);

		BankAccount b = bank.findByNumber(kontoNr);

		if (b == null) {
			System.out.println("Kontot finns inte.");
		} else {
			if (belopp >= 0) {
				b.deposit(belopp);
				String s = b.toString();
				System.out.println(s);
			} else {
				System.out.println("Negativa belopp ej tillåtna.");
			}
		}

	}

	public static void hittaKonto(Bank bank, Scanner scan) {
		System.out.print("Vänligen skriv in ID: ");
		long idNr = idNr(scan);
		ArrayList<BankAccount> kundenskonton = bank.findAccountsForHolder(idNr);

		ArrayList<BankAccount> list = bank.findAccountsForHolder(idNr);

		if (list.isEmpty() == true) {
			System.out.println("Personen har inget konto.");
		} else {
			for (BankAccount b : kundenskonton) {
				String s = b.toString();
				System.out.println(s);
			}
		}
	}

	public static void sökPåNamn(Bank bank, Scanner scan) {
		System.out.print("Sök här: ");
		String namepart = namn(scan);

		ArrayList<Customer> mednamn = bank.findByPartofName(namepart);
		ArrayList<Customer> utandubbletter = new ArrayList<Customer>();

		for (int p = 0; p < mednamn.size(); p++) {
			Customer c = mednamn.get(p);
			if (!utandubbletter.contains(c)) {
				utandubbletter.add(c);
				String s = c.toString();
				System.out.println(s);
			}
		}
	}

	public static void skrivUtKonton(Bank bank) {
		ArrayList<BankAccount> alla = bank.getAllAccounts();
		if (alla.size() == 0) {
			System.out.println("Banken har för närvarande inga konton.");
		} else {
			System.out.println("Bankens konton:");
			for (BankAccount b : alla) {
				String s = b.toString();
				System.out.println(s);
			}
		}
	}

	public static void writeMenu() {
		System.out.println("M E N Y");
		System.out.println("1. Hitta konto utifrån innehavare.");
		System.out.println("2. Sök kontoinnehavare utifrån (del av) namn.");
		System.out.println("3. Sätt in pengar.");
		System.out.println("4. Ta ut pengar.");
		System.out.println("5. Överför pengar.");
		System.out.println("6. Skapa nytt konto");
		System.out.println("7. Ta bort konto.");
		System.out.println("8. Skriv ut konton.");
		System.out.println("9. Avsluta.");
		System.out.println("Skriv in ditt val här: ");
	}
}
