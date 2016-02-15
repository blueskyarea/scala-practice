// count blank lines
val file2 = sc.textFile("/home/mh/tmp/accumulator-test1.txt")
val blankLines = sc.accumulator(0)

// use accumulator in action
file2.foreach(line => {
  if (line == "") {
    blankLines += 1
  }
})

blankLines.value
