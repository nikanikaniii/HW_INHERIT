import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void testSimpleTaskWhenMatches() {
        SimpleTask task = new SimpleTask(1,"Задача 1");
        Assertions.assertTrue(task.matches("Задача"));
    }

    @Test
    public void testSimpleTaskWhenNotMatches() {
        SimpleTask task = new SimpleTask(1, "Задача 1");
        Assertions.assertFalse(task.matches("Текст"));
    }


    @Test
    public void testEpicWhenMatches() {
        String[] subtasks = {"Подзадача 1", "Подзадача 2"};
        Epic epic = new Epic(2, subtasks);
        Assertions.assertTrue(epic.matches("Подзадача 1"));
    }

    @Test
    public void testEpicWhenNotMatches() {
        String[] subtasks = {"Подзадача 1", "Подзадача 2"};
        Epic epic = new Epic(2, subtasks);
        Assertions.assertFalse(epic.matches("Текст"));
    }


    @Test
    public void testMeetingWhenMatches() {
        Meeting meeting = new Meeting(3, "Тема 1", "Проект 1", "Время");
        Assertions.assertTrue(meeting.matches("Тема"));
        Assertions.assertTrue(meeting.matches("Проект"));
    }

    @Test
    public void testMeetingWhenNotMatches() {
        Meeting meeting = new Meeting(3, "Тема 1", "Проект 1", "Время");
        Assertions.assertFalse(meeting.matches("Время"));
    }
}
