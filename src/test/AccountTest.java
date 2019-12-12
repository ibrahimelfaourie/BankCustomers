import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {



    @Test
    void when_SettingAccountConstructor_BalanceToValidInput_ShouldReturnTheNewInput(){

        Account account = new Account(200,"123456");

        assertEquals(200,account.getBalance(),"Should be the given value");

    }

    @Test
    void when_SettingAccountConstructor_BalanceToInValidInput_ShouldReturnTheDefaultValue(){

        Account account = new Account(50,"123456");
        assertEquals(100,account.getBalance(),"Balance should be set to the default value(100)");

    }

    @Test
    void when_deposit_onExistingAccount_ShouldAddBalanceWithInput(){
        Account account = new Account(500.00, "123456");

        account.deposit(200);

        assertEquals(700, account.getBalance(),"Actual balance should be the balance with added deposit(700)");
    }

    @Test
    void when_deposit_onExistingAccount_withNegativeValues_ShouldNotAddBalanceWithInput(){
        Account account = new Account(500.00, "123456");

        account.deposit(-100);

        assertEquals(500,account.getBalance(),"Actual balance Should be the same as default without the deposit(500)");
    }

    @Test
    void when_withdraw_onExistingAccount_ShouldSubtractBalanceWithInput(){
        Account account = new Account(500.00, "123456");

        account.withdraw(300);

        assertEquals(200,account.getBalance(),"Actual balance should be the balance subtract the withdraw value(200)");
    }

    @Test
    void when_withdraw_onExistingAccount_withNegativeValues_ShouldNotSubtractBalanceWithInput(){
        Account account = new Account(500.00, "123456");

        account.withdraw(-100);

        assertEquals(500, account.getBalance(),"Actual balance should be same as default without the withdraw (500)");
    }
    @Test
    void when_withdrawTwice_onExistingAccount_ShouldAlsoSubstractFee(){
        Account account = new Account(500.00, "123456");

        account.withdraw(100);
        account.withdraw(100);

        assertEquals(290, account.getBalance(),"Actual balance should be the balance substract the withdraw and sustract the fee(290)");
    }

}