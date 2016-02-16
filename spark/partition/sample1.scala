// use map function
val memberList = List("A-san", "B-san", "C-san")
val memberRDD = sc.parallelize(memberList)

def fasterThanEver(member: String) = {
  val slogan = " is faster than ever."
  member + slogan
}

val fasterMember = memberRDD.map(member => fasterThanEver(member))
fasterMember.foreach(println)

// use mapPartitions function
val memberList = List("D-san", "E-san", "F-san")
val memberRDD = sc.parallelize(memberList)

def fasterThanEver(members: Iterator[String]) = {
  val slogan = " is faster than ever."
  members.map(member => member + slogan)
}

val fasterMember = memberRDD.mapPartitions(fasterThanEver)
fasterMember.foreach(println)
