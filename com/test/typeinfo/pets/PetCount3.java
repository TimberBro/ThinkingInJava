package com.test.typeinfo.pets;

import com.test.util.MapData;
import java.util.*;

public class PetCount3 {
  static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {
    public PetCounter() {
      super(MapData.map(LiteralPetCreator.allTypes, 0));
    }

    public void count(Pet pet) {
      // Class.isInstance() eliminates instanceof:
      for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
        if (pair.getKey().isInstance(pet)) {
          put(pair.getKey(), pair.getValue() + 1);
        }
      }
    }

    public String toString() {
      StringBuilder result = new StringBuilder(" {");
      for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
        result.append(pair.getKey().getSimpleName());
        result.append("=");
        result.append(pair.getValue());
        result.append(", ");
      }
      result.delete(result.length() - 2, result.length());
      result.append("}");
      return result.toString();
    }
  }

  public static void main(String[] args) {
    PetCounter petCount = new PetCounter();
    for (Pet pet : Pets2.createArray(20)) {
      System.out.print(pet.getClass().getSimpleName() + " ");
      petCount.count(pet);
    }
    System.out.println();
    System.out.println(petCount);
  }
}
