package ca.jrvs.practice.dataStructure.list;

import java.util.Arrays;
import java.util.List;

public class ArrayAPIs {

  public static void main(String[] args) {
    // Create an array of integers
    int[] intArray = new int[10];
    intArray[0] = 100; // Initialize first element
    intArray[1] = 100; // Initialize second element
    intArray[2] = 100; // and so forth

    // Shortcut syntax to create and initialize an array
    int[] inlineArray = {100, 200, 300};

    // 2-d array
    String[][] names = {
        {"Mr. ", "Mrs. ", "Ms. "},
        {"Smith", "Jones"}
    };

    // Copy array
    char[] copyFrom = {'d', 'e', 'c', 'a', 'f', 'f', 'e', 'i', 'n', 'a', 't', 'e', 'd'};
    char[] copyTo = new char[7];

    System.arraycopy(copyFrom, 2, copyTo, 0, 7);
    System.out.println(new String(copyTo));

    // Convert an array to a List
    List<String> fruits = Arrays.asList("apple", "orange");
    fruits = Arrays.asList(new String[]{"apple", "orange"});

    // Copy
    String[] fruitArray = new String[]{"mango", "banana"};
    String[] anotherFruitArray = Arrays.copyOfRange(fruitArray, 0, 1);
    System.out.printf(Arrays.toString(anotherFruitArray));

    // Sort
    Arrays.sort(fruitArray);
    System.out.println(Arrays.toString(fruitArray));

    //Binary Search
    int exact = Arrays.binarySearch(fruitArray,"banana");
    System.out.println(exact);
  }
}
