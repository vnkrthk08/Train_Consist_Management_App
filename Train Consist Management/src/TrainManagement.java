import java.util.*;

public class TrainManagement {
    public static void main(String[] args) {
        Set<String> train = new LinkedHashSet<>();

        train.add("Engine");
        train.add("Sleeper");
        train.add("Cargo");
        train.add("Guard");
        train.add("Sleeper");

        System.out.println(train);
    }
}