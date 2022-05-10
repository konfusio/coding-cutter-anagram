package de.konfusio.anagram;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/** @noinspection ArraysAsListWithZeroOrOneArgument */
class AnagramSearchTest {

  private final AnagramSearch underTest = new AnagramSearch();

  @ParameterizedTest
  @MethodSource("searchForAnagramsTestCases")
  void searchForAnagrams(List<String> words, List<List<String>> expectedMatches) {
    // when
    final Stream<List<String>> actual = underTest.findAnagrams(words.stream());

    // then
    Assertions.assertEquals(expectedMatches, actual.collect(Collectors.toList()));
  }

  @Test()
  public void errorHandling() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> underTest.findAnagrams(null));
  }

  private static Stream<Arguments> searchForAnagramsTestCases() {
    return Stream.of(
        // good case
        Arguments.of(asList("Palme", "Lampe", "anderes"), asList(asList("Palme", "Lampe"))),
        Arguments.of(asList("Palme", "Lampe", "Auto", "Atou"), asList(asList("Auto", "Atou"), asList("Palme", "Lampe"))),

        // no anagrams found
        Arguments.of(asList("b", "c"), asList()),
        Arguments.of(asList("a", "b", "c"), asList()),
        Arguments.of(asList("c", "b", "a"), asList()),
        Arguments.of(asList("a", "aa"), asList())
    );
  }
}