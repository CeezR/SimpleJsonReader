package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonReader {
  public String readFile() {
    Path path = Paths.get(Application.props.getProperty("data.files.location") + "/test.json");
    StringBuilder sb = new StringBuilder();

    if(Files.exists(path)) {
      try {
        Files.readAllLines(path).forEach(line -> sb.append(line));
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    return sb.toString();
  }
}
