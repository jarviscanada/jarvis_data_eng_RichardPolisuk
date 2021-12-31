package ca.jrvs.apps.twitter.util;

import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Tweet;

import java.util.Arrays;

public class TweetUtil {

  /**
   * create a new tweet with text and coordinates
   *
   * @param text status
   * @param lon longitude
   * @param lat latitude
   * @return a new tweet
   */
  public static Tweet createTweet(String text, Float lon, Float lat) {
    return new Tweet(text, new Coordinates(Arrays.asList(lon, lat), "Point"));
  }
}