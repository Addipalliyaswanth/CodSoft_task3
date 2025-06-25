import java.util.Scanner;

// Bank account class
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}

// ATM class
class ATM {
    private BankAccount account;
    private Scanner sc = new Scanner(System.in);

    public ATM(BankAccount acc) {
        this.account = acc;
    }

    public void start() {
        int choice;
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double wAmt = sc.nextDouble();
                    if (account.withdraw(wAmt)) {
                        System.out.println("Withdrawal successful. Balance: $" + account.getBalance());
                    } else {
                        System.out.println("Failed: insufficient funds or invalid amount.");
                    }
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double dAmt = sc.nextDouble();
                    account.deposit(dAmt);
                    System.out.println("Deposit successful. Balance: $" + account.getBalance());
                    break;

                case 3:
                    System.out.println("Current balance: $" + account.getBalance());
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);
    }
}

// Main class
public class ATMProgram {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.00); // initial balance
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
