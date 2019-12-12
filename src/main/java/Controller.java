import java.util.Scanner;

public class Controller {

    int numberOfCustomers = 0;

    Bank bank = new Bank();
    Customer[] c = bank.getCustomer();
    String acc;
    Scanner scan = new Scanner(System.in);


    public void addNewCustomerForTest(Customer customer) {
        int existingNumber = findIfCustomerName(customer.getName());
        if (existingNumber > -1) {
            throw new IllegalArgumentException("Customer already exist");
        } else {
            c[numberOfCustomers] = customer;
            //  System.out.println("Customer name: " + customer.getName() + ", Was added to the bank.\n");
            numberOfCustomers++;
        }
    }


    public void depositMoneyForTest(String acc, double money) throws IllegalArgumentException {
        int i = findCustomerAccount(acc);
        if (i == -1) throw new IllegalArgumentException("Account does not exist");
        else {
            Account temp = c[i].getAccount();
            temp.deposit(money);
        }
    }

    public void withdrawMoneyForTest(String acc, double amount) {
        int i = findCustomerAccount(acc);
        if (i >= 0) {
            Account temp = c[i].getAccount();
            temp.withdraw(amount);
        }
    }


    public double calculateInterestForTest(String acc) {
        int i = findCustomerAccount(acc);
        if (i >= 0) {
            return bank.calculateInterestForTest(c[i]);
        } else {
            return -1;
        }
    }

    public int findCustomerAccount(String acc) {
        boolean found = false;
        int i = -1;
        while (found == false && i < (numberOfCustomers - 1)) {
            i++;
            Account temp = c[i].getAccount();
            String accTemp = temp.getAccountNumber();
            if (accTemp.equals(acc)) {
                found = true;
            }
        }
        if (found == true) {
            return i;
        } else {
            return -1;
        }

    }

    public int findIfCustomerName(String name) {

        boolean found = false;
        int i = -1;
        while (found == false && i < (numberOfCustomers - 1)) {
            i++;
            String temp = c[i].getName();

            if (temp.equals(name)) {
                found = true;
            }
        }
        if (found == true) {
            return i;
        } else {
            return -1;
        }

    }

    public double getBalance(String acc) {
        int i = findCustomerAccount(acc);
        if (i >= 0) {
            Account temp = c[i].getAccount();
            return temp.getBalance();
        } else {
            return -1;
        }
    }
}





































        /*
        public void showCustomerInfo () {

            System.out.println("Enter account number: ");
            acc = scan.nextLine();
            if (numberOfCustomers == 0) {
                System.err.println("Account number not found\n");
            } else {
                int i = findCustomerAccount(acc);
                if (i >= 0) {
                    System.out.println("Namn: " + c[i].getName() + "\nBank: " + c[i].getBankName() +
                            "\nClearing nr: " + c[i].getBankClearing() + "\nAccount nr: " + c[i].getAccountNumber() +
                            "\nBalance: " + c[i].getBalance() + "\n");
                } else {
                    System.err.println("Account Number not found\n");
                }
            }
        }

 */
/*
        public void withdrawMoney () {

            System.out.println("Enter account number: ");
            acc = scan.nextLine();
            if (numberOfCustomers == 0) {
                System.err.println("Account number not found\n");
            } else {
                int i = findCustomerAccount(acc);
                if (i >= 0) {
                    Account temp = c[i].getAccount();
                    System.out.println("please enter the amount to withdraw: ");
                    double money = scan.nextDouble();
                    scan.nextLine();
                    temp.withdraw(money);
                } else {
                    System.err.println("Account Number not found\n");
                }
            }
        }

 */



/*
        public void checkBalance () {

            System.out.println("Enter account number: ");
            acc = scan.nextLine();
            if (numberOfCustomers == 0) {
                System.err.println("Account number not found\n");
            } else {
                int i = findCustomerAccount(acc);
                if (i >= 0) {
                    Account temp = c[i].getAccount();
                    System.out.println("Balance is: " + temp.getBalance());
                } else {
                    System.err.println("Account Number not found\n");
                }
            }
        }

 */
/*
        public void calculateInterest () {

            System.out.println("Enter account number: ");

            acc = scan.nextLine();
            if (numberOfCustomers == 0) {
                System.err.println("Account number not found\n");
            } else {
                int i = findCustomerAccount(acc);
                if (i >= 0) {
                    bank.calculateInterest(c[i]);
                } else {
                    System.err.println("Account Number not found\n");
                }
            }
        }

 */
/*
        public void depositMoney () {

            System.out.println("Enter account number: ");
            acc = scan.nextLine();
            System.out.println("please enter the amount to deposit: ");
            double money = scan.nextDouble();
            scan.nextLine();
            depositMoneyForTest(acc, money);
        }

 */
/*
        public void addNewCustomer () {

            System.out.println("Creating an account for a new customer. \n");
            System.out.println("Please enter the initial amount in your account:");
            double bal = scan.nextDouble();
            scan.nextLine();
            System.out.println("Please enter your Bank Name: ");
            String bankName = scan.nextLine();
            System.out.println("Please enter your Bank Clearing: ");
            String bankClearing = scan.nextLine();
            System.out.println("Please enter your Account Number: ");
            String acc = scan.nextLine();
            Account account = new Account(bal, acc);
            System.out.println("Please enter your name: ");
            String name = scan.nextLine();
            Customer customer = new Customer(name, account, bankName, bankClearing);
            c[numberOfCustomers] = customer;
            System.out.println("Customer name: " + customer.getName() + ", Was added to the bank.\n");
            numberOfCustomers++;

        }
*/


