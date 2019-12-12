import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void when_calculateInterest_onExistingAccount_shouldReturnInterestAmount(){
        Account account = new Account(100.00, "123456");
        Bank bank = new Bank();
        Customer customer = new Customer("Ibbe",account,"SEB","5177");

        assertEquals(8.5, bank.calculateInterestForTest(customer));
    }

    @Test
    void when_AddingInterestAmmountToAccount_shouldReturnBalanceAndInterestAmount(){
        Account account = new Account(100,"123456");
        Customer customer = new Customer("Ibbe", account,"SEB","5177");
        Bank bank = new Bank();

        assertEquals(108.5,bank.depositInterestOnAccount(customer));
    }

}