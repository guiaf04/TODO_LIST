package main;

import java.util.Date;

public class Alarm {
  private String message;
  private int horaDeLembrete;
  private Date dataLembrete;

  public Alarm(String message, int horaDeLembrete) {
    this.message = message;
    this.horaDeLembrete = horaDeLembrete;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Date getDataLembrete() {
    return dataLembrete;
  }

  public void setDataLembrete(Date dataLembrete) {
    this.dataLembrete = dataLembrete;
  }

  public int getHoraDeLembrete() {
    return horaDeLembrete;
  }

  public void setHoraDeLembrete(int horaDeLembrete) {
    this.horaDeLembrete = horaDeLembrete;
  }
}
