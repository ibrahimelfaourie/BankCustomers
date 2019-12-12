public class Customer extends BankOffice {


    private String name;
    private Account account;


    Customer(String n, Account a, String bankName, String bankClearing) {
        super(bankName, bankClearing);
        name = n;
        account = a;
    }



    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }
/*
    public String getAccountNumber() {
        return account.getAccountNumber();
    }
*/
    public double getBalance() {
        return account.getBalance();
    }


}
