package ca.jrvs.practice.codingChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DuplicateCharacter {

  public static void main(String[] args) {
    DuplicateCharacter dc = new DuplicateCharacter();
    System.out.println(dc.findDuplicate("A black cat"));
  }

  public ArrayList<String> findDuplicate(String str) {
    Map<Character, Integer> map = new HashMap<>();
    char[] charArray = str.toCharArray();
    for (char c : charArray) {
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }

    ArrayList<String> out = new ArrayList<>();
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      if (entry.getValue() > 1 && entry.getKey() != ' ') {
        out.add("\"" + entry.getKey() + "\"");
      }
    }
    return out;
  }

}
