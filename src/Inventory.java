import java.util.ArrayList;
import java.util.List;

//Generisk klass för att hantera samlingar av objekt (t.ex. Item).
public class Inventory<T> {
    private List<T> items = new ArrayList<>();

    // Lägger till ett objekt i inventariet
    public void add(T item) {
        items.add(item);
    }

    //Tar bort och returnerar objektet vid index, eller null
    public T remove(int index) {
        if (index >= 0 && index < items.size()) {
            return items.remove(index);
        }
        return null;
    }

    // @return lista över alla objekt
    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    // @return om inventariet är tomt
    public boolean isEmpty() {
        return items.isEmpty();
    }
}