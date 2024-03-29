package com.test.arrays;

import com.test.util.ConvertTo;
import com.test.util.Generated;
import com.test.util.SkipGenerator;
import java.util.Arrays;

public class TestArrayGeneration {
  public static void main(String[] args) {
    int size = 6;
    boolean[] a1 = ConvertTo.primitive(Generated.array(
        Boolean.class, new SkipGenerator.Boolean(true), size));
    System.out.println("a1 = " + Arrays.toString(a1));
    byte[] a2 = ConvertTo.primitive(Generated.array(
        Byte.class, new SkipGenerator.Byte((byte) 1), size));
    System.out.println("a2 = " + Arrays.toString(a2));
    char[] a3 = ConvertTo.primitive(Generated.array(
        Character.class,
        new SkipGenerator.Character(1), size));
    System.out.println("a3 = " + Arrays.toString(a3));
    short[] a4 = ConvertTo.primitive(Generated.array(
        Short.class, new SkipGenerator.Short((short) 1), size));
    System.out.println("a4 = " + Arrays.toString(a4));
    int[] a5 = ConvertTo.primitive(Generated.array(
        Integer.class, new SkipGenerator.Integer(1), size));
    System.out.println("a5 = " + Arrays.toString(a5));
    long[] a6 = ConvertTo.primitive(Generated.array(
        Long.class, new SkipGenerator.Long(1), size));
    System.out.println("a6 = " + Arrays.toString(a6));
    float[] a7 = ConvertTo.primitive(Generated.array(
        Float.class, new SkipGenerator.Float(1), size));
    System.out.println("a7 = " + Arrays.toString(a7));
    double[] a8 = ConvertTo.primitive(Generated.array(
        Double.class, new SkipGenerator.Double(1.4), size));
    System.out.println("a8 = " + Arrays.toString(a8));
  }
}
