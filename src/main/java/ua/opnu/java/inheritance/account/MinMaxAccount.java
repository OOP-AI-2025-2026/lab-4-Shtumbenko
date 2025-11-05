package ua.opnu.java.inheritance.account;

public class MinMaxAccount {

    private BankingAccount account;

    private int minBalance;
    private int maxBalance;

    public MinMaxAccount(Startup s) {
        this.account = new BankingAccount(s);
        this.minBalance = s.getBalance();
        this.maxBalance = s.getBalance();
    }

    private void updateMinMax() {
        int currentBalance = this.account.getBalance();
        if (currentBalance < minBalance) {
            minBalance = currentBalance;
        }
        if (currentBalance > maxBalance) {
            maxBalance = currentBalance;
        }
    }

    public void debit(Debit d) {
        this.account.debit(d);
        updateMinMax();
    }

    public void credit(Credit c) {
        this.account.credit(c);
        updateMinMax();
    }

    public int getBalance() {
        return this.account.getBalance();
    }

    public int getMin() {
        return minBalance;
    }

    public int getMax() {
        return maxBalance;
    }
}
