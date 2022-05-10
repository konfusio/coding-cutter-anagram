package de.konfusio.anagram;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/** @noinspection ArraysAsListWithZeroOrOneArgument */
class AnagramSearchTest {

  private final AnagramSearch underTest = new AnagramSearch();

  @ParameterizedTest
  @MethodSource("searchForAnagramsTestCases")
  void searchForAnagrams(String givenWord, List<String> words, List<String> expectedMatches) {
    // when
    final List<String> actual = underTest.findAnagrams(givenWord, words);

    // then
    Assertions.assertEquals(expectedMatches, actual);
  }

  private static Stream<Arguments> searchForAnagramsTestCases() {
    return Stream.of(
        // good case
        Arguments.of("Ampel", asList("Palme", "Lampe", "anderes"), asList("Palme", "Lampe")),

        // dont find the same word again
        Arguments.of("a", asList("a"), asList()),
        Arguments.of("a", asList("a", "b"), asList()),
        Arguments.of("a", asList("b", "a"), asList()),
        Arguments.of("a", asList("a", "a"), asList()),
        Arguments.of("ab", asList("ab", "ba"), asList("ba")),

        //  dont find the same word again - ignore case
        Arguments.of("A", asList("a"), asList()),
        Arguments.of("a", asList("A"), asList()),
        Arguments.of("A", asList("a", "b"), asList()),
        Arguments.of("a", asList("b", "A"), asList()),
        Arguments.of("A", asList("b", "a"), asList()),
        Arguments.of("a", asList("a", "a"), asList()),
        Arguments.of("AB", asList("ab", "ba"), asList("ba")),
        Arguments.of("ab", asList("AB", "BA"), asList("BA")),

        // dont find words with differant number of letter
        Arguments.of("aa", asList("a"), asList()),
        Arguments.of("a", asList("aa"), asList()),
        Arguments.of("AA", asList("a"), asList()),
        Arguments.of("a", asList("AA"), asList()),

        // return empty result if not enough information is given
        Arguments.of(null, asList("a"), asList()),
        Arguments.of(null, null, asList()),
        Arguments.of("a", null, asList())

    );
  }
}