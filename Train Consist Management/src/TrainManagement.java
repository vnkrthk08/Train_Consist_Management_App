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

    public int totalCapacity(List<Bogie> list) {
        return list.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    public Map<String, List<Bogie>> groupBogies(List<Bogie> list) {
        return list.stream()
                .collect(Collectors.groupingBy(b -> b.name));
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
        int total = t.totalCapacity(list);

        System.out.println("Total capacity: " + total);
        List<Bogie> result = t.filterBogies(list, 60);

        TrainManagement t = new TrainManagement();
        System.out.println(t.groupBogies(list));
    }
}