import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void when_getBalance_ShouldReturnValueFromDummyClass() {

        Account accountStub = new AccountStub();
        Customer customer = new Customer("Ibbe",accountStub,"Handelsbanken","123");

        assertEquals(500, customer.getBalance(),"Actual balance should be the return value from the dummy class(500)");
    }

}