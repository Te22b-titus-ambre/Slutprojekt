import java.util.ArrayList;
import java.util.List;

// Dungeonen är en samling av rum.
public class Dungeon {
    private List<Room> rooms = new ArrayList<>(); // Lista över alla rum i dungeonen

    // Konstruktor – skapar ett visst antal rum och genererar monster i varje
    public Dungeon(int numRooms) {
        for (int i = 0; i < numRooms; i++) {
            Room r = new Room();           // Skapar nytt rum
            r.generateMonsters();          // Genererar monster i rummet
            rooms.add(r);                  // Lägger till rummet i listan
        }
    }

    // Returnerar listan med alla rum
    public List<Room> getRooms() {
        return rooms;
    }

    // Returnerar antalet rum i dungeonen
    public int size() {
        return rooms.size();
    }
}
