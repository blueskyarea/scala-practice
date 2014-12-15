
object TraversableTest extends App {

  /**
   * foreach
   * 要素表示に使える
   *
   * abstract def foreach(f: (A) => Unit): Unit
   * 引数として受け取った関数をコレクションの要素全てに適用する
   */
  println("-- foreach --")
  val listA = List(1, 2, 3)
  listA.foreach(x => println(x))

  /**
   * map
   * 要素を加工する
   *
   * def map[B](f: (A) => B): CC[B]
   * 引数として受け取った関数でコレクションの要素全てを加工し、新たなコレクションを生成する
   */
  println("-- map --")
  val listB = List("a", "b", "c")
  val listB2 = listB.map(x => x.toUpperCase)
  listB2.foreach(println)

  /**
   * collect
   * マッチした要素を加工する
   *
   * def collect[B](pf: PartialFunction[A, B]): CC[B]
   * case にマッチした結果で、新たなコレクションを生成する
   */
  println("-- collect --")
  val listC = List("speed", "max", "regular")
  val listC2 = listC.collect {
    case "speed" => "SPEED"
    case "max" => "min"
    case other => other
  }
  println(listC2.mkString(", "))

  /**
   * find
   * 要素を探す
   *
   * def find(p: (A) => Boolean): Option[A]
   * 引数の条件に合った最初の要素を Option に包んで取り出す
   */
  println("-- find --")
  val listD = List("apple", "orange", "peach")
  println(listD.find(_ == "orange"))
  println(listD.find(_ == "mango"))

  /**
   * takeWhile
   * 要素を頭から取り出す
   *
   * def takeWhile(p: (A) => Boolean): Traversable[A]
   * 引数の条件が true が続く間の要素を新たなコレクションに追加する
   */
  println("-- takeWhile --")
  val listE = List(1, 1, 2, 3, 5, 8, 13, 21, 34, 3, 2)
  val listE2 = listE.takeWhile(_ < 15)
  println(listE2.mkString(", "))

  /**
   * dropWhile
   * 要素を頭から取り除く
   *
   * def dropWhile(p: (A) => Boolean): Traversable[A]
   * 引数の条件が true が続く間の要素を捨て、 false 以降の要素を新たなコレクションに追加する
   */
  println("-- dropWhile --")
  val listF = List(1, 1, 2, 3, 5, 8, 13, 21, 34, 3, 2)
  val listF2 = listF.dropWhile(_ < 15)
  println(listF2.mkString(", "))

  /**
   * span
   * 要素を前後に二分する
   *
   * def span(p: (A) => Boolean): (Traversable[A], Traversable[A])
   * 引数の条件が true が続く間の要素を新たなコレクションに追加し、残りを別の新たなコレクションに追加する
   */
  println("-- span --")
  val listG = List(1, 1, 2, 3, 5, 8, 13, 21, 34, 3, 2)
  val listG2 = listG.span(_ < 15)
  println(listG2)

  /**
   * filter
   * 合致した要素を取り出す
   *
   * def filter(p: (A) => Boolean): Traversable[A]
   * 引数の条件が true の要素を新たなコレクションに追加する
   */
  println("-- filter --")
  val listH = List(1, 1, 2, 3, 5, 8, 13, 21, 34, 3, 2)
  val listH2 = listH.filter(_ < 15)
  println(listH2)

  /**
   * filterNot
   * 合致しない要素を取り出す
   *
   * def filterNot(p: (A) => Boolean): Traversable[A]
   * 引数の条件が false の要素を新たなコレクションに追加する
   */
  println("-- filterNot --")
  val listI = List(1, 1, 2, 3, 5, 8, 13, 21, 34, 3, 2)
  val listI2 = listI.filterNot(_ < 15)
  println(listI2)

  /**
   * partition
   * 要素を条件で二分する
   *
   * def partition(p: (A) => Boolean): (Traversable[A], Traversable[A])
   * 引数の条件が true の要素を新たなコレクションに追加し、残りを別の新たなコレクションに追加する
   */
  println("-- partition --")
  val listJ = List(1, 1, 2, 3, 5, 8, 13, 21, 34, 3, 2)
  val listJ2 = listJ.partition(_ < 15)
  println(listJ2)

  /**
   * groupBy
   * 要素を分類する
   *
   * def groupBy[K](f: (A) => K): immutable.Map[K, Traversable[A]]
   * 同じ戻り値のものをリストにまとめ、戻り値とリストのペアをMapに格納する
   */
  println("-- groupBy --")
  val listK = List(1, 1, 2, 3, 5, 8, 13, 21, 34, 3, 2)
  val listK2 = listK.groupBy(_ < 15)
  println(listK2)

  /**
   * forall
   * 要素全体をチェックする
   *
   * def forall(p: (A) => Boolean): Boolean
   * 引数の条件ですべての要素が true なら true を返す
   */
  println("-- forall --")
  val listL = List(1, 1, 2, 3, 5, 8, 13, 21, 34, 3, 2)
  println(listL.forall(_ < 15))
  println(listL.forall(_ < 50))

  /**
   * exists
   * 合致する要素の存在をチェックする
   *
   * def exists(p: (A) => Boolean): Boolean
   * 引数の条件で true の要素が存在すれば true を返す
   */
  println("-- exists --")
  val listM = List(1, 1, 2, 3, 5, 8, 13, 21, 34, 3, 2)
  println(listM.exists(_ == 13))
  println(listM.exists(_ == 50))

  /**
   * count
   * 合致する要素の数を返す
   *
   * def count(p: (A) => Boolean): Int
   * 引数の条件に合致した要素の数を返す
   */
  println("-- count --")
  val listN = List(1, 1, 2, 3, 5, 8, 13, 21, 34, 3, 2)
  println(listN.count(_ < 15))
  println(listN.count(_ == 2))
}
