import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TodoList{
  private List<Task> taskList = new ArrayList<>();

  public void addTask(String name, String description, int priorityLevel, String category){
    Task task = new Task(name, description, priorityLevel, category);
    taskList.add(task);
    Collections.sort(taskList);
  }

  public void deleteTask(String name){
    List<Task> tasksForRemove = new ArrayList<>();

    if(!taskList.isEmpty() && name != null){
      for(Task t : taskList){
        if(t.getName().equals(name)){
          tasksForRemove.add(t);
        }
      }

      taskList.removeAll(tasksForRemove);
    }
  }

  public void editTask(){
    //TODO
  }

  public void showList() {
    System.out.println();
    for(Task t : taskList) {
      System.out.println(t);
    }
  }

  public void showList(Comparator<Task> filter) {
    System.out.println();
    taskList.sort(filter);
    for(Task t : taskList) {
      System.out.println(t);
    }
  }

}
