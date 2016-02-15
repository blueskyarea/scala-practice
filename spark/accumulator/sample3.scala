// custom accumulator
import org.apache.spark.AccumulatorParam

object ListAccumulator extends AccumulatorParam[List[Int]] {
    def zero(initialValue: List[Int]): List[Int] = {
      return initialValue
    }

    def addInPlace(v1: List[Int], v2: List[Int]): List[Int] = {
      v1 ::: v2
    }
}

val file3 = sc.textFile("accumulator-test2.txt")
val acc = sc.accumulator(List(0))(ListAccumulator)

val lineLengthList = file3.map(line => {
  acc += List(line.length)
  println("length is " + line.length)
  line.length
})

lineLengthList.count
lineLengthList.first
acc.value
