import java.util.ArrayList;

public class Dungeon {
    private ArrayList<Room> rooms = new ArrayList<>();
    private int playerPosition = 0;

    public Dungeon(int numberOfRooms) {
        for (int i = 0; i < numberOfRooms; i++) {
            Room room = new Room();
            room.GenerateMonster();
            rooms.add(room);
        }
    }

    public Room getRoom(int index) {
        if (index >= 0 && index < rooms.size()) {
            return rooms.get(index);
        }
        return null;
    }

    public int getRoomCount() {
        return rooms.size();
    }
}