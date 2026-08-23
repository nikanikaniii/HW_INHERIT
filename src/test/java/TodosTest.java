import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenOneMatch() {
        SimpleTask simpleTask = new SimpleTask(1, "Задача 1");
        Epic epic = new Epic(2, new String[]{"Элемент 1", "Элемент 2"});

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Задача");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenMultipleMatch() {
        SimpleTask simpleTask = new SimpleTask(1, "Общая задача 1");
        Epic epic = new Epic(2, new String[]{"Общая задача "});

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Общая");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenZeroMatch() {
        SimpleTask simpleTask = new SimpleTask(1, "Задача 1");

        Todos todos = new Todos();
        todos.add(simpleTask);

        Task[] expected = {};
        Task[] actual = todos.search("Запрос");

        Assertions.assertArrayEquals(expected, actual);
    }
}
