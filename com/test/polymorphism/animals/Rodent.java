package com.test.polymorphism.animals;

class Tail {
  public int length;

  Tail() {
    System.out.println("Tail constructor");
  }
}

public class Rodent {
  void type() {
    System.out.println("This is base type");
  }

  private Tail tail = new Tail();

  Rodent() {
    System.out.println("Rodent constructor");
    tail.length = 15;
  }

  public static void main(String[] args) {
    System.out.println("Array declared");
    Rodent[] rodents = {new Mouse(), new Gerbil(), new Hamster(), new Rodent()};
    System.out.println("Array filled");
    for (Rodent value : rodents) {
      value.type();
    }
  }
}

class Mouse extends Rodent {
  private Tail tail = new Tail();

  void type() {
    System.out.println("This is mouse");
  }

  Mouse() {
    System.out.println("Mouse constructor");
    tail.length = 5;
  }
}

class Gerbil extends Rodent {
  private Tail tail = new Tail();

  void type() {
    System.out.println("This is gerbil");
  }

  Gerbil() {
    System.out.println("Gerbil constructor");
    tail.length = 2;
  }
}

class Hamster extends Rodent {
  private Tail tail = new Tail();

  void type() {
    System.out.println("This is hamster");
  }

  Hamster() {
    System.out.println("Hamster constructor");
    tail.length = 1;
  }
}
