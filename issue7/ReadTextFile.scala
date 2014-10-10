
import scala.io.Source

object ReadTextFile {
  def main(args: Array[String]): Unit = {
    if(!checkArgs(args)) return
    val num = args(0).toInt
    readText(num)
  }

  def checkArgs(args: Array[String]): Boolean = {
    if (args.isEmpty) {
      println("引数が指定されていません。")
      false
    } else if (args(0) == "0") {
      println("1以上の数字を指定してください。")
      false
    } else if (args(0) forall {_.isDigit}) {
      true
    } else {
      println("引数が数字ではありません。")
      false
    }
  }

  def readText(num: Int): Unit = {
    val textFile = Source.fromFile("res/ejdic-hand-utf8.txt")
    val list = try {
      textFile.getLines.toList
    } finally {
      textFile.close
    }
    val listSize = list.size
    if(num > listSize){
      println(listSize + "より小さい値を指定してください。")
    }else{
      println(list(num - 1))
    }
  }
}
