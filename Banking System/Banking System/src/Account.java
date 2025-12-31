import java.io.Serializable;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    private String accountNumber;
    private String holderName;
    private double balance;

    public Account(String accountNumber, String holderName) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = 0.0;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public void setBalance(double balance) { this.balance = balance; }
}