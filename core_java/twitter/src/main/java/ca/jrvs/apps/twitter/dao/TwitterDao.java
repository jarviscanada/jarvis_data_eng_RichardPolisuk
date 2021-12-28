package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.util.JsonUtil;
import com.google.gdata.util.common.base.PercentEscaper;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class TwitterDao implements CrdDao<Tweet, String> {

  // URI constants
  private static final String API_BASE_URI = "https://api.twitter.com";
  private static final String POST_PATH = "/2/tweets";
  private static final String SHOW_PATH = "/2/users/";
  private static final String DELETE_PATH = "/2/tweets/";

  // URI symbols
  private static final String QUERY_SYM = "?";
  private static final String AMPERSAND = "&";
  private static final String EQUAL = "=";

  // Response code
  private static final int HTTP_OK = 200;
  private HttpHelper httpHelper;

  @Autowired
  public TwitterDao(HttpHelper httpHelper) {
    this.httpHelper = httpHelper;
  }

  /**
   * Create an entity(Tweet) to the underlying storage
   *
   * @param entity entity that to be created
   * @return created entity
   */
  @Override
  public Tweet create(Tweet entity) {
    PercentEscaper percentEscaper = new PercentEscaper("", false);
    URI uri = URI.create(
        API_BASE_URI + POST_PATH + QUERY_SYM + "status" + EQUAL + percentEscaper.escape(
            entity.getText()));
    HttpResponse response = httpHelper.httpPost(uri);
    return parseResponseBody(response, HTTP_OK);
  }

  /**
   * Find an entity(Tweet) by its id
   *
   * @param s entity id
   * @return Tweet entity
   */
  @Override
  public Tweet findById(String s) {
    URI uri;
    try {
      uri = new URI(API_BASE_URI + SHOW_PATH + QUERY_SYM + "id" + EQUAL + s);
    } catch (URISyntaxException ex) {
      throw new IllegalArgumentException("Invalid id input", ex);
    }
    HttpResponse response = httpHelper.httpGet(uri);
    return parseResponseBody(response, HTTP_OK);
  }

  /**
   * Delete an entity(Tweet) by its ID
   *
   * @param s of the entity to be deleted
   * @return deleted entity
   */
  @Override
  public Tweet deleteById(String s) {
    URI uri;
    try {
      uri = new URI(API_BASE_URI + DELETE_PATH + "/" + s + ".json");
    } catch (URISyntaxException ex) {
      throw new IllegalArgumentException("Invalid id input", ex);
    }
    HttpResponse response = httpHelper.httpPost(uri);
    return parseResponseBody(response, HTTP_OK);
  }

  public Tweet parseResponseBody(HttpResponse response, Integer expectedStatusCode) {
    Tweet tweet = null;

    //check response status
    int status = response.getStatusLine().getStatusCode();
    if (status != expectedStatusCode) {
      try {
        System.out.println(EntityUtils.toString(response.getEntity()));
      } catch (IOException e) {
        System.out.println("Response has no entity");
      }
      throw new RuntimeException("Unexpected HTTP status:" + status);
    }

    if (response.getEntity() == null) {
      throw new RuntimeException("Empty response body");
    }

    //Convert Response Entity to Str
    String jsonStr;
    try {
      jsonStr = EntityUtils.toString(response.getEntity());
    } catch (IOException e) {
      throw new RuntimeException("Failed to convert entity to String", e);
    }

    //Convert JSON string to Tweet object
    try {
      tweet = JsonUtil.toObjectFromJson(jsonStr, Tweet.class);
    } catch (IOException e) {
      throw new RuntimeException("Unable to convert JSON str to Object", e);
    }
    return tweet;
  }

  private URI getUri(Tweet tweet) {
    URI uri;
    PercentEscaper percentEscaper = new PercentEscaper("", false);
    try {
      uri = new URI(API_BASE_URI + POST_PATH + QUERY_SYM + "status" + EQUAL + percentEscaper
          .escape(tweet.getText()) + AMPERSAND + "long" + EQUAL + tweet.getCoordinates()
          .getCoordinates().get(0) + AMPERSAND + "lat" + EQUAL + tweet.getCoordinates()
          .getCoordinates().get(1));
      return uri;
    } catch (URISyntaxException ex) {
      throw new IllegalArgumentException("Invalid input", ex);
    }
  }
}
