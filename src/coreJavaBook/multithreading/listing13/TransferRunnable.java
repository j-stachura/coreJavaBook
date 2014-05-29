package coreJavaBook.multithreading.listing13;

public class TransferRunnable implements Runnable{
	
	/**
	 * Konstruktor
	 * @param b bank, pomiêdzy kontami, którego dokonywane s¹ przelewy
	 * @param from konto nadawcy
	 * @param max maksymalna kwota przelewu
	 */
	public TransferRunnable(Bank b, int from, double max){
		bank = b;
		fromAccount = from;
		maxAmount = max;
	}
	
	public void run(){
		
		try{
			
			int toAccount = (int)(bank.size() * Math.random());
			double amount = maxAmount + Math.random();
			bank.transfer(fromAccount, toAccount, amount);
			Thread.sleep((int)(DELAY * Math.random()));
		} catch(InterruptedException e){
			
		}
	}
	
	private Bank bank;
	private int fromAccount;
	private double maxAmount;
	private static final int DELAY = 10;

}
