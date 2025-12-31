import java.util.Scanner;

public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Banking System!");

        while (true) {
            System.out.println("\n1. Create Account\n2. Deposit\n3. Withdraw\n4. View Balance\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Account Number: ");
                        String accNum = sc.nextLine();
                        System.out.print("Enter Holder Name: ");
                        String name = sc.nextLine();
                        BankOperations.createAccount(accNum, name);
                        System.out.println("Account created successfully.");
                        break;

                    case 2:
                        System.out.print("Enter Account Number: ");
                        accNum = sc.nextLine();
                        Account acc = BankOperations.getAccount(accNum);
                        if (acc == null) throw new IllegalArgumentException("Account not found.");
                        BankOperations op = new BankOperations(acc);
                        System.out.print("Enter amount to deposit: ");
                        double dep = sc.nextDouble();
                        op.deposit(dep);
                        System.out.println("Deposit successful.");
                        break;

                    case 3:
                        System.out.print("Enter Account Number: ");
                        accNum = sc.nextLine();
                        acc = BankOperations.getAccount(accNum);
                        if (acc == null) throw new IllegalArgumentException("Account not found.");
                        op = new BankOperations(acc);
                        System.out.print("Enter amount to withdraw: ");
                        double wd = sc.nextDouble();
                        op.withdraw(wd);
                        System.out.println("Withdrawal successful.");
                        break;

                    case 4:
                        System.out.print("Enter Account Number: ");
                        accNum = sc.nextLine();
                        acc = BankOperations.getAccount(accNum);
                        if (acc == null) throw new IllegalArgumentException("Account not found.");
                        op = new BankOperations(acc);
                        System.out.println("Balance: ₹" + op.getBalance());
                        break;

                    case 5:
                        System.out.println("Thank you for using Banking System.");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}