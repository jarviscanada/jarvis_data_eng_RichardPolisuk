package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.util.TweetUtil;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@Ignore
public class TwitterServiceIntTest {

  private TwitterService service;

  @Before
  public void setUp() {
    String consumerKey = System.getenv("consumerKey");
    String consumerSecret = System.getenv("consumerSecret");
    String accessToken = System.getenv("accessToken");
    String tokenSecret = System.getenv("tokenSecret");

    HttpHelper httpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken,
        tokenSecret);

    TwitterDao dao = new TwitterDao(httpHelper);
    service = new TwitterService(dao);
  }

  @Test
  public void shouldPostTweet() {
    Tweet tweetWillBePosted = TweetUtil.createTweet("Post Int Test " + System.currentTimeMillis(),
        30.0f, 31.0f);

    Tweet postTweet = service.postTweet(tweetWillBePosted);

    assertEquals(tweetWillBePosted.getText(), postTweet.getText());
    assertNotNull(postTweet.getCoordinates());
    assertEquals(2, postTweet.getCoordinates().getCoordinates().size());
    assertEquals(tweetWillBePosted.getCoordinates().getCoordinates().get(0),
        postTweet.getCoordinates().getCoordinates().get(0));
    assertEquals(tweetWillBePosted.getCoordinates().getCoordinates().get(1),
        postTweet.getCoordinates().getCoordinates().get(1));
  }

  @Test
  public void shouldShowTweet() {
    Tweet tweetShouldBePosted = TweetUtil.createTweet(
        "Show Post Int Test " + System.currentTimeMillis(), 40.0f, 41.0f);

    Tweet showTweet = service.postTweet(tweetShouldBePosted);

    assertEquals(tweetShouldBePosted.getText(), showTweet.getText());
    assertNotNull(showTweet.getCoordinates());
    assertEquals(2, showTweet.getCoordinates().getCoordinates().size());
    assertEquals(tweetShouldBePosted.getCoordinates().getCoordinates().get(0),
        showTweet.getCoordinates().getCoordinates().get(0));
    assertEquals(tweetShouldBePosted.getCoordinates().getCoordinates().get(1),
        showTweet.getCoordinates().getCoordinates().get(1));
  }

  @Test
  public void shouldDeleteTweet() {
    Tweet tweet1ShouldBeDeleted = TweetUtil.createTweet(
        "Delete Post 1 Int Test " + System.currentTimeMillis(), 50.0f, 51.0f);
    Tweet tweet2ShouldBeDeleted = TweetUtil.createTweet(
        "Delete Post 2 Int Test " + System.currentTimeMillis(), 50.0f, 51.0f);

    Tweet deletedTweet1 = service.postTweet(tweet1ShouldBeDeleted);
    Tweet deletedTweet2 = service.postTweet(tweet2ShouldBeDeleted);

    String Tweet1Id = deletedTweet1.getId_str();
    String Tweet2Id = deletedTweet2.getId_str();

    String[] ids = {Tweet1Id, Tweet2Id};
    List<Tweet> deletedTweets = service.deleteTweets(ids);

    assertEquals(deletedTweet1.getText(), deletedTweets.get(0).getText());
    assertEquals(deletedTweet2.getText(), deletedTweets.get(1).getText());
  }

}