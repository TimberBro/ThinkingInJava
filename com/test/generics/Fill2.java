package com.test.generics;

import com.test.typeinfo.pets.Cat;
import com.test.typeinfo.pets.Dog;
import com.test.typeinfo.pets.Hamster;
import com.test.typeinfo.pets.Pet;
import com.test.util.Generator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

interface Addable<T> {
  void add(T t);
}

public class Fill2 {
  // Classtoken version:
  public static <T> void fill(Addable<T> addable, Class<? extends T> classToken, int size) {
    for (int i = 0; i < size; i++) {
      try {
        addable.add(classToken.newInstance());
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }

  // Generator version:
  public static <T> void fill(Addable<T> addable, Generator<T> generator, int size) {
    for (int i = 0; i < size; i++) {
      addable.add(generator.next());
    }
  }
}

// To adapt a base type, you must use composition.
// Make any Collection Addable using composition:
class AddableCollectionAdapter<T> implements Addable<T> {
  private Collection<T> c;

  public AddableCollectionAdapter(Collection<T> c) {
    this.c = c;
  }

  public void add(T item) {
    c.add(item);
  }
}

// A Helper to capture the type automatically:
class Adapter {
  public static <T> Addable<T> collectionAdapter(Collection<T> c) {
    return new AddableCollectionAdapter<T>(c);
  }
}

// To adapt a specific type, you can use inheritance.
// Make a SimpleQueue Addable using inheritance:
class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
  public void add(T item) {
    super.add(item);
  }
}

class Fill2Test {
  public static void main(String[] args) {
    // Adapt a Collection:
    List<Pet> carrier = new ArrayList<>();
    Fill2.fill(new AddableCollectionAdapter<>(carrier), Pet.class, 3);
    // Helper method captures the type:
    Fill2.fill(Adapter.collectionAdapter(carrier), Dog.class, 2);
    for (Pet c : carrier) {
      System.out.println(c);
    }
    System.out.println("----------------------");
    // Use an adapted class:
    AddableSimpleQueue<Pet> petQueue = new AddableSimpleQueue<Pet>();
    Fill2.fill(petQueue, Cat.class, 4);
    Fill2.fill(petQueue, Hamster.class, 1);
    for (Pet c : petQueue) {
      System.out.println(c);
    }
  }
}
