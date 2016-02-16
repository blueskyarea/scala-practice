// use map function
val memberList = List("A-san", "B-san", "C-san")
val memberRDD = sc.parallelize(memberList)

def overTakeMyself(member: String) = {
  val slogan = " overtake myself."
  member + slogan
}

val overTakeMember = memberRDD.map(member => overTakeMyself(member))
overTakeMember.foreach(println)

// use mapPartitions function
val memberList = List("D-san", "E-san", "F-san")
val memberRDD = sc.parallelize(memberList)

def overTakeMyself(members: Iterator[String]) = {
  val slogan = " overtake myself."
  members.map(member => member + slogan)
}

val overTakeMember = memberRDD.mapPartitions(overTakeMyself)
overTakeMember.foreach(println)
