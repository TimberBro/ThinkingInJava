package com.test.generics;

public class GenericMethods {
  public <T, U> void f(T x, U y, GenericMethods z) {
    System.out.println(x.getClass().getName());
    System.out.println(y.getClass().getName());
    System.out.println(z.getClass().getName());
  }

  public static void main(String[] args) {
    GenericMethods gm = new GenericMethods();
    gm.f("", 1, gm);
    gm.f(1.0F, 'c', gm);
  }
}
