package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.controller.TwitterController;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import java.io.IOException;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

public class TwitterCLIApp extends TwitterController {

  public TwitterCLIApp(String consumerKey, String consumerSecret, String accessToken,
      String tokenSecret) throws IOException {
    super(consumerKey, consumerSecret, accessToken, tokenSecret);
  }

  public static void main(String[] args) {

    String consumerKey = System.getenv("consumerKey");
    String consumerSecret = System.getenv("consumerSecret");
    String accessToken = System.getenv("accessToken");
    String tokenSecret = System.getenv("tokenSecret");

    try {
      HttpHelper httpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken,
          tokenSecret);

      HttpResponse response = httpHelper.httpGet(new URI(
          "https://api.twitter.com/2/tweets/1473869945364750345?tweet.fields=created_at,attachments&expansions=author_id"
      ));
      System.out.println(EntityUtils.toString(response.getEntity()));
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
