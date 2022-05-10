package de.konfusio.anagram.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.List.of;

class ClasspathFileTest {

  @Test
  public void canReadFile() {
    final List<String> content = new ClasspathFile("de/konfusio/anagram/sample.txt").lines()
        .collect(Collectors.toList());
    Assertions.assertEquals(of("act", "cat", "tree", "race", "care", "acre", "bee"), content);
  }

  @Test
  public void unknownFileThrowsError() {
    Assertions.assertThrows(RuntimeException.class, () -> new ClasspathFile("de/konfusio/anagram/unknown.txt"));
  }
}