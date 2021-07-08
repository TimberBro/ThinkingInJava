package com.test.generics.storycharacters;

import com.test.util.Generator;
import java.util.Iterator;
import java.util.Random;

public class StoryCharacterGenerator
    implements Generator<StoryCharacter>, Iterable<StoryCharacter> {

  private Class[] types = {DarthVader.class, Dracula.class, LukeSkywalker.class, VanHelsing.class};
  private static Random random = new Random(47);

  public StoryCharacterGenerator() {}

  private int size = 0;

  public StoryCharacterGenerator(int size) {
    this.size = size;
  }

  @Override
  public StoryCharacter next() {
    try {
      return (StoryCharacter) types[random.nextInt(types.length)].newInstance();
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  class StoryCharacterIterator implements Iterator<StoryCharacter> {
    int count = size;

    @Override
    public boolean hasNext() {
      return count > 0;
    }

    @Override
    public StoryCharacter next() {
      count--;
      return StoryCharacterGenerator.this.next();
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }

  @Override
  public Iterator<StoryCharacter> iterator() {
    return new StoryCharacterIterator();
  }

  public static void main(String[] args) {
    StoryCharacterGenerator generator = new StoryCharacterGenerator();
    for (int i = 0; i < 5; i++) {
      System.out.println(generator.next());
    }

    for (StoryCharacter character : new StoryCharacterGenerator(5)) {
      System.out.println(character);
    }
  }
}
