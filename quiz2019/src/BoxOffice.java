import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoxOffice {
    private static Map<Concert, Integer> ticketsNumber = new HashMap<>();
    public static List<Ticket> buy(Concert concert, int number) throws InvalidTicket {
        int oldNumber = 0, newNumber;
        List<Ticket> tickets = new ArrayList<>();

        if (!ticketsNumber.containsKey(concert)){
            newNumber = number;
            ticketsNumber.put(concert, number);
        } else {
            oldNumber = ticketsNumber.get(concert);
            newNumber = oldNumber + number;
            ticketsNumber.replace(concert, oldNumber, newNumber);
        }

        for (int i = oldNumber + 1; i <= newNumber; i++){
            tickets.add(new Ticket(i, concert));
        }
        return tickets;
    }
}
