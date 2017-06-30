
import scala.util.control.Breaks.{break, breakable}

object PrimeNumber {
  def main(args: Array[String]): Unit = {
    val startTime = System.currentTimeMillis()
    val num = args(0).toInt
    breakable {
      for (i <- 2 to Math.floor(num / 2).toInt) {
        if (num % i == 0) {
          println(num + "は素数ではありません。")
          break
        }
      }
    }
    println("処理にかかった時間は " + (System.currentTimeMillis() - startTime) + " msecです。")
  }
}
