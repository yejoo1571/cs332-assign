abstract class TweetSet {
  def filter(p: Tweet => Boolean): TweetSet =
    filterAcc(p, new Empty)

  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet
}

class Empty extends TweetSet {
  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet = acc
}

class NonEmpty(elem: Tweet, left: TweetSet, right: TweetSet) extends TweetSet {
  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet = {
    val acc1 = left.filterAcc(p, acc)
    val acc2 = right.filterAcc(p, acc1)
    if (p(elem)) acc2.incl(elem) else acc2
  }
}