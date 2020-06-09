public class Withdrawal implements Transaction {
    private ATM atm;
    private Session session;
    private Card card;
    private int code;
    private Double amount;

    public Withdrawal(ATM atm, Session session, Card card, int code) {
        this.atm = atm;
        this.session = session;
        this.card = card;
        this.code = code;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Withdrawal at " + atm.toString() + " of " + amount;
    }
}
