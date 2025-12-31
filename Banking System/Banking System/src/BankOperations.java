import java.io.*;
import java.util.HashMap;

public class BankOperations implements Transaction {
    private Account account;
    private static final String FILE_NAME = "accounts.dat";
    private static HashMap<String, Account> accounts = new HashMap<>();

    static {
        loadAccounts();
    }

    public BankOperations(Account account) {
        this.account = account;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive.");
        account.setBalance(account.getBalance() + amount);
        saveAccount(account);
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive.");
        if (amount > account.getBalance()) throw new IllegalArgumentException("Insufficient funds.");
        account.setBalance(account.getBalance() - amount);
        saveAccount(account);
    }

    public double getBalance() {
        return account.getBalance();
    }

    public static void createAccount(String accNum, String name) {
        if (accounts.containsKey(accNum)) throw new IllegalArgumentException("Account already exists.");
        Account acc = new Account(accNum, name);
        accounts.put(accNum, acc);
        saveAccount(acc);
    }

    public static Account getAccount(String accNum) {
        return accounts.get(accNum);
    }

    private static void saveAccount(Account acc) {
        accounts.put(acc.getAccountNumber(), acc);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("Error saving account: " + e.getMessage());
        }
    }

    private static void loadAccounts() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            accounts = (HashMap<String, Account>) in.readObject();
        } catch (Exception e) {
            accounts = new HashMap<>();
        }
    }
}