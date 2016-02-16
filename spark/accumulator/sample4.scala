// custom accumulator
import org.apache.spark.AccumulatorParam

object StringAccumulatorParam extends AccumulatorParam[String] {

  def zero(initialValue: String): String = ""

  def addInPlace(t1: String, t2: String): String = {
    t1 + t2
  }
}

val teamRDD = sc.makeRDD(Seq("中日", "ヤクルト", "広島", "横浜", "巨人"))
val customAcc = sc.accumulator("阪神")(StringAccumulatorParam)
teamRDD.foreach(team => customAcc += team)
println(customAcc.value)
