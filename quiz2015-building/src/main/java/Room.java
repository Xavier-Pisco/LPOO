import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room implements Facility{
    private Building building;
    private String number;
    private int floor;
    private int capacity = 0;
    private List<User> users;

    public Room(Building building, String number, int floor) throws Exception {
        if (building.getMaxFloor() < floor || building.getMinFloor() > floor) throw new IllegalArgumentException();
        this.building = building;
        this.number = number;
        this.floor = floor;
        building.addRoom(this);
        users = new ArrayList<>();
    }

    public Room(Building building, String number, int floor, int capacity) throws Exception {
        if (building.getMaxFloor() < floor || building.getMinFloor() > floor) throw new IllegalArgumentException();
        this.building = building;
        this.number = number;
        this.floor = floor;
        this.capacity = capacity;
        building.addRoom(this);
        users = new ArrayList<>();
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getName(){
        return building.getName() + this.getNumber();
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean canEnter(User u) {
        return users.contains(u);
    }

    public void authorize(User u) {
        users.add(u);
    }

    @Override
    public String toString() {
        return "Room(" + building.getName() + "," + getNumber() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return Objects.equals(building, room.building) &&
                Objects.equals(number, room.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(building, number);
    }
}
