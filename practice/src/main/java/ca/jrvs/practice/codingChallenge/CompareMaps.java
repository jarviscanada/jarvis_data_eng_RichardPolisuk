package ca.jrvs.practice.codingChallenge;

import java.util.HashMap;
import java.util.Map;

/**
 * ticket: https://www.notion.so/jarvisdev/How-to-compare-two-maps-cbca847f5cca4e529e57c3f9722345b1
 */

public class CompareMaps {

  public static void main(String[] args) {
    Map<String, String> c1 = new HashMap<String, String>();
    c1.put("Ontario", "Toronto");
    c1.put("Manitoba", "Winnipeg");

    Map<String, String> c2 = new HashMap<String, String>();
    c2.put("Ontario", "Vaughan");
    c2.put("Manitoba", "Flin Flon");

    System.out.println(new CompareMaps().compareMaps1(c1, c2));
  }

  // Using Java Collection .equals API, and read API implementation
  public <K, V> boolean compareMaps1(Map<K, V> m1, Map<K, V> m2) {
    return m1.equals(m2);
  }

  // Implement equals in HashJMap
  public <K, V> boolean compareMaps2(Map<K, V> m1, Map<K, V> m2) {
    return false;
  }

}
