public class Deposit implements Transaction {
    private ATM atm;
    private Session session;
    private Card card;
    private int code;
    private double amount;

    public Deposit(ATM atm, Session session, Card card, int code) {
        this.atm = atm;
        this.session = session;
        this.card = card;
        this.code = code;
    }
}
