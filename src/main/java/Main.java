import java.util.Scanner;

public class Main {

    static int numberOfCustomers = 0;

    static Bank bank = new Bank();
    static Customer[] c = bank.getCustomer();
    static String acc;
    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {

        Controller controller = new Controller();
        while (true) {
            System.out.println("Please enter your choice:");
            System.out.println("1: Add Customer");
            System.out.println("2: Deposit Money");
            System.out.println("3: Withdraw Money");
            System.out.println("4: Check Balance");
            System.out.println("5: Calculate Interest");
            System.out.println("6: Show Customer info");
            System.out.println("7: Exit");
            int choice = scan.nextInt();
            scan.nextLine();
/*
            switch (choice) {

                case 1:
                    controller.addNewCustomer();
                    break;
                case 2:
                    controller.depositMoney();
                    break;
                case 3:
                    controller.withdrawMoney();
                    break;
                case 4:
                    controller.checkBalance();
                    break;
                case 5:
                    controller.calculateInterest();
                    break;
                case 6:
                    controller.showCustomerInfo();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

 */


        }
    }
}