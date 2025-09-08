object Main {
  def balance(chars: List[Char]): Boolean = {
    var open = 0
    var i = 0

    while(i < chars.length) {
      val c = chars(i)
      if(c == '(') {
        open += 1
      }
      else if(c == ')') {
        open -= 1
        if(open < 0) return false
      }
      i += 1
    }

    open == 0
  }

  def main(args: Array[String]): Unit = {
    println("문자열을 입력하세요:")
    val input = scala.io.StdIn.readLine()
    println(balance(input.toList))
  }
}