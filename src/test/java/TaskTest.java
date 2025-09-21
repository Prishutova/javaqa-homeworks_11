import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void shouldFindWithTrueTitle() {
        SimpleTask task = new SimpleTask(1, "Сон");
        String query = "Сон";
        boolean expected = true;
        boolean actual = task.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindWithFalseTitle() {
        SimpleTask task = new SimpleTask(1, "Сон");
        String query = "Готовка";
        boolean expected = false;
        boolean actual = task.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindWithTrueSubtasks() {
        Epic epic = new Epic(1, new String[]{"Сварить бульон", "Пожарить картошку", "Порезать салат"});
        String query = "Сварить бульон";
        boolean expected = true;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindWithFalseSubtasks() {
        Epic epic = new Epic(1, new String[]{"Сварить бульон", "Пожарить картошку", "Порезать салат"});
        String query = "Испечь пирог";
        boolean expected = false;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindWithTrueTopic() {
        Meeting meeting = new Meeting(1, "Составление сметы", "Аренда оборудования", "21/09/2025 12:00");
        String query = "Составление сметы";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldFindWithTrueProject() {
        Meeting meeting = new Meeting(1, "Составление сметы", "Аренда оборудования", "21/09/2025 12:00");
        String query = "Аренда оборудования";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindWithFalseTopic() {
        Meeting meeting = new Meeting(1, "Составление сметы", "Аренда оборудования", "21/09/2025 12:00");
        String query = "Оплата";
        boolean expected = false;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindWithFalseProject() {
        Meeting meeting = new Meeting(1, "Составление сметы", "Аренда оборудования", "21/09/2025 12:00");
        String query = "Закупка";
        boolean expected = false;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }
}