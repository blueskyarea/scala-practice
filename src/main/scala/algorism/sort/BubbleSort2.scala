package algorism.sort

object BubbleSort2 {
  
  def main(args: Array[String]): Unit = {
    println("start")
    println(bubbleSort(List(3,2,6,4,7,1,5)))
    println("end")
  }

  def bubbleSort(list: List[Int]): List[Int] = {
    def swap(swappingList: List[Int]): List[Int] = {
      swappingList match {
        case slist if slist.length == 1 => List(slist.head)
        case slist => {
          lazy val slist2 = swap(slist.tail)
          if (slist.head > slist2.head) slist2.head :: slist.head :: slist2.tail
          else slist.head :: slist2.head :: slist2.tail
        }
      }
    }
    
    lazy val slist2 = swap(list)
    list match {
      case list if list.isEmpty => List()
      case list => slist2.head :: bubbleSort(slist2.tail)
    }
  }
}