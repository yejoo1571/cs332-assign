import org.scalatest.funsuite.AnyFunSuite

class SetSuite extends AnyFunSuite {
  test("singletonSet contains its element"){
    val s = singletonSet(1)
    assert(contains(s, 1))
    assert(!contains(s, 2))
  }

  test("union contains all elements"){
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val u = union(s1, s2)

    assert(contains(u, 1))
    assert(contains(u, 2))
    assert(!contains(u, 3))
  }
}