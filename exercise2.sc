object Main {
  def main(args: Array[String]): Unit = {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = union(s1, s2)

    println(contains(s1, 1))
    println(contains(s2, 2))
    println(contains(s3, 1))
    println(contains(s3, 2))
    println(contains(s3, 3))
  }
}