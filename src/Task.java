import java.util.Comparator;

public class Task implements Comparable<Task>{
  private String name;
  private String description;
  private String endDate;
  private int priorityLevel;
  private String category;
  private Status status;

  public Task(String name, String description, int priorityLevel, String category) {
    this.name = name;
    this.description = description;
    this.priorityLevel = priorityLevel;
    this.category = category;
    this.status = Status.TODO;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public int getPriorityLevel() {
    return priorityLevel;
  }

  public void setPriorityLevel(int priorityLevel) {
    this.priorityLevel = priorityLevel;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "name=" + name + '\'' +
            ", description='" + description + '\'' +
            ", endDate='" + endDate + '\'' +
            ", priorityLevel=" + priorityLevel +
            ", category='" + category + '\'' +
            ", status=" + status;
  }

  @Override
  public int compareTo(Task t) {
    if(this.getPriorityLevel() == t.getPriorityLevel()){
      return this.name.compareTo(t.getName());
    }else if(this.getPriorityLevel() < t.getPriorityLevel()){
      return 1;
    }else{
      return -1;
    }
  }
}

class ComparatorForCategory implements Comparator<Task>{
  @Override
  public int compare(Task o1, Task o2) {
    return o1.getCategory().compareTo(o2.getCategory());
  }
}

class ComparatorForStatus implements Comparator<Task>{
  @Override
  public int compare(Task o1, Task o2) {
    return o1.getStatus().compareTo(o2.getStatus());
  }
}