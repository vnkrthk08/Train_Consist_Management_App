import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class TrainManagementTest {

    @Test
    public void testGrouping_BogiesGroupedByType() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 56)
        );

        TrainManagement t = new TrainManagement();
        Map<String, List<Bogie>> result = t.groupBogies(list);

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
    }

    @Test
    public void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70)
        );

        TrainManagement t = new TrainManagement();
        Map<String, List<Bogie>> result = t.groupBogies(list);

        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    public void testGrouping_DifferentBogieTypes() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56)
        );

        TrainManagement t = new TrainManagement();
        Map<String, List<Bogie>> result = t.groupBogies(list);

        assertEquals(2, result.size());
    }

    @Test
    public void testGrouping_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();

        TrainManagement t = new TrainManagement();
        Map<String, List<Bogie>> result = t.groupBogies(list);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testGrouping_SingleBogieCategory() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72)
        );

        TrainManagement t = new TrainManagement();
        Map<String, List<Bogie>> result = t.groupBogies(list);

        assertEquals(1, result.size());
        assertTrue(result.containsKey("Sleeper"));
    }

    @Test
    public void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56)
        );

        TrainManagement t = new TrainManagement();
        Map<String, List<Bogie>> result = t.groupBogies(list);

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
    }

    @Test
    public void testGrouping_GroupSizeValidation() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 56)
        );

        TrainManagement t = new TrainManagement();
        Map<String, List<Bogie>> result = t.groupBogies(list);

        assertEquals(2, result.get("Sleeper").size());
        assertEquals(1, result.get("AC Chair").size());
    }

    @Test
    public void testGrouping_OriginalListUnchanged() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));

        TrainManagement t = new TrainManagement();
        t.groupBogies(list);

        assertEquals(1, list.size());
    }
}