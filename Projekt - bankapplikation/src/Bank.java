import java.util.ArrayList;

public class Bank {
	private ArrayList<BankAccount> bank = new ArrayList<BankAccount>();
	
	public Bank() {
		
	}
	
	/** Öppna ett nytt konto i banken. Om det redan finns en kontoinnehavare med 
	 * de givna uppgifterna ska inte en ny Customer skapas, utan istället den befintliga användas. 
	 * Det nya kontonumret returneras.*/
	public int addAccount(String holderName, long idNr) {
		boolean kundfinns = false;
		int accountNbr = 0;
		Customer cu = null;
		
		for (BankAccount b : bank) {
			Customer c = b.getHolder();
			String namnjamfor = c.getName();
			long idnrjamfor = c.getIdNr();
			if (namnjamfor.equals(holderName) && idnrjamfor == idNr) {
				kundfinns = true;
				cu = b.getHolder();
			} 
		}
		
		if (kundfinns == true) {
			BankAccount ban = new BankAccount(cu);
			bank.add(ban);
			accountNbr = ban.getAccountNumber();
			
		} else if (kundfinns == false) {
			Customer o = new Customer (holderName, idNr);
			BankAccount ba = new BankAccount(o);
			bank.add(ba);
			accountNbr = ba.getAccountNumber();
		}
		
		return accountNbr;
	}
	
	/** Returnerar den kontoinnehavare som har det givna id-numret, eller null om ingen sådan finns.*/
	public Customer findHolder(long idNr) {
		Customer cu = null;
		
		for (BankAccount b : bank) {
			Customer c = b.getHolder();
			long id = c.getIdNr();
			if (id == idNr) {
				cu = c;
			} 
		}
		return cu;
	}
	
	/**Tar bort konto med nummer 'number' från banken. Returnerar true 
	 * om kontot fanns (och kunde tas bort), annars false.*/
	public boolean removeAccount(int number) {
		int k = 0;
			
		for (BankAccount b : bank) {
			if (b.getAccountNumber() == number) {
				bank.remove(b);
				k++;
				break;
			} 
		}
		
		if (k == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	/** Returnerar en lista innehållande samtliga bankkonton i banken. 
	 * Listan är sorterad på kontoinnehavarnas namn.*/
	public ArrayList<BankAccount> getAllAccounts() {
		BankAccount temp = null;
		
		for (int i = 1; i < bank.size(); i++) {
		    for (int j = i; j > 0; j--) {
		    	int k = 0;
		    
		    	BankAccount b1 = bank.get(j);
				Customer c1 = b1.getHolder();
				String namn1 = c1.getName();
				int längd1 = namn1.length();
				
				BankAccount b2 = bank.get(j-1);
				Customer c2 = b2.getHolder();
				String namn2 = c2.getName();
				int längd2 = namn2.length();
									
					while(namn2.charAt(k) == namn1.charAt(k) && k < längd2-1 && k < längd1-1) {
						k++;
					}
					
		    		if (namn2.charAt(k) > namn1.charAt(k)) {
		    			temp = bank.get(j-1);
		    			bank.set(j-1, bank.get(j));
		    			bank.set(j, temp);
		    		} else if (namn2.charAt(k) == namn1.charAt(k)) {
		    			if (längd1 > längd2) {
		    				temp = bank.get(j-1);
			    			bank.set(j-1, bank.get(j));
			    			bank.set(j, temp);
		    			}
		    		}
		        }
		    }

		
		return bank;
	}
	
	/**Söker upp och returnerar bankkontot med kontonummer 'accountNumber'. 
	 * Returnerar null om inget sådant konto finns.*/
	public BankAccount findByNumber(int accountNumber) {
		BankAccount ba = null;
		
		for (BankAccount b : bank) {
			if (b.getAccountNumber() == accountNumber) {
				ba = b;
			}
		} 
		return ba;
	}
	
	/**Söker upp alla bankkonton som innehas av kunden med id-nummer 'idNr'. 
	 * Kontona returneras i en lista. Kunderna antas ha unika id-nummer.*/
	public ArrayList<BankAccount> findAccountsForHolder(long idNr) {
		ArrayList<BankAccount> kundenskonton = new ArrayList<BankAccount>();
		
		for (BankAccount b : bank) {
			Customer c = b.getHolder(); 
			if (c.getIdNr() == idNr) {
				kundenskonton.add(b);
			}
		}
		return kundenskonton;
	}
	
	
	/**Söker upp kunder utifrån sökning på namn eller del av namn. Alla personer vars namn 
	 * innehåller strängen 'namePart' inkluderas i resultatet, som returneras som en lista. 
	 * Samma person kan förekomma flera gånger i resultatet. Sökningen är "case insensitive". */
	public ArrayList<Customer> findByPartofName(String namePart) {
		int k = 0;
		String namePartLowCase = namePart.toLowerCase();
		ArrayList<Customer> medNamn = new ArrayList<Customer>();
		
			for (BankAccount b : bank) {
				Customer c = b.getHolder();
				String namn = c.getName();
				String namnLowCase = namn.toLowerCase();
            		if (namnLowCase.contains(namePartLowCase) == true) {
            			medNamn.add(c);
            		} else {
            			k++;
            		}
            }
			
			if(k == bank.size()) {
				System.out.println("Detta namn finns inte registrerat.");
			}
		
        return medNamn;
	}
		
}
