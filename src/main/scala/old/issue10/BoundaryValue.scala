
// 型境界
object BoundaryValue {

  class Creature  // 生物
  class Mammal extends Creature   // 哺乳類
  class Human extends Mammal  // 人類

  def main(args: Array[String]) {
    // 上限境界
    class Man[A <: Mammal]

    val man1 = new Man[Human]   // サブ型
    val man2 = new Man[Mammal]  // 同一型
    println("サブ型:" + man1)
    println("同一型:" + man2)
    // val man3 = new Man[Creature]
    // 上限境界として、 Mammal を定義しているため、更に上位の Creature ではインスタンス生成できない

    // 下限境界
    class Woman[A >: Mammal]

    val woman1 = new Woman[Creature]   // スーパー型
    val woman2 = new Woman[Mammal]    // 同一型
    println("スーパー型：" + woman1)
    println("同一型：" + woman2)
    // val woman3 = new Woman[Human]
    // 下限境界として、Mammal を定義しているため、更に下位の Human ではインスタンス生成できない
  }
}
