import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class TrainManagementTest {

    @Test
    public void testReduce_TotalSeatCalculation() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 40)
        );

        TrainManagement t = new TrainManagement();
        int total = t.totalCapacity(list);

        assertEquals(168, total);
    }

    @Test
    public void testReduce_MultipleBogiesAggregation() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC", 56)
        );

        TrainManagement t = new TrainManagement();
        int total = t.totalCapacity(list);

        assertEquals(128, total);
    }

    @Test
    public void testReduce_SingleBogieCapacity() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72)
        );

        TrainManagement t = new TrainManagement();
        int total = t.totalCapacity(list);

        assertEquals(72, total);
    }

    @Test
    public void testReduce_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();

        TrainManagement t = new TrainManagement();
        int total = t.totalCapacity(list);

        assertEquals(0, total);
    }

    @Test
    public void testReduce_CorrectCapacityExtraction() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 70),
                new Bogie("AC", 30)
        );

        TrainManagement t = new TrainManagement();
        int total = t.totalCapacity(list);

        assertEquals(100, total);
    }

    @Test
    public void testReduce_AllBogiesIncluded() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 50),
                new Bogie("AC", 30),
                new Bogie("First Class", 20)
        );

        TrainManagement t = new TrainManagement();
        int total = t.totalCapacity(list);

        assertEquals(100, total);
    }

    @Test
    public void testReduce_OriginalListUnchanged() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));

        TrainManagement t = new TrainManagement();
        t.totalCapacity(list);

        assertEquals(1, list.size());
    }
}