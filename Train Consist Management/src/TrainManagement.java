import java.util.*;

public class TrainManagement {
    public static void main(String[] args) {
        List<String> bogies = new ArrayList<>();
        bogies.add("Sleeper");
        bogies.add("AC Chair");
        bogies.add("First Class");

        System.out.println(bogies);

        bogies.remove("AC Chair");

        System.out.println("Sleeper exists: " + bogies.contains("Sleeper"));
        System.out.println(bogies);
    }
}