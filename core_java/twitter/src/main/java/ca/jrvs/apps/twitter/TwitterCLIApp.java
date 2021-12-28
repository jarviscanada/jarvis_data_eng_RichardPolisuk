package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.controller.TwitterController;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import java.io.IOException;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

public class TwitterCLIApp extends TwitterController {

  public TwitterCLIApp(HttpHelper httpHelper) {
    super(httpHelper);
  }

  public static void main(String[] args) {



  }
}
