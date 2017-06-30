package algorism.sort

object BubbleSort {
  def main(args: Array[String]): Unit = {
    println("starting bubble sort.")
    println(new BubbleSort().bubbleSort1(List(3,2,6,4,7,1,5)))
    println(new BubbleSort().bubbleSort2(List(3,2,6,4,7,1,5)))
    println("end.")
  }
}

class BubbleSort {
  def bubbleSort1(list: List[Int]): List[Int] = {
    def switchElement(list2: List[Int]): List[Int] = {
      val headValue = list2.head
      val tailList = list2.tail
      var switchedList = headValue :: tailList
      
      if (headValue > tailList.head) {
        switchedList = tailList.head :: headValue :: tailList.tail
      }
      
      if (switchedList.tail.length > 1) {
        switchedList = switchedList.head :: switchElement(switchedList.tail)
      }
      switchedList
    }
    
    if (list.length > 1) {
      var latestSwitchedList = switchElement(list)
      if (latestSwitchedList.init.length > 1) {
        latestSwitchedList = bubbleSort1(latestSwitchedList.init) :+ latestSwitchedList.last
      }
      latestSwitchedList
    } else {
      list  
    }
  }
  
  def bubbleSort2(list: List[Int]): List[Int] = {
    def switchElement(list2: List[Int]): List[Int] = {
      val headValue = list2.head
      val tailList = list2.tail
      
      val switchedList = 
        if (headValue > tailList.head) tailList.head :: headValue :: tailList.tail
        else headValue :: tailList
      
      if (switchedList.tail.length > 1) switchedList.head :: switchElement(switchedList.tail)
      else switchedList
    }
    
    if (list.length > 1) {
      val latestSwitchedList = switchElement(list)
      if (latestSwitchedList.init.length > 1) bubbleSort2(latestSwitchedList.init) :+ latestSwitchedList.last
      else latestSwitchedList
    } else {
      list  
    }
  }
}
