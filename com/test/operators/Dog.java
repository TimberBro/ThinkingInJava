package com.test.operators;

import static com.test.util.Print.print;

public class Dog {
  String name;
  String says;

  Dog(String name, String says) {
    this.name = name;
    this.says = says;
  }

  public String getName() {
    return name;
  }

  public String voice() {
    return says;
  }

  public static void main(String[] args) {
    Dog spot = new Dog("spot", "Ruff!");
    Dog scruffy = new Dog("scruffy", "Wurf!");
    print("Dog1: name is " + spot.getName() + ", says " + spot.voice());
    print("Dog2: name is " + scruffy.getName() + ", says " + scruffy.voice());
    Dog zidan = new Dog("zidan", "Whoof!");
    print("Comparing before assigning");
    print(zidan == spot);
    print(zidan.equals(spot));
    print(zidan == scruffy);
    print(zidan.equals(scruffy));
    print(scruffy == spot);
    print(scruffy.equals(spot));
    print("Assign spot and zidan");
    zidan = spot;
    print(zidan == spot);
    print(zidan.equals(spot));
    print(zidan == scruffy);
    print(zidan.equals(scruffy));
    print(scruffy == spot);
    print(scruffy.equals(spot));
    print("Spot: name is " + spot.getName() + ", says " + spot.voice());
    print("Zidan: name is " + zidan.getName() + ", says " + zidan.voice());
  }
}
