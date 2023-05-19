package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Application {
  public static Properties props = loadProperties();

  private static Properties loadProperties() {
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
