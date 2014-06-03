package coreJavaBook.multithreading.listing15;


/**
 * 
 * @author Jakub Bank o pewnej liczbie kont.
 * 
 */
public class Bank {

	/**
	 * Tworzy bank
	 * 
	 * @param n
	 *            liczba kont.
	 * @param initialBalance
	 *            pocz¹tkowy stan ka¿dego konta
	 */
	public Bank(int n, double initialBalance) {
		accounts = new double[n];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = initialBalance;
		}

	}

	/**
	 * Przelewa pieni¹dze z jednego konta na drugie.
	 * 
	 * @param from
	 *            konto nadawcy
	 * @param to
	 *            konto odbiorcy
	 * @param amount
	 *            kwota przelewu
	 */
	public synchronized void transfer(int from, int to, double amount)
			throws InterruptedException {

		while (accounts[from] < amount)
			wait();

		System.out.print(Thread.currentThread());
		accounts[from] -= amount;
		System.out
				.printf(" %10.2f z konta %d na konto %d %n", amount, from, to);
		accounts[to] += amount;
		System.out.printf(" Ogólne saldo: %10.2f%n ", getTotalBalance());
		notifyAll();

	}

	/**
	 * Zwraca saldo banku.
	 * 
	 * @return saldo banku
	 */
	public synchronized double getTotalBalance() {

		double sum = 0;
		for (double a : accounts)
			sum += a;

		return sum;

	}

	/**
	 * Zwraca liczbê kont w banku
	 * 
	 * @return liczba kont
	 */
	public int size() {
		return accounts.length;
	}

	private final double[] accounts;

}
