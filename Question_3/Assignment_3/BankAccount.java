package Assignment_3;

public class BankAccount {
	int balance;
	public BankAccount(int balance) {
		this.balance=balance;
	}
	
	public void displayDetails() {
		System.out.println("Balance : "+balance);
	}
	
	public void withdraw(int amount) throws InsufficientBalanceException {
		if(amount>balance) {
			throw new InsufficientBalanceException("Insufficient balance in account");
		}
		else {
			balance -=amount;
			System.out.println("Amount withdrawn\nBalance : "+balance);
		}
	}
}
