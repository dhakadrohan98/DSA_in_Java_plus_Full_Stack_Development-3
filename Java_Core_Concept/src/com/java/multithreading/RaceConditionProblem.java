package com.java.multithreading;

class BankAccount {
	
    private int balance = 100;
    
    //Race conditions - Both thread will execute this method simultaneously
    void withdrawProblem(int amount) {
        if (balance >= amount) { // Check before withdrawing
            System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
            balance -= amount; // Modify shared resource
            System.out.println("Remaining Balance after executing: " + Thread.currentThread().getName() + " " + balance);
        } else {
            System.out.println("Insufficient balance for " + Thread.currentThread().getName());
        }
    }
    
  //Race conditions - solution make withdraw() method synchronized
    synchronized void withdraw(int amount) {
        if (balance >= amount) { // Check before withdrawing
            System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
            balance -= amount; // Modify shared resource
            System.out.println("Remaining Balance after executing: " + Thread.currentThread().getName() + " " + balance);
        } else {
            System.out.println("Insufficient balance for " + Thread.currentThread().getName());
        }
    }
}

public class RaceConditionProblem {

	public static void main(String[] args) {
		BankAccount account = new BankAccount();
		Runnable task = () -> {
			account.withdraw(80);
		};
		
		Thread t1 = new Thread(task, "Thread 1");
		Thread t2 = new Thread(task, "Thread 2");
		t1.start();
		t2.start();
	}

}
