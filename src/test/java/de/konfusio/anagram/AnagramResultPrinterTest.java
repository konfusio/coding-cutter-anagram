package de.konfusio.anagram;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnagramResultPrinterTest {

  @Test
  public void printsResult() {

    // given
    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    final AnagramResultPrinter underTest = new AnagramResultPrinter(new PrintStream(outputStream));

    // when
    underTest.printResult(Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("c", "d")).stream());

    // then
    final String expected = "a b" + System.lineSeparator() +
                            "c d" + System.lineSeparator();
    assertEquals(expected, outputStream.toString());
  }
}