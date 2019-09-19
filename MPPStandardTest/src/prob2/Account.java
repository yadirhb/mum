package prob2;

public abstract class Account {
    protected final String accountId;
    protected final double balance;

    Account(String accountId, double balance){
        this.accountId = accountId;
        this.balance = balance;
    }

    public abstract double computeUpdateBalance();
}
