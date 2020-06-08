import java.util.Objects;

public class Attendee extends Person implements Comparable<Person> {
    private boolean paid = false;

    public Attendee(String name) {
        super(name);
    }

    public Attendee(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Attendee " + getName() + (paid ? " has" : " hasn't") + " paid its registration.";
    }

    public boolean hasPaid(){
        return paid;
    }

    @Override
    public int compareTo(Person person) {
        return this.getName().compareTo(person.getName());

    }
}
