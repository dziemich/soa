package ex4;

import java.util.Arrays;
import java.util.List;

public class DataRepository {
  static List<String> getAuthors(){
        return Arrays.asList("Astrid Lindgren", "Stieg Larsson", "Jo Nesbo", "Stefan Żeromski", "J.R.R Tolkien");
  }

  static List<String> getGenres(){
    return Arrays.asList("kids", "criminal", "novel", "fantasy");
  }
}
