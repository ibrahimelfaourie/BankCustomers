public class Bank {



    private double interestRate = 8.5;
    private double transactionFees = 10;
    public double interestAmount;
    public double totalBalance;
    public int numberOfCustomers = 0;
    Customer[] customers = new Customer[1000];

  /*
    public void calculateInterest(Customer customer) {

        Account account = customer.getAccount();
        double bal = account.getBalance();
        double interestAmount = bal * interestRate / 100;
        double totalBalance = bal + interestAmount;

        System.out.println("Interest amount: " + interestAmount + ", Total money after adding interest: " + totalBalance);
}
*/


    public double calculateInterestForTest(Customer customer) {

        Account account = customer.getAccount();
        double bal = account.getBalance();
        double interestAmount = bal * interestRate / 100;
        double totalBalance = bal + interestAmount;
        return interestAmount;

    }



    public double depositInterestOnAccount(Customer customer) {

        Account account = customer.getAccount();
        account.deposit(calculateInterestForTest(customer));
        return account.getBalance();

    }

    public double getTransactionFees() {
        return transactionFees;
    }

    public Customer[] getCustomer() {
        return customers;
    }

}
