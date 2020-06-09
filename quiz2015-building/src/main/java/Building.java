import java.util.ArrayList;
import java.util.List;

public class Building implements Facility{
    private String name;
    private int minFloor;
    private int maxFloor;
    private List<Room> rooms;

    public Building(String name, int minFloor, int maxFloor) {
        if (minFloor > maxFloor) throw new IllegalArgumentException();
        this.name = name;
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.rooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinFloor() {
        return minFloor;
    }

    public void setMinFloor(int minFloor) {
        this.minFloor = minFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(int maxFloor) {
        this.maxFloor = maxFloor;
    }

    public void addRoom(Room room) throws Exception {
        if (rooms.contains(room)) throw new DuplicateRoomException();
        rooms.add(room);
    }

    public int getCapacity(){
        int capacity = 0;
        for (Room room: rooms) capacity += room.getCapacity();
        return capacity;
    }

    @Override
    public boolean canEnter(User u) {
        for (Room room: rooms)
            if (room.canEnter(u)) return true;

        return false;
    }

    @Override
    public String toString() {
        return "Building(" + getName() + ")";
    }
}
