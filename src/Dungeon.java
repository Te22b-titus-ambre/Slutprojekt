import java.util.ArrayList;
import java.util.List;

public class Dungeon {
    private List<Room> rooms = new ArrayList<>();

    public Dungeon(int numberOfRooms) {
        for (int i = 0; i < numberOfRooms; i++) {
            rooms.add(new Room());
        }
    }

    public Room getRoom(int index) {
        if (index >= 0 && index < rooms.size()) return rooms.get(index);
        return null;
    }

    public int getRoomCount() {
        return rooms.size();
    }
}