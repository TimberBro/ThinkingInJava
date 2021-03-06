package com.test.polymorphism;

public class Print {
  void print1() {
    System.out.println("Inside Print called print2()");
    print2();
  }

  void print2() {
    System.out.println("This is print2();");
  }

  public static void main(String[] args) {
    Print n = new ChildPrint();
    n.print1();
  }
}

class ChildPrint extends Print {
  void print2() {
    System.out.println("print2(); in child class");
  }
}
