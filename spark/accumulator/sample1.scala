// Count blank lines
val file1 = sc.textFile("accumulator-test1.txt")
val blankLines = sc.accumulator(0)

val countBlankLines = file1.map(line => {
  if (line == "") {
    blankLines += 1
  }
  line
})

blankLines.value

countBlankLines.collect

blankLines.value
