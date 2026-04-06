import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class TrainManagementTest {

    @Test
    public void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC", 56)
        );

        TrainManagement t = new TrainManagement();
        List<Bogie> result = t.filterBogies(list, 60);

        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).name);
    }

    @Test
    public void testFilter_EmptyList() {
        List<Bogie> list = new ArrayList<>();

        TrainManagement t = new TrainManagement();
        List<Bogie> result = t.filterBogies(list, 60);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_NoMatch() {
        List<Bogie> list = Arrays.asList(
                new Bogie("AC", 50),
                new Bogie("First Class", 40)
        );

        TrainManagement t = new TrainManagement();
        List<Bogie> result = t.filterBogies(list, 60);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_MultipleMatches() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC", 65),
                new Bogie("First Class", 40)
        );

        TrainManagement t = new TrainManagement();
        List<Bogie> result = t.filterBogies(list, 60);

        assertEquals(2, result.size());
    }
}