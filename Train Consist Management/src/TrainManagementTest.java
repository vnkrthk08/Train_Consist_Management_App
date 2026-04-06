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
        t.totalCapacity(list);

        assertEquals(1, list.size());
        t.groupBogies(list);

        assertEquals(1, list.size());
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