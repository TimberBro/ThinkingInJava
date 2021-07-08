package com.test.generics;

import com.test.typeinfo.pets.Cat;
import com.test.typeinfo.pets.Cymric;
import com.test.typeinfo.pets.Dog;
import com.test.typeinfo.pets.EgyptianMau;
import com.test.typeinfo.pets.Manx;
import com.test.typeinfo.pets.Mouse;
import com.test.typeinfo.pets.Pet;
import com.test.typeinfo.pets.Pug;
import com.test.typeinfo.pets.Rat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class RandomList<T> {
  private ArrayList<T> storage = new ArrayList<T>();
  private Random rand = new Random(47);

  public void add(T item) {
    storage.add(item);
  }

  public T select() {
    return storage.get(rand.nextInt(storage.size()));
  }

  public static void main(String[] args) {
    RandomList<String> rs = new RandomList<String>();
    RandomList<Integer> rs1 = new RandomList<Integer>();
    RandomList<Pet> rs2 = new RandomList<Pet>();
    for (String s : ("The quick brown fox jumped over " + "the lazy brown dog").split(" ")) {
      rs.add(s);
    }
    for (Integer s : Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 9, 10)) {
      rs1.add(s);
    }
    for (Pet pet :
        Arrays.asList(
            new Manx(),
            new Dog(),
            new Pug(),
            new Cat(),
            new Cymric(),
            new Mouse(),
            new EgyptianMau(),
            new Rat())) {
      rs2.add(pet);
    }
    for (int i = 0; i < 11; i++) {
      System.out.print(rs.select() + " ");
    }
    System.out.println();
    for (int i = 0; i < 11; i++) {
      System.out.print(rs1.select() + " ");
    }
    System.out.println();
    for (int i = 0; i < 7; i++) {
      System.out.print(rs2.select() + " ");
    }
  }
}
