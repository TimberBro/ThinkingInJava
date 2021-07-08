package com.test.generics;

public class Holder4<T> {
  private T first;
  private T second;
  private T third;

  public Holder4(T first, T second, T third) {
    this.first = first;
    this.second = second;
    this.third = third;
  }

  public void setFirst(T first) {
    this.first = first;
  }

  public void setSecond(T second) {
    this.second = second;
  }

  public void setThird(T third) {
    this.third = third;
  }

  public T getFirst() {
    return first;
  }

  public T getSecond() {
    return second;
  }

  public T getThird() {
    return third;
  }

  public static void main(String[] args) {
    Holder4<String> stringHolder4 = new Holder4<>("First", "Second", "Third");
    System.out.println(stringHolder4.getFirst());
    System.out.println(stringHolder4.getSecond());
    System.out.println(stringHolder4.getThird());
    stringHolder4.setFirst("Первый");
    stringHolder4.setSecond("Второй");
    stringHolder4.setThird("Третий");
    System.out.println(stringHolder4.getFirst());
    System.out.println(stringHolder4.getSecond());
    System.out.println(stringHolder4.getThird());
  }
}
