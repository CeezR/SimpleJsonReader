import org.example.JsonReader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonReaderTest {
  JsonReader reader = new JsonReader();

  @Test
  void shouldReturnCorrectString() {
    String expect = "Just created a JSON file!";
    String returned = reader.readFile();
    assertEquals(expect,returned);
  }
}
