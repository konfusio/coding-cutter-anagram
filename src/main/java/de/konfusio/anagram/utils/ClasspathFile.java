package de.konfusio.anagram.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ClasspathFile {

  private final String fileLocation;

  public ClasspathFile(String fileLocation) {
    this.fileLocation = fileLocation;
  }

  public Stream<String> lines() {
    final InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileLocation);
    return new BufferedReader(new InputStreamReader(inputStream, UTF_8)).lines();
  }
}
