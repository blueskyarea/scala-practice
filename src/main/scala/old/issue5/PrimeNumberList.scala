
import scala.util.control.Breaks.{break, breakable}

object PrimeNumberList {
  def main(args: Array[String]): Unit = {
    if (checkArgs(args)) {
      println("引数が指定されていません。")
      return
    }
    val startTime = System.currentTimeMillis()
    val num = args(0).toInt
    var index = 1

    println("--Prime Number List Start--")
    for (i <- 2 to num) {
      breakable {
        for (j <- 2 to i - 1) {
          if (i % j == 0) {
            break
          }
        }
        println(index + ": " + i)
        index += 1
      }
    }
    println("--Prime Number List End--")
    println("処理時間は " + (System.currentTimeMillis() - startTime) + " msecです。")
  }

  def checkArgs(args: Array[String]): Boolean = {
    args.isEmpty
  }
}
