package ua.opnu.java.inheritance.account;

public class BankingAccount {
    private int balance;

    public BankingAccount(Startup s) {
        this.balance = s.getBalance();
    }

    public void debit(Debit d) {
        this.balance += d.getBalance();
    }

    public void credit(Credit c) {
        this.balance -= Math.abs(c.getBalance());
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankingAccount balance: " + balance;
    }
}
