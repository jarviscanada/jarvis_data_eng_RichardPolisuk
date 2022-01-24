package ca.jrvs.practice.dataStructure.search;

import java.util.Arrays;
import java.util.Optional;

// Class Optional<T>:
// A container object which may or may not contain a non-null value.
// If a value is present, isPresent() will return true and get() will return the value.

public class BinarySearch {

  public static void main(String[] args) {
    Integer[] items = {22, 55, 66, 11, 32, 56, 67, 89, 95, 10};
    Arrays.sort(items);

    String[] strItems = { "alk", "abc", "adk", "zyt", "fre", "nhy" };
    Arrays.sort(strItems);

    Double[] dItems = { 11.3, 13.3, 6.0, 9.6, 45.7, 23.2 };
    Arrays.sort(dItems);

    BinarySearch searcher = new BinarySearch();
    System.out.println(searcher.binarySearchRecursion(items, 67));
    System.out.println(searcher.binarySearchRecursion(strItems, "alk"));
    System.out.println(searcher.binarySearchRecursion(dItems, 13.3));
  }

  <T extends Comparable<T>> Optional<Integer> binarySearchRecursion(T[] items, T item) {
    return binarySearchRecursion(items, item, 0, items.length - 1);
  }

  <T extends Comparable<T>> Optional<Integer> binarySearchRecursion(T[] items, T key, int low,
      int high) {

    if (key == null) {
      return Optional.empty();
    }

    if (low > high) {
      return Optional.empty();
    }

    int mid = low + (high - low) / 2;

    if (key.compareTo(items[mid]) > 0) {
      return binarySearchRecursion(items, key, mid + 1, high);
    } else if (key.compareTo(items[mid]) < 0) {
      return binarySearchRecursion(items, key, low, mid - 1);
    } else {
      return Optional.of(mid);
    }
  }
}