import java.util.ArrayList;
import java.util.List;

public class Party extends Event {
    public Party(String title) {
        super(title);
    }

    public Party(String title, String date) {
        super(title, date);
    }

    public Party(String title, String date, String description) {
        super(title, date, description);
    }

    public void addEvent(Event e){
        for (Person person: e.getPeople()){
            addPerson(person);
        }
    }
}
