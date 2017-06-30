
object HelloWorlds {
  def main(args: Array[String]): Unit = {
    val repeat = if(args.isEmpty) {1} else {args(0).toInt}
    for(i <- 1 to repeat){
      println("Hello World!")
    }
  }
}
