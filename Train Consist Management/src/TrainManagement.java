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
    public static void main(String[] args) {
        List<Bogie> list = new ArrayList<>();

        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 56));
        list.add(new Bogie("First Class", 40));

        List<Bogie> result = list.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        for (Bogie b : result) {
            System.out.println(b.name + " " + b.capacity);
        }
    }
}