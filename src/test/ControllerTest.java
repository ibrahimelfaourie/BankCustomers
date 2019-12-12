import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import java.util.zip.CheckedOutputStream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

class ControllerTest {

    @Mock
   private Customer customer;

    @Mock
    private Account account;

    @Test
    void when_addingNewCustomer_ShouldNotReturnMinusOne() {
        Controller controller = new Controller();
        Account account = new Account(500,"123456");
        Customer customer = new Customer("Ibbe",account, "SEB","5177");

        controller.addNewCustomerForTest(customer);
        int i = controller.findCustomerAccount("123456");
        assertNotEquals(-1, i,"Actual should not be -1");

    }
    @Test
    void when_addingNewCustomer_ShouldNotReturnMinusOne_Mockito() {
        Controller controller = new Controller();

        when(account.getAccountNumber()).thenReturn("123456");
        when(customer.getAccount()).thenReturn(account);

        controller.addNewCustomerForTest(customer);

        int i = controller.findCustomerAccount("123456");

        assertNotEquals(-1, i,"Actual should not be -1");

    }

    @Test
    void when_addingNewCustomer_ThatAlreadyExists_ShouldThrowIllegalArgumentExeption() {
        Controller controller = new Controller();
        Account account = new Account(500,"123456");
        Customer customer = new Customer("Ibbe",account, "SEB","5177");


        controller.addNewCustomerForTest(customer);

        assertThrows(IllegalArgumentException.class, ()->controller.addNewCustomerForTest(customer),"Should throw IAE");
    }

    @Test
    void when_depositMoney_ShouldVerify_ThatMethodIsExsecuded_Mockito() {
        Controller controller = new Controller();

        when(account.getAccountNumber()).thenReturn("123456");
        when(customer.getAccount()).thenReturn(account);

        controller.addNewCustomerForTest(customer);

        controller.depositMoneyForTest("123456", 200);
        verify(account, times(1)).deposit(200);
    }



    @Test
    void when_depositMoney_withNegativeValue_shouldNotAffectBalance() {
        Controller controller = new Controller();

        Account account = new Account(500, "123456");
        Customer customer = new Customer("Ibbe", account, "SEB", "5177");

        controller.addNewCustomerForTest(customer);

        controller.depositMoneyForTest("123456", -200);

        assertEquals(500, controller.getBalance("123456"),"Actual Balance should be 500, same as default");
    }

    @Test
    void when_depositMoney_OnNonExistingCustomer_shouldThrowIllegalArgumentExeption() {
        Controller controller = new Controller();

        assertThrows(IllegalArgumentException.class, ()->controller.depositMoneyForTest("123",500),"Should thro IAE");

    }

    @Test
    void when_withdrawMoney_ShouldVerify_ThatMethodIsExsecuded_Mockito() {
        Controller controller = new Controller();

        when(account.getAccountNumber()).thenReturn("123456");
        when(customer.getAccount()).thenReturn(account);

        controller.addNewCustomerForTest(customer);

        controller.withdrawMoneyForTest("123456", 200);
        controller.withdrawMoneyForTest("123456", 200);

        verify(account, times(2)).withdraw(200);
    }

    @Test
    void when_withdrawMoney_WithNegativeValue_ShouldNotAffectBalance() {

        Controller controller = new Controller();
        Account account = new Account(500,"123456");
        Customer customer = new Customer("Ibbe",account, "SEB","5177");

        controller.addNewCustomerForTest(customer);

        controller.withdrawMoneyForTest("123456", -200);

        assertEquals(500, controller.getBalance("123456"),"Actual Balance should be 500, same as default");

    }

    @Test
    void when_checkBalance_onExistingAccount_ShouldReturnBalance() {
        Controller controller = new Controller();
        Account account = new Account(500,"123456");
        Customer customer = new Customer("Ibbe",account, "SEB","5177");

        controller.addNewCustomerForTest(customer);


        assertEquals(500,controller.getBalance("123456"),"Actual Balance should be 500, same as default");
    }
    @Test
    void when_checkBalance_OnNonExistingAccount_ShouldReturnMinusOne() {
        Controller controller = new Controller();

        assertEquals(-1,controller.getBalance("000000"),"Actual should be -1");
    }

    @Test
    void when_calculateInterest_onExisitingAccount_ShouldReturnInterestAmount_Mockito() {
        Controller controller = new Controller();
        Account account = new Account(100,"123456");

        when(customer.getAccount()).thenReturn(account);

        controller.addNewCustomerForTest(customer);

        assertEquals(8.5, controller.calculateInterestForTest("123456"),"Actual should be the interest amount(8,5)");
    }

    @Test
    void when_calculateInterest_onNonExisitingAccount_ShouldReturnInterestAmount_Mockito() {
        Controller controller = new Controller();

        assertEquals(-1, controller.calculateInterestForTest("123456"),"Actual should be -1 since we dont have an actual accouunt to calculate interest on");
    }

    @Test
    void when_TryingTofindCustomer_OnExistingAccount_shouldReturnZero_Mockito() {

        Controller controller = new Controller();
        Account account = new Account(500,"123456");

        when(customer.getAccount()).thenReturn(account);

        controller.addNewCustomerForTest(customer);

        assertEquals(0,controller.findCustomerAccount("123456"),"Should find A customer and actual should be 0");
    }
}