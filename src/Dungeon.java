import java.util.ArrayList;
import java.util.List;

//Dungeonen är en samling av rum.

public class Dungeon {
    private List<Room> rooms = new ArrayList<>();

    public Dungeon(int numRooms) {
        for (int i = 0; i < numRooms; i++) {
            Room r = new Room();
            r.generateMonsters();
            rooms.add(r);
        }
    }

    // @return listan av rum
    public List<Room> getRooms() {
        return rooms;
    }

    // @return antalet rum
    public int size() {
        return rooms.size();
    }
}