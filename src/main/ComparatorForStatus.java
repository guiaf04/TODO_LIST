package main;

import java.util.Comparator;

class ComparatorForStatus implements Comparator<Task> {
  @Override
  public int compare(Task o1, Task o2) {
    return o2.getStatus().compareTo(o1.getStatus());
  }
}