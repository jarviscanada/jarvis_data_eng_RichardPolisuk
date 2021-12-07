package ca.jrvs.apps.practice;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegexExcMain implements RegexExc {

  // Your program begins with a call to main().
  // Prints "Hello, World" to the terminal window.
  public static void main(String[] args) {
    // boolean result = new Practice().matchJpeg("jpg");
    System.out.println(new RegexExcMain().matchJpeg("a.jpg"));
    System.out.println(new RegexExcMain().matchIp("10.10.10.10"));
    System.out.println(new RegexExcMain().isEmptyLine(" r"));
  }

  // return true if filename extension is jpg or jpeg (case-insensitive)
  public boolean matchJpeg(String filename) {
      if (filename == null || filename.isEmpty()) {
          return false;
      }
    final String regex = "([^\\s]+(\\.(?i)(jpe?g))$)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(filename.toLowerCase(Locale.ROOT));
    return matcher.matches();
  }

  // return true if ip address is valid
  // to simplify the problem, IP address range is from 0.0.0.0 to 999.999.999.999
  public boolean matchIp(String ip) {
      if (ip == null || ip.isEmpty()) {
          return false;
      }
    final String regex =
        "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(ip.toLowerCase(Locale.ROOT));
    return matcher.matches();
  }

  // return true if line is empty (e.g. empty, white space, tabs, etc...)
  public boolean isEmptyLine(String line) {
      if (line == null) {
          return true;
      }
      if (line.isEmpty()) {
          return true;
      }
    final String regex = "\\s";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(line.toLowerCase(Locale.ROOT));
    return matcher.matches();
  }

  ;
}
