package ca.jrvs.apps.twitter.dao.helper;

import static org.junit.Assert.*;

import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TwitterHttpHelperTest {

  static final Logger logger = LoggerFactory.getLogger(TwitterHttpHelperTest.class);

  @Test
  public void httpPost() {
    String consumerKey = System.getenv("consumerKey");
    String consumerSecret = System.getenv("consumerSecret");
    String accessToken = System.getenv("accessToken");
    String tokenSecret = System.getenv("tokenSecret");

    logger.debug(consumerKey + "|" + consumerSecret + "|" + accessToken + "|" + tokenSecret);

    try {
      HttpHelper httpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken,
          tokenSecret);

      HttpResponse response = httpHelper.httpGet(new URI(
          "https://api.twitter.com/2/tweets/1473869945364750345?tweet.fields=created_at,attachments&expansions=author_id"
      ));
      logger.debug(EntityUtils.toString(response.getEntity()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}