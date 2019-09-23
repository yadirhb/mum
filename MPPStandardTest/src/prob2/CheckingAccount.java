package prob2;

public class CheckingAccount extends Account {
    private final double monthlyRate    ;

    public CheckingAccount(String accountId, double monthlyRate, double balance) {
        super(accountId, balance);
        this.monthlyRate = monthlyRate;
    }

    @Override
    public double computeUpdateBalance() {
        return this.balance - this.monthlyRate;
    }
}
