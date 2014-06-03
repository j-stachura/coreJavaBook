package coreJavaBook.multithreading.listing14;

/**
 * 
 * @author Jakub
 * Program ilustruje uszkodzenie danych dost�pnych dla wielu w�tk�w.
 *
 */
public class SynchBankTest {

	public static final int NACCOUNTS = 100;
	public static final int INITIAL_BALANCE = 1000;

	public static void main(String[] args) {

		Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
		for(int i =0; i< NACCOUNTS; i++){
			TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
			Thread t = new Thread(r);
			t.start();
		}
	}
}
