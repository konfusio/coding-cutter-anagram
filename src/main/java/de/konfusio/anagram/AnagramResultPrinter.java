package de.konfusio.anagram;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnagramResultPrinter {

  private final PrintStream printStream;

  public AnagramResultPrinter(PrintStream printStream) {
    this.printStream = printStream;
  }

  void printResult(Stream<List<String>> result) {
    result.forEach(lists -> printStream.println(lists.stream().collect(Collectors.joining(" "))));
  }
}
