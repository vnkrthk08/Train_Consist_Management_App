import java.util.*;
import java.util.stream.*;

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class TrainManagement {

    public List<Bogie> filterBogies(List<Bogie> list, int threshold) {
        return list.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Bogie> list = new ArrayList<>();

        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 56));
        list.add(new Bogie("First Class", 40));

        TrainManagement t = new TrainManagement();
        List<Bogie> result = t.filterBogies(list, 60);

        for (Bogie b : result) {
            System.out.println(b.name + " " + b.capacity);
        }
    }
}