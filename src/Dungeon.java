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

    public Room getCurrentRoom() {
        return rooms.get(playerPosition);
    }

    public int getRoomCount() {
        return rooms.size();
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void moveToNextRoom() {
        if (playerPosition < rooms.size() - 1) {
            playerPosition++;
            System.out.println("Du gick till rum " + playerPosition);
        } else {
            System.out.println("Du är redan i sista rummet.");
        }
    }

    public void moveToPreviousRoom() {
        if (playerPosition > 0) {
            playerPosition--;
            System.out.println("Du gick till rum " + playerPosition);
        } else {
            System.out.println("Du är redan i första rummet.");
        }
    }

    public void printAllRooms() {
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println("Rum " + i + (i == playerPosition ? " (Här är du)" : ""));
        }
    }
}
