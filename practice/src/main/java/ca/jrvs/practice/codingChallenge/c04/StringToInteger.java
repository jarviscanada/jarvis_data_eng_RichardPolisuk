package ca.jrvs.practice.codingChallenge.c04;

public class StringToInteger {

  //  Use Java build-in parsing method (be careful with exception handling)
  public int myAtoiParse(String s) {
    s = s.trim();
    s = s.split("\\s+")[0];
    int n = s.length();
    int index = n;
    for (int i = n - 1; i > 0; i--) {
      if (!Character.isDigit(s.charAt(i))) {
        index = i;
      }
    }
    s = s.substring(0, index);
    double res;
    try {
      res = Double.parseDouble(s);
      if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
        return res < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }
    } catch (Exception e) {
      return 0;
    }
    return (int) res;
  }

  // Without java build-in parsing methods
  public int myAtoi(String s) {
    int sign = 1;
    int result = 0;
    int index = 0;
    int n = s.length();

    // Discard all spaces from the beginning of the input string.
    while (index < n && s.charAt(index) == ' ') {
      index++;
    }

    // sign = +1, if it's positive number, otherwise sign = -1.
    if (index < n && s.charAt(index) == '+') {
      sign = 1;
      index++;
    } else if (index < n && s.charAt(index) == '-') {
      sign = -1;
      index++;
    }

    // Traverse next digits of input and stop if it is not a digit
    while (index < n && Character.isDigit(s.charAt(index))) {
      int digit = s.charAt(index) - '0';

      // Check overflow and underflow conditions.
      if ((result > Integer.MAX_VALUE / 10) ||
          (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
        // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }

      // Append current digit to the result.
      result = 10 * result + digit;
      index++;
    }

    // We have formed a valid number without any overflow/underflow.
    // Return it after multiplying it with its sign.
    return sign * result;
  }

}
