package ca.jrvs.practice.codingChallenge;

// Given an integer n, return the number of prime numbers that are strictly less than n.

/**
 * ticket: https://www.notion.so/jarvisdev/Count-Primes-22b49d3821d54656a4010b5ac3a7fa7e
 */

/**
 * Big-O: O(n*n) Justification: Double array processing
 */
public class CountPrimes {

  private boolean isPrime(int number) {
    int sqrt = (int) Math.sqrt(number) + 1;
    for (int i = 2; i < sqrt; i++) {
      if (number % i == 0) { // number is perfectly divisible - no prime
        return false;
      }
    }
    return true;
  }

  public int countPrimes(int n) {
    int cnt = 0;
    for (int num = 2; num < n; num++) {
      if (isPrime(num)) {
        cnt++;
      }
    }
    return cnt;
  }

  /*
  Sieve of Eratosthenes (https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes)
  public int countPrimes(int n) {
     boolean[] isPrime = new boolean[n];
     for (int i = 2; i < n; i++) {
        isPrime[i] = true;
     }
     // Loop's ending condition is i * i < n instead of i < sqrt(n)
     // to avoid repeatedly calling an expensive function sqrt().
     for (int i = 2; i * i < n; i++) {
        if (!isPrime[i]) continue;
        for (int j = i * i; j < n; j += i) {
           isPrime[j] = false;
        }
     }
     int count = 0;
     for (int i = 2; i < n; i++) {
        if (isPrime[i]) count++;
     }
     return count;
   }
 */

}
