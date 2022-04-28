package ca.jrvs.practice.codingChallenge.c01;

import java.util.Map;

public class CompareMaps {

  // Using Java Collection .equals API
  public <K, V> boolean compareMapsEquals(Map<K, V> m1, Map<K, V> m2) {
    if (m1.size() != m2.size()) {
      return false;
    }
    return m1.equals(m2);
  }

  public <K, V> boolean compareMapsStream(Map<K, V> m1, Map<K, V> m2) {
    if (m1.size() != m2.size()) {
      return false;
    }
    return m1.entrySet().stream()
        .allMatch(e -> e.getValue().equals(m2.get(e.getKey())));
  }

}
