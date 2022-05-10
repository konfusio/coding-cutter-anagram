package de.konfusio.anagram;

import de.konfusio.anagram.utils.ClasspathFile;

import java.util.List;
import java.util.stream.Stream;

public class AnagramApplication {

  public static void main(String[] args) {

    final Stream<String> fileSource = new ClasspathFile("de/konfusio/anagram/sample.txt").lines();
    final Stream<List<String>> resultStream = new AnagramSearch().findAnagrams(fileSource);
    new AnagramResultPrinter(System.out).printResult(resultStream);
  }
}
