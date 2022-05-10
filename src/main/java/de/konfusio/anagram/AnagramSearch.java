package de.konfusio.anagram;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class AnagramSearch {

  public final List<List<String>> findAnagrams(List<String> words) {
    if (words == null) {
      throw new IllegalArgumentException("words is null");
    }

    final Map<String, List<String>> wordsWitheSameLetters = words.stream()
        .collect(groupingBy(this::sortedLettersInLowerCase));

    return wordsWitheSameLetters.values().stream()
        .filter(list -> list.size() > 1)
        .collect(Collectors.toList());
  }

  private String sortedLettersInLowerCase(String s) {
    final char[] chars = s.toLowerCase().toCharArray();
    Arrays.sort(chars);
    return String.valueOf(chars);
  }
}
