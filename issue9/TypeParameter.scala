object TypeParameter {

  class TypeParam[T](val t: T) {
    def getValue: T = this.t
  }

  def main(args: Array[String]) = {
    val strTypeParameter = new TypeParam[String]("文字列ね")
    println(strTypeParameter.getValue)

    val intTypeParameter = new TypeParam[Int](101)
    println(intTypeParameter.getValue)
  }
}
