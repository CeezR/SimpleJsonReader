package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Main {

  public static Properties props = loadProperties();

  public static void main(String[] args) {
    //String FILE_LOCATION =  Application.props.getProperty("data.files.location");
    Path demo = Paths.get(props.getProperty("data.files.location") + "/test.json");
    if(!Files.exists(demo)) {
      try {
        Files.createFile(demo);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    try {
      Files.write(demo, "Just created a JSON file!".getBytes(StandardCharsets.UTF_8));
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      System.out.println(Files.readAllLines(demo)); // -> [Just created a file!]
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static Properties loadProperties() {
    InputStream propertiesResource = Main.class.getClassLoader().getResourceAsStream("application.properties");
    Properties props = new Properties();
    try {
      props.load(propertiesResource);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return props;
  }
}