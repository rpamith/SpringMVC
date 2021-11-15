package Assignment_3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BankAccountTest {

	@Test
	void test() {
		BankAccount obj = new BankAccount(10000);
		assertThrows(InsufficientBalanceException.class,() -> obj.withdraw(20000));
	}
}
