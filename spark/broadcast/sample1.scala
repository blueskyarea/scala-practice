// not use broadcast variable
val rdd = sc.makeRDD((0 to 10).toList)
val CONSTANT = 2
val filteredRDD = rdd.filter(x => x % CONSTANT == 0)
filteredRDD.foreach(println)

// use broadcast variable
val rdd = sc.makeRDD((0 to 10).toList)
val BROADCAST = sc.broadcast(2)
val filteredRDD = rdd.filter(x => x % BROADCAST.value == 0)
filteredRDD.foreach(println)
