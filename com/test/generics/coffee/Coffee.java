
// : generics/coffee/Coffee.java
package com.test.generics.coffee;


public class Coffee {
  private static long counter = 0;
  private final long id = counter++;

  public String toString() {
    return getClass().getSimpleName() + " " + id;
  }

} /// :~

