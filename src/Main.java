import java.util.Date;
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

        System.out.println("Digite o dia de finalização");
        int day = scanner.nextInt();
        System.out.println("Digite o mes de finalização");
        int month = scanner.nextInt();
        System.out.println("Digite o ano de finalização");
        int year = scanner.nextInt();
        System.out.println("Digite a hora de finalização");
        int hour = scanner.nextInt();
        System.out.println("Digite o minuto de finalização");
        int min = scanner.nextInt();

        Date endDate = new Date(year - 1900, ((month-1) % 12) , day, hour, min);

        Task task = new Task(name, description, priority, category, endDate);

        System.out.println("Você deseja adicionar um alerta para essa tarefa? \n " +
                "Digite 1 para sim, e qualquer coisa para não");

        String alarmOption = scanner.next();

        if(alarmOption.equalsIgnoreCase("1")){
          System.out.println("Com quantas horas de antecedencia você quer ser avisado?");
          int horaLembrete = scanner.nextInt();
          String message = "Uma task está prestes a expirar";

          if(task.getPriorityLevel() > 3){
            if(task.getStatus() == Status.TODO){
              message = "Uma tarefa muito importante vai expirar e você ainda não começou ela, apresse-se!";
            } else if (task.getStatus() == Status.DOING) {
              message = "Uma tarefa muito importante vai expirar e você ainda não terminou ela, apresse-se!";
            }
          }

          Alarm alarm = new Alarm(message,horaLembrete);

          todoList.addAlarm(task, alarm);
        }

        todoList.addTask(task);

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