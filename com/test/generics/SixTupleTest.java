package com.test.generics;

import com.test.typeinfo.pets.Manx;
import com.test.typeinfo.pets.Pet;
import com.test.util.SixTuple;

class Amphibian {}

class Vehicle {}

public class SixTupleTest {

  static SixTuple<Pet, Vehicle, Amphibian, String, Integer, Double> l() {
    return new SixTuple<>(new Manx(), new Vehicle(), new Amphibian(), "hi", 47, 11.1);
  }

  public static void main(String[] args) {
    System.out.println(l());
  }
}
