import java.util.Objects;

public class Speaker extends Person implements Comparable<Person> {
    private int fee = 0;

    public Speaker(String name, int age) {
        super(name, age);
    }

    public Speaker(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Speaker " + getName() + " has a fee value of " + fee + ".";
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public int compareTo(Person person) {
        return this.getName().compareTo(person.getName());
    }
}
