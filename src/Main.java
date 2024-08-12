import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    TodoList todoList = new TodoList();
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    String input = "";

    while(!input.equalsIgnoreCase("0")){
      System.out.println( """
            Welcome to the TODO List application! Options:
            0 - Exit
            1 - Add task
            2 - Delete task
            3 - Show tasks:
              a - By priority and name
              b - By category
              c - By status
            4 - Update Status of a task
            """);
      input = scanner.next();
      if(input.equalsIgnoreCase("1")){
        System.out.println("Give a name, description, priority an category for the task");

        String name = scanner.next();
        String description = scanner.next();
        int priority = scanner.nextInt();
        String category = scanner.next();

        todoList.addTask(name, description, priority, category);

      }else if(input.equalsIgnoreCase("2")){
        System.out.println("Give a name for the task that you want delete");
        String name = scanner.next();
        todoList.deleteTask(name);
      }else if(input.equalsIgnoreCase("3")){
        System.out.println("Give a option for filter that you have");
        String option = scanner.next();
        System.out.println(option);
        if(option.equals("a")){
          todoList.showList();
        }else if(option.equalsIgnoreCase("b")){
          todoList.showList(new ComparatorForCategory());
        }else if(option.equalsIgnoreCase("c")){
          todoList.showList(new ComparatorForStatus());
        }else{
          System.out.println("invalid option, try again");
        }

      }else if(input.equalsIgnoreCase("4")){
        System.out.println("Give a name and status for the task that you want update");
        String name = scanner.next();
        String status = scanner.next();

        if(status.equalsIgnoreCase("todo")){
          todoList.editStatus(name, Status.TODO);
        }else if(status.equalsIgnoreCase("doing")){
          todoList.editStatus(name, Status.DOING);
        }else if(status.equalsIgnoreCase("done")){
          todoList.editStatus(name, Status.DONE);
        }else{
          System.out.println("invalid option, try again");
        }

      }else{
        System.out.println("Invalid option");
      }
    }
    scanner.close();
  }
}