public class Account {

    private double balance;
    private String accountNumber;
    private boolean firstTime = true;


    public Account(double bal, String acc) {
        if (bal >= 100) {
            balance = bal;
        } else {

            balance = 100;
        }
        accountNumber = acc;
    }

    public void deposit(double howMuch) {
        if (howMuch > 0) {
            balance = balance + howMuch;
           // System.out.println(howMuch + " was successfully deposited im your account." +
            //        " The new balance is : " + balance);
        } else {
          //  System.err.println("Please ensure the amount to deposit is not negative or 0.\n");
        }

    }

    public void withdraw(double howMuch) {
        if (howMuch >= 0) {
            double tempBalance = balance;
            tempBalance = tempBalance - howMuch;

            double fees = 0;

            if (firstTime == false) {
                Bank bank = new Bank();
                tempBalance = tempBalance - bank.getTransactionFees();
                fees = bank.getTransactionFees();
            } else {
                firstTime = false;
            }
            if (tempBalance >= 100) {
                balance = tempBalance;
              //  System.out.println(howMuch + " was successfully withdrewed from your account." +
                 //       " The new balance is : " + balance + "\n");
                if (firstTime == false) {
                  //  System.out.println("You have also paid a fee of " + fees);
                }
            } else {
               // System.err.println("Insufficient balance to remove " + howMuch + "\n");
            }
        } else {

         //   System.err.println("Please ensure the amount to be withdrawn is not negative");
        }
    }

    public double getBalance() {

        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


}
