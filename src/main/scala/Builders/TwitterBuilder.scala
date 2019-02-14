package Builders

import twitter4j.TwitterFactory
import twitter4j.conf.ConfigurationBuilder
import com.typesafe.config.ConfigFactory

object TwitterBuilder {

  def buildTwitterFactory: TwitterFactory = {
    val cb = new ConfigurationBuilder
    cb.setDebugEnabled(true)
      .setOAuthConsumerKey(ConfigFactory.load().getString("twitter.consumer_key"))
      .setOAuthConsumerSecret(ConfigFactory.load().getString("twitter.consumer_secret"))
      .setOAuthAccessToken(ConfigFactory.load().getString("twitter.access_token"))
      .setOAuthAccessTokenSecret(ConfigFactory.load().getString("twitter.access_token_secret"))
    val tf = new TwitterFactory(cb.build)
    return tf
  }

}
