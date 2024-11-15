package main;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.*;

public class TodoList{
  private final List<Task> taskList = new ArrayList<>();

  public TodoList(){
    verifyAlarm();
  }

  public void verifyAlarm(){
    File task = new File("tasklits.csv");
    try {
      Scanner scanner = new Scanner(task);

      scanner.nextLine();

      while (scanner.hasNextLine()) {
        String linha =  scanner.nextLine();
        String[] stringList = linha.split(";");

        String horaAlarme = stringList[stringList.length - 2];

        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

        Date dataTask = simpleDateFormat.parse(stringList[3]);

        System.out.println("Now time: " + date.getTime() + ", main.Task time: " + dataTask.getTime());

        if((dataTask.getTime() - date.getTime())/(3600.0*1000) < Integer.parseInt(horaAlarme)){
          System.out.println("main.Task: " + stringList[0] + " " + stringList[stringList.length-1]);
        }

      }
    }catch (Exception e){
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }

  public boolean addTask(Task task) {
    taskList.add(task);
    Collections.sort(taskList);

    if(task.getAlarm() != null){
      return addAlarmtoCSV(task);
    }

    return true;
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

  public List<Task> showList() {
    return this.taskList;
  }

  public List<Task> showList(Comparator<Task> filter) {
    taskList.sort(filter);

    return this.taskList;
  }

  public void editStatus(String name, Status status){
    for(Task t : taskList){
      if(t.getName().equals(name)){
        t.setStatus(status);
      }
    }
  }

  public void addAlarm(Task task, Alarm alarm){
    task.setAlarm(alarm);
  }

  public boolean addAlarmtoCSV(Task task){
    File taskList = new File("tasklits.csv");

    try {
      if (!taskList.exists()) {
        taskList.createNewFile();
      }

      FileWriter fileWriter = new FileWriter(taskList, true);

      if(taskList.length() == 0){
        fileWriter.write("nome;status;priority;endDate;dataLembrete;mensagemLembrete");
      }

      fileWriter.write("\n" + task.getName() + ";" + task.getStatus() + ";" + task.getPriorityLevel() + ";"
              + task.getEndDate() + ";" + task.getAlarm().getHoraDeLembrete() + ";" + task.getAlarm().getMessage());
      fileWriter.close();
    }catch (Exception e){
      System.out.println(e.getMessage());
      return false;
    }

    return true;
  }
}
