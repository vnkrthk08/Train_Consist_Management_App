import java.util.*;

public class TrainManagement {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("Sleeper", 72);
        map.put("AC Chair", 56);
        map.put("First Class", 40);

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}