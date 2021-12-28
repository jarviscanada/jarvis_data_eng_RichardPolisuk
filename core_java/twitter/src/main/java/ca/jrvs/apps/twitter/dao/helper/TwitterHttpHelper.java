package ca.jrvs.apps.twitter.dao.helper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.http.HttpMethod;

public class TwitterHttpHelper implements HttpHelper {

  private OAuthConsumer consumer;
  private HttpClient httpClient;

  /**
   * Constructor Setup dependencies using sercrets
   *
   * @param consumerKey    Consumer key
   * @param consumerSecret Consumer secret
   * @param accessToken    Access token
   * @param tokenSecret    Access secret
   * @throws IOException   IO Exception
   */
  public TwitterHttpHelper(String consumerKey, String consumerSecret, String accessToken,
      String tokenSecret) throws IOException {
    consumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
    consumer.setTokenWithSecret(accessToken, tokenSecret);
    httpClient = new DefaultHttpClient();
  }

  /**
   * Execute a HTTP Post call
   *
   * @param uri URI
   * @return Response
   */
  @Override
  public HttpResponse httpPost(URI uri) {
    try {
      return executeHttpRequest(HttpMethod.POST, uri, null);
    } catch (Exception e) {
      throw new RuntimeException("Failed to execute ", e);
    }
  }

  /**
   * Execute a HTTP Get call
   *
   * @param uri URI
   * @return Response
   */
  @Override
  public HttpResponse httpGet(URI uri) {
    try {
      return executeHttpRequest(HttpMethod.GET, uri, null);
    } catch (Exception e) {
      throw new RuntimeException("Failed to execute ", e);
    }
  }

  private HttpResponse executeHttpRequest(HttpMethod method, URI uri, StringEntity stringEntity)
      throws IOException, OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException {

    switch (method.toString()) {
      case "GET":
        HttpGet get = new HttpGet(uri);
        consumer.sign(get);
        return httpClient.execute(get);
      case "POST":
        HttpPost post = new HttpPost(uri);
        if (stringEntity != null) {
          post.setEntity(stringEntity);
        }
        consumer.sign(post);
        return httpClient.execute(post);
      default:
        throw new IllegalArgumentException("Unknown HTTP method: " + method.name());
    }
  }
}
