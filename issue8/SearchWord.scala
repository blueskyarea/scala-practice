
import scala.io.Source

object SearchWord {
  def main(args: Array[String]): Unit = {
    if (!checkArgs(args)) return
    val keyword = args(0)
    searchText(keyword)
  }

  def checkArgs(args: Array[String]): Boolean = {
    if (args.isEmpty) {
      println("キーワードが指定されていません。")
      false
    } else {
      true
    }
  }

  def searchText(keyword: String): Unit = {
    val textFile = Source.fromFile("res/ejdic-hand-utf8.txt")
    val list = try {
      textFile.getLines().toList
    } finally {
      textFile.close()
    }
    val listSize = list.size
    for (i <- 0 to listSize - 1) {
      if (list(i).startsWith(keyword)) {
        println(list(i))
      }
    }
  }

}
