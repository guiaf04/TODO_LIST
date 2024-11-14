package test;

import main.Status;
import main.Task;
import main.TodoList;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@SuppressWarnings("MagicConstant")
public class TodoListTaskTest {
    TodoList todoList = new TodoList();

    @Test
    public void createUniqueTaskTest() {
        Task task = new Task("teste1", "teste 1 descricao", 4,
                "teste", new Date(2024 - 1900, 10, 15, 22, 0));

        assertTrue(todoList.addTask(task));
    }

    @Test
    public void listTaskOrderByNameTest() {
        Task task = new Task("teste1", "teste 1 descricao", 4,
                "teste", new Date(2024 - 1900, 10, 15, 22, 0));
        Task task2 = new Task("teste2", "teste 1 descricao", 4,
                "teste", new Date(2024 - 1900, 10, 15, 22, 0));
        Task task3 = new Task("teste3", "teste 1 descricao", 4,
                "teste", new Date(2024 - 1900, 10, 15, 22, 0));

        todoList.addTask(task);
        todoList.addTask(task2);
        todoList.addTask(task3);

        List<Task> tasks = todoList.showList();
        assertEquals(tasks.get(0), task);
    }

    @Test
    public void listTaskOrderByCategoryTest() {
        Task task = new Task("teste1", "teste 1 descricao", 4,
                "teste1 castegoria", new Date(2024 - 1900, 10, 15, 22, 0));
        Task task2 = new Task("teste2", "teste 1 descricao", 4,
                "teste2 categoria", new Date(2024 - 1900, 10, 15, 22, 0));
        Task task3 = new Task("teste3", "teste 1 descricao", 4,
                "teste3 categoria", new Date(2024 - 1900, 10, 15, 22, 0));

        todoList.addTask(task);
        todoList.addTask(task2);
        todoList.addTask(task3);

        List<Task> tasks = todoList.showList();
        assertEquals(tasks.get(2), task3);
    }

    @Test
    public void listTaskOrderByStatusTest() {
        Task task = new Task("teste1", "teste 1 descricao", 4,
                "teste1 castegoria", new Date(2024 - 1900, 10, 15, 22, 0));
        Task task2 = new Task("teste2", "teste 1 descricao", 4,
                "teste2 categoria", new Date(2024 - 1900, 10, 15, 22, 0));
        Task task3 = new Task("teste3", "teste 1 descricao", 4,
                "teste3 categoria", new Date(2024 - 1900, 10, 15, 22, 0));

        todoList.editStatus(task2.getName(), Status.DOING);
        todoList.editStatus(task3.getName(), Status.DONE);

        todoList.addTask(task);
        todoList.addTask(task2);
        todoList.addTask(task3);

        List<Task> tasks = todoList.showList();
        assertEquals(tasks.get(2), task3);
    }

    @Test
    public void deleteTaskTest(){
        Task task = new Task("teste1", "teste 1 descricao", 4,
                "teste1 castegoria", new Date(2024 - 1900, 10, 15, 22, 0));
        Task task2 = new Task("teste2", "teste 1 descricao", 4,
                "teste2 categoria", new Date(2024 - 1900, 10, 15, 22, 0));
        Task task3 = new Task("teste3", "teste 1 descricao", 4,
                "teste3 categoria", new Date(2024 - 1900, 10, 15, 22, 0));

        todoList.addTask(task);
        todoList.addTask(task2);
        todoList.addTask(task3);

        todoList.deleteTask(task.getName());

        List<Task> tasks = todoList.showList();

        assertEquals(tasks.size(), 2);
    }
}