
class Movie(t: String){
  def title = t
}

object implicitConvTest03 {
  def main(args: Array[String]): Unit = {
    val movie = new Movie("You've got mail.")
    println(movie.title)
    println(movie + 10)
  }
  implicit def convToInt(a: Movie): Int = a.title.length
}
