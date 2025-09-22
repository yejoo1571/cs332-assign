object GoogleVsApple {
  val google = List("android", "galaxy", "nexus", "google")
  val apple = List("ios", "iphone", "ipad", "apple")

  lazy val googleTweets: TweetSet =
    TweetReader.allTweets.filter(tweet => google.exists(kw => tweet.text.contains(kw)))

  lazy val appleTweets: TweetSet =
    TweetReader.allTweets.filter(tweet => apple.exists(kw => tweet.text.contains(kw)))

  lazy val trending: TweetList =
    (googleTweets union appleTweets).descendingByRetweet
}