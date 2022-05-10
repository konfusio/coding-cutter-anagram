package de.konfusio.anagram.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ClasspathFile {

  private final Path path;

  public ClasspathFile(String fileLocation) {
    try {
      path = Path.of(this.getClass().getClassLoader().getResource(fileLocation).toURI());
    }
    catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }

  public Stream<String> lines() {
    try {
      return Files.lines(path);
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
