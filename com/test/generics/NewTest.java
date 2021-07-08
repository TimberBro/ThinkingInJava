package com.test.generics;

import com.test.generics.storycharacters.StoryCharacter;
import com.test.generics.storycharacters.StoryCharacterGenerator;
import com.test.util.New;
import java.util.List;
import java.util.Set;

public class NewTest {

  static void f(List<StoryCharacter> storyCharactersList) {
    for (StoryCharacter character : new StoryCharacterGenerator(5)) {
      storyCharactersList.add(character);
    }
    System.out.println(storyCharactersList);
  }

  static void g(Set<Fibonacci> fibonacciSet) {
    fibonacciSet.add(new Fibonacci());
    System.out.println(fibonacciSet);
  }

  public static void main(String[] args) {
    f(New.<StoryCharacter>list());
    g(New.<Fibonacci>set());
    // Output will be same.
  }
}
