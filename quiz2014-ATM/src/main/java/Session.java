import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Session extends Countable {
    private ATM atm;

    public Session(ATM atm) {
        super();
        this.atm = atm;
    }

    public ATM getATM() {
        return atm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Session)) return false;
        Session session = (Session) o;
        return Objects.equals(atm, session.atm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atm);
    }
}
