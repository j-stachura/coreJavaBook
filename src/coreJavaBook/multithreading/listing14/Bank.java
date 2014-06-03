package coreJavaBook.multithreading.listing14;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author Jakub
 * Bank o pewnej liczbie kont.
 *
 */
public class Bank {

	/**
	 * Tworzy bank
	 * @param n liczba kont.
	 * @param initialBalance pocz¹tkowy stan ka¿dego konta
	 */
	public Bank(int n, double initialBalance) {
		accounts = new double[n];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = initialBalance;
		}
		bankLock = new ReentrantLock();
		sufficientFunds = bankLock.newCondition();
	}
	
	/**
	 * Przelewa pieni¹dze z jednego konta na drugie.
	 * @param from konto nadawcy
	 * @param to konto odbiorcy
	 * @param amount kwota przelewu
	 */
	public void transfer(int from, int to, double amount) throws InterruptedException {
		
		bankLock.lock();
		try {
		System.out.print(Thread.currentThread());		
		accounts[from] -= amount;
		System.out.printf(" %10.2f z konta %d na konto %d %n", amount, from, to);
		accounts[to] += amount;
		System.out.printf(" Ogólne saldo: %10.2f%n ", getTotalBalance());
		sufficientFunds.signalAll();
		} finally {
			bankLock.unlock();
		}
	}
	
	/**
	 * Zwraca saldo banku.
	 * @return saldo banku
	 */
	public double getTotalBalance(){
		
		bankLock.lock();
		try {			
		double sum = 0;		
		for (double a : accounts) {
			sum += a;
		}
		return sum;
		} finally {
			
			bankLock.unlock();
		}
	}
	/**
	 * Zwraca liczbê kont w banku
	 * @return liczba kont
	 */
	public int size(){
		return accounts.length;
	}
	
	private final double[] accounts;
	private Lock bankLock;
	private Condition sufficientFunds;
}
