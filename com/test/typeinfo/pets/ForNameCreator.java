//: typeinfo/pets/ForNameCreator.java
package com.test.typeinfo.pets;
import java.util.*;

public class ForNameCreator extends PetCreator {
  private static List<Class<? extends Pet>> types =
    new ArrayList<Class<? extends Pet>>();
  // Types that you want to be randomly created:
  private static String[] typeNames = {
    "com.test.typeinfo.pets.Mutt",
    "com.test.typeinfo.pets.Pug",
    "com.test.typeinfo.pets.EgyptianMau",
    "com.test.typeinfo.pets.Manx",
    "com.test.typeinfo.pets.Cymric",
    "com.test.typeinfo.pets.Rat",
    "com.test.typeinfo.pets.Mouse",
    "com.test.typeinfo.pets.Hamster"
  };	
  @SuppressWarnings("unchecked")
  private static void loader() {
    try {
      for(String name : typeNames)
        types.add(
          (Class<? extends Pet>)Class.forName(name));
    } catch(ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  static { loader(); }
  public List<Class<? extends Pet>> types() {return types;}
} ///:~
