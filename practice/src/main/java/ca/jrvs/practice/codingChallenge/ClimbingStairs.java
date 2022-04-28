package ca.jrvs.practice.codingChallenge.c02;

// You are climbing a staircase. It takes n steps to reach the top.
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
public class ClimbingStairs {

  public static void main(String[] args) {
    ClimbingStairs cs = new ClimbingStairs();
    System.out.println(cs.climbStairsDP(4));
    System.out.println(cs.climbStairsREC(5));
  }

  // Dynamic programing
  // Store some intermediate results
  public int climbStairsDP(int n) {
    if (n < 3) return n;
    int[] countWays = new int[n + 1];
    return countWaysUsingMemoization(n, countWays);
  }

  private int countWaysUsingMemoization(int num, int[] countWays) {
    if (num == 0)
      return 1;
    else if (num < 0)
      return 0;

    if (countWays[num] != 0)
      return countWays[num];

    int countPaths1 = countWaysUsingMemoization(num - 1, countWays);
    int countPaths2 = countWaysUsingMemoization(num - 2, countWays);
    countWays[num] = countPaths1 + countPaths2;
    return countPaths1 + countPaths2;
  }

  // Recursion
  public int climbStairsREC(int n) {
    if (n < 3) return n;
    return climbREC(0, n);
  }

  private int climbREC(int stepsTaken, int numSteps) {
    if (stepsTaken > numSteps) {
      return 0;
    }
    if (stepsTaken == numSteps) {
      return 1;
    }
    return climbREC(stepsTaken + 1, numSteps) + climbREC(stepsTaken + 2, numSteps);
  }
}
