
public class Customer {
	private String namn;
	private long idNr;
	private int customerNr;
	private static int nbrofcustomers;
	
	/** Skapar en kund (kontoinnehavare) med namet 'name' och id-nummer 'idNr'. 
	 * Kunden tilldelas också ett unikt kundnummer.*/
	public Customer (String namn, long idNr) {
		this.namn = namn;
		this.idNr = idNr; 
		customerNr = ++nbrofcustomers;
	}
	
	/** Tar reda på kundens namn. */
	public String getName() {
		return namn;
	}
	
	/** Tar reda på kundens personnummer. */
	public long getIdNr() {
		return idNr;
	}
	
	/**Tar reda på kundens kundnummer. */
	public int getCustomerNr() {
		return customerNr;
	}
	
	/** Returnerar en strängbeskrivning av kunden. */
	public String toString() {
		String idnr = Long.toString(idNr);
		String kundNr = Integer.toString(customerNr);
		return "Namn: "+ namn + ", ID-nummer: " + idnr + ", Kundnummer: " + kundNr;
	}
	
}
