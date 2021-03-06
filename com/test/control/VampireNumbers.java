package com.test.control;

public class VampireNumbers {
  public static boolean isVampireNumber(int n) {
    int a = n / 1000;
    int b = n % 1000 / 100;
    int c = n % 100 / 10;
    int d = n % 10;
    if ((10 * a + b) * (10 * c + d) == n) return true;
    if ((10 * a + b) * (10 * d + c) == n) return true;
    if ((10 * a + c) * (10 * b + d) == n) return true;
    if ((10 * a + c) * (10 * d + b) == n) return true;
    if ((10 * a + d) * (10 * b + c) == n) return true;
    if ((10 * a + d) * (10 * c + b) == n) return true;
    if ((10 * b + a) * (10 * c + d) == n) return true;
    if ((10 * b + a) * (10 * d + c) == n) return true;
    if ((10 * b + c) * (10 * d + a) == n) return true;
    if ((10 * b + d) * (10 * c + a) == n) return true;
    if ((10 * c + a) * (10 * d + b) == n) return true;
    return (10 * c + b) * (10 * d + a) == n;
  }

  public static void main(String[] args) {
    for (int i = 1000; i < 10000; i++) {
      if (isVampireNumber(i)) {
        System.out.println(i);
      }
    }
  }
}
