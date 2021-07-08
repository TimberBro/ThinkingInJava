package com.test.generics;

import com.test.generics.coffee.Coffee;
import com.test.generics.coffee.CoffeeGenerator;
import com.test.util.Generator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Generators {
  public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
    for (int i = 0; i < n; i++) {
      coll.add(gen.next());
    }
    return coll;
  }

  public static <T> List<T> fill(List<T> list, Generator<T> gen, int n) {
    for (int i = 0; i < n; i++) {
      list.add(gen.next());
    }
    return list;
  }

  public static <T> Queue<T> fill(Queue<T> queue, Generator<T> gen, int n) {
    for (int i = 0; i < n; i++) {
      queue.add(gen.next());
    }
    return queue;
  }

  public static <T> LinkedList<T> fill(LinkedList<T> linkedList, Generator<T> gen, int n) {
    for (int i = 0; i < n; i++) {
      linkedList.add(gen.next());
    }
    return linkedList;
  }

  public static <T> Set<T> fill(Set<T> set, Generator<T> gen, int n) {
    for (int i = 0; i < n; i++) {
      set.add(gen.next());
    }
    return set;
  }

  public static void main(String[] args) {
    Collection<Coffee> coffee = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 4);
    for (Coffee c : coffee) {
      System.out.print(c + ", ");
    }
    System.out.println();

    List<Coffee> coffeeList = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 4);
    for (Coffee c : coffeeList) {
      System.out.print(c + ", ");
    }
    System.out.println();

    Queue<Integer> integerQueue =
        fill((Queue<Integer>) new LinkedList<Integer>(), new Fibonacci(), 12);
    for (int i : integerQueue) {
      System.out.print(i + ", ");
    }
    System.out.println();

    LinkedList<Coffee> coffeeLinkedList = fill(new LinkedList<Coffee>(), new CoffeeGenerator(), 5);
    for (Coffee c : coffeeLinkedList) {
      System.out.print(c + ", ");
    }
    System.out.println();

    Set<Integer> integerSet = fill(new HashSet<Integer>(), new Fibonacci(), 10);
    for (Integer integer : integerSet) {
      System.out.print(integer + ", ");
    }
  }
}
