package prob2;

public class SavingsAccount extends Account {
    private final double interestRate;

    SavingsAccount(String accountId, double interestRate, double balance) {
        super(accountId, balance);

        this.interestRate = interestRate;
    }

    @Override
    public double computeUpdateBalance() {
        return this.balance + (this.interestRate * this.balance);
    }
}
