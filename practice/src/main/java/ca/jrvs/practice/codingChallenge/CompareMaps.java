package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CompareMaps {

  public static void main(String[] args) {
    Map<String, String> map1 = new HashMap<String, String>();
    map1.put("key1", "element 1");
    map1.put("key2", "element 2");
    map1.put("key3", "element 3");

    Map<String, String> map2 = new HashMap<>();
    map2.put("key1", "element 1");
    map2.put("key2", "element 2");
    map2.put("key3", "element 3");

    CompareMaps cm = new CompareMaps();
    System.out.println(cm.compareMapsEquals(map1, map2));
    System.out.println(cm.compareMapsStream(map1, map2));

  }

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
