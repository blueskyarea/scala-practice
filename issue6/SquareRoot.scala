
object SquareRoot {
  def main(args: Array[String]): Unit = {
    if (!checkArgs(args)) {
      return
    }
    val num = args(0).toInt
    val result = calcSquareRoot(num)
    println(num + "の平方根は " + result)
  }

  def checkArgs(args: Array[String]): Boolean = {
    if (args.isEmpty) {
      // 引数の存在チェック
      println("引数が指定されていません。")
      false
    } else if (args(0) forall {
      _.isDigit
    }) {
      // 第1引数が数字であるかチェック
      true
    } else {
      println("引数が数字ではありません。")
      false
    }
  }

  def calcSquareRoot(num: Float): Float = {
    var result = num
    for (i <- 1 to 100) {
      // Ｘｎ＋１＝（Ｘｎ＋ａ／Ｘｎ）／２
      result = (result + (num / result)) / 2
    }
    result
  }
}
