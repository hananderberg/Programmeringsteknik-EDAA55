
public class BankAccount {
	private String holderName;
	private long holderId;
	private Customer holder;
	private int kontoNr;
	private static int nbrofaccounts = 999;
	private double saldo;
	
	/**Skapar ett nytt bankkonto åt en innehavare med namn 'holderName' och id 'holderId'. 
	 * Kontot tilldelas ett unikt kontonummer och innehåller inledningsvis 0 kr.*/
	public BankAccount(String holderName, long holderId) {
		Customer holder = new Customer(holderName, holderId);
		this.holderName = holder.getName();
		this.holderId = holder.getIdNr();
		kontoNr = ++nbrofaccounts;
		saldo = 0;
	}
	
	/**Skapar ett nytt bankkonto åt en innehavare 'holder'. 
	 * Kontot tilldelas ett unikt kontonummer och innehåller inledningsvis 0 kr.*/
	public BankAccount(Customer holder) {
		this.holder = holder;
		this.holderName = holder.getName();
		this.holderId = holder.getIdNr();
		kontoNr = ++nbrofaccounts;
		saldo = 0;
	}
	
	/** Tar reda på kontots innehavare. */
	public Customer getHolder() {
		return holder;
	}
	
	/** Tar reda på det kontonummer som identifierar detta konto. */
	public int getAccountNumber() {
		return kontoNr;
	}
	
	/** Tar reda på hur mycket pengar som finns på kontot. */
	public double getAmount() {
		return saldo;
	}
	
	/** Sätter in beloppet 'amount' på kontot. */
	public void deposit(double amount) {
		saldo = saldo + amount;
	}
	
	/** Tar ut beloppet 'amount' från kontot. Om kontot saknar täckning blir saldot negativt. */
	public void withdraw(double amount) {
		saldo = saldo - amount;
	}
	
	/**Returnerar en strängrepresenation av bankkontot.*/
	public String toString() {
		String customer = holder.toString();
		String kontoNr = Integer.toString(getAccountNumber());
		String saldo = Double.toString(getAmount());
		return "Kontonummer: " + kontoNr + ". " + "Saldo: " + saldo + ". " + "(" + customer + ")";
	}
	
}
