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

    public Map<String, List<Bogie>> groupBogies(List<Bogie> list) {
        return list.stream()
                .collect(Collectors.groupingBy(b -> b.name));
    }

    public static void main(String[] args) {
        List<Bogie> list = new ArrayList<>();

        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("Sleeper", 70));
        list.add(new Bogie("AC Chair", 56));

        TrainManagement t = new TrainManagement();
        System.out.println(t.groupBogies(list));
    }
}