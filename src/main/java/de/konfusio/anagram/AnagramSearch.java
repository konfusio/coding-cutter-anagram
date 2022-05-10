package de.konfusio.anagram;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class AnagramSearch {

  public final Stream<List<String>> findAnagrams(Stream<String> words) {
    if (words == null) {
      throw new IllegalArgumentException("words is null");
    }

    final Map<String, List<String>> wordsWithSameLetters = words
        .collect(groupingBy(this::sortedLettersInLowerCase));

    return wordsWithSameLetters.values().stream()
        .filter(list -> list.size() > 1);
  }

  private String sortedLettersInLowerCase(String s) {
    final char[] chars = s.toLowerCase().toCharArray();
    Arrays.sort(chars);
    return String.valueOf(chars);
  }
}
