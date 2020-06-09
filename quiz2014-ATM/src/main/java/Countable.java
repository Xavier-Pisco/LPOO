import java.util.ArrayList;
import java.util.List;

public class Countable {
    private List<Transaction> transactions = new ArrayList<>();

    public  void addTransaction(Transaction t){
        transactions.add(t);
    }

    public int count(){
        return transactions.size();
    }
}
