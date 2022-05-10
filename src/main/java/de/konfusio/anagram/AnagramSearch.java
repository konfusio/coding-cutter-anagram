package de.konfusio.anagram;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class AnagramSearch {

  public final List<String> findAnagrams(String givenWord, List<String> words) {
    // be nice to users
    if (givenWord == null || words == null) { return emptyList(); }

    return words.stream()
        .filter(s -> isDifferantWord(s, givenWord))
        .filter(s -> containsSameLetters(s, givenWord))
        .collect(Collectors.toList());
  }

  private boolean isDifferantWord(String givenWord, String word) {
    return !word.equalsIgnoreCase(givenWord);
  }

  private boolean containsSameLetters(String s1, String s2) {
    return sortLetters(s1.toLowerCase()).equals(sortLetters(s2.toLowerCase()));
  }

  private String sortLetters(String s) {
    final char[] chars = s.toCharArray();
    Arrays.sort(chars);
    return String.valueOf(chars);
  }
}
