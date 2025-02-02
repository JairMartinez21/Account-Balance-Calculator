import java.util.Scanner;

public class AccountBalanceApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CheckingAccount checking = new CheckingAccount(1000.00, 1.00);
        SavingsAccount savings = new SavingsAccount(1000.00, 0.01); // 1% interest rate

        System.out.println("Welcome to the Account application");
        System.out.printf("\nStarting Balances\nChecking: $%.2f\nSavings:  $%.2f\n", 
                          checking.getBalance(), savings.getBalance());

        String continueInput;
        do {
            System.out.print("\nWithdrawal or deposit? (w/d): ");
            String transactionType = scanner.next();

            System.out.print("Checking or savings? (c/s): ");
            String accountType = scanner.next();

            System.out.print("Amount?: ");
            double amount = scanner.nextDouble();

            if (transactionType.equalsIgnoreCase("w")) {
                if (accountType.equalsIgnoreCase("c")) {
                    checking.withdraw(amount);
                } else if (accountType.equalsIgnoreCase("s")) {
                    savings.withdraw(amount);
                }
            } else if (transactionType.equalsIgnoreCase("d")) {
                if (accountType.equalsIgnoreCase("c")) {
                    checking.deposit(amount);
                } else if (accountType.equalsIgnoreCase("s")) {
                    savings.deposit(amount);
                }
            }

            System.out.print("\nContinue? (y/n): ");
            continueInput = scanner.next();

        } while (continueInput.equalsIgnoreCase("y"));

        // Apply fees and interests
        checking.subtractMonthlyFee();
        savings.applyMonthlyInterest();

        System.out.println("\nMonthly Payments and Fees");
        System.out.printf("Checking fee:              $%.2f\n", checking.getMonthlyFee());
        System.out.printf("Savings interest payment:  $%.2f\n", savings.getMonthlyInterestPayment());

        System.out.println("\nFinal Balances");
        System.out.printf("Checking: $%.2f\n", checking.getBalance());
        System.out.printf("Savings:  $%.2f\n", savings.getBalance());

        scanner.close();
    }
}
