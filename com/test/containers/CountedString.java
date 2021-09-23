package com.test.containers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountedString {
  private static List<String> created = new ArrayList<>();
  private String s;
  private int id = 0;

  public CountedString(String str) {
    s = str;
    created.add(s);
    // id is the total number of instances
    // of this string in use by CountedString:
    for (String s2 : created) {
      if (s2.equals(s)) {
        id++;
      }
    }
  }

  public String toString() {
    return "String: " + s + " id: " + id + " hashCode(): " + hashCode();
  }

  public int hashCode() {
    // Code still compiling and working, but this implementation will be slower, than previous one.
    // Now object with same String value will be stored in one bucket and we must use equals()
    // method to find correct from container.
    int result = 17;
    result = 37 * result + s.hashCode();
    return result;
  }

  public boolean equals(Object o) {
    return o instanceof CountedString
        && s.equals(((CountedString) o).s)
        && id == ((CountedString) o).id;
  }

  public static void main(String[] args) {
    Map<CountedString, Integer> map = new HashMap<>();
    CountedString[] cs = new CountedString[5];
    for (int i = 0; i < cs.length; i++) {
      cs[i] = new CountedString("hi");
      map.put(cs[i], i); // Autobox int -> Integer
    }
    System.out.println(map);
    for (CountedString cstring : cs) {
      System.out.println("Looking up " + cstring);
      System.out.println(map.get(cstring));
    }
  }
}
