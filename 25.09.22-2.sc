abstract class TweetSet {
  def union(that: TweetSet): TweetSet
}

class Empty extends TweetSet {
  def union(that: TweetSet): TweetSet = that
}

class NonEmpty(elem: Tweet, left: TweetSet, right: TweetSet) extends TweetSet {
  def union(that: TweetSet): TweetSet =
    left.union(right.union(that)).incl(elem)
}