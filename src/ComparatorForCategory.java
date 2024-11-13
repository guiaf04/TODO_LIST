import java.util.Comparator;

class ComparatorForCategory implements Comparator<Task> {
  @Override
  public int compare(Task o1, Task o2) {
    return o1.getCategory().compareTo(o2.getCategory());
  }
}