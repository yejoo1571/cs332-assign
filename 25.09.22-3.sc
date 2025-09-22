abstract class TweetSet {
  def mostRetweeted: Tweet
  def descendingByRetweet: TweetList
}

class Empty extends TweetSet {
  def mostRetweeted: Tweet =
    throw new NoSuchElementException("Empty.mostRetweeted")

  def descendingByRetweet: TweetList = Nil
}

class NonEmpty(elem: Tweet, left: TweetSet, right: TweetSet) extends TweetSet {
  def mostRetweeted: Tweet = {
    val leftMaxOpt =
      try Some(left.mostRetweeted) catch { case _: NoSuchElementException => None }
    val rightMaxOpt =
      try Some(right.mostRetweeted) catch { case _: NoSuchElementException => None }

    val candidates = List(Some(elem), leftMaxOpt, rightMaxOpt).flatten
    candidates.maxBy(_.retweets)
  }

  def descendingByRetweet: TweetList = {
    val most = this.mostRetweeted
    Cons(most, this.remove(most).descendingByRetweet)
  }
}